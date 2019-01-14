/**
 * Classe usata per associare il docente ad un corso;
 * @author Emilio Mainardi
 * @author Donato Marmora
 * @author Luca Di Chiara
 */

package safemeeting.model;

public class InsegnaBean {

  private String insegnaMatricolaDoc;
  private String insegnaCodiceCorso;

  public InsegnaBean() {

  }

  /**
   * Questo metodo serve per prendere la matricola del docente.
   * 
   * @return insegnaMatricolaDoc (matricola del docente)
   */
  public String getInsegnaMatricolaDoc() {
    return insegnaMatricolaDoc;
  }

  /**
   * Questo metodo serve per salvare la matricola del docente.
   */
  public void setInsegnaMatricolaDoc(String insegnaMatricolaDoc) {
    this.insegnaMatricolaDoc = insegnaMatricolaDoc;
  }

  /**
   * Questo metodo serve per prendere il codice del corso.
   * 
   * @return insegnaCodiceCorso (codice del corso)
   */
  public String getInsegnaCodiceCorso() {
    return insegnaCodiceCorso;
  }

  /**
   * Questo metodo serve per salvare il codice del corso.
   */
  public void setInsegnaCodiceCorso(String insegnaCodiceCorso) {
    this.insegnaCodiceCorso = insegnaCodiceCorso;
  }

}
