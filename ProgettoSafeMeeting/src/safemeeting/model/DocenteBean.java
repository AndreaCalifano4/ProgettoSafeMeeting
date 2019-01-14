package safemeeting.model;

/**
 * Classe usata per salvare sul database o recuperare dal database informazioni relative al docente.
 * @author Emilio Mainardi
 * @author Donato Marmora
 * @author Luca Di Chiara
 */


public class DocenteBean {

  private String matricolaDoc;
  private String nome;
  private String cognome;
  private String password;
  private String email;
  private String studio;
  private String immagine;

  /**
   * Questo metodo popola l'oggetto docente con email e password.
   * 
   * @param email    (e-mail inserita dal docente)
   * @param password (password inserita dal docente)
   */
  public DocenteBean(String email, String password) {
    this.email = email;
    this.password = password;
  }

  public DocenteBean() {

  }

  /**
   * Questo metodo serve per prendere la matricola di un docente.
   * 
   * @return matrcolaDoc (matricola del docente)
   */
  public String getMatricolaDoc() {
    return matricolaDoc;
  }

  /**
   * Questo metodo salva la matricola inserita dal docente.
   * 
   * @param matricolaDoc (matricola del docente)
   */
  public void setMatricolaDoc(String matricolaDoc) {
    this.matricolaDoc = matricolaDoc;
  }

  /**
   * Questo metodo serve per prendere il nome del docente.
   * 
   * @return nome (nome del docente)
   */
  public String getNome() {
    return nome;
  }

  /**
   * Questo metodo salva il nome inserito dal docente.
   * 
   * @param nome (nome del docente)
   */
  public void setNome(String nome) {
    this.nome = nome;
  }

  /**
   * Questo metodo serve per prendere il cognome del docente.
   * 
   * @return cognome (cognome del docente)
   */
  public String getCognome() {
    return cognome;
  }

  /**
   * Questo metodo salva il cognome inserito dal docente.
   * 
   * @param cognome (cognome del docente)
   */
  public void setCognome(String cognome) {
    this.cognome = cognome;
  }

  /**
   * Questo metodo serve per prendere la password del docente.
   * 
   * @return password (password del docente)
   */
  public String getPassword() {
    return password;
  }

  /**
   * Questo metodo salva la password inserita dal docente.
   * 
   * @param password (password del docente)
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * Questo metodo serve per prendere l'e-mail del docente.
   * 
   * @return email (email del docente)
   */
  public String getEmail() {
    return email;
  }

  /**
   * Questo metodo salva l'e-mail inserita dal docente.
   * 
   * @param email (email del docente)
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Questo metodo serve per prendere lo studio del docente.
   * 
   * @return studio (studio del docente)
   */
  public String getStudio() {
    return studio;
  }

  /**
   * Questo metodo salva lo studio inserito dal docente.
   * 
   * @param studio (studio del docente)
   */
  public void setStudio(String studio) {
    this.studio = studio;
  }

  /**
   * Questo metodo serve per prendere l'immagine inserita dal docente.
   * 
   * @return immagine (immagine del docente)
   */
  public String getImmagine() {
    return immagine;
  }

  /**
   * Questo metodo salva l'immagine inserita dal docente.
   * 
   * @param immagine (immagine del docente)
   */
  public void setImmagine(String immagine) {
    this.immagine = immagine;
  }
}
