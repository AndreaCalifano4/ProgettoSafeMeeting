/**
 * Classe per eseguire delle operazioni per l'assenza;
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
import javax.servlet.http.HttpSession;

import safemeeting.model.DocenteBean;
import safemeeting.model.DocenteDAO;
import safemeeting.model.MessaggioBean;
import safemeeting.model.PrenotaBean;
import safemeeting.model.StudenteBean;
import safemeeting.observer.Observer;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


/**
 * Questa servlet prende in input il giorno e l'orario in cui è assente un docente e anche il messaggio inserito e, se va a buon fine, restituisce
 * il messaggio scritto allo studente ed elimina le prenotazioni in base all'ora e il giorno inseriti dal docente.
 */
@WebServlet("/ServletAssenza")
public class ServletAssenza extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAssenza() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
		HttpSession ssn = request.getSession();
		
		DocenteBean db = (DocenteBean) ssn.getAttribute("docbean");
		
		String s = request.getParameter("messag");
		
		int a = Integer.parseInt(request.getParameter("anno"));
		int m = Integer.parseInt(request.getParameter("mese"));
		int g = Integer.parseInt(request.getParameter("giorno"));
		Date d = new Date(a, m, g);
		System.out.println(d);
		String oraInizio = request.getParameter("dalle");
		String oraFine = request.getParameter("alle");
		
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
		long oraI = sdf.parse(oraInizio).getTime();
		Time ti = new Time(oraI);
		long oraF = sdf.parse(oraFine).getTime();
		Time tf = new Time(oraF);
		
		DocenteDAO dd = new DocenteDAO();
		
		PrenotaBean pb = new PrenotaBean();
		Observer obj = null;
		MessaggioBean mb = null;
			
		ArrayList<StudenteBean> arrsb = dd.getStudentiAssenza(db,d,ti,tf);
		
		for(int i = 0 ; i < arrsb.size();i++) {
			mb = new MessaggioBean();
			obj = new StudenteBean(arrsb.get(i).getMatricolaStud());
			pb.registerObserver(obj);
			obj.setSubject(pb);
			obj.update();
			mb.setMessaggio(s);
			mb.setMessaggioEmailStud(arrsb.get(i).getEmail());
			mb.setMessaggioMatricolaDoc(db.getMatricolaDoc());
			dd.setMessaggio(mb);
		}
		
		dd.assenzaDocente(db.getMatricolaDoc(), ti, tf, d);
		
		pb.postMessage(s);
		
		request.setAttribute("success", "");
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("HomeDocente.jsp");
		requestDispatcher.forward(request, response);
		
		}catch(Exception e) 
		{
		
			e.printStackTrace();
		}
	}

}
