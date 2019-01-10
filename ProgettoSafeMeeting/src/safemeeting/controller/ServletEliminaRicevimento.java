/**
 * @author Emilio Mainardi
 * @author Donato Marmora
 * @author Luca Di Chiara
 */

package safemeeting.controller;

import java.io.IOException;
import java.sql.Time;
import java.text.SimpleDateFormat;
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
import safemeeting.model.RicevimentoDao;

/**
 * Questa servlet ci permette di eliminare un ricevimento lato docente.
 */
@WebServlet("/ServletEliminaRicevimento")
public class ServletEliminaRicevimento extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public ServletEliminaRicevimento() {
    super();
    // TODO Auto-generated constructor stub
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {

    HttpSession ssn = request.getSession();
    
    DocenteBean docbean = null;
    
    try {
      docbean = (DocenteBean) ssn.getAttribute("docbean");
      String giorno = request.getParameter("giorno");
      String oraInizio = request.getParameter("ora_inizio");
      String oraFine = request.getParameter("ora_fine");
      int indice = Integer.parseInt(request.getParameter("indice"));
      ArrayList<RicevimentoBean> arrb = (ArrayList<RicevimentoBean>) 
          ssn.getAttribute("stampaRicevimenti");
      ;

      SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
      long oraI = sdf.parse(oraInizio).getTime();
      Time ti = new Time(oraI);
      long oraF = sdf.parse(oraFine).getTime();
      Time tf = new Time(oraF);

      RicevimentoBean rb = new RicevimentoBean();
      rb.setGiorno(giorno);
      rb.setOra_fine(tf);
      rb.setOra_inizio(ti);
      rb.setMatricolaDoc(docbean.getMatricolaDoc());

      RicevimentoDao rd = new RicevimentoDao();

      if (rd.eliminaRicevimento(rb)) {

        arrb.remove(indice);

        request.setAttribute("error", "");
        request.setAttribute("RicevimentoBean", rb);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("OrarioRicevimento.jsp");
        requestDispatcher.forward(request, response);
      }

    } catch (Exception e) {
      e.printStackTrace();

    }
  }
}
