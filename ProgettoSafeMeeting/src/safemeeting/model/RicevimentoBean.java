/**
 * Classe usata per gestire l'oggetto ricevimento;
 * @author Emilio Mainardi
 * @author Donato Marmora
 * @author Luca Di Chiara
 */
package safemeeting.model;

import java.sql.Time;

public class RicevimentoBean {

	private String matricolaDoc;
	private Time ora_fine;
	private Time ora_inizio;
	private String giorno;
	
	public RicevimentoBean() {
		
	}
	
	/**
	 * Questo metodo popola l'oggetto ricevimento con la matricola del docente, l'ora d'inizio, l'ora di fine e il giorno;
	 * @param matricolaDoc (matricola del docente)
	 * @param ora_fine (ora d'inizio)
	 * @param ora_inizio (ora di fine)
	 * @param giorno (giorno)
	 */
	public RicevimentoBean(String matricolaDoc, Time ora_fine, Time ora_inizio, String giorno) {
		this.matricolaDoc=matricolaDoc;
		this.ora_fine=ora_fine;
		this.ora_inizio=ora_inizio;
		this.giorno=giorno;
	}

	/**
	 * Questo metodo serve per prendere la matricola di un docente;
	 * @return matrcolaDoc (matricola del docente)
	 */
	public String getMatricolaDoc() {
		return matricolaDoc;
	}

	/**
	 * Questo metodo salva la matricola inserita dal docente;
	 * @param matricolaDoc (matricola del docente)
	 */
	public void setMatricolaDoc(String matricolaDoc) {
		this.matricolaDoc = matricolaDoc;
	}

	/**
	 * Questo metodo serve per prendere l'ora di fine ricevimento;
	 * @return ora_fine (ora di fine del ricevimento)
	 */
	public Time getOra_fine() {
		return ora_fine;
	}

	/**
	 * Questo metodo serve per salvare l'ora di fine ricevimento;
	 * @param ora_fine (ora di fine del ricevimento)
	 */
	public void setOra_fine(Time ora_fine) {
		this.ora_fine = ora_fine;
	}


	/**
	 * Questo metodo serve per prendere l'ora d'inizio ricevimento;
	 * @return ora_fine (ora d'inizio del ricevimento)
	 */
	public Time getOra_inizio() {
		return ora_inizio;
	}

	/**
	 * Questo metodo serve per salvare l'ora d'inizio ricevimento;
	 * @param ora_fine (ora d'inizio del ricevimento)
	 */
	public void setOra_inizio(Time ora_inizio) {
		this.ora_inizio = ora_inizio;
	}

	/**
	 * Questo metodo serve per prendere il giorno del ricevimento;
	 * @return giorno (giorno del ricevimento)
	 */
	public String getGiorno() {
		return giorno;
	}

	/**
	 * Questo metodo serve per salvare il giorno del ricevimento;
	 * @param giorno (giorno del ricevimento)
	 */
	public void setGiorno(String giorno) {
		this.giorno = giorno;
	}
	
	
}
