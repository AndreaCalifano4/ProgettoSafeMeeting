package safemeeting.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import safemeeting.model .*;
/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletRicerca")
public class ServletRicerca extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletRicerca() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String parametro = request.getParameter("parametro");
		ArrayList<DocenteBean> dbarr = new ArrayList<DocenteBean>();
		
		try {
			DocenteBean db = new DocenteBean();
			StudenteDAO sdao = new StudenteDAO();
			
			dbarr = sdao.ricercaDocente(parametro,db);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("dbarr", dbarr);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("Ricerca.jsp");
		requestDispatcher.forward(request, response);
	}
}
