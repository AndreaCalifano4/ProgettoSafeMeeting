package safemeeting.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import safemeeting.model.*;
/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession ssn = request.getSession();
		
		synchronized (ssn)//SINCRONIZZO LA SESSIONE
		{
		
			String email = request.getParameter("email");
			String password = request.getParameter("password");
		
			if(email.contains("@studenti.unisa.it")) { //LOGIN STUDENTE
				StudenteDAO sd = new StudenteDAO();
				StudenteBean sb = sd.getLogin(email,password);
			
				if(sb != null) {
					ssn.setAttribute("studbean",sb);
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("HomeStudente.jsp");
					requestDispatcher.forward(request, response);
				}
				else {
					ssn.setAttribute("errorLogin", true);
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("Login.jsp");
					requestDispatcher.forward(request, response);
				}
			}
			
			if(email.contains("@unisa.it")) { //LOGIN DOCENTE
				DocenteDAO dd = new DocenteDAO();
				DocenteBean db = dd.getLogin(email,password);
			
				if(db != null) {
					ssn.setAttribute("docbean",db);
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("HomeDocente.jsp");
					requestDispatcher.forward(request, response);
				}
				else {
					ssn.setAttribute("errorLogin", true);
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("Login.jsp");
					requestDispatcher.forward(request, response);
				}
			}
			else {
				ssn.setAttribute("errorLogin", true);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("Login.jsp");
				requestDispatcher.forward(request, response);
			}
		
		}
		
	}
}