package safemeeting.test;

import java.sql.Time;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import safemeeting.model.CorsoBean;
import safemeeting.model.CorsoDao;
import safemeeting.model.DocenteBean;
import safemeeting.model.DocenteDao;
import safemeeting.model.InsegnaBean;
import safemeeting.model.MessaggioBean;
import safemeeting.model.RicevimentoBean;
import safemeeting.model.RicevimentoDao;
import safemeeting.model.StudenteBean;
import safemeeting.model.StudenteDao;
import safemeeting.model.TipologiaBean;

/**
 * Questa classe testa i metodi di StudenteDao.
 * @author Andrea Califano
 * @author Gianluca Verlingieri
 * @author Donato Marmora
 * @author Luca Di Chiara
 */

public class TestStudenteDao extends TestCase {

  private DocenteBean dbGlobal = new DocenteBean();
  private DocenteDao ddaoGlobal = new DocenteDao();
  private StudenteBean sbGlobal = new StudenteBean();
  private StudenteDao sdaoGlobal = new StudenteDao();
  private String emailStud = "m.rossi21@studenti.unisa.it";
  private String emailDoc = "mrossi@unisa.it";
  private String matricolaDoc = "0512101100";

  /**
   * In questo metodo verranno istanziati tutti 
   * gli oggetti che saranno utili per questa classe di test.
   */
  @Before
  public void setUp() {

    dbGlobal.setNome("Mario");
    dbGlobal.setCognome("Rossi");
    dbGlobal.setEmail(emailDoc);
    dbGlobal.setPassword("F/NgVDRA+O9FrDoLn9AGew==");
    dbGlobal.setMatricolaDoc(matricolaDoc);
    dbGlobal.setStudio("A100");
    dbGlobal.setImmagine("");

    sbGlobal.setNome("Marcello");
    sbGlobal.setCognome("Rossi");
    sbGlobal.setMatricolaStud("0512101111");
    sbGlobal.setEmail(emailStud);
    sbGlobal.setPassword("F/NgVDRA+O9FrDoLn9AGew==");

  }

  /**
   * Questo metodo testa la ServletLogin in caso di Login di uno studente.
   */
  @After
  public void tearDown() {

    sdaoGlobal.eliminaAccount(emailStud);
    ddaoGlobal.eliminaAccount(matricolaDoc);

  }

  /**
   * Test del metodo registraAccount, della classe StudenteDao.
   */
  @Test
  public void testRegistraAccount() throws Exception {
    System.out.println("TEST CLASSE: [StudenteDAO], METODO: [registraAccountStudente];");

    boolean result = sdaoGlobal.registraAccount(sbGlobal);

    assertEquals(true, result);
  }

  /**
   * Test del metodo getLogin, della classe StudenteDao.
   */
  @Test
  public void testGetLogin() throws Exception {
    System.out.println("TEST CLASSE: [StudenteDAO], METODO: [getLoginStudente];");

    sdaoGlobal.registraAccount(sbGlobal);

    StudenteBean result = sdaoGlobal.getLogin(emailStud, "safemeeting1");

    assertEquals(sbGlobal.getNome(), result.getNome());
    assertEquals(sbGlobal.getCognome(), result.getCognome());
    assertEquals(sbGlobal.getEmail(), result.getEmail());
    assertEquals(sbGlobal.getMatricolaStud(), result.getMatricolaStud());
  }

  /**
   * Test del metodo getDocente, della classe StudenteDao.
   */
  @Test
  public void testGetDocente() throws Exception {
    System.out.println("TEST CLASSE: [StudenteDAO], METODO: [getDocente];");

    ddaoGlobal.registraAccount(dbGlobal);

    DocenteBean result = sdaoGlobal.getDocente(matricolaDoc);

    assertEquals(matricolaDoc, result.getMatricolaDoc());
    assertEquals(dbGlobal.getNome(), result.getNome());
    assertEquals(dbGlobal.getCognome(), result.getCognome());
    assertEquals(dbGlobal.getPassword(), result.getPassword());
    assertEquals(dbGlobal.getStudio(), result.getStudio());
    assertEquals(emailDoc, result.getEmail());
    assertEquals(dbGlobal.getImmagine(), result.getImmagine());
  }

