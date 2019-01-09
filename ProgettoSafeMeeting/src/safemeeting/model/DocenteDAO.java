/**
 * Classe usata per interfacciare il DocenteBean con in database;
 * @author Emilio Mainardi
 * @author Donato Marmora
 * @author Luca Di Chiara
 */
package safemeeting.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import safemeeting.observer.Observer;

public class DocenteDAO{
	
	/**
	 * Questo metodo mi permettere di inserire un nuovo docente all'interno del db relazionale;
	 * @param db (DocenteBean)
	 * @return true (nel try, nel caso in cui l'ha inserito con successo) oppure false(nel catch, nel caso in cui l'inserimento non è avvenuto con successo).
	 */
	
	public synchronized boolean registraAccount(DocenteBean db)
	{
		Connection conn = null;
		PreparedStatement ps = null;
		
		try
		{
			conn = DriverManagerConnectionPool.getConnection();
			ps = conn.prepareStatement("INSERT INTO docente VALUE (?, ?, ?, ?, ?, ?,''); ");
			ps.setString(1, db.getMatricolaDoc());
			ps.setString(2, db.getNome());
			ps.setString(3, db.getCognome());
			ps.setString(4, db.getPassword());
			ps.setString(5, db.getEmail());
			ps.setString(6, db.getStudio());
		
			ps.executeUpdate();
			return true;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return false;
			
		}
		finally
		{
			try
			{
				DriverManagerConnectionPool.releaseConnection(conn);
				ps.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			
		}
			
	}

	/**
	 * Questo metodo serve per effettuare il login dal lato docente;
	 * @param email (email del docente)
	 * @param password(password del docente)
	 * @return db(DocenteBean, nel try, nel caso in cui viene effettuato l'accesso) oppure null (altrimenti), SQLException (nel catch, altrimenti)
	 */
	public synchronized DocenteBean getLogin(String email, String password)
	{
		Connection conn = null;
		PreparedStatement ps = null;
		
		try 
		{
			DocenteBean db = new DocenteBean(email,password);
			conn = DriverManagerConnectionPool.getConnection();
			ps = conn.prepareStatement("SELECT * FROM docente WHERE email = ?");
			ps.setString(1, email);
			
			ResultSet res = ps.executeQuery();
			String decriptpsw = null;
			if(res.next()) {
				decriptpsw = MyCript.decrypt(res.getString("password"));
				db.setPassword(decriptpsw);
				
				if(decriptpsw.equals(password))
				{
					db.setNome(res.getString("nome"));
					db.setCognome(res.getString("cognome"));
					db.setEmail(res.getString("email"));
					db.setMatricolaDoc(res.getString("matricolaDoc"));
					db.setStudio(res.getString("studio"));
					db.setImmagine(res.getString("immagine"));
					return db;
				}
				else return null;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				DriverManagerConnectionPool.releaseConnection(conn);
				ps.close();
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		return null;
	}
	
	/**
	 * Questo metodo serve per vedere se il docente è assente o meno;
	 * @param matricolaDoc (matricola del docente)
	 * @param tempo1 (ora d'inizio)
	 * @param tempo2 (ora di fine)
	 * @param d (data)
	 * @return true (nel try, in caso sia assente) oppure false (nel catch, altrimenti)
	 */
	public synchronized boolean assenzaDocente(String matricolaDoc, Time tempo1, Time tempo2, Date d) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DriverManagerConnectionPool.getConnection();
			ps = conn.prepareStatement("DELETE FROM prenota WHERE prenotaMatricolaDoc = ? AND giorno = ? AND orario between ? AND ? ;");
			ps.setString(1, matricolaDoc);
			ps.setDate(2, d);
			ps.setTime(3, tempo1);
			ps.setTime(4, tempo2);
			
			ps.executeUpdate();
			
			return true;
			}
			catch (SQLException e)
			{
				e.printStackTrace();
				return false;
			}
		}
	
	/**
	 * Questo metodo serve per ricavarci tutti gli studenti a cui verrà eliminata la prenotazione;
	 * @param db (DocenteBean)
	 * @param d (Date)
	 * @param ti (Time)
	 * @param tf (Time)
	 * @return arrsb(nel try, se riesce a stampare tutti gli studenti) oppure null(nel catch, altrimenti)
	 */
	public synchronized ArrayList<StudenteBean> getStudentiAssenza(DocenteBean db, Date d,Time ti, Time tf){
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			ArrayList<StudenteBean> arrsb = new ArrayList<StudenteBean>();
			StudenteBean sb = null;
			conn = DriverManagerConnectionPool.getConnection();
			ps = conn.prepareStatement("SELECT s.nome, s.cognome, s.email, s.matricolaStud, s.password FROM prenota p, studente s WHERE s.email = p.prenotaEmailStud AND p.prenotaMatricolaDoc = ? AND p.giorno = ? AND p.orario BETWEEN ? AND ?");
			ps.setString(1, db.getMatricolaDoc());
			ps.setDate(2, d);
			ps.setTime(3,ti);
			ps.setTime(4, tf);
			
			ResultSet res = ps.executeQuery();
			while(res.next()) {
				sb = new StudenteBean();
				sb.setNome(res.getString("s.nome"));
				sb.setCognome(res.getString("s.cognome"));
				sb.setEmail(res.getString("s.email"));
				sb.setMatricolaStud(res.getString("s.matricolaStud"));
				sb.setPassword(res.getString("s.password"));
				
				arrsb.add(sb);
			}
			return arrsb;
		}
		catch (SQLException e)
			{
				e.printStackTrace();
				return null;
			}
		}
	
	
	/**
	 * Questo metodo serve per stampare tutti gli studenti;
	 * @param db (DocenteBean)
	 * @return arrsb(nel try, se riesce a stampare tutti gli studenti) oppure null(nel catch, altrimenti)
	 */
	public synchronized ArrayList<StudenteBean> getStudenti(DocenteBean db){
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			ArrayList<StudenteBean> arrsb = new ArrayList<StudenteBean>();
			StudenteBean sb = null;
			conn = DriverManagerConnectionPool.getConnection();
			ps = conn.prepareStatement("SELECT s.nome, s.cognome, s.email, s.matricolaStud, s.password FROM prenota p, studente s WHERE s.email = p.prenotaEmailStud AND p.prenotaMatricolaDoc = ?");
			ps.setString(1, db.getMatricolaDoc());
			
			ResultSet res = ps.executeQuery();
			while(res.next()) {
				sb = new StudenteBean();
				sb.setNome(res.getString("s.nome"));
				sb.setCognome(res.getString("s.cognome"));
				sb.setEmail(res.getString("s.email"));
				sb.setMatricolaStud(res.getString("s.matricolaStud"));
				sb.setPassword(res.getString("s.password"));
				
				arrsb.add(sb);
			}
			return arrsb;
		}
		catch (SQLException e)
			{
				e.printStackTrace();
				return null;
			}
		}
	
	
	/**
	 * Questo metodo serve per inserire un nuovo messaggio all'interno del bd;
	 * @param mb(MessaggioBean, oggetto messaggio)
	 * @return true (nel try, nel caso in cui l'ha inserito con successo) oppure false(nel catch, nel caso in cui l'inserimento non è avvenuto con successo).
	 */
	public synchronized boolean setMessaggio(MessaggioBean mb){
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DriverManagerConnectionPool.getConnection();
			ps = conn.prepareStatement("INSERT INTO messaggio VALUE(?,?,?)");
			ps.setString(1, mb.getMessaggioEmailStud());
			ps.setString(2, mb.getMessaggioMatricolaDoc());
			ps.setString(3, mb.getMessaggio());
			
			ps.executeUpdate();
			return true;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Questo metodo serve per eliminare il docente all'interno del db;
	 * @param matricola(String)
	 * @return true (nel try, nel caso in cui l'ha rimosso con successo) oppure false(nel catch, nel caso in cui la cancellazione non è avvenuta con successo).
	 */
	public boolean eliminaAccount(String matricola)
	{
			Connection conn = null;
			PreparedStatement ps = null;
			
			try
			{
				conn = DriverManagerConnectionPool.getConnection();
				ps = conn.prepareStatement("DELETE FROM docente WHERE matricolaDoc = ?");
				ps.setString(1, matricola);
				ps.executeUpdate();
				return true;
				
			}catch (SQLException e)
			{
				e.printStackTrace();
				return false;
			}
			finally
			{
				try
				{
					DriverManagerConnectionPool.releaseConnection(conn);
					ps.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
				
			}
		}
	
	
	/**
	 * Questo metodo ci permette di modificare i dati del docente presenti nel db;
	 * @param nome(String)
	 * @param cognome(String)
	 * @param matricola(String)
	 * @param studio(String)
	 * @param oldPassword(String)
	 * @param newPassword(String)
	 * @param immagine(String)
	 * @param email(String)
	 * @return db(DocenteBean) nel try, nel caso in cui l'ha modificato con successo e ritorna null se non corrisponde il controllo sulla password,oppure null nel catch, nel caso in cui la modifica non è avvenuta con successo).
	 */
	public DocenteBean modificaAccount(String nome, String cognome, String matricola, String studio, String oldPassword, String newPassword,String immagine,String email)
	{
		Connection conn = null;
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		
		try
		{
			DocenteBean db = new DocenteBean();
			conn = DriverManagerConnectionPool.getConnection();
			
			ps = conn.prepareStatement("SELECT password FROM docente WHERE matricolaDoc = ?");
			ps.setString(1, matricola);
			ResultSet res = ps.executeQuery();
		
			String dbPass = null;
			
			if(res.next())
			{
				dbPass = res.getString("password");
			}	
			
			if(oldPassword.equals(dbPass))
			{
				ps1 = conn.prepareStatement("UPDATE docente SET nome = ?, cognome = ?, password = ?, studio = ?, immagine = ? WHERE matricolaDoc = ?;");
				ps1.setString(1, nome);
				ps1.setString(2, cognome);
				ps1.setString(3, newPassword);
				ps1.setString(4, studio);
				ps1.setString(5, immagine);
				ps1.setString(6, matricola);
				int flag = ps1.executeUpdate();
				
				if(flag != 0)
				{
					db.setMatricolaDoc(matricola);
					db.setNome(nome);
					db.setCognome(cognome);
					db.setPassword(newPassword);
					db.setStudio(studio);
					db.setImmagine(immagine);
					db.setEmail(email);
					
				}
			}
			else return null;
			
			return db;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
		finally
		{
			try
			{
				DriverManagerConnectionPool.releaseConnection(conn);
				ps.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			
		}
	}
}
