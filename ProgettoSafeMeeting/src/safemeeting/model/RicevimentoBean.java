package safemeeting.model;

/**
 * Classe usata per gestire l'oggetto ricevimento;
 * @author Emilio Mainardi
 * @author Donato Marmora
 * @author Luca Di Chiara
 */

import java.sql.Time;

public class RicevimentoBean {

  private String matricolaDoc;
  private Time oraFine;
  private Time oraInizio;
  private String giorno;

  public RicevimentoBean() {

  }

  /**
   * Questo metodo popola l'oggetto ricevimento con la matricola del docente
   * l'ora d'inizio, l'ora di fine e il giorno.
   * 
   * @param matricolaDoc (matricola del docente)
   * @param oraFine (ora d'inizio)
   * @param oraInizio (ora di fine)
   * @param giorno (giorno)
   */
  public RicevimentoBean(String matricolaDoc, Time oraFine, Time oraInizio, String giorno) {
    this.matricolaDoc = matricolaDoc;
    this.oraFine = oraFine;
    this.oraInizio = oraInizio;
    this.giorno = giorno;
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
   * Questo metodo serve per prendere l'ora di fine ricevimento.
   * 
   * @return ora_fine (ora di fine del ricevimento)
   */
  public Time getOra_fine() {
    return oraFine;
  }

  /**
   * Questo metodo serve per salvare l'ora di fine ricevimento.
   * 
   * @param oraFine (ora di fine del ricevimento)
   */
  public void setOra_fine(Time oraFine) {
    this.oraFine = oraFine;
  }

  /**
   * Questo metodo serve per prendere l'ora d'inizio ricevimento.
   * 
   * @return ora_fine (ora d'inizio del ricevimento)
   */
  public Time getOra_inizio() {
    return oraInizio;
  }

  /**
   * Questo metodo serve per salvare l'ora d'inizio ricevimento.
   * 
   * @param oraInizio (ora d'inizio del ricevimento)
   */
  public void setOra_inizio(Time oraInizio) {
    this.oraInizio = oraInizio;
  }

  /**
   * Questo metodo serve per prendere il giorno del ricevimento.
   * 
   * @return giorno (giorno del ricevimento)
   */
  public String getGiorno() {
    return giorno;
  }

  /**
   * Questo metodo serve per salvare il giorno del ricevimento.
   * 
   * @param giorno (giorno del ricevimento)
   */
  public void setGiorno(String giorno) {
    this.giorno = giorno;
  }

}
