package safemeeting.test;

/**
 * @author Andrea Califano
 * @author Gianluca Verlingieri
 * @author Donato Marmora
 * @author Luca Di Chiara
 */

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import safemeeting.model.DocenteBean;
import safemeeting.model.DocenteDao;
import safemeeting.model.PrenotaBean;
import safemeeting.model.PrenotaDao;
import safemeeting.model.RicevimentoBean;
import safemeeting.model.RicevimentoDao;
import safemeeting.model.StudenteBean;
import safemeeting.model.StudenteDao;

public class TestPrenotaDao extends TestCase {
  private DocenteBean db = new DocenteBean();
  private DocenteDao ddao = new DocenteDao();
  private PrenotaBean pb = new PrenotaBean();
  private PrenotaDao pdao = new PrenotaDao();
  private StudenteBean sb = new StudenteBean();
  private StudenteDao sdao = new StudenteDao();
  private RicevimentoBean rb = new RicevimentoBean();
  private String matricolaDoc = "0512101111";

  
  /**
   * In questo metodo verranno istanziati tutti 
   * gli oggetti che saranno utili per questa classe di test.
   */
  @Before
  public void setUp() throws Exception {

    db.setNome("Mario");
    db.setCognome("Rossi");
    db.setEmail("m.rossi@unisa.it");
    db.setPassword("F/NgVDRA+O9FrDoLn9AGew==");
    db.setMatricolaDoc(matricolaDoc);
    db.setStudio("A100");
    db.setImmagine("rossi.jpg");

    sb.setNome("Gianni");
    sb.setCognome("Bianchi");
    sb.setEmail("g.bianchi@studenti.unisa.it");
    sb.setPassword("F/NgVDRA+O9FrDoLn9AGew==");
    sb.setMatricolaStud("0512102222");

    String gio = "2019/01/11";
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    java.util.Date data = sdf.parse(gio);
    Date giorno = new Date(data.getTime());

    String oraInizio = "11:00:00";
    Time time = Time.valueOf(oraInizio);
    SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
    long oraI = sdf1.parse(oraInizio).getTime();
    String oraFine = "13:00:00";
    long oraF = sdf1.parse(oraFine).getTime();
    
    pb.setGiorno(giorno);
    pb.setNumero_prenotazione(1);
    pb.setOrario(time);
    pb.setNome_corso("Architettura degli Elaboratori");
    pb.setPrenotaEmailStud(sb.getEmail());
    pb.setPrenotaMatricolaDoc(matricolaDoc);
    pb.setTipologia("Tesi");

    Time ti = new Time(oraI);
    Time tf = new Time(oraF);
    
    rb.setGiorno("Lunedì");
    rb.setOra_inizio(ti);
    rb.setOra_fine(tf);
    rb.setMatricolaDoc(matricolaDoc);
  }

  /**
   * Questo metodo servirà per effettuare eventuali cancellazioni dopo i test.
   */
  @After
  public void tearDown() {
    ddao.eliminaAccount(matricolaDoc);
    sdao.eliminaAccount(sb.getEmail());
  }

  /**
   * Test del metodo effettuaPrenotazione, della classe PrenotaDao.
   */
  @Test
  public void testEffettuaPrenotazione() throws Exception {
    System.out.println("TEST CLASSE: [PrenotaDAO], METODO: [effettuaPrenotazione];");

    ddao.registraAccount(db);
    sdao.registraAccount(sb);

    boolean result = pdao.effettuaPrenotazione(pb);

    assertEquals(true, result);
  }

  /**
   * Test del metodo settaIndice, della classe PrenotaDao.
   */
  @Test
  public void testSettaIndice() throws Exception {
    
    StudenteBean sb1 = new StudenteBean();
    
    sb1.setCognome("Bonfiglio");
    sb1.setEmail("m.bonfiglio@studenti.unisa.it");
    sb1.setNome("Mario");
    sb1.setPassword("safemeeting1");
    sb1.setMatricolaStud("0512104123");

    PrenotaBean pb1 = new PrenotaBean();
    
    String gio = "2019/01/11";
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    java.util.Date data = sdf.parse(gio);
    Date giorno = new Date(data.getTime());

    String oraInizio = "11:30:00";
    Time time = Time.valueOf(oraInizio);
    
    pb1.setGiorno(giorno);
    pb1.setOrario(time);
    pb1.setNome_corso("Architettura degli Elaboratori");
    pb1.setPrenotaEmailStud("m.bonfiglio@studenti.unisa.it");
    pb1.setPrenotaMatricolaDoc(matricolaDoc);
    pb1.setTipologia("Tesi");
    
    ArrayList<PrenotaBean> arrpb = new ArrayList<PrenotaBean>();
    
    assertEquals(0,arrpb.size());
    arrpb.add(pb);
    assertEquals(pb.getNumero_prenotazione(), arrpb.size());
    arrpb.add(pb1);
    pb1.setNumero_prenotazione(pb.getNumero_prenotazione() + 1);
    assertEquals(pb1.getNumero_prenotazione(), arrpb.size());
  }
  
