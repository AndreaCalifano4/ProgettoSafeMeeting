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

  /**
   * Questo metodo popola l'oggetto preferiti 
   * con la matricola del docente e con l'email dello studente.
   * 
   * @param matricolaDoc (matricola del docente)
   * @param preferitiEmailStud (e-mail dello studente)
   */
  public PreferitiBean(String matricolaDoc, String preferitiEmailStud) {
    this.matricolaDoc = matricolaDoc;
    this.preferitiEmailStud = preferitiEmailStud;
  }

  /**
   * Questo metodo serve per prendere la matricola del docente.
   */
  public PreferitiBean(String preferitiEmailStud) {
    this.preferitiEmailStud = preferitiEmailStud;
  }

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

  /**
   * Questo metodo serve per sampare tutti i dati esistenti di un preferito.
   * 
   * @return tutti i dati esistenti in una prenotazione
   */
  @Override
  public String toString() {
    return "PreferitiBean [matricolaDoc=" + matricolaDoc + ","
        + " preferitiEmailStud=" + preferitiEmailStud + "]";
  }
}
