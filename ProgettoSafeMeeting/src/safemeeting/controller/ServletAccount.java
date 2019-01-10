/**
 * @author Emilio Mainardi
 * @author Donato Marmora
 * @author Luca Di Chiara
 */

package safemeeting.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import safemeeting.model.*;


@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
maxFileSize=1024*1024*20,      // 10MB
maxRequestSize=1024*1024*200)		//200MB

/**
 * Servlet implementation class ServletAccount
 * Questa servlet serve per gestire l'intero reparto Account,
 * ovvero modifica account sia docente che studente e elimina account
 * sia docente che studente.
 */
@WebServlet("/ServletAccount")
public class ServletAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    
    private static final String SAVE_DIR="C:\\Users\\emili\\git\\ProgettoSafeMeeting\\ProgettoSafeMeeting\\WebContent\\bootstrap\\images";
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/***************************** INIZIO STUDENTE *******************************/
		
		StudenteBean sb = (StudenteBean) request.getSession().getAttribute("studbean");
		
		if(sb!=null)
		{
			String flag = request.getParameter("flag");
		
			if(flag.equals("visualizza")) // DA HOME STUDENTE AD ACCOUNT
			{
				try
				{
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("VisualizzaDatiStudente.jsp");
					requestDispatcher.forward(request, response);
				}
				catch(Exception e) 
				{
					e.printStackTrace();
				}	
			}
		
			if(flag.equals("salvaModifica")) // SALVA MODIFICA DEI DATI
			{
				String nome = request.getParameter("nome");
				String cognome = request.getParameter("cognome");
				String matricola = request.getParameter("matricola");
				String oldPassword = request.getParameter("oldPassword");
				String newPassword = request.getParameter("newPassword");
			
				try
				{
				
					StudenteDAO sdao = new StudenteDAO();
					String newPasswordEn = "", oldPasswordEn = "";
				
					String regexPassword = "^[a-zA-Z0-9\\_\\*\\-\\+\\!\\?\\,\\:\\;\\.\\xE0\\xE8\\xE9\\xF9\\xF2\\xEC\\x27]{8,20}";
					if(newPassword.matches(regexPassword)) {
					
						newPasswordEn = MyCript.encrypt(newPassword);
					}
				
					if(oldPassword.matches(regexPassword)) {
					
						oldPasswordEn = MyCript.encrypt(oldPassword);
					}
				
					String regexNome = "^[a-zA-Z\\'\\s]+$";
					if(nome.matches(regexNome));
				
					String regexCognome = "^[a-zA-Z\\s]+$";
					if(cognome.matches(regexCognome));
				
					String regexMatricola = "^\\d{10}$";
					if(matricola.matches(regexMatricola));
				
					String email = sb.getEmail();
				
					StudenteBean stud = sdao.modificaAccount(nome, cognome, matricola, oldPasswordEn, newPasswordEn,email);
					
					if(stud != null)
					{
						request.setAttribute("success", " ");
						request.getSession().removeAttribute("studbean");
						request.getSession().setAttribute("studbean",stud);
						RequestDispatcher requestDispatcher = request.getRequestDispatcher("VisualizzaDatiStudente.jsp");
						requestDispatcher.forward(request, response);
					} else {
						request.setAttribute("error", " ");
						RequestDispatcher requestDispatcher = request.getRequestDispatcher("AccountStudente.jsp");
						requestDispatcher.forward(request, response);
					}
				
				}
				catch(Exception e) 
				{
					e.printStackTrace();
				}	
			}
		
			if(flag.equals("modifica")) // DA VISUALIZZA DATI E MODIFICA DEI DATI
			{
				try
				{
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("AccountStudente.jsp");
					requestDispatcher.forward(request, response);
				}
				catch(Exception e) 
				{
					e.printStackTrace();
				}	
			}
		
			if(flag.equals("elimina")) // ELIMINA LO STUDENTE
			{
				try
				{
					StudenteDAO sdao = new StudenteDAO();
					String email = sb.getEmail();
				
					sdao.eliminaAccount(email);
				
					request.setAttribute("delete", " ");
				
					request.getSession().invalidate();
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("Login.jsp");
					requestDispatcher.forward(request, response);
				}
				catch(Exception e) 
				{
					e.printStackTrace();
				}	
			}
		}
		
		/**************************** FINE STUDENTE ******************************/
		
		/**************************** INIZIO DOCENTE *****************************/
		
		DocenteBean db = (DocenteBean) request.getSession().getAttribute("docbean");
		
		if(db!=null)
		{
			String flag1 = request.getParameter("flag1");
		
			if(flag1.equals("visualizzaDoc")) // DA HOME DOCENTE QUANDO CLICCA SU ACCOUNT
			{
				try
				{
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("VisualizzaDatiDocente.jsp");
					requestDispatcher.forward(request, response);
				}
				catch(Exception e) 
				{
					e.printStackTrace();
				}	
			}
		
			if(flag1.equals("eliminaDoc")) // ELIMINA DOCENTE
			{
				try
				{
					DocenteDAO ddao = new DocenteDAO();
					String matricola = db.getMatricolaDoc();
				
					ddao.eliminaAccount(matricola);
				
					request.setAttribute("delete", " ");
				
					request.getSession().invalidate();
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("Login.jsp");
					requestDispatcher.forward(request, response);
				}
				catch(Exception e) 
				{
					e.printStackTrace();
				}	
			}
		
			if(flag1.equals("modificaDoc")) //QUANDO DA ACCOUNT DI CLICCA DU MODIFICA DATI
			{
				try
				{
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("AccountDocente.jsp");
					requestDispatcher.forward(request, response);
				}
				catch(Exception e) 
				{
					e.printStackTrace();
				}	
			}
		
			if(flag1.equals("salvaModificaDoc")) // QUANDO SI SALVANO I DATI MODIFICATI
			{
				String nome = request.getParameter("nome");
				String cognome = request.getParameter("cognome");
				String matricola = request.getParameter("matricola");
				String studio = request.getParameter("studio");
				String oldPassword = request.getParameter("oldPassword");
				String newPassword = request.getParameter("newPassword");
				String email = db.getEmail();
			
				try
				{
					DocenteDAO ddao = new DocenteDAO();
					String newPasswordEn = "", oldPasswordEn = "";
				
					String regexPassword = "^[a-zA-Z0-9\\_\\*\\-\\+\\!\\?\\,\\:\\;\\.\\xE0\\xE8\\xE9\\xF9\\xF2\\xEC\\x27]{8,20}";
					if(newPassword.matches(regexPassword)) {
					
						newPasswordEn = MyCript.encrypt(newPassword);
					}
				
					if(oldPassword.matches(regexPassword)) {
					
						oldPasswordEn = MyCript.encrypt(oldPassword);
					}
				
					String regexNome = "^[a-zA-Z\\'\\s]+$";
					if(nome.matches(regexNome));
				
					String regexCognome = "^[a-zA-Z\\s]+$";
					if(cognome.matches(regexCognome));
				
					String regexStudio = "^[A-Z0-9\\'\\s]+$";
					if(studio.matches(regexStudio));
				
					/*--------IMMAGINE--------*/
					
					File uploads = new File(SAVE_DIR);
			        List<Part> fileParts = request.getParts().stream().filter(part -> "file".equals(part.getName())).collect(Collectors.toList()); // Retrieves <input type="file" name="file" multiple="true">
			        
			        if(!fileParts.get(0).getSubmittedFileName().isEmpty()) /* CONTROLLA SE E' STATO EFFETTUATO UN UPLOAD */
					{
			        	for (Part filePart : fileParts)
			        	{
			        		String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
			        		
			            	InputStream fileContent = filePart.getInputStream();

			            	File file = new File(uploads, fileName);
			            	
			            	Files.copy(fileContent, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
			            
			            	db.setImmagine(file.getName()); /* SETTA IMMAGINE DA UPLOAD */
			        	}
			        }
			        else db.setImmagine(db.getImmagine()); /* SETTA IMMAGINE CHE E' GIA' PRESENTE */
			        	
			        String immagine = db.getImmagine();
				
			        DocenteBean doc = ddao.modificaAccount(nome, cognome, matricola, studio, oldPasswordEn, newPasswordEn,immagine,email);
			        
					if(doc != null)
					{
						request.setAttribute("success", " ");
						request.getSession().removeAttribute("docbean");
						request.getSession().setAttribute("docbean",doc);
						RequestDispatcher requestDispatcher = request.getRequestDispatcher("VisualizzaDatiDocente.jsp");
						requestDispatcher.forward(request, response);
					} else {
						request.setAttribute("error", " ");
						RequestDispatcher requestDispatcher = request.getRequestDispatcher("AccountDocente.jsp");
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

}