  /**
   * Test del metodo settaTempo, della classe PrenotaDao.
   */
  @Test
  public void testSettaTempo() throws Exception {

    System.out.println("TEST CLASSE: [PrenotaDAO], METODO: [settaTempo];");

    ArrayList<RicevimentoBean> rbarr = new ArrayList<RicevimentoBean>();

    rbarr.add(rb);

    sdao.registraAccount(sb);
    ddao.registraAccount(db);
    RicevimentoDao rd = new RicevimentoDao();
    rd.creaRicevimento(rb);

    boolean result = pdao.settaTempo(pb, rbarr);

    assertEquals(true, result);
  }

  /**
   * Test del metodo getNumPrenotazioni, della classe PrenotaDao.
   */
  @Test
  public void testGetNumPrenotazioni() throws Exception {
    System.out.println("TEST CLASSE: [PrenotaDAO], METODO: [getNumPrenotazioni];");

    sdao.registraAccount(sb);
    ddao.registraAccount(db);
    pdao.effettuaPrenotazione(pb);

    ArrayList<PrenotaBean> pbarr = new ArrayList<PrenotaBean>();
    pbarr.add(pb);

    ArrayList<PrenotaBean> result = pdao.getNumPrenotazioni(sb);

    assertEquals(pbarr.get(0).getNumero_prenotazione(), result.get(0).getNumero_prenotazione());
    assertEquals(pbarr.get(0).getPrenotaMatricolaDoc(), result.get(0).getPrenotaMatricolaDoc());
  }

  /**
   * Test del metodo getDocentePrenot, della classe PrenotaDao.
   */
  public void testGetDocentePrenot() throws Exception {
    System.out.println("TEST CLASSE: [PrenotaDAO], METODO: [getDocentePrenot];");

    sdao.registraAccount(sb);
    ddao.registraAccount(db);
    pdao.effettuaPrenotazione(pb);

    DocenteBean result = pdao.getDocentePrenot(sb, 1);

    assertEquals(db.getCognome(), result.getCognome());
    assertEquals(db.getNome(), result.getNome());
  }

  /**
   * Test del metodo getDatiPrenot, della classe PrenotaDao.
   */
  public void testGetDatiPrenot() throws Exception {
    System.out.println("TEST CLASSE: [PrenotaDAO], METODO: [getDatiPrenot];");

    sdao.registraAccount(sb);
    ddao.registraAccount(db);
    pdao.effettuaPrenotazione(pb);

    PrenotaBean result = pdao.getDatiPrenot(sb, 1);

    assertEquals(pb.getNumero_prenotazione(), result.getNumero_prenotazione());
    assertEquals(pb.getTipologia(), result.getTipologia());
    assertEquals(pb.getOrario(), result.getOrario());
    assertEquals(pb.getGiorno(), result.getGiorno());
  }

  /**
   * Test del metodo getNumPrenotati, della classe PrenotaDao.
   */
  public void testGetNumPrenotati() throws Exception {
    System.out.println("TEST CLASSE: [PrenotaDAO], METODO: [getNumPrenotati];");

    sdao.registraAccount(sb);
    ddao.registraAccount(db);
    pdao.effettuaPrenotazione(pb);

    int result = pdao.getNumPrenotati(db.getMatricolaDoc());

    assertEquals(1, result);
  }

  /**
   * Test del metodo eliminaPrenotazione, della classe PrenotaDao.
   */
  public void testEliminaPrenotazione() throws Exception {
    System.out.println("TEST CLASSE: [PrenotaDAO], METODO: [eliminaPrenotazione];");

    sdao.registraAccount(sb);
    ddao.registraAccount(db);
    pdao.effettuaPrenotazione(pb);

    boolean result = pdao.eliminaPrenotazione(sb, 1);

    assertEquals(true, result);
  }

  /**
   * Test del metodo listaPrenotatiDoc, della classe PrenotaDao.
   */
  public void testListaPrenotatiDoc() throws Exception {
    System.out.println("TEST CLASSE: [PrenotaDAO], METODO: [getNumPrenotati];");

    sdao.registraAccount(sb);
    ddao.registraAccount(db);
    pdao.effettuaPrenotazione(pb);

    ArrayList<PrenotaBean> pbarr = new ArrayList<PrenotaBean>();
    pbarr.add(pb);

    ArrayList<PrenotaBean> result = pdao.listaPrenotatiDoc(pb, db);

    assertEquals(pbarr.get(0).getNome_corso(), result.get(0).getNome_corso());
    assertEquals(pbarr.get(0).getTipologia(), result.get(0).getTipologia());
    assertEquals(pbarr.get(0).getGiorno(), result.get(0).getGiorno());
    assertEquals(pbarr.get(0).getOrario(), result.get(0).getOrario());
  }
}
