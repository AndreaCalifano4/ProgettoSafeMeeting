/**
 * Classe usata per gestire l'oggetto preferiti;
 * @author Emilio Mainardi
 * @author Donato Marmora
 * @author Luca Di Chiara
 */
package safemeeting.model;

public class PreferitiBean {

	private String matricolaDoc;
	private String preferitiEmailStud;


	/**
	 * Questo metodo popola l'oggetto preferiti con la matricola del docente e con ;
	 * @param MatricolaDoc (matricola del docente)
	 * @param preferitiEmailStud (e-mail dello studente)
	 */
	public PreferitiBean(String matricolaDoc, String preferitiEmailStud) {
		this.matricolaDoc = matricolaDoc;
		this.preferitiEmailStud = preferitiEmailStud;
	}
	
	/**
	 * Questo metodo serve per prendere la matricola del docente;
	 * @return matricolaDoc (matricola del docente)
	 */
	public PreferitiBean(String preferitiEmailStud)
	{
		this.preferitiEmailStud = preferitiEmailStud;
	}
	
	public PreferitiBean() {}

	public String getMatricolaDoc() {
		return matricolaDoc;
	}

	/**
	 * Questo metodo serve per salvare la matricola del docente;
	 * @param matricolaDoc (matricola del docente)
	 */
	public void setMatricolaDoc(String matricolaDoc) {
		this.matricolaDoc = matricolaDoc;
	}

	/**
	 * Questo metodo serve per prendere l'e-mail di uno studente che ha la lista preferiti;
	 * @return preferitiEmailStud (e-mail dello studente)
	 */
	public String getPreferitiEmailStud() {
		return preferitiEmailStud;
	}


	/**
	 * Questo metodo serve per salvare l'e-mail di uno studente che ha la lista preferiti;
	 * @param preferitiEmailStud (e-mail dello studente)
	 */
	public void setPreferitiEmailStud(String preferitiEmailStud) {
		this.preferitiEmailStud = preferitiEmailStud;
	}
	
	/**
	 * Questo metodo serve per sampare tutti i dati esistenti di un preferito;
	 * @return tutti i dati esistenti in una prenotazione
	 */
	@Override
	public String toString() {
		return "PreferitiBean [matricolaDoc=" + matricolaDoc + ", preferitiEmailStud=" + preferitiEmailStud + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricolaDoc == null) ? 0 : matricolaDoc.hashCode());
		result = prime * result + ((preferitiEmailStud == null) ? 0 : preferitiEmailStud.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PreferitiBean other = (PreferitiBean) obj;
		if (matricolaDoc == null) {
			if (other.matricolaDoc != null)
				return false;
		} else if (!matricolaDoc.equals(other.matricolaDoc))
			return false;
		if (preferitiEmailStud == null) {
			if (other.preferitiEmailStud != null)
				return false;
		} else if (!preferitiEmailStud.equals(other.preferitiEmailStud))
			return false;
		return true;
	}
	

}
