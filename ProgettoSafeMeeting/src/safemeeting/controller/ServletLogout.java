/**
 * @author Emilio Mainardi
 * @author Donato Marmora
 * @author Luca Di Chiara
 */

package safemeeting.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Questa servlet serve per effettuare il logout.
 */
@WebServlet("/ServletLogout")
public class ServletLogout extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public ServletLogout() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * Metodo doPost di ServletLogout.
   */
  
  public void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {

    request.getSession().invalidate();

    // Pagina login

    response.sendRedirect("Login.jsp");

  }
}