/**
 * @author Emilio Mainardi
 * @author Donato Marmora
 * @author Luca Di Chiara
 */


package safemeeting.controller;

import java.io.IOException;
import java.sql.Time;
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
import safemeeting.model.RicevimentoBean;
import safemeeting.model.RicevimentoDAO;
import safemeeting.model.TipologiaBean;

/**
 * Questa servlet serve per aggiungere il giorno, l'orario (ora inizio e ora fine, la tipologia e la durata della tipologia del ricevimento
 * in un array. Se esiste il ricevimento setta questi paramenti su quel ricevimento (nel try), oppure lancia l'eccezione e.printStackTrace() in caso 
 * di errore.
 */

@WebServlet("/ServletAggiungiOrario")
public class ServletAggiungiOrario extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession ssn = request.getSession();
		
		try {
				DocenteBean docbean = (DocenteBean) ssn.getAttribute("docbean");
				String giorno = request.getParameter("scelta-giorno");
				String oraInizio = request.getParameter("dalle");
				String oraFine = request.getParameter("ora-alle");
				
				
		
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
				long oraI = sdf.parse(oraInizio).getTime();
				Time ti = new Time(oraI);
				long oraF = sdf.parse(oraFine).getTime();
				Time tf = new Time(oraF);
		
				RicevimentoBean rb = new RicevimentoBean();		
				rb.setGiorno(giorno);
				rb.setOra_fine(tf);
				rb.setOra_inizio(ti);
				rb.setMatricolaDoc(docbean.getMatricolaDoc());
				
				int tempoT = Integer.parseInt(request.getParameter("tempo-tesi"));
				int tempoP = Integer.parseInt(request.getParameter("tempo-problem-Corso"));
				int tempoI = Integer.parseInt(request.getParameter("tempo-info"));
				int tempoA = Integer.parseInt(request.getParameter("tempo-altro"));
				
				String tipoT = request.getParameter("tesi");
				String tipoP = request.getParameter("problem-Corso");
				String tipoI = request.getParameter("info");
				String tipoA = request.getParameter("altro");
			
				TipologiaBean tb = new TipologiaBean();
				ArrayList<Integer> arrTempo = new ArrayList<>();
				ArrayList<String> arrTipo = new ArrayList<>();
				
				
				arrTempo.add(tempoT);
				arrTempo.add(tempoP);
				arrTempo.add(tempoI);
				arrTempo.add(tempoA);
				
				arrTipo.add(tipoT);
				arrTipo.add(tipoP);
				arrTipo.add(tipoI);
				arrTipo.add(tipoA);
				
				RicevimentoDAO rd = new RicevimentoDAO();
				
				if(rd.creaRicevimento(rb)) {
				
					request.setAttribute("success", "");
					
					for(int i=0; i<arrTempo.size(); i++) 
					{	

						tb.setTempo(arrTempo.get(i));
						tb.setTipo(arrTipo.get(i));
						tb.setTipoMatricolaDoc(docbean.getMatricolaDoc());

						rd.creaTipologia(tb);
					}
				}
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("ServletStampaRicevimenti");
				requestDispatcher.forward(request, response);
		
		}catch(Exception e) {
			
			e.printStackTrace();
		
		}
		
		}
	}


