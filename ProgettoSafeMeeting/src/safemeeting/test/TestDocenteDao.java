package safemeeting.test;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import safemeeting.model.CorsoBean;
import safemeeting.model.DocenteBean;
import safemeeting.model.DocenteDao;
import safemeeting.model.MessaggioBean;
import safemeeting.model.PrenotaBean;
import safemeeting.model.PrenotaDao;
import safemeeting.model.StudenteBean;
import safemeeting.model.StudenteDao;

/**
 * Questa classe testa i metodi della classe DocenteDao.
 * @author Andrea Califano
 * @author Gianluca Verlingieri
 * @author Donato Marmora
 * @author Luca Di Chiara
 */

public class TestDocenteDao extends TestCase {

  private DocenteBean db = new DocenteBean();
  private DocenteDao ddao = new DocenteDao();
  private PrenotaBean pb = new PrenotaBean();
  private PrenotaDao pd = new PrenotaDao();
  private StudenteBean sb = new StudenteBean();
  private StudenteDao sdao = new StudenteDao();
  private MessaggioBean mb = new MessaggioBean();
  private CorsoBean cb = new CorsoBean();

  
  /**
   * In questo metodo verranno istanziati tutti 
   * gli oggetti che saranno utili per questa classe di test.
   */
  @Before
  public void setUp() throws ParseException {
    db.setNome("Mario");
    db.setCognome("Rossi");
    db.setEmail("m.rossi@unisa.it");
    db.setPassword("F/NgVDRA+O9FrDoLn9AGew==");
    db.setMatricolaDoc("0512101111");
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
    String tempo = "15:00:00";
    Time time = Time.valueOf(tempo);
    pb.setGiorno(giorno);
    pb.setNumero_prenotazione(1);
    pb.setNome_corso("Architettura degli Elaboratori");
    pb.setOrario(time);
    pb.setPrenotaEmailStud(sb.getEmail());
    pb.setPrenotaMatricolaDoc(db.getMatricolaDoc());
    pb.setTipologia("Informazioni");

    mb.setMessaggio("Ciao");
    mb.setMessaggioEmailStud("g.bianchi@studenti.unisa.it");
    mb.setMessaggioMatricolaDoc("0512101111");

    cb.setCodice("0512100001");
    cb.setNome("Analisi Matematica");
    cb.setNum_cfu(9);
    cb.setOre_totali(72);
  }

  /**
   * Questo metodo servirà per effettuare eventuali cancellazioni dopo i test.
   */
  @After
  public void tearDown() {
    ddao.eliminaAccount(db.getMatricolaDoc());
    sdao.eliminaAccount(sb.getEmail());
  }

  /**
   * Test del metodo registraAccount, della classe DocenteDao.
   */
  @Test
  public void testRegistraAccount() throws Exception {
    System.out.println("TEST CLASSE: [DocenteDAO], METODO: [registraAccount];");

    boolean result = ddao.registraAccount(db);

    assertEquals(true, result);
  }

  /**
   * Test del metodo getLogin, della classe DocenteDao.
   */
  @Test
  public void testGetLogin() throws Exception {
    System.out.println("TEST CLASSE: [DocenteDAO], METODO: [getLogin];");

    ddao.registraAccount(db);

    DocenteBean result = ddao.getLogin(db.getEmail(), "safemeeting1");

    assertEquals(db.getNome(), result.getNome());
    assertEquals(db.getCognome(), result.getCognome());
    assertEquals(db.getEmail(), result.getEmail());
    assertEquals(db.getMatricolaDoc(), result.getMatricolaDoc());
  }

  /**
   * Test del metodo assenzaDocente, della classe DocenteDao.
   */
  @Test
  public void testAssenzaDocente() throws Exception {
    System.out.println("TEST CLASSE: [DocenteDAO], METODO: [assenzaDocente];");

    ddao.registraAccount(db);

    String tia = "10:00:00";
    Time timeia = Time.valueOf(tia);
    String tfa = "18:00:00";
    Time timefa = Time.valueOf(tfa);

    boolean result = ddao.assenzaDocente(db.getMatricolaDoc(), timeia, timefa, pb.getGiorno());

    assertEquals(true, result);
  }

