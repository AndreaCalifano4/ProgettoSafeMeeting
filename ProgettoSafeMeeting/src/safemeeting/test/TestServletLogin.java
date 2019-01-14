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

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import safemeeting.controller.ServletLogin;
import safemeeting.model.DocenteBean;
import safemeeting.model.StudenteBean;

public class TestServletLogin extends Mockito {

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
   * Questo metodo testa la ServletLogin in caso di Login di uno studente.
   */
  @Test
  public void testServletLoginStudente() throws Exception {

    HttpServletRequest request = mock(HttpServletRequest.class);
    HttpSession session = mock(HttpSession.class);
    RequestDispatcher rd = mock(RequestDispatcher.class);

    when(request.getParameter("email")).thenReturn("d.marmora1@studenti.unisa.it");
    when(request.getParameter("password")).thenReturn("safemeeting1");
    when(request.getSession()).thenReturn(session);
    when(request.getRequestDispatcher("HomeStudente.jsp")).thenReturn(rd);

    StudenteBean sb = new StudenteBean();

    sb.setNome("Donato");
    sb.setCognome("Marmora");
    sb.setEmail("d.marmora1@studenti.unisa.it");
    sb.setPassword("safemeeting1");
    sb.setMatricolaStud("0512104565");

    StringWriter sw = new StringWriter();
    PrintWriter pw = new PrintWriter(sw);
    
    HttpServletResponse response = mock(HttpServletResponse.class);
    
    when(response.getWriter()).thenReturn(pw);

    new ServletLogin().doPost(request, response);
  }

  /**
   * Questo metodo testa ServletLogin in caso di login di un docente.
   */

  @Test
  public void testServletLoginDocente() throws Exception {

    HttpServletRequest request = mock(HttpServletRequest.class);
    HttpSession session = mock(HttpSession.class);
    RequestDispatcher rd = mock(RequestDispatcher.class);

    when(request.getParameter("email")).thenReturn("alberto@unisa.it");
    when(request.getParameter("password")).thenReturn("safemeeting1");
    when(request.getSession()).thenReturn(session);
    when(request.getRequestDispatcher("HomeDocente.jsp")).thenReturn(rd);

    DocenteBean db = new DocenteBean();

    db.setNome("Alberto");
    db.setCognome("Negro");
    db.setEmail("alberto@unisa.it");
    db.setPassword("safemeeting1");
    db.setMatricolaDoc("0512101001");
    db.setStudio("A001");

    StringWriter sw = new StringWriter();
    PrintWriter pw = new PrintWriter(sw);

    HttpServletResponse response = mock(HttpServletResponse.class);
    
    when(response.getWriter()).thenReturn(pw);

    new ServletLogin().doPost(request, response);
  }

  /**
   * Questo metodo testa ServletLogin in caso di errore di login di uno studente.
   */

  @Test
  public void testServletLoginStudenteErrore() throws Exception {

    HttpServletRequest request = mock(HttpServletRequest.class);
    HttpSession session = mock(HttpSession.class);
    RequestDispatcher rd = mock(RequestDispatcher.class);

    when(request.getParameter("email")).thenReturn("prova@studenti.unisa.it");
    when(request.getParameter("password")).thenReturn("safemeeting1");
    when(request.getSession()).thenReturn(session);
    when(request.getRequestDispatcher("Login.jsp")).thenReturn(rd);

    StudenteBean sb = new StudenteBean();

    sb.setNome("Prova");
    sb.setCognome("Prova");
    sb.setEmail("prova@studenti.unisa.it");
    sb.setPassword("safemeeting1");
    sb.setMatricolaStud("0512104111");

    StringWriter sw = new StringWriter();
    PrintWriter pw = new PrintWriter(sw);

    HttpServletResponse response = mock(HttpServletResponse.class);
    
    when(response.getWriter()).thenReturn(pw);

    new ServletLogin().doPost(request, response);
  }

  /**
   * Questo metodo testa ServletLogin in caso di errore di login di un docente.
   */

  @Test
  public void testServletLoginDocenteErrore() throws Exception {

    HttpServletRequest request = mock(HttpServletRequest.class);
    HttpSession session = mock(HttpSession.class);
    RequestDispatcher rd = mock(RequestDispatcher.class);

    when(request.getParameter("email")).thenReturn("prova@unisa.it");
    when(request.getParameter("password")).thenReturn("safemeeting1");
    when(request.getSession()).thenReturn(session);
    when(request.getRequestDispatcher("Login.jsp")).thenReturn(rd);

    DocenteBean db = new DocenteBean();

    db.setNome("Prova");
    db.setCognome("Prova");
    db.setEmail("prova@unisa.it");
    db.setPassword("safemeeting1");
    db.setMatricolaDoc("0512101099");
    db.setStudio("A099");

    StringWriter sw = new StringWriter();
    PrintWriter pw = new PrintWriter(sw);

    HttpServletResponse response = mock(HttpServletResponse.class);
    
    when(response.getWriter()).thenReturn(pw);

    new ServletLogin().doPost(request, response);
  }

  /**
   * Questo metodo testa ServletLogin in caso di formato dell'email non valido sia
   * per studente che per docente.
   */

  @Test
  public void testServletLoginEmailNonValida() throws Exception {

    HttpServletRequest request = mock(HttpServletRequest.class);
    HttpSession session = mock(HttpSession.class);
    RequestDispatcher rd = mock(RequestDispatcher.class);

    when(request.getParameter("email")).thenReturn("prova@gmail.com");
    when(request.getParameter("password")).thenReturn("safemeeting1");
    when(request.getSession()).thenReturn(session);
    when(request.getRequestDispatcher("Login.jsp")).thenReturn(rd);

    DocenteBean db = new DocenteBean();

    db.setNome("Prova");
    db.setCognome("Prova");
    db.setEmail("prova@gmail.com");
    db.setPassword("safemeeting1");
    db.setMatricolaDoc("0512101066");
    db.setStudio("A066");

    StringWriter sw = new StringWriter();
    PrintWriter pw = new PrintWriter(sw);
    
    HttpServletResponse response = mock(HttpServletResponse.class);
    
    when(response.getWriter()).thenReturn(pw);

    new ServletLogin().doPost(request, response);
  }

}
