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
import safemeeting.model.CorsoDAO;
import safemeeting.model.DocenteBean;

/**
 * Questa servlet serve per visualizzare tutti i corsi associati ad un docente;
 */
@WebServlet("/ServletVisualizzaCorsi")
public class ServletVisualizzaCorsi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletVisualizzaCorsi() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession ssn = request.getSession();
		
		DocenteBean docbean = (DocenteBean) ssn.getAttribute("docbean");
		ArrayList<CorsoBean> corsi = new ArrayList<CorsoBean>();
		
		try {
			CorsoDAO cd = new CorsoDAO();
		
			corsi = cd.visualizzaCorsi(docbean);
		}catch(Exception e) {
			
		}
		
		ssn.setAttribute("visualizzaCorsi", corsi);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("CorsiAssociati.jsp");
		requestDispatcher.forward(request, response);
	}
}
