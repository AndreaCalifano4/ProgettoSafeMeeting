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
import safemeeting.model.PrenotaDAO;
import safemeeting.model.RicevimentoBean;
import safemeeting.model.StudenteBean;
import safemeeting.model.TipologiaBean;

/**
 * Questa servlet serve per effettuare una prenotazione;
 */
@WebServlet("/ServletPrenotazione")
public class ServletPrenotazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPrenotazione() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession ssn = request.getSession();
		PrintWriter out = response.getWriter();
		
		try {
			
			PrenotaDAO pd = new PrenotaDAO();
			PrenotaBean pb = new PrenotaBean();
			
			String gio = request.getParameter("giorno");
			if(gio.equals("")) {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("EffettuaPrenotazione.jsp");
				requestDispatcher.forward(request, response);
			}
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			java.util.Date data = sdf.parse(gio);
			Date giorno = new Date(data.getTime());
			
			String corso = request.getParameter("corso");
			String tipologia = request.getParameter("tipologia");
			DocenteBean db = (DocenteBean) ssn.getAttribute("docente");
			StudenteBean sb = (StudenteBean) ssn.getAttribute("studbean");
			ArrayList<RicevimentoBean> rb = (ArrayList<RicevimentoBean>) ssn.getAttribute("ricevimento");
			
			pb.setNome_corso(corso);
			pb.setTipologia(tipologia);
			pb.setGiorno(giorno);
			pb.setPrenotaEmailStud(sb.getEmail());
			pb.setPrenotaMatricolaDoc(db.getMatricolaDoc());
			pd.settaIndice(pb);
			
			if(!pd.settaTempo(pb, rb)) {
				
				request.setAttribute("errore", " ");
				
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("EffettuaPrenotazione.jsp");
				requestDispatcher.forward(request, response);
			}
			
			if(pd.effettuaPrenotazione(pb)) {

				request.setAttribute("errore", " ");
				
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("HomeStudente.jsp");
				requestDispatcher.forward(request, response);
				
			}
			else {
				
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("EffettuaPrenotazione.jsp");
				requestDispatcher.forward(request, response);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
