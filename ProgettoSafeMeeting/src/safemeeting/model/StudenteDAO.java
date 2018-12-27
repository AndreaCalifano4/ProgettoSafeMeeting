package safemeeting.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;

public class StudenteDAO {
	/**
	 * Questo metodo ti permette di registrare un nuovo studente all'interno del database;
	 * @param sb (StudenteBean)
	 * @return true (Inserimento avvenuto con successo, nel try)
	 * otherwise false (Inserimento fallito, nel catch)
	 */
	public synchronized boolean registraAccount(StudenteBean sb)
	{
		Connection conn = null;
		PreparedStatement ps = null;
		
		try
		{
			conn = DriverManagerConnectionPool.getConnection();
			ps = conn.prepareStatement("INSERT INTO studente VALUE (?, ?, ?, ?, ?); ");
			ps.setString(1, sb.getMatricolaStud());
			ps.setString(2, sb.getNome());
			ps.setString(3, sb.getCognome());
			ps.setString(4, sb.getPassword());
			ps.setString(5, sb.getEmail());
		
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
	
	public synchronized StudenteBean getLogin(String email, String password)
	{
		Connection conn = null;
		PreparedStatement ps = null;
		
		try 
		{
			StudenteBean sb = new StudenteBean(email,password);
			conn = DriverManagerConnectionPool.getConnection();
			ps = conn.prepareStatement("SELECT password,nome,cognome FROM studente WHERE email = ?");
			ps.setString(1, email);
			
			ResultSet res = ps.executeQuery();
			String decriptpsw = null;
			if(res.next()) {
				decriptpsw = MyCript.decrypt(res.getString("password"));
				sb.setPassword(decriptpsw);
				
				if(decriptpsw.equals(password))
				{
					sb.setNome(res.getString("nome"));
					sb.setCognome(res.getString("cognome"));
					return sb;
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
	
	public ArrayList<DocenteBean> ricercaDocente(String param,DocenteBean db){
		Connection conn = null;
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		ArrayList<DocenteBean> listadoc = new ArrayList<DocenteBean>();
		
		try
		{
			conn = DriverManagerConnectionPool.getConnection();
			ps = conn.prepareStatement("SELECT d.cognome,d.nome FROM docente d, corso c, insegna i WHERE d.matricolaDoc=i.insegnaMatricolaDoc AND i.insegnaCodiceCorso = c.Codice AND d.cognome LIKE ? LIMIT 1");
			ps.setString(1, param+"%");
			
			ResultSet res = ps.executeQuery();
			while(res.next()) {
				db = new DocenteBean();
				db.setNome(res.getString("d.nome"));
				db.setCognome(res.getString("d.cognome"));
				listadoc.add(db);
			}
			if(listadoc.isEmpty()) {
				ps2 = conn.prepareStatement("SELECT d.cognome,d.nome FROM docente d, corso c, insegna i WHERE d.matricolaDoc=i.insegnaMatricolaDoc AND i.insegnaCodiceCorso = c.Codice AND c.nome LIKE ?");
				ps2.setString(1, param+"%");
				
				ResultSet res2 = ps2.executeQuery();
				while(res2.next()) {
					db = new DocenteBean();
					db.setNome(res2.getString("d.nome"));
					db.setCognome(res2.getString("d.cognome"));
					listadoc.add(db);
				}
				if(listadoc.isEmpty()) {
					return null;
				}
				else { 
					return listadoc;
				}
			}
			else { 
				return listadoc;
			}
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
	
