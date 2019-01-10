package safemeeting.model;

/**
 * Classe usata per salvare sul database o recuperare
 *  dal database informazioni relative alla tipologia.
 * @author Emilio Mainardi
 * @author Donato Marmora
 * @author Luca Di Chiara
 */


public class TipologiaBean {

  private String tipoMatricolaDoc;
  private String tipo;
  private int tempo;

  public TipologiaBean() {

  }

  /**
   * Questo metodo popola l'oggetto tipologia con la matricola del docente, la
   * tipologia e il tempo.
   */
  public TipologiaBean(String tipoMatricolaDoc, String tipo, int tempo) {
    this.tipoMatricolaDoc = tipoMatricolaDoc;
    this.tipo = tipo;
    this.tempo = tempo;
  }

  /**
   * Questo metodo serve per prendere la matricola del docente.
   * 
   * @return tipoMatricolaDoc (matricola del docente)
   */
  public String getTipoMatricolaDoc() {
    return tipoMatricolaDoc;
  }

  /**
   * Questo metodo serve per salvare la matricola del docente.
   * 
   * @param tipoMatricolaDoc (matricola del docente)
   */
  public void setTipoMatricolaDoc(String tipoMatricolaDoc) {
    this.tipoMatricolaDoc = tipoMatricolaDoc;
  }

  /**
   * Questo metodo serve per prendere il tipo del tipologia.
   * 
   * @return tipo (tipologia)
   */
  public String getTipo() {
    return tipo;
  }

  /**
   * Questo metodo serve per salvare il tipo del tipologia.
   */
  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  /**
   * Questo metodo serve per prendere il tempo del tipologia.
   * 
   * @return tempo (tempo impostato per ogni tipo)
   */
  public int getTempo() {
    return tempo;
  }

  /**
   * Questo metodo serve per salvare il tempo della tipologia.
   */
  public void setTempo(int tempo) {
    this.tempo = tempo;
  }

}
