package safemeeting.test;

/**
 * @author Andrea Califano
 * @author Gianluca Verlingieri
 * @author Donato Marmora
 * @author Luca Di Chiara
 */

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import safemeeting.controller.ServletStampaPrenotazioni;
import safemeeting.model.PrenotaBean;
import safemeeting.model.PrenotaDao;
import safemeeting.model.StudenteBean;

public class TestServletStampaPrenotazioni extends Mockito {

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
   * Questo metodo servirà per effettuare eventuali cancellazioni dopo i test.
   */
  
  @After
  public void tearDown() {
    StudenteBean sb = new StudenteBean();
    sb.setNome("Donato");
    sb.setCognome("Marmora");
    sb.setEmail("d.marmora1@studenti.unisa.it");
    sb.setPassword("safemeeting1");
    sb.setMatricolaStud("0512104565");
    PrenotaDao pd = new PrenotaDao();
    pd.eliminaPrenotazione(sb, 1);
  }

  /**
   * Questo metodo testa ServletStampaPrenotazioni nel caso in cui dovranno essere
   * visualizzate le prenotazioni lasto studente.
   */

  @Test
  public void testServletStampaPrenotazioni() throws Exception {

    HttpServletRequest request = mock(HttpServletRequest.class);
    HttpSession session = mock(HttpSession.class);
    RequestDispatcher rd = mock(RequestDispatcher.class);

    when(request.getSession()).thenReturn(session);
    when(request.getRequestDispatcher("VisualizzaPrenot.jsp")).thenReturn(rd);
    StudenteBean sb = new StudenteBean();
    sb.setNome("Donato");
    sb.setCognome("Marmora");
    sb.setEmail("d.marmora1@studenti.unisa.it");
    sb.setPassword("safemeeting1");
    sb.setMatricolaStud("0512104565");

    PrenotaBean pb = new PrenotaBean();

    String gio = "25/01/2019";
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    java.util.Date data = sdf.parse(gio);
    Date giorno = new Date(data.getTime());

    String oraInizio = "10:00:00";
    Time time = Time.valueOf(oraInizio);

    pb.setGiorno(giorno);
    pb.setNumero_prenotazione(1);
    pb.setOrario(time);
    pb.setNome_corso("Architettura degli Elaboratori");
    pb.setPrenotaEmailStud("d.marmora1@studenti.unisa.it");
    pb.setPrenotaMatricolaDoc("0512101001");
    pb.setTipologia("Informazioni");

    PrenotaDao pd = new PrenotaDao();
    pd.effettuaPrenotazione(pb);

    StringWriter sw = new StringWriter();
    PrintWriter pw = new PrintWriter(sw);
    
    HttpServletResponse response = mock(HttpServletResponse.class);
    
    when(response.getWriter()).thenReturn(pw);
    when(session.getAttribute("studbean")).thenReturn(sb);

    new ServletStampaPrenotazioni().doPost(request, response);

  }

}