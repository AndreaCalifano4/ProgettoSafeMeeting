package safemeeting.model;

/**
 * Classe usata per gestire l'oggetto preferiti.
 * @author Emilio Mainardi
 * @author Donato Marmora
 * @author Luca Di Chiara
 */

public class PreferitiBean {

  private String matricolaDoc;
  private String preferitiEmailStud;

  public PreferitiBean() {
  }

  public String getMatricolaDoc() {
    return matricolaDoc;
  }

  /**
   * Questo metodo serve per salvare la matricola del docente.
   * 
   * @param matricolaDoc (matricola del docente)
   */
  public void setMatricolaDoc(String matricolaDoc) {
    this.matricolaDoc = matricolaDoc;
  }

  /**
   * Questo metodo serve per prendere l'e-mail di uno studente che ha la lista
   * preferiti.
   * 
   * @return preferitiEmailStud (e-mail dello studente)
   */
  public String getPreferitiEmailStud() {
    return preferitiEmailStud;
  }

  /**
   * Questo metodo serve per salvare l'e-mail di uno studente che ha la lista.
   * preferiti;
   * 
   * @param preferitiEmailStud (e-mail dello studente)
   */
  public void setPreferitiEmailStud(String preferitiEmailStud) {
    this.preferitiEmailStud = preferitiEmailStud;
  }
}
