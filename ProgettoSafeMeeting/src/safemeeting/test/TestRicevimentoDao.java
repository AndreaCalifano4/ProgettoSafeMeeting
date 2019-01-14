package safemeeting.test;

import static org.junit.Assert.assertEquals;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import safemeeting.model.DocenteBean;
import safemeeting.model.DocenteDao;
import safemeeting.model.RicevimentoBean;
import safemeeting.model.RicevimentoDao;
import safemeeting.model.TipologiaBean;

/**
 * Questa classe testa i metodi della classe RicevimentoDao.
 * @author Andrea Califano
 * @author Gianluca Verlingieri
 * @author Donato Marmora
 * @author Luca Di Chiara
 */
public class TestRicevimentoDao {

  private String matricolaDoc = "0512101100";
  private RicevimentoBean rb = new RicevimentoBean();

  @BeforeClass
  public static void setUpClass() {

  }

  @AfterClass
  public static void tearDownClass() {

  }

  /**
   * In questo metodo verranno istanziati tutti 
   * gli oggetti che saranno utili per questa classe di test.
   */
  @Before
  public void setUp() throws Exception {

    DocenteBean db = new DocenteBean();
    String oraInizio = "10:00:00";
    String oraFine = "12:00:00";

    db.setNome("Mario");
    db.setCognome("Rossi");
    db.setEmail("mrossi@unisa.it");
    db.setPassword("F/NgVDRA+O9FrDoLn9AGew==");
    db.setMatricolaDoc(matricolaDoc);
    db.setStudio("A100");
    db.setImmagine("rossi.jpg");

    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    long oraI = sdf.parse(oraInizio).getTime();
    Time ti = new Time(oraI);
    long oraF = sdf.parse(oraFine).getTime();
    Time tf = new Time(oraF);

    rb.setGiorno("Lunedì");
    rb.setOra_inizio(ti);
    rb.setOra_fine(tf);
    rb.setMatricolaDoc(matricolaDoc);
    DocenteDao dd = new DocenteDao();
    dd.registraAccount(db);

  }

  /**
   * Questo metodo servirà per effettuare eventuali cancellazioni dopo i test.
   */
  @After
  public void tearDown() {

    DocenteDao dd = new DocenteDao();

    dd.eliminaAccount(matricolaDoc);

  }

  /**
   * Test del metodo stampaRicevimenti, della classe RicevimentiDao.
   */
  @Test

  public void testStampaRicevimenti() throws Exception {

    System.out.println("TEST CLASSE: [RicevimentoDAO], METODO: [stampaRicevimenti];");

    RicevimentoDao rd = new RicevimentoDao();
    DocenteDao dd = new DocenteDao();
    DocenteBean db = dd.getLogin("mrossi@unisa.it", "safemeeting1");
    ArrayList<RicevimentoBean> arrb = new ArrayList<RicevimentoBean>();

    arrb.add(rb);

    rd.creaRicevimento(rb);

    ArrayList<RicevimentoBean> result = rd.stampaRicevimenti(db);

    assertEquals(arrb.get(0).getGiorno(), result.get(0).getGiorno());
    assertEquals(arrb.get(0).getOra_inizio(), result.get(0).getOra_inizio());
    assertEquals(arrb.get(0).getOra_fine(), result.get(0).getOra_fine());
    assertEquals(arrb.get(0).getMatricolaDoc(), result.get(0).getMatricolaDoc());

    rd.eliminaRicevimento(rb);
  }

  /**
   * Test del metodo creaRicevimenti, della classe RicevimentiDao.
   */
  @Test

  public void testCreaRicevimento() throws Exception {

    System.out.println("TEST CLASSE: [RicevimentoDAO], METODO: [creaRicevimento];");

    RicevimentoDao rd = new RicevimentoDao();
    ArrayList<RicevimentoBean> arrb = new ArrayList<RicevimentoBean>();

    arrb.add(rb);

    boolean result = rd.creaRicevimento(rb);

    assertEquals(true, result);

    rd.eliminaRicevimento(rb);

  }

  /**
   * Test del metodo creaTipologia, della classe RicevimentiDao.
   */
  @Test

