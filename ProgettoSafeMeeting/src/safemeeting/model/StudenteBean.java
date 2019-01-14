package safemeeting.model;

/**
 * Classe usata per salvare sul database o recuperare dal
 *  database informazioni relative allo studente.
 * @author Emilio Mainardi
 * @author Donato Marmora
 * @author Luca Di Chiara
 */

import safemeeting.observer.Observer;
import safemeeting.observer.Subject;

public class StudenteBean implements Observer {

  private String matricolaStud;
  private String nome;
  private String cognome;
  private String password;
  private String email;
  private Subject subject;

  /**
   * Questo metodo popola l'oggetto studente con email e password.
   * 
   * @param email    (e-mail inserita dallo studente)
   * @param password (password inserita dallo studente)
   */
  public StudenteBean(String email, String password) {
    this.password = password;
    this.email = email;
  }

  /**
   * Questo metodo popola l'oggetto studente con la matricola.
   * 
   * @param matricolaStud (matricola inserita dallo studente)
   */
  public StudenteBean(String matricolaStud) {
    this.matricolaStud = matricolaStud;
  }

  public StudenteBean() {

  }

  /**
   * Questo metodo serve per prendere la matricola dello studente.
   * 
   * @return matricolaStud (matricola dello studente)
   */
  public String getMatricolaStud() {
    return matricolaStud;
  }

  /**
   * Questo metodo salva la matricola inserita dallo studente.
   * 
   * @param matricolaStud (matricola dello studente)
   */
  public void setMatricolaStud(String matricolaStud) {
    this.matricolaStud = matricolaStud;
  }

  /**
   * Questo metodo serve per prendere il nome dello studente.
   * 
   * @return nome (nome dello studente)
   */
  public String getNome() {
    return nome;
  }

  /**
   * Questo metodo serve per salvare il nome dello studente.
   * 
   * @param nome (nome dello studente)
   */
  public void setNome(String nome) {
    this.nome = nome;
  }

  /**
   * Questo metodo serve per prendere il cognome dello studente.
   * 
   * @return cognome (cognome dello studente)
   */
  public String getCognome() {
    return cognome;
  }

  /**
   * Questo metodo serve per salvare il cognome dello studente.
   * 
   * @param cognome (cognome dello studente)
   */
  public void setCognome(String cognome) {
    this.cognome = cognome;
  }

  /**
   * Questo metodo serve per prendere la password dello studente.
   * 
   * @return password (password dello studente)
   */
  public String getPassword() {
    return password;
  }

  /**
   * Questo metodo serve per salvare la password dello studente.
   * 
   * @param password (passowrd dello studente)
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * Questo metodo serve per prendere l'e-mail dello studente.
   * 
   * @return email (e-mail dello studente)
   */
  public String getEmail() {
    return email;
  }

  /**
   * Questo metodo serve per salvare l'e-mail dello studente.
   * 
   * @param email (e-mail dello studente)
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Questo metodo serve per prendere i dati di un oggetto subject.
   * 
   * @return subject (soggetto preso)
   */
  public Subject getSubject() {
    return subject;
  }

  /**
   * Questo metodo serve per controllare se ci sono messaggi; nel caso in cui ci
   * siano li stampa.
   */
  @Override
  public void update() {
    // TODO Auto-generated method stub
    String msg = (String) subject.getUpdate(this);
    if (msg == null) {
      System.out.println(matricolaStud + ":: No new message");
    } else {
      System.out.println(matricolaStud + ":: Student message::" + msg);
    }
  }

  /**
   * Questo metodo salva il soggetto preso.
   * 
   * @param sub (soggetto preso)
   */
  @Override
  public void setSubject(Subject sub) {
    // TODO Auto-generated method stub
    this.subject = sub;

  }
}
