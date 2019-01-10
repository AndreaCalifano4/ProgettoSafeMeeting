package safemeeting.controller;

/**
 * @author Emilio Mainardi
 * @author Donato Marmora
 * @author Luca Di Chiara
 */

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import safemeeting.model.DocenteBean;
import safemeeting.model.PrenotaBean;
import safemeeting.model.PrenotaDAO;
import safemeeting.model.StudenteBean;

/**
 * Questa servlet serve per stampare i dettagli di una singola prenotazione lato studente.
 */
@WebServlet("/ServletDettagliPrenot")
public class ServletDettagliPrenot extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDettagliPrenot() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		StudenteBean sb =(StudenteBean) request.getSession().getAttribute("studbean");
		int numprenot = Integer.parseInt(request.getParameter("numprenot"));
		String matrdoc = request.getParameter("matrdoc");
		String indice = request.getParameter("indice");
		
		PrenotaDAO pd = new PrenotaDAO();
		DocenteBean db = pd.getDocentePrenot(sb, numprenot);
		PrenotaBean pb = pd.getDatiPrenot(sb, numprenot);
		int numeroprenotati = pd.getNumPrenotati(matrdoc);
		
		request.setAttribute("db", db);
		request.setAttribute("pb", pb);
		request.setAttribute("numprenotati", numeroprenotati);
		request.getSession().setAttribute("indice", indice);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("VisualizzaPrenotazione.jsp");
		requestDispatcher.forward(request, response);
		
	}

}
