package safemeeting.test;

/**
 * @author Andrea Califano
 * @author Gianluca Verlingieri
 * @author Donato Marmora
 * @author Luca Di Chiara
 */

import java.io.PrintWriter;
import java.io.StringWriter;

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

import safemeeting.controller.ServletRegistraAccount;
import safemeeting.model.DocenteBean;
import safemeeting.model.DocenteDao;
import safemeeting.model.StudenteBean;
import safemeeting.model.StudenteDao;

public class TestServletRegistraAccount extends Mockito {

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
  public void tearDown() throws Exception {

    StudenteDao sd = new StudenteDao();

    sd.eliminaAccount("m.rossi@studenti.unisa.it");

    DocenteDao docdao = new DocenteDao();

    docdao.eliminaAccount("0512101030");
  }

  /**
   * Questo metodo testa ServletRegistrazione in caso di registrazione di uno
   * studente.
   */

  @Test
  public void testServletRegistraAccountStudente() throws Exception {

    HttpServletRequest request = mock(HttpServletRequest.class);
    HttpSession session = mock(HttpSession.class);
    RequestDispatcher rd = mock(RequestDispatcher.class);

    when(request.getParameter("tipo-utente")).thenReturn("studente");
    when(request.getParameter("nome")).thenReturn("Mario");
    when(request.getParameter("cognome")).thenReturn("Rossi");
    when(request.getParameter("email")).thenReturn("m.rossi@studenti.unisa.it");
    when(request.getParameter("password")).thenReturn("safemeeting1");
    when(request.getParameter("matricola")).thenReturn("0512101112");
    when(request.getSession()).thenReturn(session);
    when(request.getRequestDispatcher("Login.jsp")).thenReturn(rd);

    StudenteBean sb = new StudenteBean();

    sb.setNome(request.getParameter("nome"));
    sb.setCognome(request.getParameter("cognome"));
    sb.setEmail(request.getParameter("email"));
    sb.setPassword(request.getParameter("password"));
    sb.setMatricolaStud(request.getParameter("matricola"));

    StringWriter sw = new StringWriter();
    PrintWriter pw = new PrintWriter(sw);
    
    HttpServletResponse response = mock(HttpServletResponse.class);
    
    when(response.getWriter()).thenReturn(pw);

    new ServletRegistraAccount().doPost(request, response);

  }

  /**
   * Questo metodo testa ServletRegistrazione in caso di registrazione di un
   * docente.
   */

  @Test
  public void testServletRegistraAccountDocente() throws Exception {

    HttpServletRequest request = mock(HttpServletRequest.class);
    HttpSession session = mock(HttpSession.class);
    RequestDispatcher rd = mock(RequestDispatcher.class);

    when(request.getParameter("tipo-utente")).thenReturn("docente");
    when(request.getParameter("nome")).thenReturn("Mario");
    when(request.getParameter("cognome")).thenReturn("Bonfiglio");
    when(request.getParameter("email")).thenReturn("m.bonfiglio@unisa.it");
    when(request.getParameter("password")).thenReturn("safemeeting1");
    when(request.getParameter("matricola")).thenReturn("0512101030");
    when(request.getParameter("studio")).thenReturn("A030");
    when(request.getSession()).thenReturn(session);
    when(request.getRequestDispatcher("Login.jsp")).thenReturn(rd);

    DocenteBean db = new DocenteBean();

    db.setNome(request.getParameter("nome"));
    db.setCognome(request.getParameter("cognome"));
    db.setEmail(request.getParameter("email"));
    db.setPassword(request.getParameter("password"));
    db.setMatricolaDoc(request.getParameter("matricola"));
    db.setStudio(request.getParameter("studio"));

    StringWriter sw = new StringWriter();
    PrintWriter pw = new PrintWriter(sw);

    HttpServletResponse response = mock(HttpServletResponse.class);
    
    when(response.getWriter()).thenReturn(pw);

    new ServletRegistraAccount().doPost(request, response);

  }

  /**
   * Questo metodo testa ServletRegistrazione in caso di errore di registrazione
   * dello studente.
   */

  @Test
  public void testServletRegistraAccountStudenteErrore() throws Exception {

    HttpServletRequest request = mock(HttpServletRequest.class);
    HttpSession session = mock(HttpSession.class);
    RequestDispatcher rd = mock(RequestDispatcher.class);

    when(request.getParameter("tipo-utente")).thenReturn("studente");
    when(request.getParameter("nome")).thenReturn("Emilio");
    when(request.getParameter("cognome")).thenReturn("Mainardi");
    when(request.getParameter("email")).thenReturn("e.mainardi@studenti.unisa.it");
    when(request.getParameter("password")).thenReturn("safemeeting1");
    when(request.getParameter("matricola")).thenReturn("0512104841");
    when(request.getSession()).thenReturn(session);
    when(request.getRequestDispatcher("Registrazione.jsp")).thenReturn(rd);

    StudenteBean sb = new StudenteBean();

    sb.setNome(request.getParameter("nome"));
    sb.setCognome(request.getParameter("cognome"));
    sb.setEmail(request.getParameter("email"));
    sb.setPassword(request.getParameter("password"));
    sb.setMatricolaStud(request.getParameter("matricola"));

    StringWriter sw = new StringWriter();
    PrintWriter pw = new PrintWriter(sw);
    
    HttpServletResponse response = mock(HttpServletResponse.class);
    
    when(response.getWriter()).thenReturn(pw);

    new ServletRegistraAccount().doPost(request, response);

  }

  /**
   * Questo metodo testa ServletRegistrazione in caso di errore di registrazione
   * del docente.
   */

  @Test
  public void testServletRegistraAccountDocenteErrore() throws Exception {

    HttpServletRequest request = mock(HttpServletRequest.class);
    HttpSession session = mock(HttpSession.class);
    RequestDispatcher rd = mock(RequestDispatcher.class);

    when(request.getParameter("tipo-utente")).thenReturn("docente");
    when(request.getParameter("nome")).thenReturn("Alberto");
    when(request.getParameter("cognome")).thenReturn("Negro");
    when(request.getParameter("email")).thenReturn("alberto@unisa.it");
    when(request.getParameter("password")).thenReturn("safemeeting1");
    when(request.getParameter("matricola")).thenReturn("0512101001");
    when(request.getParameter("studio")).thenReturn("A001");
    when(request.getSession()).thenReturn(session);
    when(request.getRequestDispatcher("Registrazione.jsp")).thenReturn(rd);

    DocenteBean db = new DocenteBean();

    db.setNome(request.getParameter("nome"));
    db.setCognome(request.getParameter("cognome"));
    db.setEmail(request.getParameter("email"));
    db.setPassword(request.getParameter("password"));
    db.setMatricolaDoc(request.getParameter("matricola"));
    db.setStudio(request.getParameter("studio"));

    StringWriter sw = new StringWriter();
    PrintWriter pw = new PrintWriter(sw);

    HttpServletResponse response = mock(HttpServletResponse.class);
    
    when(response.getWriter()).thenReturn(pw);

    new ServletRegistraAccount().doPost(request, response);

  }

}