  /**
   * Test del metodo getCorso, dalla classe StudenteDao.
   */
  @Test
  public void testGetCorso() throws Exception {
    System.out.println("TEST CLASSE: [StudenteDAO], METODO: [getCorso];");

    InsegnaBean ib = new InsegnaBean();
    ddaoGlobal.registraAccount(dbGlobal);

    ib.setInsegnaMatricolaDoc(matricolaDoc);
    ib.setInsegnaCodiceCorso("0512100003");
    CorsoBean cb = null;
    CorsoDao cdao = new CorsoDao();
    cb = cdao.associaCorso(ib);

    ArrayList<CorsoBean> result = sdaoGlobal.getCorso(matricolaDoc);

    assertEquals(cb.getNome(), result.get(0).getNome());

    cdao.eliminaCorso(ib);
  }

  /**
   * Test del metodo getRicevimento, della classe StudenteDao.
   */
  @Test
  public void testGetRicevimento() throws Exception {
    System.out.println("TEST CLASSE: [StudenteDAO], METODO: [getRicevimento];");

    String oraInizio = "10:00:00";
    String oraFine = "12:00:00";

    RicevimentoBean rb = new RicevimentoBean();
    ddaoGlobal.registraAccount(dbGlobal);

    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    long oraI = sdf.parse(oraInizio).getTime();
    Time ti = new Time(oraI);
    long oraF = sdf.parse(oraFine).getTime();
    Time tf = new Time(oraF);

    rb.setGiorno("Lunedì");
    rb.setOra_inizio(ti);
    rb.setOra_fine(tf);
    rb.setMatricolaDoc(matricolaDoc);
    RicevimentoDao rdao = new RicevimentoDao();
    rdao.creaRicevimento(rb);

    ArrayList<RicevimentoBean> result = sdaoGlobal.getRicevimento(matricolaDoc);

    assertEquals(rb.getGiorno(), result.get(0).getGiorno());
    assertEquals(rb.getOra_fine(), result.get(0).getOra_fine());
    assertEquals(rb.getOra_inizio(), result.get(0).getOra_inizio());

    rdao.eliminaRicevimento(rb);
  }

  /**
   * Test del metodo getTipologia, della classe StudenteDao.
   */
  @Test
  public void testGetTipologia() throws Exception {
    System.out.println("TEST CLASSE: [StudenteDAO], METODO: [getTipologia];");

    TipologiaBean tb = new TipologiaBean();
    ddaoGlobal.registraAccount(dbGlobal);

    tb.setTipoMatricolaDoc(matricolaDoc);
    tb.setTipo("Altro");
    tb.setTempo(30);
    RicevimentoDao rdao = new RicevimentoDao();
    rdao.creaTipologia(tb);

    ArrayList<TipologiaBean> result = sdaoGlobal.getTipologia(matricolaDoc);

    assertEquals(tb.getTipoMatricolaDoc(), result.get(0).getTipoMatricolaDoc());
    assertEquals(tb.getTipo(), result.get(0).getTipo());
    assertEquals(tb.getTempo(), result.get(0).getTempo());

  }

  /**
   * Test del metodo getMessaggio, della classe StudenteDao.
   */
  @Test
  public void testGetMessaggio() throws Exception {
    System.out.println("TEST CLASSE: [StudenteDAO], METODO: [getMessaggio];");

    MessaggioBean mb = new MessaggioBean();
    mb.setMessaggio("Messagio di prova.");
    mb.setMessaggioEmailStud(emailStud);
    mb.setMessaggioMatricolaDoc(matricolaDoc);

    sdaoGlobal.registraAccount(sbGlobal);
    ddaoGlobal.registraAccount(dbGlobal);
    ddaoGlobal.setMessaggio(mb);

    ArrayList<MessaggioBean> result = sdaoGlobal.getMessaggio(emailStud);

    assertEquals(mb.getMessaggio(), result.get(0).getMessaggio());
    assertEquals(mb.getMessaggioEmailStud(), result.get(0).getMessaggioEmailStud());
    assertEquals(mb.getMessaggioMatricolaDoc(), result.get(0).getMessaggioMatricolaDoc());

  }

