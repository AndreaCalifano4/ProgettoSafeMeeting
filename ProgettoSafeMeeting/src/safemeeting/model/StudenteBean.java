package safemeeting.model;

public class StudenteBean {
	
	private String matricolaStud;
	private String nome;
	private String cognome;
	private String password;
	private String email;
	
	public StudenteBean(String email, String password) {
		this.password=password;
		this.email=email;
	}
	
	public StudenteBean() {
		
	}

	public String getMatricolaStud() {
		return matricolaStud;
	}

	public void setMatricolaStud(String matricolaStud) {
		this.matricolaStud = matricolaStud;
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

	@Override
	public String toString() {
		return "StudenteBean [matricolaStud=" + matricolaStud + ", nome=" + nome + ", cognome=" + cognome
				+ ", password=" + password + ", email=" + email + "]";
	}
}
