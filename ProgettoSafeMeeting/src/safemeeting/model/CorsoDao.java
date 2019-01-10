package safemeeting.model;

/**
 * Classe usata per interfacciare il CorsoBean con in database;
 * @author Emilio Mainardi
 * @author Donato Marmora
 * @author Luca Di Chiara
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CorsoDao {

  /**
   * Questo metodo serve per stampare tutti i corsi presenti nel database.
   * 
   * @param cb (CorsoBean)
   * @return arr (nel try, cioè l'arraylist di tutti i corsi) oppure null (nel
   *         catch, altrimenti)
   */

  public synchronized ArrayList<CorsoBean> stampaCorsi(CorsoBean cb) {

    Connection con = null;
    PreparedStatement ps = null;

    try {
      con = DriverManagerConnectionPool.getConnection();
      ps = con.prepareStatement("SELECT * FROM corso");

      ResultSet res = ps.executeQuery();
      ArrayList<CorsoBean> arr = new ArrayList<>();
      while (res.next()) {
        cb = new CorsoBean();
        cb.setCodice(res.getString("Codice"));
        cb.setNome(res.getString("nome"));
        cb.setNum_cfu(res.getInt("num_CFU"));
        cb.setOre_totali(res.getInt("ore_totali"));

        arr.add(cb);
      }

      return arr;

    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    } finally {
      try {
        DriverManagerConnectionPool.releaseConnection(con);
        ps.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }

    }
  }

  /**
   * Questo metodo serve per associare un corso ad un docente.
   * 
   * @param ib (InsegnaBean)
   * @return cb(CorsoBean, se l'operazione è andata a buon fine) oppure null (in
   *         tutti gli altri casi)
   */

  public synchronized CorsoBean associaCorso(InsegnaBean ib) {
    Connection con = null;
    PreparedStatement ps = null;
    PreparedStatement ps2 = null;
    PreparedStatement ps3 = null;

    try {
      con = DriverManagerConnectionPool.getConnection();
      ps = con.prepareStatement("SELECT * FROM insegna"
          + " WHERE insegnaMatricolaDoc = ? AND insegnaCodiceCorso = ?");
      ps.setString(1, ib.getInsegnaMatricolaDoc());
      ps.setString(2, ib.getInsegnaCodiceCorso());

      ResultSet res = ps.executeQuery();
      if (!res.next()) {
        ps2 = con.prepareStatement("INSERT INTO insegna VALUE (?, ?); ");
        ps2.setString(1, ib.getInsegnaMatricolaDoc());
        ps2.setString(2, ib.getInsegnaCodiceCorso());

        ps2.executeUpdate();

        ps3 = con.prepareStatement("SELECT * FROM corso WHERE Codice = ?");
        ps3.setString(1, ib.getInsegnaCodiceCorso());
        ResultSet res1 = ps3.executeQuery();
        if (res1.next()) {
          CorsoBean cb = new CorsoBean();
          cb.setCodice(res1.getString("Codice"));
          cb.setNome(res1.getString("nome"));
          cb.setNum_cfu(res1.getInt("num_cfu"));
          cb.setOre_totali(res1.getInt("ore_totali"));

          return cb;
        } else {
          return null;
        }
      } else {
        return null;
      }
    } catch (SQLException e) {
      e.printStackTrace();

    } finally {
      try {
        DriverManagerConnectionPool.releaseConnection(con);
        ps.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }

    }
    return null;

  }

  /**
   * Questo metodo serve per visualizzare i corsi esistenti nel database.
   * 
   * @param db (DocenteBean)
   * @return arr(nel try, ArrayList di tutti i corsi) oppure null (nel catch,
   *         altrimenti)
   */
  public synchronized ArrayList<CorsoBean> visualizzaCorsi(DocenteBean db) {

    Connection con = null;
    PreparedStatement ps = null;
    CorsoBean cb = null;

    try {
      con = DriverManagerConnectionPool.getConnection();
      ps = con.prepareStatement(
          "SELECT c.nome, c.num_CFU, c.ore_totali,c.codice FROM docente d, corso c, insegna i "
          + "WHERE d.matricolaDoc = i.insegnaMatricolaDoc "
          + "AND i.insegnaCodiceCorso= c.Codice AND d.cognome=?");
      ps.setString(1, db.getCognome());

      ResultSet res = ps.executeQuery();

      ArrayList<CorsoBean> arr = new ArrayList<>();
      while (res.next()) {
        cb = new CorsoBean();
        cb.setCodice(res.getString("c.codice"));
        cb.setNome(res.getString("c.nome"));
        cb.setNum_cfu(res.getInt("c.num_CFU"));
        cb.setOre_totali(res.getInt("c.ore_totali"));

        arr.add(cb);
      }
      return arr;

    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    } finally {
      try {
        DriverManagerConnectionPool.releaseConnection(con);
        ps.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }

    }
  }

  /**
   * Questo metodo serve per eliminare un corso dal database.
   * 
   * @param ib (InsegnaBean)
   * @return true (nel try, nel caso in cui il corso viene eliminato con successo)
   *         oppure false (nel catch, altrimenti)
   */
  public synchronized boolean eliminaCorso(InsegnaBean ib) {

    Connection con = null;
    PreparedStatement ps = null;

    try {
      con = DriverManagerConnectionPool.getConnection();
      ps = con.prepareStatement("DELETE FROM insegna "
          + "WHERE insegnaMatricolaDoc=? AND insegnaCodiceCorso=?");
      ps.setString(1, ib.getInsegnaMatricolaDoc());
      ps.setString(2, ib.getInsegnaCodiceCorso());

      ps.executeUpdate();

      return true;

    } catch (SQLException e) {
      e.printStackTrace();

      return false;
    } finally {
      try {
        DriverManagerConnectionPool.releaseConnection(con);
        ps.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }

    }
  }
}
