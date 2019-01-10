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

import safemeeting.model.DocenteBean;
import safemeeting.model.StudenteDao;



/**
 * Questa servlet serve per effettuare la ricerca di un professore.
 */
@WebServlet("/ServletRicerca")
public class ServletRicerca extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public ServletRicerca() {
    super();
    // TODO Auto-generated constructor stub
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {

    String parametro = request.getParameter("parametro");
    ArrayList<DocenteBean> dbarr = new ArrayList<DocenteBean>();

    try {
      DocenteBean db = new DocenteBean();
      StudenteDao sdao = new StudenteDao();

      dbarr = sdao.ricercaDocente(parametro, db);
    } catch (Exception e) {
      e.printStackTrace();
    }

    request.getSession().setAttribute("dbarr", dbarr);
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("Ricerca.jsp");
    requestDispatcher.forward(request, response);
  }
}
