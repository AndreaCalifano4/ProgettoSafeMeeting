package safemeeting.test;

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

/**
 * Questa è la classe che testa i metodo di CorsoDao.
 * @author Andrea Califano
 * @author Gianluca Verlingieri
 * @author Donato Marmora
 * @author Luca Di Chiara
 */

public class TestCorsoDao extends TestCase {

  private CorsoBean cb = new CorsoBean();
  private CorsoDao cdao = new CorsoDao();
  private DocenteBean db = new DocenteBean();
  private DocenteDao ddao = new DocenteDao();
  private InsegnaBean ib = new InsegnaBean();

  /**
   * In questo metodo verranno istanziati tutti 
   * gli oggetti che saranno utili per questa classe di test.
   */
  @Before
  public void setUp() {
    db.setNome("Mario");
    db.setCognome("Rossi");
    db.setEmail("m.rossi@unisa.it");
    db.setPassword("F/NgVDRA+O9FrDoLn9AGew==");
    db.setMatricolaDoc("0512101111");
    db.setStudio("A100");
    db.setImmagine("rossi.jpg");

    ddao.registraAccount(db);

    cb.setCodice("0512100001");
    cb.setNome("Analisi Matematica");
    cb.setNum_cfu(9);
    cb.setOre_totali(72);

    ib.setInsegnaCodiceCorso(cb.getCodice());
    ib.setInsegnaMatricolaDoc(db.getMatricolaDoc());
  }

  /**
   * Questo metodo servirà per effettuare eventuali cancellazioni dopo i test.
   */
  @After
  public void tearDown() {
    ddao.eliminaAccount("0512101111");
    cdao.eliminaCorso(ib);
  }

  /**
   * Test del metodo stampaCorsi, della classe CorsoDao.
   */
  @Test
  public void testStampaCorsi() throws Exception {
    System.out.println("TEST CLASSE: [CorsoDAO], METODO: [stampaCorsi];");

    ArrayList<CorsoBean> cbarr = new ArrayList<CorsoBean>();
    cbarr.add(cb);

    ArrayList<CorsoBean> result = cdao.stampaCorsi(cb);

    assertEquals(cbarr.get(0).getCodice(), result.get(0).getCodice());
    assertEquals(cbarr.get(0).getNome(), result.get(0).getNome());
    assertEquals(cbarr.get(0).getNum_cfu(), result.get(0).getNum_cfu());
    assertEquals(cbarr.get(0).getOre_totali(), result.get(0).getOre_totali());
  }

  /**
   * Test del metodo associaCorso, della classe CorsoDao.
   */
  @Test
  public void testAssociaCorso() throws Exception {
    System.out.println("TEST CLASSE: [CorsoDAO], METODO: [associaCorso];");

    String matricolaDoc = db.getMatricolaDoc();
    CorsoBean result = cdao.associaCorso(ib);

    assertEquals(ib.getInsegnaCodiceCorso(), result.getCodice());
    assertEquals(ib.getInsegnaMatricolaDoc(), matricolaDoc);
  }

  /**
   * Test del metodo visualizzaCorsi, della classe CorsoDao.
   */
  public void testVisualizzaCorsi() throws Exception {
    System.out.println("TEST CLASSE: [CorsoDAO], METODO: [visualizzaCorsi];");

    cdao.associaCorso(ib);
    ArrayList<CorsoBean> cbarr = new ArrayList<CorsoBean>();
    cbarr.add(cb);

    ArrayList<CorsoBean> result = cdao.visualizzaCorsi(db);

    assertEquals(cbarr.get(0).getCodice(), result.get(0).getCodice());
    assertEquals(cbarr.get(0).getNome(), result.get(0).getNome());
    assertEquals(cbarr.get(0).getNum_cfu(), result.get(0).getNum_cfu());
    assertEquals(cbarr.get(0).getOre_totali(), result.get(0).getOre_totali());
  }

  /**
   * Test del metodo eliminaCorso, della classe CorsoDao.
   */
  public void testEliminaCorso() throws Exception {
    System.out.println("TEST CLASSE: [CorsoDAO], METODO: [eliminaCorso];");

    boolean result = cdao.eliminaCorso(ib);

    assertEquals(true, result);
  }
}