  /**
   * Test del metodo getStudentiAssenza, della classe DocenteDao.
   */
  @Test
  public void testGetStudentiAssenza() throws Exception {
    System.out.println("TEST CLASSE: [DocenteDAO], METODO: [getStudentiAssenza]");

    sdao.registraAccount(sb);
    ddao.registraAccount(db);
    pd.effettuaPrenotazione(pb);

    ArrayList<StudenteBean> sbarr = new ArrayList<StudenteBean>();
    sbarr.add(sb);

    String tia = "10:00:00";
    Time timeia = Time.valueOf(tia);
    String tfa = "18:00:00";
    Time timefa = Time.valueOf(tfa);

    ArrayList<StudenteBean> result = ddao.getStudentiAssenza(db, pb.getGiorno(), timeia, timefa);

    assertEquals(sbarr.get(0).getCognome(), result.get(0).getCognome());
    assertEquals(sbarr.get(0).getEmail(), result.get(0).getEmail());
    assertEquals(sbarr.get(0).getMatricolaStud(), result.get(0).getMatricolaStud());
    assertEquals(sbarr.get(0).getNome(), result.get(0).getNome());
    assertEquals(sbarr.get(0).getPassword(), result.get(0).getPassword());
  }

  /**
   * Test del metodo getStudenti, della classe DocenteDao.
   */
  @Test
  public void testGetStudenti() throws Exception {
    System.out.println("TEST CLASSE: [DocenteDAO], METODO: [getStudenti];");

    sdao.registraAccount(sb);
    ddao.registraAccount(db);
    pd.effettuaPrenotazione(pb);

    ArrayList<StudenteBean> sbarr = new ArrayList<StudenteBean>();
    sbarr.add(sb);

    ArrayList<StudenteBean> result = ddao.getStudenti(db);

    assertEquals(sbarr.get(0).getNome(), result.get(0).getNome());
    assertEquals(sbarr.get(0).getCognome(), result.get(0).getCognome());
    assertEquals(sbarr.get(0).getEmail(), result.get(0).getEmail());
    assertEquals(sbarr.get(0).getMatricolaStud(), result.get(0).getMatricolaStud());
    assertEquals(sbarr.get(0).getPassword(), result.get(0).getPassword());
  }

  /**
   * Test del metodo setMessaggio, della classe DocenteDao.
   */
  @Test
  public void testSetMessaggio() throws Exception {
    System.out.println("TEST CLASSE: [DocenteDAO], METODO: [setMessaggio];");

    ddao.registraAccount(db);
    sdao.registraAccount(sb);

    boolean result = ddao.setMessaggio(mb);

    assertEquals(true, result);
  }

  /**
   * Test del metodo eliminaAccount, della classe DocenteDao.
   */
  @Test
  public void testEliminaAccount() throws Exception {
    System.out.println("TEST CLASSE: [DocenteDAO], METODO: [eliminaAccount];");

    ddao.registraAccount(db);

    boolean result = ddao.eliminaAccount(db.getMatricolaDoc());

    assertEquals(true, result);
  }

  /**
   * Test del metodo modificaAccount, della classe DocenteDao.
   */
  @Test
  public void testModificaAccount() throws Exception {
    System.out.println("TEST CLASSE: [DocenteDAO], METODO: [modificaAccount];");

    ddao.registraAccount(db);
    String newpassword = "F/NgVDRA+O9FrDoLn9AGew==";

    DocenteBean result = ddao.modificaAccount(db.getNome(), 
        db.getCognome(), db.getMatricolaDoc(), db.getStudio(),
        db.getPassword(), newpassword, db.getImmagine(), db.getEmail());

    assertEquals(db.getCognome(), result.getCognome());
    assertEquals(db.getEmail(), result.getEmail());
    assertEquals(db.getImmagine(), result.getImmagine());
    assertEquals(db.getMatricolaDoc(), result.getMatricolaDoc());
    assertEquals(db.getNome(), result.getNome());
    assertEquals(db.getPassword(), result.getPassword());
    assertEquals(db.getStudio(), result.getStudio());
  }
}