/**
 * Classe usata per salvare sul database o recuperare dal database informazioni relative ad un corso;
 * @author Emilio Mainardi
 * @author Donato Marmora
 * @author Luca Di Chiara
 */
package safemeeting.model;

public class CorsoBean {

	private String codice;
	private String nome;
	private int num_cfu;
	private int ore_totali;
	
	public CorsoBean() {
		
	}
	

	/**
	 * Questo metodo popola l'oggetto corso con codice, nome, numero di cfu, e ore totali;
	 * @param codice (codice identificativo del corso) 
	 * @param nome (nome del codice)
	 * @param num_cfu (numero di cfu di un corso)
	 * @param ore_totali (numero di ore totali di un corso)
	 */
	public CorsoBean(String codice, String nome, int num_cfu, int ore_totali) {
		this.codice=codice;
		this.nome=nome;
		this.num_cfu=num_cfu;
		this.ore_totali=ore_totali;
	}

	/**
	 * Questo metodo serve per prendere il codice del corso;
	 * @return codice (codice del corso)
	 */
	public String getCodice() {
		return codice;
	}

	/**
	 * Questo metodo serve per salvare il codice del corso;
	 * @param codice (codice del corso)
	 */

	public void setCodice(String codice) {
		this.codice = codice;
	}

	/**
	 * Questo metodo serve per prendere il nome del corso;
	 * @return nome (nome del corso)
	 */

	public String getNome() {
		return nome;
	}

	/**
	 * Questo metodo serve per salvare il nome del corso;
	 * @param nome (nome del corso)
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Questo metodo serve per prendere il numero dei cfu del corso;
	 * @return num_cfu (numero dei cfu del corso)
	 */
	public int getNum_cfu() {
		return num_cfu;
	}

	/**
	 * Questo metodo serve per salvare il numero dei cfu di un corso;
	 * @param num_cfu (numero dei cfu del corso)
	 */
	public void setNum_cfu(int num_cfu) {
		this.num_cfu = num_cfu;
	}

	/**
	 * Questo metodo serve per prendere il numero di ore totali di un corso;
	 * @return ore_totali (ore totali di un corso)
	 */

	public int getOre_totali() {
		return ore_totali;
	}

	/**
	 * Questo metodo serve per salvare il numero di ore totali di un corso;
	 * @param ore_totali (ore totali di un corso)
	 */
	public void setOre_totali(int ore_totali) {
		this.ore_totali = ore_totali;
	}
}
