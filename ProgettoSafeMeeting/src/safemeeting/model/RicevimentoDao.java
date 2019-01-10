package safemeeting.model;

/**
 * Classe usata per interfacciare il RicevimentoBean con in database;
 * @author Emilio Mainardi
 * @author Donato Marmora
 * @author Luca Di Chiara
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RicevimentoDao {

  /**
   * Questo metodo serve per creare un ricevimento.
   * 
   * @param rb (RicevimentoBean)
   * @return true (nel try, se è stato creato con successo) oppure false (nel
   *         try, se non è stato creato) oppure false (nel catch, per colpa di
   *         qualche errore)
   */
  public synchronized boolean creaRicevimento(RicevimentoBean rb) {
    Connection conn = null;
    PreparedStatement ps = null;
    PreparedStatement ps2 = null;
    PreparedStatement ps3 = null;

    try {

      conn = DriverManagerConnectionPool.getConnection();

      ps3 = conn.prepareStatement("select count(ricevMatricolaDoc) AS conta "
          + "from ricevimento where ricevMatricolaDoc = ?");
      ps3.setString(1, rb.getMatricolaDoc());

      ResultSet res2 = ps3.executeQuery();
      int cont = 0;
      if (res2.next()) {
        cont = res2.getInt("conta");
      }
      if (cont < 2) {
        ps = conn.prepareStatement("select * from ricevimento"
            + " where ricevMatricolaDoc = ? AND ora_inizio= ? AND ora_fine= ? AND giorno= ?");
        ps.setString(1, rb.getMatricolaDoc());
        ps.setTime(2, rb.getOra_inizio());
        ps.setTime(3, rb.getOra_fine());
        ps.setString(4, rb.getGiorno());

        ResultSet res = ps.executeQuery();

        if (!res.next()) {

          ps2 = conn.prepareStatement("INSERT INTO ricevimento VALUE (?, ?, ?, ?); ");
          ps2.setString(1, rb.getMatricolaDoc());
          ps2.setTime(2, rb.getOra_inizio());
          ps2.setTime(3, rb.getOra_fine());
          ps2.setString(4, rb.getGiorno());

          ps2.executeUpdate();

          return true;
        } else {
          return false;
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return false;

    } finally {
      try {
        DriverManagerConnectionPool.releaseConnection(conn);
        ps3.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }

    }
    return false;

  }

  /**
   * Questo metodo serve per creare la tipologia del ricevimento.
   * 
   * @param tb (TipologiaBean)
   * @return true (nel try, se la tipologia è stata creata) oppure false (nel
   *         catch, altrimenti)
   */
  public synchronized boolean creaTipologia(TipologiaBean tb) {

    Connection con = null;
    PreparedStatement ps = null;
    PreparedStatement ps2 = null;
    PreparedStatement ps3 = null;

    try {

      con = DriverManagerConnectionPool.getConnection();
      ps = con.prepareStatement("SELECT * FROM tipologia WHERE tipoMatricolaDoc = ? AND tipo = ? ");
      ps.setString(1, tb.getTipoMatricolaDoc());
      ps.setString(2, tb.getTipo());

      ResultSet res = ps.executeQuery();
      if (!res.next()) {

        ps2 = con.prepareStatement("INSERT INTO tipologia VALUE (?, ?, ?)");
        ps2.setString(1, tb.getTipoMatricolaDoc());
        ps2.setInt(2, tb.getTempo());
        ps2.setString(3, tb.getTipo());

        ps2.executeUpdate();

        return true;
      } else {

        ps3 = con.prepareStatement("UPDATE tipologia SET tempo = ? "
            + "WHERE tipoMatricolaDoc = ? AND tipo = ?");
        ps3.setInt(1, tb.getTempo());
        ps3.setString(2, tb.getTipoMatricolaDoc());
        ps3.setString(3, tb.getTipo());

        ps3.executeUpdate();
        return true;
      }

    } catch (Exception e) {

      e.printStackTrace();

      return false;
    }

  }

  /**
   * Questo metodo serve per stampare tutti i ricevimenti.
   * 
   * @param db (DocenteBean)
   * @return arrb (nel try, stampa l'arraylist contenente tutti i ricevimenti)
   *         oppure e.printStackTrace()(nel catch, in caso ci sia un errore)
   */
  public synchronized ArrayList<RicevimentoBean> stampaRicevimenti(DocenteBean db) {

    Connection con = null;
    PreparedStatement ps = null;
    try {

      ArrayList<RicevimentoBean> arrb = new ArrayList<RicevimentoBean>();
      RicevimentoBean rb = null;
      con = DriverManagerConnectionPool.getConnection();
      ps = con.prepareStatement("select * from ricevimento where ricevMatricolaDoc = ?");
      ps.setString(1, db.getMatricolaDoc());

      ResultSet res = ps.executeQuery();
      while (res.next()) {

        rb = new RicevimentoBean();
        rb.setMatricolaDoc(res.getString("ricevMatricolaDoc"));
        rb.setOra_inizio(res.getTime("ora_inizio"));
        rb.setOra_fine(res.getTime("ora_fine"));
        rb.setGiorno(res.getString("giorno"));

        arrb.add(rb);

      }

      return arrb;

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
   * Questo metodo serve per eliminare un determinato ricevimento all'interno del
   * db.
   * 
   * @param rb (RicevimentoBean)
   * @return true (nel try, nel caso in cui il ricevimento viene eliminato con
   *         successo) oppure false (nel catch, altrimenti)
   */

  public synchronized boolean eliminaRicevimento(RicevimentoBean rb) {

    Connection con = null;
    PreparedStatement ps = null;
    try {

      con = DriverManagerConnectionPool.getConnection();
      ps = con.prepareStatement(
          "delete from ricevimento "
          + "where ricevMatricolaDoc = ? and ora_inizio = ? and ora_fine = ? and giorno = ?");
      ps.setString(1, rb.getMatricolaDoc());
      ps.setTime(2, rb.getOra_inizio());
      ps.setTime(3, rb.getOra_fine());
      ps.setString(4, rb.getGiorno());

      ps.executeUpdate();

      return true;

    } catch (Exception e) {

      e.printStackTrace();
      return false;
    }
  }

}
