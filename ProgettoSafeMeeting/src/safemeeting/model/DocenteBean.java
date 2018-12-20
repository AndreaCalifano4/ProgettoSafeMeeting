package safemeeting.model;

public class DocenteBean {
	
	private String matricolaDoc;
	private String nome;
	private String cognome;
	private String password;
	private String email;
	private String studio;
	private String immagine;
	
	public DocenteBean(String email, String password) {
		this.email=email;
		this.password=password;
	}
	
	public DocenteBean() {
		
	}

	public String getMatricolaDoc() {
		return matricolaDoc;
	}

	public void setMatricolaDoc(String matricolaDoc) {
		this.matricolaDoc = matricolaDoc;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStudio() {
		return studio;
	}

	public void setStudio(String studio) {
		this.studio = studio;
	}

	public String getImmagine() {
		return immagine;
	}

	public void setImmagine(String immagine) {
		this.immagine = immagine;
	}

	@Override
	public String toString() {
		return "DocenteBean [matricolaDoc=" + matricolaDoc + ", nome=" + nome + ", cognome=" + cognome + ", password="
				+ password + ", email=" + email + ", studio=" + studio + ", immagine=" + immagine + "]";
	}

}
