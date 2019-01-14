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

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import safemeeting.controller.ServletLogout;

public class TestServletLogout extends Mockito {

  @Mock
  HttpServletRequest request;
  @Mock
  HttpServletResponse response;
  @Mock
  HttpSession session;

  @Mock
  RequestDispatcher rd;

  /**
   * Questo metodo testa ServletLogout nel caso in cui si vuole effettuare il
   * logout.
   */

  @Test
  public void testServletLogout() throws Exception {

    HttpServletRequest request = mock(HttpServletRequest.class);
    HttpServletResponse response = mock(HttpServletResponse.class);
    HttpSession session = mock(HttpSession.class);
    // RequestDispatcher rd=mock(RequestDispatcher.class);

    when(request.getSession()).thenReturn(session);
    when(request.getRequestDispatcher("Login.jsp")).thenReturn(rd);

    new ServletLogout().doPost(request, response);

    session.invalidate();

  }

}
