/**
 * Classe usata per interfacciare il PreferitiBean con in database;
 * @author Emilio Mainardi
 * @author Donato Marmora
 * @author Luca Di Chiara
 */
package safemeeting.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PreferitiDAO {
	
	/**
	 * Questo metodo serve per stampare tutti i preferiti;
	 * @param preferitiEmailStud (Email dello studente)
	 * @return null (se la lista è vuota) oppure listadoc (se la lista contiene elementi, nel try) oppure SQLException (nel catch, in caso di errore)
	 */
	public ArrayList<DocenteBean> getPreferiti(String preferitiEmailStud)
	{
		Connection conn = null;
		PreparedStatement ps = null;
		ArrayList<DocenteBean> listadoc = new ArrayList<DocenteBean>();
		DocenteBean db = null;
		
		try
		{
			conn = DriverManagerConnectionPool.getConnection();
			ps = conn.prepareStatement("SELECT doc.matricolaDoc, doc.nome, doc.cognome, doc.immagine "
					+ "FROM docente AS doc, aggiungi_ai_preferiti AS preferiti "
					+ "WHERE "
					+ "preferiti.preferitiMatricolaDoc = doc.matricolaDoc AND "
					+ "preferiti.preferitiEmailStud = ?");
			ps.setString(1, preferitiEmailStud);
			
			ResultSet res = ps.executeQuery();
			while(res.next())
			{
					db = new DocenteBean();
					db.setNome(res.getString("doc.nome"));
					db.setCognome(res.getString("doc.cognome"));
					db.setImmagine(res.getString("doc.immagine"));
					db.setMatricolaDoc(res.getString("doc.matricolaDoc"));
					listadoc.add(db);
				
			}
			
			if(listadoc.isEmpty()) return null;
			else return listadoc;

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
	 * Questo metodo serve per salvare un docente tra i preferiti;
	 * @param matricolaDoc (matricola del docente)
	 * @param preferitiEmailStud (email dello studente)
	 * @return true (nel try, se l'operazione Ã¨ andata a buon fine) oppure false (nel try, altrimenti) oppure SQLException (nel catch, in caso di errore)
	 */
	public synchronized boolean setPreferiti(String matricolaDoc, String preferitiEmailStud)
	{
		Connection conn = null;
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		
		try
		{
			conn = DriverManagerConnectionPool.getConnection();

			ps2 = conn.prepareStatement("select * from aggiungi_ai_preferiti where preferitiEmailStud = ? AND preferitiMatricolaDoc = ?");
			ps2.setString(1, preferitiEmailStud);
			ps2.setString(2, matricolaDoc);

			ResultSet res = ps2.executeQuery();
			if(!res.next()) {

				ps = conn.prepareStatement("INSERT INTO aggiungi_ai_preferiti VALUES (?,?)");
				ps.setString(1, matricolaDoc);
				ps.setString(2, preferitiEmailStud);

				ps.executeUpdate();
				return true;
			}
			else return false;
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
				ps2.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			
		}
	}
	
	/**
	 * Questo metodo serve per eliminare un docente dai preferiti;
	 * @param matricolaDoc (matricola del docente)
	 * @param preferitiEmailStud (email dello studente)
	 * @param db (DocenteBean)
	 * @return true (nel try, in caso l'operazione vada a buon fine) oppure false(nel catch, altrimenti)
	 */
	public synchronized boolean deletePreferiti(String matricolaDoc, String preferitiEmailStud,ArrayList<DocenteBean> db)
	{
		Connection conn = null;
		PreparedStatement ps = null;
		
		try
		{
			conn = DriverManagerConnectionPool.getConnection();
			ps = conn.prepareStatement("DELETE FROM aggiungi_ai_preferiti WHERE preferitiMatricolaDoc = ? AND preferitiEmailStud = ?");
			ps.setString(1, matricolaDoc);
			ps.setString(2, preferitiEmailStud);
			
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
}