  /**
   * Test del metodo getDocMessaggio, della classe StudenteDao.
   */
  @Test
  public void testGetDocMessaggio() throws Exception {
    System.out.println("TEST CLASSE: [StudenteDAO], METODO: [getDocMessaggio];");

    MessaggioBean mb = new MessaggioBean();
    mb.setMessaggio("Messagio di prova.");
    mb.setMessaggioEmailStud(emailStud);
    mb.setMessaggioMatricolaDoc(matricolaDoc);

    sdaoGlobal.registraAccount(sbGlobal);
    ddaoGlobal.registraAccount(dbGlobal);
    ddaoGlobal.setMessaggio(mb);

    ArrayList<DocenteBean> result = sdaoGlobal.getDocMessaggio(emailStud);

    assertEquals(dbGlobal.getNome(), result.get(0).getNome());
    assertEquals(dbGlobal.getCognome(), result.get(0).getCognome());

  }

  /**
   * Test del metodo eliminaAccount, della classe StudenteDao.
   */
  @Test
  public void testEliminaAccount() throws Exception {
    System.out.println("TEST CLASSE: [StudenteDAO], METODO: [eliminaAccount];");

    sdaoGlobal.registraAccount(sbGlobal);

    boolean result = sdaoGlobal.eliminaAccount(emailStud);

    assertEquals(true, result);

  }

  /**
   * Test del metodo ricercaDocente, della classe StudenteDao In input al metodo
   * inseriamo il parametro "ros".
   */
  @Test
  public void testRicercaDocente() throws Exception {
    System.out.println("TEST CLASSE: [StudenteDAO], "
        + "METODO: [ricercaDocente], PARAMETRO RICERCA: [ros];");

    InsegnaBean ib = new InsegnaBean();
    // dbGlobal.setImmagine("rossi.jpg");
    ddaoGlobal.registraAccount(dbGlobal);

    ib.setInsegnaMatricolaDoc(matricolaDoc);
    ib.setInsegnaCodiceCorso("0512100003");
    CorsoDao cdao = new CorsoDao();
    cdao.associaCorso(ib);

    ArrayList<DocenteBean> result = sdaoGlobal.ricercaDocente("ros", dbGlobal);

    assertEquals(matricolaDoc, result.get(0).getMatricolaDoc());
    assertEquals(dbGlobal.getNome(), result.get(0).getNome());
    assertEquals(dbGlobal.getCognome(), result.get(0).getCognome());
    assertEquals(emailDoc, result.get(0).getEmail());
    assertEquals(dbGlobal.getPassword(), result.get(0).getPassword());
    assertEquals(dbGlobal.getStudio(), result.get(0).getStudio());
    assertEquals(dbGlobal.getImmagine(), result.get(0).getImmagine());

    cdao.eliminaCorso(ib);
  }

  /**
   * Test del metodo ricercaDocente, della classe StudenteDao In input al metodo
   * inseriamo il parametro " " (campo vuoto).
   */
  @Test
  public void testRicercaDocente1() throws Exception {
    System.out.println("TEST CLASSE: [StudenteDAO],"
        + " METODO: [ricercaDocente], PARAMETRO RICERCA: [ ];");

    InsegnaBean ib = new InsegnaBean();
    // dbGlobal.setImmagine("rossi.jpg");
    ddaoGlobal.registraAccount(dbGlobal);

    ib.setInsegnaMatricolaDoc(matricolaDoc);
    ib.setInsegnaCodiceCorso("0512100003");
    CorsoDao cdao = new CorsoDao();
    cdao.associaCorso(ib);

    /* RESULT */

    assertEquals(null, sdaoGlobal.ricercaDocente("", dbGlobal));

    cdao.eliminaCorso(ib);
  }

