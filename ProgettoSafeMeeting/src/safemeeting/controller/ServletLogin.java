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
import safemeeting.model.MessaggioBean;
import safemeeting.model.StudenteBean;
import safemeeting.model.StudenteDao;

/**
 * Questa servlet serve per effettuare il login.
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public ServletLogin() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * Metodo doPost di ServletLogin.
   */
  
  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    HttpSession ssn = request.getSession();

    synchronized (ssn) { // SINCRONIZZO LA SESSIONE

      String email = request.getParameter("email");
      String password = request.getParameter("password");

      if (email.contains("@studenti.unisa.it")) { // LOGIN STUDENTE
        StudenteDao sd = new StudenteDao();
        StudenteBean sb = sd.getLogin(email, password);
        ArrayList<MessaggioBean> arrmb = sd.getMessaggio(email);
        ArrayList<DocenteBean> arrdb = sd.getDocMessaggio(email);

        if (sb != null) {
          ssn.setAttribute("studbean", sb);
          ssn.setAttribute("messaggio", arrmb);
          ssn.setAttribute("messaggiodoc", arrdb);
          RequestDispatcher requestDispatcher = request.getRequestDispatcher("HomeStudente.jsp");
          request.setAttribute("errorLogin", null);
          requestDispatcher.forward(request, response);
        } else {
          request.setAttribute("errorLogin", "");
          RequestDispatcher requestDispatcher = request.getRequestDispatcher("Login.jsp");
          requestDispatcher.forward(request, response);
        }
      } else {
        if (email.contains("@unisa.it")) { // LOGIN DOCENTE
          DocenteDao dd = new DocenteDao();

          DocenteBean db = dd.getLogin(email, password);

          if (db != null) {
            ssn.setAttribute("docbean", db);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("HomeDocente.jsp");
            requestDispatcher.forward(request, response);
          } else {
            request.setAttribute("errorLogin", true);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("Login.jsp");
            requestDispatcher.forward(request, response);
          }
        } else {
          ssn.setAttribute("errorLogin", true);
          RequestDispatcher requestDispatcher = request.getRequestDispatcher("Login.jsp");
          requestDispatcher.forward(request, response);
        }
      }
    }

  }
}