package safemeeting.test;

/**
 * @author Andrea Califano
 * @author Gianluca Verlingieri
 * @author Donato Marmora
 * @author Luca Di Chiara
 */

import java.sql.Time;
import java.text.SimpleDateFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import safemeeting.controller.ServletStampaRicevimenti;
import safemeeting.model.DocenteBean;
import safemeeting.model.RicevimentoBean;
import safemeeting.model.RicevimentoDao;

public class TestServletStampaRicevimenti extends Mockito {

  @Mock
  HttpServletRequest request;
  @Mock
  HttpServletResponse response;
  @Mock
  HttpSession session;
  @Mock
  RequestDispatcher rd;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
  }

  /**
   * Questo metodo testa ServletStampaRicevimenti nel caso in cui dovranno essere
   * stampati lato docente i ricevimenti.
   */

  @Test
  public void testServletStampaRicevimenti() throws Exception {

    DocenteBean db = new DocenteBean();

    db.setNome("Alberto");
    db.setCognome("Negro");
    db.setEmail("alberto@unisa.it");
    db.setPassword("safemeeting1");
    db.setMatricolaDoc("0512101001");
    db.setStudio("A001");

    RicevimentoBean rb = new RicevimentoBean();

    rb.setGiorno("Martedì");
    rb.setMatricolaDoc("0512101001");

    String oraInizio = "10:00:00";
    String oraFine = "12:00:00";

    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    long oraI = sdf.parse(oraInizio).getTime();
    Time ti = new Time(oraI);
    long oraF = sdf.parse(oraFine).getTime();
    Time tf = new Time(oraF);

    rb.setOra_inizio(ti);
    rb.setOra_fine(tf);

    RicevimentoDao ric = new RicevimentoDao();
    ric.creaRicevimento(rb);
    
    HttpServletRequest request = mock(HttpServletRequest.class);
    HttpSession session = mock(HttpSession.class);
    RequestDispatcher rd = mock(RequestDispatcher.class);
    
    when(request.getSession()).thenReturn(session);
    when(request.getRequestDispatcher("OrarioRicevimento.jsp")).thenReturn(rd);
    when(session.getAttribute("docbean")).thenReturn(db);

    HttpServletResponse response = mock(HttpServletResponse.class);

    new ServletStampaRicevimenti().doPost(request, response);

  }

}