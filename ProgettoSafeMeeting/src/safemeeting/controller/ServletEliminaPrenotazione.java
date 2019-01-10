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
import javax.servlet.http.HttpSession;

import safemeeting.model.PrenotaBean;
import safemeeting.model.PrenotaDao;
import safemeeting.model.StudenteBean;

/**
 * Questa servlet ci permette di eliminare una prenotazione lato studente.
 */
@WebServlet("/ServletEliminaPrenotazione")
public class ServletEliminaPrenotazione extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public ServletEliminaPrenotazione() {
    super();
    // TODO Auto-generated constructor stub
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {

    HttpSession ssn = request.getSession();

    StudenteBean sb = (StudenteBean) ssn.getAttribute("studbean");
    int numprenot = Integer.parseInt(request.getParameter("numeroprenotaz"));
    ArrayList<PrenotaBean> arrpb = (ArrayList<PrenotaBean>) ssn.getAttribute("arrpb");

    String ind = (String) ssn.getAttribute("indice");
    int indice = Integer.parseInt(ind);

    PrenotaDao pd = new PrenotaDao();

    if (pd.eliminaPrenotazione(sb, numprenot)) {

      arrpb.remove(indice);

      request.setAttribute("success", "");

      RequestDispatcher requestDispatcher = request.getRequestDispatcher("VisualizzaPrenot.jsp");
      requestDispatcher.forward(request, response);

    }
  }

}