  public void testCreaTipologia() throws Exception {

    System.out.println("TEST CLASSE: [RicevimentoDAO], METODO: [creaTipologia];");

    String tempT = "30";
    String tempP = "20";
    String tempI = "10";
    String tempA = "5";

    int tempoT = Integer.parseInt(tempT);
    int tempoP = Integer.parseInt(tempP);
    int tempoI = Integer.parseInt(tempI);
    int tempoA = Integer.parseInt(tempA);

    ArrayList<Integer> arrTempo = new ArrayList<>();
    
    arrTempo.add(tempoT);
    arrTempo.add(tempoP);
    arrTempo.add(tempoI);
    arrTempo.add(tempoA);

    String tipoT = "Tesi";
    String tipoP = "Problematiche relative al corso";
    String tipoI = "Informazioni";
    String tipoA = "Altro";

    ArrayList<String> arrTipo = new ArrayList<>();
    
    arrTipo.add(tipoT);
    arrTipo.add(tipoP);
    arrTipo.add(tipoI);
    arrTipo.add(tipoA);
    
    TipologiaBean tb = new TipologiaBean();
    
    tb.setTipoMatricolaDoc(matricolaDoc);
    tb.setTempo(tempoA);
    tb.setTempo(tempoI);
    tb.setTempo(tempoP);
    tb.setTempo(tempoT);
    tb.setTipo(tipoA);
    tb.setTipo(tipoI);
    tb.setTipo(tipoP);
    tb.setTipo(tipoT);

    RicevimentoDao rd = new RicevimentoDao();
    
    boolean result = rd.creaTipologia(tb);

    assertEquals(true, result);
  }

  /**
   * Test del metodo creaTipologia, della classe RicevimentiDao Caso in cui
   * modifica la tipologia associata al docente già esistente.
   */
  @Test

  public void testCreaTipologia1() throws Exception {

    System.out.println("TEST CLASSE: [RicevimentoDAO],"
        + " METODO: [creaTipologia], MODIFICA TIPOLOGIA;");

    String tempT = "30";
    String tempP = "20";
    String tempI = "10";
    String tempA = "5";

    int tempoT = Integer.parseInt(tempT);
    int tempoP = Integer.parseInt(tempP);
    int tempoI = Integer.parseInt(tempI);
    int tempoA = Integer.parseInt(tempA);

    ArrayList<Integer> arrTempo = new ArrayList<>();
    
    arrTempo.add(tempoT);
    arrTempo.add(tempoP);
    arrTempo.add(tempoI);
    arrTempo.add(tempoA);

    String tipoT = "Tesi";
    String tipoP = "Problematiche relative al corso";
    String tipoI = "Informazioni";
    String tipoA = "Altro";
    
    ArrayList<String> arrTipo = new ArrayList<>();
    
    arrTipo.add(tipoT);
    arrTipo.add(tipoP);
    arrTipo.add(tipoI);
    arrTipo.add(tipoA);
    
    TipologiaBean tb = new TipologiaBean();
    
    tb.setTipoMatricolaDoc("0512101001");
    tb.setTempo(tempoA);
    tb.setTempo(tempoI);
    tb.setTempo(tempoP);
    tb.setTempo(tempoT);
    tb.setTipo(tipoA);
    tb.setTipo(tipoI);
    tb.setTipo(tipoP);
    tb.setTipo(tipoT);

    RicevimentoDao rd = new RicevimentoDao();
    
    boolean result = rd.creaTipologia(tb);

    assertEquals(true, result);
  }

  /**
   * Test del metodo eliminaRicevimento, della classe RicevimentiDao.
   */
  @Test

  public void testEliminaRicevimento() {

    System.out.println("TEST CLASSE: [RicevimentoDAO], METODO: [eliminaRicevimento];");

    RicevimentoDao rd = new RicevimentoDao();
    ArrayList<RicevimentoBean> arrb = new ArrayList<RicevimentoBean>();

    arrb.add(rb);

    rd.creaRicevimento(rb);

    boolean result = rd.eliminaRicevimento(rb);
    assertEquals(true, result);

  }

}
