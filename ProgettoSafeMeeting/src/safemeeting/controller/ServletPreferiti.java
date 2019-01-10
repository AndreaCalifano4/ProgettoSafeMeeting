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

import safemeeting.model.*;

/**
 * Questa pagina serve per creare, stampare o eliminare la lista dei preferiti;
 */
@WebServlet("/ServletPreferiti")
public class ServletPreferiti extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPreferiti() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession ssn = request.getSession();
		StudenteBean sb = (StudenteBean) request.getSession().getAttribute("studbean");
		String flag = request.getParameter("flag");
		
		if(flag.equals("ricerca"))//AGGIUNGO AI PREFERITI
		{
			String matricolaDoc = request.getParameter("matricolaDoc");
			String email = sb.getEmail();
			
			try
			{
				PreferitiDAO pd = new PreferitiDAO();
				if(pd.setPreferiti(matricolaDoc, email)) {
					
					request.setAttribute("success", "");
					request.setAttribute("stella", matricolaDoc);
					
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("Ricerca.jsp");
					requestDispatcher.forward(request, response);
				}
				else {
					request.setAttribute("error", "");
					
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("Ricerca.jsp");
					requestDispatcher.forward(request, response);
				}
				
			}
			catch(Exception e) 
			{
				e.printStackTrace();
			}
		}
		
		if(flag.equals("preferiti"))//STAMPO I PREFERITI
		{
			ArrayList<DocenteBean> pbarr = new ArrayList<DocenteBean>();
			String email = sb.getEmail();
			try {
				PreferitiDAO pdao = new PreferitiDAO();
				pbarr = pdao.getPreferiti(email);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			ssn.setAttribute("pbarr", pbarr);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Preferiti.jsp");
			requestDispatcher.forward(request, response);
		}
		
		if(flag.equals("delete"))//ELIMINO I PREFERITI
		{
			PreferitiDAO pd = new PreferitiDAO();
			String matricolaDoc = request.getParameter("matricolaDoc");
			String email = sb.getEmail();
			ArrayList<DocenteBean> pbarr = (ArrayList<DocenteBean>) ssn.getAttribute("pbarr");
			int i = Integer.parseInt(request.getParameter("indice"));
			
			try
			{
				if(pd.deletePreferiti(matricolaDoc, email,pbarr)) {
					
					request.setAttribute("success", "");
					
					pbarr.remove(i);
					
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("Preferiti.jsp");
					requestDispatcher.forward(request, response);
				}
			}
			catch(Exception e) 
			{
				e.printStackTrace();
			}
		}
	}

}