package safemeeting.model;

/**
 * Classe usata per interfacciare il PrenotaBean con in database;
 * @author Emilio Mainardi
 * @author Donato Marmora
 * @author Luca Di Chiara
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;

public class PrenotaDao {

  private static int i = 0;

  /**
   * Questo metodo serve per effettuare la prenotazione.
   * 
   * @param pb (PrenotaBean)
   * @return true (nel try, in caso l'operazione abbia successo) oppure false (nel
   *         catch, altrimenti)
   */

  public synchronized boolean effettuaPrenotazione(PrenotaBean pb) {
    Connection conn = null;
    PreparedStatement ps = null;

    try {
      conn = DriverManagerConnectionPool.getConnection();
      ps = conn.prepareStatement("INSERT INTO prenota VALUE (?, ?, ?, ?, ?, ?, ?); ");

      ps.setInt(1, pb.getNumero_prenotazione());
      ps.setString(2, pb.getNome_corso());
      ps.setString(3, pb.getTipologia());
      ps.setTime(4, pb.getOrario());
      ps.setDate(5, pb.getGiorno());
      ps.setString(6, pb.getPrenotaEmailStud());
      ps.setString(7, pb.getPrenotaMatricolaDoc());

      ps.executeUpdate();
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
      return false;

    } finally {
      try {
        DriverManagerConnectionPool.releaseConnection(conn);
        ps.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }

    }

  }

  /**
   * Questo metodo serve per impostare il numero della prenotazione.
   * 
   * @param pb (PrenotaBean)
   */
  public synchronized void settaIndice(PrenotaBean pb) {

    Connection con = null;
    PreparedStatement ps = null;

    try {
      con = DriverManagerConnectionPool.getConnection();
      ps = con.prepareStatement("SELECT max(numero_prenotazione)  as maximo FROM prenota");
      ResultSet res = ps.executeQuery();

      if (!res.next()) {
        i = 1;
        pb.setNumero_prenotazione(i);

      } else {
        i = res.getInt("maximo") + 1;
        pb.setNumero_prenotazione(i);

      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * Questo metodo serve per impostare il tempo della prenotazione.
   * 
   * @param pb (PrenotaBean)
   * @param rb (RicevimentoBean)
   * @return (nel try)
   */
  public synchronized boolean settaTempo(PrenotaBean pb, ArrayList<RicevimentoBean> rb) {

    Connection con = null;
    PreparedStatement ps = null;
    PreparedStatement ps2 = null;

    try {
      con = DriverManagerConnectionPool.getConnection();
      ps = con.prepareStatement(
          "SELECT p.orario,p.tipologia FROM prenota p WHERE p.numero_prenotazione = "
          + "( SELECT max(p.numero_prenotazione) "
          + "FROM prenota p WHERE p.prenotaMatricolaDoc = ? AND p.giorno = ?);");
      ps.setString(1, pb.getPrenotaMatricolaDoc());
      ps.setDate(2, pb.getGiorno());

      ResultSet res = ps.executeQuery();
      if (!res.next()) {
        pb.setOrario(rb.get(0).getOra_inizio());// Ora iniziale
        return true;
      } else {
        Time tempo = res.getTime("p.orario");
        String tipo = res.getString("p.tipologia");
        ps2 = con.prepareStatement(
            "SELECT t.tempo FROM tipologia t, docente d, prenota p "
            + "WHERE t.tipoMatricolaDoc = d.matricolaDoc "
            + "AND d.matricolaDoc = p.prenotaMatricolaDoc AND t.tipo = ? AND d.matricolaDoc = ? ");
        ps2.setString(2, pb.getPrenotaMatricolaDoc());
        ps2.setString(1, tipo);

        ResultSet res2 = ps2.executeQuery();

        if (res2.next()) {

          int temptoassString = res2.getInt("t.tempo");
          Long tempotoadd = Long.valueOf(temptoassString);

          LocalTime localtime = tempo.toLocalTime();
          localtime = localtime.plusMinutes(tempotoadd);

          Time tempoeffett = Time.valueOf(localtime);

          if (rb.get(0).getOra_fine().toLocalTime().getHour() 
              <= tempoeffett.toLocalTime().getHour()) {
            if (rb.get(1).getOra_fine().toLocalTime().getHour() 
                <= tempoeffett.toLocalTime().getHour()) {
              return false;
            } else {
              if (rb.get(0).getOra_fine().toLocalTime().getHour() 
                  == tempoeffett.toLocalTime().getHour()) {
                pb.setOrario(rb.get(1).getOra_inizio());
                return true;
              } else {
                pb.setOrario(tempoeffett);
                return true;
              }
            }
          } else {
            pb.setOrario(tempoeffett);// ora con aggiunta dei minuti in base al tipo precedente
            return true;
          }
        }
        return false;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  /**
   * Questo metodo ritorna il codice identificativo della prenotazione per poterla
   * stampare a video,
   * ritorna nel try in caso in cui la query 
   * è stata effettuata con successo oppure ritorna null in caso di.
   * eccezioni nel catch.
   * 
   * @param sb (StudenteBean)
   * @return arrpb ArrayList&ltPrenotaBean&gt
   */
  public synchronized ArrayList<PrenotaBean> getNumPrenotazioni(StudenteBean sb) {

    Connection con = null;
    PreparedStatement ps = null;
    try {
      con = DriverManagerConnectionPool.getConnection();
      ps = con.prepareStatement(
          "select p.numero_prenotazione, p.prenotaMatricolaDoc "
          + "from prenota p where p.prenotaEmailStud= ?");
      ps.setString(1, sb.getEmail());
      PrenotaBean pb = null;
      ArrayList<PrenotaBean> arrpb = new ArrayList<PrenotaBean>();

      ResultSet res = ps.executeQuery();
      while (res.next()) {
        pb = new PrenotaBean();
        pb.setNumero_prenotazione(res.getInt("p.numero_prenotazione"));
        pb.setPrenotaMatricolaDoc(res.getString("p.prenotaMatricolaDoc"));

        arrpb.add(pb);
      }

      return arrpb;

    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }

  }

  /**
   * Questo metodo serve per ritornare i dati del docente data una determinata
   * prenotazione, per poterli stampare a video.
   * 
   * @param sb (StudenteBean)
   * @param numprenot (int)
   * @return db(DocenteBean) nel caso in cui la query è stata eseguita con
   *         successo, oppure ritorna null nel catch in caso di eccezioni.
   */
  public synchronized DocenteBean getDocentePrenot(StudenteBean sb, int numprenot) {

    Connection con = null;
    PreparedStatement ps = null;
    try {
      con = DriverManagerConnectionPool.getConnection();
      ps = con.prepareStatement(
          "select d.nome, d.cognome from docente d, prenota p "
          + "where p.prenotaMatricolaDoc=d.matricolaDoc "
          + "AND p.prenotaEmailStud = ? AND p.numero_prenotazione = ?");
      ps.setString(1, sb.getEmail());
      ps.setInt(2, numprenot);
      DocenteBean db = null;

      ResultSet res = ps.executeQuery();
      if (res.next()) {
        db = new DocenteBean();

        db.setNome(res.getString("d.nome"));
        db.setCognome(res.getString("d.cognome"));
      }

      return db;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }

  }

  /**
   * Questo metodo serve per recupare dal db i dati di una determinata
   * prenotazione per poterseli stampare a video.
   * 
   * @param sb (StudenteBean)
   * @param numprenot (int)
   * @return pb(PrenotaBean) in caso in cui la query è stata effettuata con
   *         successo, oppure ritorna null nel catch in caso di eccezioni.
   */
  public synchronized PrenotaBean getDatiPrenot(StudenteBean sb, int numprenot) {

    Connection con = null;
    PreparedStatement ps = null;
    try {
      con = DriverManagerConnectionPool.getConnection();
      ps = con.prepareStatement(
          "select p.numero_prenotazione, p.tipologia, p.orario, p.giorno from docente d, prenota p "
          + "where p.prenotaMatricolaDoc=d.matricolaDoc "
          + "AND p.prenotaEmailStud = ? AND p.numero_prenotazione = ?");
      ps.setString(1, sb.getEmail());
      ps.setInt(2, numprenot);

      PrenotaBean pb = null;

      ResultSet res = ps.executeQuery();
      if (res.next()) {
        pb = new PrenotaBean();

        pb.setNumero_prenotazione(res.getInt("p.numero_prenotazione"));
        pb.setTipologia(res.getString("p.tipologia"));
        pb.setOrario(res.getTime("p.orario"));
        pb.setGiorno(res.getDate("p.giorno"));

      }

      return pb;

    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }

  }

  /**
   * Questo metodo ritorna il numero esatto di prenotati per un dato docente.
   * 
   * @param matricoladocente (String)
   * @return i(int) nel caso in cui la query è stata effettuata con successo, in
   *         caso contrario ritorna 0, oppure ritorna 0 nel catch nel caso in cui
   *         sono presenti eccezioni.
   */
  public synchronized int getNumPrenotati(String matricoladocente) {

    Connection con = null;
    PreparedStatement ps = null;
    try {
      con = DriverManagerConnectionPool.getConnection();
      ps = con.prepareStatement(
          "select count(numero_prenotazione) from prenota p,docente d "
          + "where p.prenotaMatricolaDoc=d.matricolaDoc AND p.prenotaMatricolaDoc = ?");
      ps.setString(1, matricoladocente);

      ResultSet res = ps.executeQuery();
      if (res.next()) {
        int i = res.getInt("count(numero_prenotazione)");
        return i;
      }
      return 0;
    } catch (Exception e) {
      e.printStackTrace();
      return 0;
    }
  }

  /**
   * Questo metodo serve per eliminare una prenotazione lato studente.
   * 
   * @param sb (StudenteBean)
   * @param numprenot (int)
   * @return true (nel try, nel caso in cui il corso viene eliminato con successo)
   *         oppure false (nel catch, altrimenti)
   */

  public synchronized boolean eliminaPrenotazione(StudenteBean sb, int numprenot) {
    Connection con = null;
    PreparedStatement ps = null;
    try {
      con = DriverManagerConnectionPool.getConnection();
      ps = con.prepareStatement("delete from prenota "
          + "where numero_prenotazione = ? AND prenotaEmailStud = ?");
      ps.setInt(1, numprenot);
      ps.setString(2, sb.getEmail());

      ps.executeUpdate();

      return true;
    } catch (Exception e) {
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

  /**
   * Questo metodo ritornerà la lista degli studenti prenotati per un singolo
   * docente,
   * nel caso in cui la query è stata
   * effettuata con successo ed ha ritornato dei valori, oppure ritorna
   * null in caso di eccezioni.
   * 
   * @param pb (PrenotaBean)
   * @param db (DocenteBean)
   * @return arrpb ArrayList&ltPrenotaBean&gt 
   */
  public synchronized ArrayList<PrenotaBean> listaPrenotatiDoc(PrenotaBean pb, DocenteBean db) {

    Connection con = null;
    PreparedStatement ps = null;
    ArrayList<PrenotaBean> arrpb = new ArrayList<PrenotaBean>();
    try {
      con = DriverManagerConnectionPool.getConnection();
      ps = con.prepareStatement(
          "select s.nome, s.cognome, s.matricolaStud, p.nome_corso, p.giorno, "
          + "s.email, p.tipologia,p.orario from studente s, prenota p "
          + "where s.email = p.prenotaEmailStud AND p.prenotaMatricolaDoc = ?");
      ps.setString(1, db.getMatricolaDoc());

      ResultSet res = ps.executeQuery();

      while (res.next()) {

        pb = new PrenotaBean();
        pb.setNome_corso(res.getString("p.nome_corso"));
        pb.setGiorno(res.getDate("p.giorno"));
        pb.setTipologia(res.getString("p.tipologia"));
        pb.setOrario(res.getTime("p.orario"));

        arrpb.add(pb);

      }

    } catch (Exception e) {

      e.printStackTrace();
      return null;

    }
    return arrpb;
  }
}