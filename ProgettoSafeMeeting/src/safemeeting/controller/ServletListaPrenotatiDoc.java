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

import safemeeting.model.DocenteBean;
import safemeeting.model.DocenteDao;
import safemeeting.model.PrenotaBean;
import safemeeting.model.PrenotaDao;
import safemeeting.model.StudenteBean;

/**
 * Questa servlet ritorna la lista degli studenti prenotati per un singolo
 * docente.
 */
@WebServlet("/ServletListaPrenotatiDoc")
public class ServletListaPrenotatiDoc extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public ServletListaPrenotatiDoc() {
    super();
    // TODO Auto-generated constructor stub
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {

    HttpSession ssn = request.getSession();

    DocenteBean db = (DocenteBean) ssn.getAttribute("docbean");

    PrenotaDao pd = new PrenotaDao();
    DocenteDao dd = new DocenteDao();
    PrenotaBean pb = new PrenotaBean();

    ArrayList<PrenotaBean> arrpb = pd.listaPrenotatiDoc(pb, db);
    ArrayList<StudenteBean> arrsb = dd.getStudenti(db);

    request.setAttribute("arrpb1", arrpb);
    request.setAttribute("arrsb1", arrsb);

    RequestDispatcher requestDispatcher = 
        request.getRequestDispatcher("ListaPrenotazioniDocente.jsp");
    requestDispatcher.forward(request, response);

  }
}
