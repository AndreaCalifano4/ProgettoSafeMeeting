package safemeeting.test;

import java.util.ArrayList;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import safemeeting.model.DocenteBean;
import safemeeting.model.DocenteDao;
import safemeeting.model.PreferitiBean;
import safemeeting.model.PreferitiDao;
import safemeeting.model.StudenteBean;
import safemeeting.model.StudenteDao;

/**
 * Questo metodo testa i metodi della classe PreferitiDao.
 * @author Andrea Califano
 * @author Gianluca Verlingieri
 * @author Donato Marmora
 * @author Luca Di Chiara
 */

public class TestPreferitiDao extends TestCase {

  private String emailStud = "m.rossi21@studenti.unisa.it";
  private String emailDoc = "mrossi@unisa.it";

  /**
   * In questo metodo verranno istanziati tutti 
   * gli oggetti che saranno utili per questa classe di test.
   */
  @Before
  public void setUp() {
    DocenteBean db = new DocenteBean();

    db.setNome("Mario");
    db.setCognome("Rossi");
    db.setEmail("mrossi@unisa.it");
    db.setPassword("F/NgVDRA+O9FrDoLn9AGew==");
    db.setMatricolaDoc("0512101100");
    db.setStudio("A100");
    db.setImmagine("rossi.jpg");

    StudenteBean sb = new StudenteBean();
    
    sb.setNome("Marcello");
    sb.setCognome("Rossi");
    sb.setMatricolaStud("0512101111");
    sb.setEmail(emailStud);
    sb.setPassword("F/NgVDRA+O9FrDoLn9AGew==");

    StudenteDao sd = new StudenteDao();
    DocenteDao docdao = new DocenteDao();
    
    sd.registraAccount(sb);
    docdao.registraAccount(db);

  }

  /**
   * Questo metodo servirà per effettuare eventuali cancellazioni dopo i test.
   */
  @After
  public void tearDown() {

    DocenteDao ddao = new DocenteDao();
    StudenteDao sdao = new StudenteDao();
    sdao.eliminaAccount(emailStud);
    ddao.eliminaAccount("0512101100");

  }

  /**
   * Test del metodo getPreferiti, della classe PreferitiDao.
   */
  @Test
  public void testGetPreferiti() throws Exception {
    System.out.println("TEST CLASSE: [PreferitiDAO], METODO: [getPreferiti];");

    PreferitiBean pb = new PreferitiBean();
    DocenteDao ddao = new DocenteDao();
    DocenteBean db = ddao.getLogin("mrossi@unisa.it", "safemeeting1");
    ArrayList<DocenteBean> arrDoc = new ArrayList<DocenteBean>();
    arrDoc.add(db);
    pb.setPreferitiEmailStud(emailStud);
    pb.setMatricolaDoc("0512101100");
    PreferitiDao pdao = new PreferitiDao();
    pdao.setPreferiti(pb.getMatricolaDoc(), pb.getPreferitiEmailStud());

    ArrayList<DocenteBean> result = pdao.getPreferiti(emailStud);
    int i = 0;

    while (i < arrDoc.size()) {
      assertEquals(arrDoc.get(i).getNome(), result.get(i).getNome());
      assertEquals(arrDoc.get(i).getCognome(), result.get(i).getCognome());
      assertEquals(arrDoc.get(i).getImmagine(), result.get(i).getImmagine());
      assertEquals(arrDoc.get(i).getMatricolaDoc(), result.get(i).getMatricolaDoc());
      i++;
    }

    pdao.deletePreferiti(pb.getMatricolaDoc(), pb.getPreferitiEmailStud(), result);
  }

  /**
   * Test del metodo setPreferiti, della classe PreferitiDao.
   */
  @Test
  public void testSetPreferiti() throws Exception {
    System.out.println("TEST CLASSE: [PreferitiDAO], METODO: [setPreferiti];");

    PreferitiBean pb = new PreferitiBean();
    DocenteDao ddao = new DocenteDao();
    DocenteBean db = ddao.getLogin(emailDoc, "safemeeting1");
    ArrayList<DocenteBean> arrDoc = new ArrayList<DocenteBean>();
    arrDoc.add(db);
    pb.setPreferitiEmailStud(emailStud);
    pb.setMatricolaDoc("0512101100");
    PreferitiDao pdao = new PreferitiDao();
    pdao.setPreferiti(pb.getMatricolaDoc(), pb.getPreferitiEmailStud());
    
    ArrayList<DocenteBean> result = pdao.getPreferiti(emailStud);

    int i = 0;
    while (i < arrDoc.size()) {
      assertEquals(arrDoc.get(i).getNome(), result.get(i).getNome());
      assertEquals(arrDoc.get(i).getCognome(), result.get(i).getCognome());
      assertEquals(arrDoc.get(i).getImmagine(), result.get(i).getImmagine());
      assertEquals(arrDoc.get(i).getMatricolaDoc(), result.get(i).getMatricolaDoc());
      i++;
    }

    pdao.deletePreferiti(pb.getMatricolaDoc(), pb.getPreferitiEmailStud(), result);
  }

  /**
   * Test del metodo setPreferiti, della classe PreferitiDao Docente già presente
   * nella lista dei preferiti.
   */
  @Test
  public void testSetPreferiti1() throws Exception {
    System.out.println("TEST CLASSE: [PreferitiDAO], "
        + "METODO: [setPreferiti], DOCENTE PRESENTE IN PREFERITI;");

    PreferitiBean pb = new PreferitiBean();
    PreferitiDao pdao = new PreferitiDao();

    pb.setPreferitiEmailStud("l.dichiara3@studenti.unisa.it");
    pb.setMatricolaDoc("0512101001");
    boolean result = pdao.setPreferiti(pb.getMatricolaDoc(), pb.getPreferitiEmailStud());

    assertEquals(false, result);
  }

  /**
   * Test del metodo deletePreferiti, della classe PreferitiDao.
   */
  @Test
  public void testDeletePreferiti() throws Exception {
    System.out.println("TEST CLASSE: [PreferitiDAO], METODO: [deletePreferiti];");

    PreferitiBean pb = new PreferitiBean();
    PreferitiDao pdao = new PreferitiDao();
    DocenteDao ddao = new DocenteDao();
    DocenteBean db = ddao.getLogin(emailDoc, "safemeeting1");

    pb.setPreferitiEmailStud(emailStud);
    pb.setMatricolaDoc(db.getMatricolaDoc());
    pdao.setPreferiti(pb.getMatricolaDoc(), pb.getPreferitiEmailStud());
    ArrayList<DocenteBean> arrdoc = pdao.getPreferiti(emailStud);
    boolean result = pdao.deletePreferiti(pb.getMatricolaDoc(), pb.getPreferitiEmailStud(), arrdoc);
    assertEquals(true, result);
  }

}
