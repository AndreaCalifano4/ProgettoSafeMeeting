package safemeeting.test;

/**
 * @author Andrea Califano
 * @author Gianluca Verlingieri
 * @author Donato Marmora
 * @author Luca Di Chiara
 */

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import safemeeting.controller.ServletRicerca;

public class TestServletRicerca extends Mockito {

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
   * Questo metodo testa ServletRicerca nel caso in cui verrà inserito un valore
   * all'interno della barra di ricerca.
   */

  @Test
  public void testServletRicerca() throws Exception {

    HttpServletRequest request = mock(HttpServletRequest.class);
    HttpSession session = mock(HttpSession.class);
    RequestDispatcher rd = mock(RequestDispatcher.class);

    when(request.getParameter("parametro")).thenReturn("Negro");
    when(request.getSession()).thenReturn(session);
    when(request.getRequestDispatcher("Ricerca.jsp")).thenReturn(rd);

    HttpServletResponse response = mock(HttpServletResponse.class);
    
    new ServletRicerca().doPost(request, response);

  }

}
