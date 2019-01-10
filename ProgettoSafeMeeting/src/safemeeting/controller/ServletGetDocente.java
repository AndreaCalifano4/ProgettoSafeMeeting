/**
 * @author Emilio Mainardi
 * @author Donato Marmora
 * @author Luca Di Chiara
 */

package safemeeting.controller;

import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import safemeeting.model.CorsoBean;
import safemeeting.model.DocenteBean;
import safemeeting.model.RicevimentoBean;
import safemeeting.model.StudenteDao;
import safemeeting.model.TipologiaBean;

/**
 * Questa servlet serve per i dati del docente per effettuare la prenotazione.
 */
@WebServlet("/ServletGetDocente")
public class ServletGetDocente extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public ServletGetDocente() {
    super();
    // TODO Auto-generated constructor stub
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {

    HttpSession ssn = request.getSession();
    String matricola = request.getParameter("docente");

    try {
      StudenteDao sd = new StudenteDao();
      DocenteBean db = sd.getDocente(matricola);
      ArrayList<RicevimentoBean> rb = sd.getRicevimento(matricola);
      ArrayList<CorsoBean> cb = sd.getCorso(matricola);
      ArrayList<TipologiaBean> tb = sd.getTipologia(matricola);

      ssn.setAttribute("docente", db);
      ssn.setAttribute("corso", cb);
      ssn.setAttribute("ricevimento", rb);
      ssn.setAttribute("tipologia", tb);

      RequestDispatcher requestDispatcher = request.getRequestDispatcher("Prenotazione.jsp");
      requestDispatcher.forward(request, response);
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}
