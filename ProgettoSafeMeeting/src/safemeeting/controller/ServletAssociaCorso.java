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

import safemeeting.model.CorsoBean;
import safemeeting.model.CorsoDao;
import safemeeting.model.DocenteBean;
import safemeeting.model.InsegnaBean;

/**
 * Questa servlet serve per associa uno o più corsi ad un docente.
 */
@WebServlet("/ServletAssociaCorso")
public class ServletAssociaCorso extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public ServletAssociaCorso() {
    super();
    // TODO Auto-generated constructor stub
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    HttpSession ssn = request.getSession();

    DocenteBean docbean = (DocenteBean) ssn.getAttribute("docbean");
    String insegnaCodiceCorso = request.getParameter("id-corso");
    int indice = Integer.parseInt(request.getParameter("indice"));
    ArrayList<CorsoBean> corsi = (ArrayList<CorsoBean>) ssn.getAttribute("visualizzaCorsi");

    try {
      InsegnaBean ib = new InsegnaBean();

      ib.setInsegnaCodiceCorso(insegnaCodiceCorso);
      ib.setInsegnaMatricolaDoc(docbean.getMatricolaDoc());

      CorsoDao cd = new CorsoDao();
      CorsoBean cb = cd.associaCorso(ib);

      if (cb != null) {

        corsi.add(cb);

        request.setAttribute("associa", "");

        request.setAttribute("InsegnaBean", ib);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("CorsiAssociati.jsp");
        requestDispatcher.forward(request, response);
      } else {
        request.setAttribute("errore", "");

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("AssociaCorso.jsp");
        requestDispatcher.forward(request, response);
      }
    } catch (Exception e) {

      e.printStackTrace();
    }

  }

}
