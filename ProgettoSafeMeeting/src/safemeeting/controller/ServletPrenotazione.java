/**
 * @author Emilio Mainardi
 * @author Donato Marmora
 * @author Luca Di Chiara
 */

package safemeeting.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import safemeeting.model.DocenteBean;
import safemeeting.model.PrenotaBean;
import safemeeting.model.PrenotaDao;
import safemeeting.model.RicevimentoBean;
import safemeeting.model.StudenteBean;
import safemeeting.model.TipologiaBean;

/**
 * Questa servlet serve per effettuare una prenotazione.
 */
@WebServlet("/ServletPrenotazione")
public class ServletPrenotazione extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public ServletPrenotazione() {
    super();
    // TODO Auto-generated constructor stub
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {

    HttpSession ssn = request.getSession();
    PrintWriter out = response.getWriter();

    PrenotaDao pd = null;
    ArrayList<RicevimentoBean> rb = null;
    DocenteBean docBean = null;
    PrenotaBean pb = null;
    Date giorno = null;
    String tipologia = "";
    String corso = "";
    StudenteBean studBean = null;
    
    try {

      pd = new PrenotaDao();
      pb = new PrenotaBean();

      String gio = request.getParameter("giorno");
      if (gio.equals("")) {
        RequestDispatcher requestDispatcher = 
            request.getRequestDispatcher("EffettuaPrenotazione.jsp");
        requestDispatcher.forward(request, response);
      }
      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
      java.util.Date data = sdf.parse(gio);
      giorno = new Date(data.getTime());

      corso = request.getParameter("corso");
      tipologia = request.getParameter("tipologia");
      docBean = (DocenteBean) ssn.getAttribute("docente");
      studBean = (StudenteBean) ssn.getAttribute("studbean");
      rb = 
          (ArrayList<RicevimentoBean>) ssn.getAttribute("ricevimento");

      pb.setNome_corso(corso);
      pb.setTipologia(tipologia);
      pb.setGiorno(giorno);
      pb.setPrenotaEmailStud(studBean.getEmail());
      pb.setPrenotaMatricolaDoc(docBean.getMatricolaDoc());
      pd.settaIndice(pb);

      if (!pd.settaTempo(pb, rb)) {

        request.setAttribute("errore", " ");

        RequestDispatcher requestDispatcher = 
            request.getRequestDispatcher("EffettuaPrenotazione.jsp");
        requestDispatcher.forward(request, response);
      }

      if (pd.effettuaPrenotazione(pb)) {

        request.setAttribute("errore", " ");

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("HomeStudente.jsp");
        requestDispatcher.forward(request, response);

      } else {

        RequestDispatcher requestDispatcher = 
            request.getRequestDispatcher("EffettuaPrenotazione.jsp");
        requestDispatcher.forward(request, response);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
