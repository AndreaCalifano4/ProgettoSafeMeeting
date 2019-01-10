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
import safemeeting.model.PrenotaDAO;
import safemeeting.model.StudenteBean;

/**
 * Questa servlet serve per stampare tutte le prenotazioni di un singolo studente.
 */
@WebServlet("/ServletStampaPrenotazioni")
public class ServletStampaPrenotazioni extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletStampaPrenotazioni() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession ssn = request.getSession();
		
		StudenteBean sb =(StudenteBean) ssn.getAttribute("studbean");
		PrenotaDAO pb = new PrenotaDAO();
		
		ArrayList<PrenotaBean> arrpb = pb.getNumPrenotazioni(sb);
		
		ssn.setAttribute("arrpb",arrpb);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("VisualizzaPrenot.jsp");
		requestDispatcher.forward(request, response);
		
	}

}
