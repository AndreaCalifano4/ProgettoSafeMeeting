package safemeeting.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
}
	
