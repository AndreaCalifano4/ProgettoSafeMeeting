/**
 * @author Emilio Mainardi
 * @author Donato Marmora
 * @author Luca Di Chiara
 */

package safemeeting.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import safemeeting.model.DocenteBean;
import safemeeting.model.DocenteDAO;
import safemeeting.model.MyCript;
import safemeeting.model.StudenteBean;
import safemeeting.model.StudenteDAO;

/**
 * Questa servlet serve per registrare un nuovo account nel database;
 */


@WebServlet("/ServletRegistraAccount")
public class ServletRegistraAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			String radio = request.getParameter("tipo-utente");
			
			if(radio.equals("studente"))
			{
				StudenteBean sb = new StudenteBean();
				StudenteDAO	 sd = new StudenteDAO();
				
				String nome = request.getParameter("nome");
				String cognome = request.getParameter("cognome");
				String email = request.getParameter("email");
				String password = request.getParameter("password");
				String matricola = request.getParameter("matricola");
			

				String regexEmail = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$";
				if(email.matches(regexEmail)) {
					sb.setEmail(email);
				}
				
				String regexPassword = "^[a-zA-Z0-9\\_\\*\\-\\+\\!\\?\\,\\:\\;\\.\\xE0\\xE8\\xE9\\xF9\\xF2\\xEC\\x27]{8,20}";
				if(password.matches(regexPassword)) {
					
					String crippsw = MyCript.encrypt(password);
					sb.setPassword(crippsw);
				}
				
				String regexNome = "^[a-zA-Z\\'\\s]+$";
				if(nome.matches(regexNome)) {
					sb.setNome(nome);
				}
				
				String regexCognome = "^[a-zA-Z\\s]+$";
				if(cognome.matches(regexCognome)) {
					sb.setCognome(cognome);
				}
				
				String regexMatricola = "^\\d{10}$";
				if(matricola.matches(regexMatricola)) {
					sb.setMatricolaStud(matricola);
				}
				
				
				if(sd.registraAccount(sb)){	
					request.setAttribute("studbean", sb);
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("Login.jsp");
					requestDispatcher.forward(request, response);				
				}
				else{
					request.setAttribute("controllo", false);
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("Registrazione.jsp");
					requestDispatcher.forward(request, response);
				}
			}
			else{
				DocenteBean db = new DocenteBean();
				DocenteDAO	 dd = new DocenteDAO();
				
				String nome = request.getParameter("nome");
				String cognome = request.getParameter("cognome");
				String email = request.getParameter("email");
				String password = request.getParameter("password");
				String matricola = request.getParameter("matricola");
				String studio = request.getParameter("studio");
			
				
				String regexEmail = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$";
				if(email.matches(regexEmail)) {
					db.setEmail(email);
				}
				
				String regexPassword = "^[a-zA-Z0-9\\_\\*\\-\\+\\!\\?\\,\\:\\;\\.\\xE0\\xE8\\xE9\\xF9\\xF2\\xEC\\x27]{8,20}";
				if(password.matches(regexPassword)) {
					String crippsw = MyCript.encrypt(password);
					db.setPassword(crippsw);
				}
				
				String regexNome = "^[a-zA-Z\\'\\s]+$";
				if(nome.matches(regexNome)) {
					db.setNome(nome);
				}
				
				String regexCognome = "^[a-zA-Z\\s]+$";
				if(cognome.matches(regexCognome)) {
					db.setCognome(cognome);
				}
				
				String regexMatricola = "^\\d{10}$";
				if(matricola.matches(regexMatricola)) {
					db.setMatricolaDoc(matricola);
				}
				
				String regexStudio = "^[A-Z0-9\\'\\s]+$";
				if(studio.matches(regexStudio)) {
					db.setStudio(studio);
				}
				
				
				if(dd.registraAccount(db)) {	
					request.setAttribute("docbean", db);
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("Login.jsp");
					requestDispatcher.forward(request, response);				
				}
				else {	
					request.setAttribute("controllo", false);
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("Registrazione.jsp");
					requestDispatcher.forward(request, response);
				}
				
				request.setAttribute("success","");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}		
	}
	
}
