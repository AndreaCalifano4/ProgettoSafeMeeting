package safemeeting.model;

/**
 * Classe usata per interfacciare lo StudenteBean con in database;
 * @author Emilio Mainardi
 * @author Donato Marmora
 * @author Luca Di Chiara
 */

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudenteDao {
  /**
   * Questo metodo ti permette di registrare un nuovo studente all'interno del
   * database.
   * 
   * @param sb (StudenteBean)
   * @return true (Inserimento avvenuto con successo, nel try) otherwise false
   *         (Inserimento fallito, nel catch)
   */
  public synchronized boolean registraAccount(StudenteBean sb) {
    Connection conn = null;
    PreparedStatement ps = null;

    try {
      conn = DriverManagerConnectionPool.getConnection();
      ps = conn.prepareStatement("INSERT INTO studente VALUE (?, ?, ?, ?, ?); ");
      ps.setString(1, sb.getMatricolaStud());
      ps.setString(2, sb.getNome());
      ps.setString(3, sb.getCognome());
      ps.setString(4, sb.getPassword());
      ps.setString(5, sb.getEmail());

      ps.executeUpdate();
      return true;
    } catch (SQLException e) {
      
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
   * Questo metodo serve per effettuare il login dal lato studente.
   * 
   * @param email    (email dello studente)
   * @param password (password dello studente)
   * @return sb (StudenteBean, nel try, in caso il login sia riuscito) oppure
   *         null(nel try, altrimenti) oppure e.printStackTrace()(nel catch, in
   *         caso di errore)
   */
  public synchronized StudenteBean getLogin(String email, String password) {
    Connection conn = null;
    PreparedStatement ps = null;

    try {
      StudenteBean sb = new StudenteBean(email, password);
      conn = DriverManagerConnectionPool.getConnection();
      ps = conn.prepareStatement("SELECT * FROM studente WHERE email = ?");
      ps.setString(1, email);

      ResultSet res = ps.executeQuery();
      String decriptpsw = null;
      if (res.next()) {
        decriptpsw = MyCript.decrypt(res.getString("password"));
        sb.setPassword(decriptpsw);

        if (decriptpsw.equals(password)) {
          sb.setNome(res.getString("nome"));
          sb.setCognome(res.getString("cognome"));
          sb.setEmail(res.getString("email"));
          sb.setMatricolaStud(res.getString("matricolaStud"));
          return sb;
        } else {
          return null;
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        DriverManagerConnectionPool.releaseConnection(conn);
        ps.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return null;
  }

  /**
   * Questo metodo serve per cercare un docente.
   * 
   * @param param (stringa inserita nella barra di ricerca)
   * @param db    (DocenteBean)
   * @return null(nel try, in caso non ci siano docenti) oppure listadoc(nel try,
   *         contenente i docenti ricarcati) oppure e.printStackTrace()(nel catch,
   *         in caso di errore)
   */
  public ArrayList<DocenteBean> ricercaDocente(String param, DocenteBean db) {
    if (param != "") {
      Connection conn = null;
      PreparedStatement ps = null;
      PreparedStatement ps2 = null;
      ArrayList<DocenteBean> listadoc = new ArrayList<DocenteBean>();

      try {

        conn = DriverManagerConnectionPool.getConnection();
        ps = conn.prepareStatement(
            "SELECT * FROM docente d, corso c, insegna i "
            + "WHERE d.matricolaDoc=i.insegnaMatricolaDoc "
            + "AND i.insegnaCodiceCorso = c.Codice AND d.cognome LIKE ? LIMIT 1");
        ps.setString(1, "%" + param + "%");

        ResultSet res = ps.executeQuery();
        while (res.next()) {
          db = new DocenteBean();
          db.setMatricolaDoc(res.getString("d.matricolaDoc"));
          db.setCognome(res.getString("d.cognome"));
          db.setNome(res.getString("d.nome"));
          db.setPassword(res.getString("d.password"));
          db.setStudio(res.getString("d.studio"));
          db.setEmail(res.getString("d.email"));
          db.setImmagine(res.getString("d.immagine"));
          listadoc.add(db);
        }
        if (listadoc.isEmpty()) {
          ps2 = conn.prepareStatement(
              "SELECT * FROM docente d, corso c, insegna i "
              + "WHERE d.matricolaDoc=i.insegnaMatricolaDoc AND "
              + "i.insegnaCodiceCorso = c.Codice AND c.nome LIKE ?");
          ps2.setString(1, "%" + param + "%");

          ResultSet res2 = ps2.executeQuery();
          while (res2.next()) {
            db = new DocenteBean();
            db.setMatricolaDoc(res2.getString("d.matricolaDoc"));
            db.setCognome(res2.getString("d.cognome"));
            db.setNome(res2.getString("d.nome"));
            db.setPassword(res2.getString("d.password"));
            db.setStudio(res2.getString("d.studio"));
            db.setEmail(res2.getString("d.email"));
            db.setImmagine(res2.getString("d.immagine"));
            listadoc.add(db);
          }
          if (listadoc.isEmpty()) {
            return null;
          } else {
            return listadoc;
          }
        } else {
          return listadoc;
        }
      } catch (SQLException e) {
        e.printStackTrace();
        return null;
      } finally {
        try {
          DriverManagerConnectionPool.releaseConnection(conn);
          ps.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    } else {
      return null;
    }
  }

  /**
   * Questo metodo serve per recuperare i dati del docente.
   * 
   * @param matricola (matricola del docente)
   * @return db(DocenteBean, nel try, in caso l'operazione sia riuscita) oppure
   *         null(nel catch, altrimenti)
   */
  public DocenteBean getDocente(String matricola) {
    Connection conn = null;
    PreparedStatement ps = null;

    try {
      DocenteBean db = null;
      conn = DriverManagerConnectionPool.getConnection();
      ps = conn.prepareStatement("SELECT * FROM docente WHERE matricolaDoc = ?");
      ps.setString(1, matricola);

      ResultSet res = ps.executeQuery();
      if (res.next()) {
        db = new DocenteBean();
        db.setMatricolaDoc(res.getString("matricolaDoc"));
        db.setCognome(res.getString("cognome"));
        db.setNome(res.getString("nome"));
        db.setPassword(res.getString("password"));
        db.setStudio(res.getString("studio"));
        db.setEmail(res.getString("email"));
        db.setImmagine(res.getString("immagine"));
        return db;
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    } finally {
      try {
        DriverManagerConnectionPool.releaseConnection(conn);
        ps.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return null;
  }

  /**
   * Questo metodo serve per recuperare i dati di un corso.
   * 
   * @param matricola (matricola del docente)
   * @return arrcb(nel try, l'arraylist di tutti i corsi del docente) oppure
   *         null(nel catch, altrimenti)
   */
  public ArrayList<CorsoBean> getCorso(String matricola) {
    Connection conn = null;
    PreparedStatement ps = null;
    ArrayList<CorsoBean> arrcb = null;
    try {
      CorsoBean cb = null;
      arrcb = new ArrayList<CorsoBean>();
      conn = DriverManagerConnectionPool.getConnection();
      ps = conn.prepareStatement(
          "SELECT c.nome FROM docente d, corso c, insegna i "
          + "WHERE d.matricolaDoc = i.insegnaMatricolaDoc "
          + "AND i.insegnaCodiceCorso = c.Codice AND d.matricolaDoc = ?");
      ps.setString(1, matricola);

      ResultSet res = ps.executeQuery();
      while (res.next()) {
        cb = new CorsoBean();
        cb.setNome(res.getString("c.nome"));
        arrcb.add(cb);
      }
      return arrcb;
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
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
   * Questo metodo serve per recuperare i dati di un ricevimento.
   * 
   * @param matricola (matricola del docente)
   * @return arrrb(nel try, l'arraylist di tutti i ricevimenti del docente) oppure
   *         false(nel catch, altrimenti)
   */
  public ArrayList<RicevimentoBean> getRicevimento(String matricola) {
    Connection conn = null;
    PreparedStatement ps = null;
    ArrayList<RicevimentoBean> arrrb = null;

    try {
      RicevimentoBean rb = null;
      arrrb = new ArrayList<RicevimentoBean>();
      conn = DriverManagerConnectionPool.getConnection();
      ps = conn.prepareStatement(
          "SELECT r.giorno, r.ora_inizio, r.ora_fine FROM docente d, ricevimento r "
          + "WHERE d.matricolaDoc = r.ricevMatricolaDoc AND d.matricolaDoc = ?");
      ps.setString(1, matricola);

      ResultSet res = ps.executeQuery();
      while (res.next()) {
        rb = new RicevimentoBean();
        rb.setGiorno(res.getString("r.giorno"));
        rb.setOra_fine(res.getTime("r.ora_fine"));
        rb.setOra_inizio(res.getTime("r.ora_inizio"));
        arrrb.add(rb);
      }
      return arrrb;
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
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
   * Questo metodo serve per ricavare i dati di una tipologia.
   * 
   * @param matricola (matricola del docente)
   * @return arrtb(nel try, l'arraylist di tutti le tipologie) oppure null(nel
   *         catch, altrimenti)
   */
  public ArrayList<TipologiaBean> getTipologia(String matricola) {
    Connection conn = null;
    PreparedStatement ps = null;
    ArrayList<TipologiaBean> arrtb = null;

    try {
      TipologiaBean tb = null;
      arrtb = new ArrayList<TipologiaBean>();
      conn = DriverManagerConnectionPool.getConnection();
      ps = conn.prepareStatement(
          "SELECT * FROM tipologia t, docente d "
          + "WHERE t.tipoMatricolaDoc = d.matricolaDoc AND d.matricolaDoc = ?");
      ps.setString(1, matricola);

      ResultSet res = ps.executeQuery();
      while (res.next()) {
        tb = new TipologiaBean();
        tb.setTipoMatricolaDoc(res.getString("t.tipoMatricolaDoc"));
        tb.setTipo(res.getString("t.tipo"));
        tb.setTempo(res.getInt("t.tempo"));
        arrtb.add(tb);
      }
      return arrtb;
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
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
   * Questo metodo serve per ricavarci dal db i dati del messaggio, dato un
   * determinato studente,
   * nel caso in cui la query è stata
   * effettuata con successo, oppure ritorna null nel catch in caso di
   * eccezioni.
   * 
   * @param email (String)
   * @return arrmb ArrayList&ltMessaggioBean&gt
   */
  public synchronized ArrayList<MessaggioBean> getMessaggio(String email) {
    Connection conn = null;
    PreparedStatement ps = null;
    ArrayList<MessaggioBean> arrmb = new ArrayList<MessaggioBean>();

    try {
      conn = DriverManagerConnectionPool.getConnection();
      ps = conn.prepareStatement("SELECT * FROM messaggio m WHERE m.messaggioEmailStud = ? ");
      ps.setString(1, email);

      MessaggioBean mb = null;
      ResultSet res = ps.executeQuery();
      while (res.next()) {
        mb = new MessaggioBean();

        mb.setMessaggio(res.getString("m.messaggio"));
        mb.setMessaggioEmailStud(res.getString("m.messaggioEmailStud"));
        mb.setMessaggioMatricolaDoc(res.getString("m.messaggioMatricolaDoc"));

        arrmb.add(mb);
      }
      return arrmb;

    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Questo metodo serve per ricavare i dati del docente che hanno segnalato
   * un'assenza e, quindi, creato un messaggio,
   * nel caso in cui la query è stata
   * effettuata con successo, oppure ritorna null in caso di eccezioni.
   * 
   * @param email (String)
   * @return arrmb ArrayList&ltDocenteBean&gt
   */
  public synchronized ArrayList<DocenteBean> getDocMessaggio(String email) {
    Connection conn = null;
    PreparedStatement ps = null;
    ArrayList<DocenteBean> arrmb = new ArrayList<DocenteBean>();
    DocenteBean mb = null;

    try {
      conn = DriverManagerConnectionPool.getConnection();
      ps = conn.prepareStatement(
          "SELECT d.nome,d.cognome FROM messaggio m, docente d "
          + "WHERE m.messaggioMatricolaDoc = d.matricolaDoc AND m.messaggioEmailStud = ? ");
      ps.setString(1, email);

      ResultSet res = ps.executeQuery();
      while (res.next()) {
        mb = new DocenteBean();

        mb.setNome(res.getString("d.nome"));
        mb.setCognome(res.getString("d.cognome"));

        arrmb.add(mb);
      }
      return arrmb;

    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Questo metodo ci permette di cancellare un'account di uno studente
   * all'interno del db.
   * 
   * @param email (String)
   * @return true (nel try, nel caso in cui l'account dello studente viene
   *         eliminato con successo) oppure false (nel catch, altrimenti)
   */
  public boolean eliminaAccount(String email) {
    Connection conn = null;
    PreparedStatement ps = null;

    try {
      conn = DriverManagerConnectionPool.getConnection();
      ps = conn.prepareStatement("DELETE FROM studente WHERE email = ?");
      ps.setString(1, email);
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
   * Questo metodo ci permette di modificare i dati dello studente presenti nel
   * db.
   * 
   * @param nome (String)
   * @param cognome (String)
   * @param matricola (String)
   * @param oldPassword (String)
   * @param newPassword (String)
   * @param email (String)
   * @return sb (StudenteBean) nel try, nel caso in cui l'ha modificato con
   *         successo e ritorna null se non corrisponde il controllo sulla
   *         password,oppure null nel catch, nel caso in cui la modifica non è
   *         avvenuta con successo).
   */
  public StudenteBean modificaAccount(String nome, String cognome, 
      String matricola, String oldPassword,
      String newPassword, String email) {
    Connection conn = null;
    PreparedStatement ps = null;
    PreparedStatement ps1 = null;

    try {
      StudenteBean sb = null;
      conn = DriverManagerConnectionPool.getConnection();

      ps = conn.prepareStatement("SELECT password FROM studente WHERE email = ?");
      ps.setString(1, email);
      ResultSet res = ps.executeQuery();

      String dbPass = null;

      if (res.next()) {
        dbPass = res.getString("password");
      }

      if (oldPassword.equals(dbPass)) {
        ps1 = conn.prepareStatement(
            "UPDATE studente SET matricolaStud = ?, nome = ?, cognome = ?, password = ? "
            + "WHERE email = ?;");
        ps1.setString(1, matricola);
        ps1.setString(2, nome);
        ps1.setString(3, cognome);
        ps1.setString(4, newPassword);
        ps1.setString(5, email);
        int flag = ps1.executeUpdate();

        if (flag != 0) {
          sb = new StudenteBean();
          sb.setMatricolaStud(matricola);
          sb.setNome(nome);
          sb.setCognome(cognome);
          sb.setEmail(email);
          sb.setPassword(newPassword);

          return sb;
        } else {
          return null;
        }
      } else {
        return null;
      }

    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    } finally {
      try {
        DriverManagerConnectionPool.releaseConnection(conn);
        ps.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }

    }
  }

}