  /**
   * Test del metodo ricercaDocente, della classe StudenteDao In input al metodo
   * inseriamo il parametro "Pasquale" (docente non presente).
   */
  @Test
  public void testRicercaDocente2() throws Exception {
    System.out.println("TEST CLASSE: [StudenteDAO],"
        + " METODO: [ricercaDocente], PARAMETRO RICERCA: [Pasquale];");

    InsegnaBean ib = new InsegnaBean();
    // dbGlobal.setImmagine("rossi.jpg");
    ddaoGlobal.registraAccount(dbGlobal);

    ib.setInsegnaMatricolaDoc(matricolaDoc);
    ib.setInsegnaCodiceCorso("0512100003");
    CorsoDao cdao = new CorsoDao();
    cdao.associaCorso(ib);

    /* RESULT */
    assertEquals(null, sdaoGlobal.ricercaDocente("Pasquale", dbGlobal));

    cdao.eliminaCorso(ib);
  }

  /**
   * Test del metodo ricercaDocente, della classe StudenteDao In input al metodo
   * inseriamo il parametro "Ingegneria del software" (ricerca attesa due docenti).
   */
  @Test
  public void testRicercaDocente3() throws Exception {
    System.out.println("TEST CLASSE: [StudenteDAO], "
        + "METODO: [ricercaDocente], PARAMETRO RICERCA: [ingegneria del software];");

    DocenteBean local = ddaoGlobal.getLogin("fferrucci@unisa.it", "safemeeting1");
    ArrayList<DocenteBean> result = sdaoGlobal.ricercaDocente("ingegneria del software", dbGlobal);

    assertEquals(local.getMatricolaDoc(), result.get(0).getMatricolaDoc());
    assertEquals(local.getNome(), result.get(0).getNome());
    assertEquals(local.getCognome(), result.get(0).getCognome());
    assertEquals(local.getEmail(), result.get(0).getEmail());
    // assertEquals(local.getPassword(), result.get(0).getPassword());
    assertEquals(local.getStudio(), result.get(0).getStudio());
    assertEquals(local.getImmagine(), result.get(0).getImmagine());

    DocenteBean local1 = ddaoGlobal.getLogin("gravino@unisa.it", "safemeeting1");
    
    assertEquals(local1.getMatricolaDoc(), result.get(1).getMatricolaDoc());
    assertEquals(local1.getNome(), result.get(1).getNome());
    assertEquals(local1.getCognome(), result.get(1).getCognome());
    assertEquals(local1.getEmail(), result.get(1).getEmail());
    // assertEquals(local1.getPassword(), result.get(1).getPassword());
    assertEquals(local1.getStudio(), result.get(1).getStudio());
    assertEquals(local1.getImmagine(), result.get(1).getImmagine());

  }

  /**
   * Test del metodo modificaAccount, della classe StudenteDao.
   */
  @Test
  public void testModificaAccount() throws Exception {
    System.out.println("TEST CLASSE: [StudenteDAO], METODO: [modificaAccountStudente];");

    sdaoGlobal.registraAccount(sbGlobal);

    StudenteBean result = sdaoGlobal.modificaAccount(sbGlobal.getNome(), sbGlobal.getCognome(),
        sbGlobal.getMatricolaStud(), sbGlobal.getPassword(), 
        "F/NgVDRA+O9FrDoLn9AGew==", sbGlobal.getEmail());

    assertEquals(sbGlobal.getNome(), result.getNome());
    assertEquals(sbGlobal.getCognome(), result.getCognome());
    assertEquals(sbGlobal.getEmail(), result.getEmail());
    assertEquals(sbGlobal.getMatricolaStud(), result.getMatricolaStud());
    assertEquals(sbGlobal.getPassword(), result.getPassword());
  }

}
