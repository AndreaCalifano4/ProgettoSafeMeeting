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
import safemeeting.model.CorsoDAO;
import safemeeting.model.DocenteBean;
import safemeeting.model.RicevimentoBean;
import safemeeting.model.RicevimentoDAO;

/**
 * Questa servlet serve per stampare tutti i ricevimenti di un docente;
 */
@WebServlet("/ServletStampaRicevimenti")
public class ServletStampaRicevimenti extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletStampaRicevimenti() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<RicevimentoBean> ric = null;
		
		try {
			DocenteBean db = (DocenteBean) request.getSession().getAttribute("docbean");
			RicevimentoDAO rd = new RicevimentoDAO();
			ric = rd.stampaRicevimenti(db);
		}catch(Exception e) {
			
		}
		
		request.getSession().setAttribute("stampaRicevimenti", ric);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("OrarioRicevimento.jsp");
		requestDispatcher.forward(request, response);
	}

}
