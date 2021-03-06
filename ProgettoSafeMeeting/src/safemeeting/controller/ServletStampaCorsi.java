/**
 * @author Emilio Mainardi
 * @author Donato Marmora
 * @author Luca Di Chiara
 */

package safemeeting.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import safemeeting.model.CorsoBean;
import safemeeting.model.CorsoDao;

/**
 * Questa servlet serve per stampare tutti i corsi presenti nel database ai.
 * quali il professore pu� associarsi;
 */
@WebServlet("/ServletStampaCorsi")
public class ServletStampaCorsi extends HttpServlet {
  private static final long serialVersionUID = 1L;


  public ServletStampaCorsi() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * Metodo doPost di ServletStampaCorsi.
   */
  
  public void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {

    ArrayList<CorsoBean> corsi = null;

    try {
      CorsoDao cd = new CorsoDao();
      CorsoBean cb = new CorsoBean();
      corsi = cd.stampaCorsi(cb);
    } catch (Exception e) {
      e.printStackTrace();
    }

    request.getSession().setAttribute("stampaCorsi", corsi);
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("AssociaCorso.jsp");
    requestDispatcher.forward(request, response);
  }
}
