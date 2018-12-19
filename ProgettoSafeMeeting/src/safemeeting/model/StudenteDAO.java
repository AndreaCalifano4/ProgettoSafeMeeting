package safemeeting.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

public class StudenteDAO {
	
	public synchronized StudenteBean getLogin(String email, String password)
	{
		Connection conn = null;
		PreparedStatement ps = null;
		
		try 
		{
			StudenteBean sb = new StudenteBean(email,password);
			conn = DriverManagerConnectionPool.getConnection();
			ps = conn.prepareStatement("SELECT nome, cognome FROM studente WHERE email = ? AND password = ?");
			ps.setString(1, email);
			ps.setString(2, password);

			ResultSet res = ps.executeQuery();
			
			if(res.next())
			{
				sb.setNome(res.getString("nome"));
				sb.setCognome(res.getString("cognome"));
				return sb;
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
	
