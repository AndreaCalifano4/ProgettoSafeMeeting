/**
 * Classe usata per salvare sul database o recuperare dal database informazioni relative al docente;
 * @author Emilio Mainardi
 * @author Donato Marmora
 * @author Luca Di Chiara
 */
package safemeeting.model;

public class DocenteBean {
	
	private String matricolaDoc;
	private String nome;
	private String cognome;
	private String password;
	private String email;
	private String studio;
	private String immagine;
	

	/**
	 * Questo metodo popola l'oggetto docente con email e password;
	 * @param email (e-mail inserita dal docente)
	 * @param password (password inserita dal docente)
	 */
	public DocenteBean(String email, String password) {
		this.email=email;
		this.password=password;
	}
	
	public DocenteBean() {
		
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
	 * Questo metodo serve per prendere il nome del docente;
	 * @return nome (nome del docente)
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Questo metodo salva il nome inserito dal docente;
	 * @param nome (nome del docente)
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Questo metodo serve per prendere il cognome del docente;
	 * @return cognome (cognome del docente)
	 */
	public String getCognome() {
		return cognome;
	}

	/**
	 * Questo metodo salva il cognome inserito dal docente;
	 * @param cognome (cognome del docente)
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	/**
	 * Questo metodo serve per prendere la password del docente;
	 * @return password (password del docente)
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Questo metodo salva la password inserita dal docente;
	 * @param password (password del docente)
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Questo metodo serve per prendere l'e-mail del docente;
	 * @return email (email del docente)
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Questo metodo salva l'e-mail inserita dal docente;
	 * @param email (email del docente)
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Questo metodo serve per prendere lo studio del docente;
	 * @return studio (studio del docente)
	 */
	public String getStudio() {
		return studio;
	}

	/**
	 * Questo metodo salva lo studio inserito dal docente;
	 * @param studio (studio del docente)
	 */
	public void setStudio(String studio) {
		this.studio = studio;
	}

	/**
	 * Questo metodo serve per prendere l'immagine inserita dal docente;
	 * @return immagine (immagine del docente)
	 */
	public String getImmagine() {
		return immagine;
	}

	/**
	 * Questo metodo salva l'immagine inserita dal docente;
	 * @param immagine (immagine del docente)
	 */
	public void setImmagine(String immagine) {
		this.immagine = immagine;
	}

	/**
	 * Questo metodo serve per sampare tutti i dati esistenti di un docente;
	 * @return tutti i dati del docente
	 */
	@Override
	public String toString() {
		return "DocenteBean [matricolaDoc=" + matricolaDoc + ", nome=" + nome + ", cognome=" + cognome + ", password="
				+ password + ", email=" + email + ", studio=" + studio + ", immagine=" + immagine + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((immagine == null) ? 0 : immagine.hashCode());
		result = prime * result + ((matricolaDoc == null) ? 0 : matricolaDoc.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((studio == null) ? 0 : studio.hashCode());
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
		DocenteBean other = (DocenteBean) obj;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (immagine == null) {
			if (other.immagine != null)
				return false;
		} else if (!immagine.equals(other.immagine))
			return false;
		if (matricolaDoc == null) {
			if (other.matricolaDoc != null)
				return false;
		} else if (!matricolaDoc.equals(other.matricolaDoc))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (studio == null) {
			if (other.studio != null)
				return false;
		} else if (!studio.equals(other.studio))
			return false;
		return true;
	}

}
