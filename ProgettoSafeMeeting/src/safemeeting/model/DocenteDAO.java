package safemeeting.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DocenteDAO {
	
	/**
	 * 
	 * @param db
	 * @return
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

	public synchronized DocenteBean getLogin(String email, String password)
	{
		Connection conn = null;
		PreparedStatement ps = null;
		
		try 
		{
			DocenteBean db = new DocenteBean(email,password);
			conn = DriverManagerConnectionPool.getConnection();
			ps = conn.prepareStatement("SELECT password,nome,cognome FROM docente WHERE email = ?");
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
	
}
