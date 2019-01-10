/**
 * Classe usata per gestire l'oggetto prenota;
 * @author Emilio Mainardi
 * @author Donato Marmora
 * @author Luca Di Chiara
 */
package safemeeting.model;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import safemeeting.observer.*;

public class PrenotaBean implements Subject{

  int numero_prenotazione;
  String nome_corso;
  String tipologia;
  Time orario;
  Date giorno;
  String prenotaEmailStud;
  String prenotaMatricolaDoc;
  private String message;
  private List<Observer> listOfObservers;
  private boolean cambiamento;
  private final Object MUTEX= new Object();
  
  public PrenotaBean() {
	 this.listOfObservers = new ArrayList<Observer>();
  }
  
   /**
   *  Questo metodo popola l'oggetto prenota con il numero della prenotazione, il nome del corso, la tipologia, l'orario, il giorno,
   *  l'e-mail dello studente e la matricola del docente;
   * @param numero_prenotazione (numero della prenotazione)
   * @param nome_corso (nome del corso)
   * @param tipologia (tipologia)
   * @param orario (orario)
   * @param giorno (giorno)
   * @param prenotaEmailStud (e-mail dello studente)
   * @param prenotaMatricolaDoc (matriola del docente)
   */
  public PrenotaBean(int numero_prenotazione, String nome_corso, String tipologia, Time orario, Date giorno, String prenotaEmailStud, String prenotaMatricolaDoc) {
    this.numero_prenotazione=numero_prenotazione;
    this.nome_corso=nome_corso;
    this.tipologia=tipologia;
    this.orario=orario;
    this.giorno=giorno;
    this.prenotaEmailStud=prenotaEmailStud;
    this.prenotaMatricolaDoc=prenotaMatricolaDoc;
  }

   /**
   * Questo metodo serve per prendere il numero della prenotazione;
   * @return numero_prenotazione (numero della prenotazione)
   */
  public int getNumero_prenotazione() {
    return numero_prenotazione;
  }

   /**
   * Questo metodo serve per salvare il numero della prenotazione;
   * @param numero_prenotazione (numero della prenotazione)
   */
  public void setNumero_prenotazione(int numero_prenotazione) {
    this.numero_prenotazione = numero_prenotazione;
  }

   /**
   * Questo metodo serve per prendere il nome del corso per cui ci si prenota;
   * @return nome_corso (nome del corso)
   */
  public String getNome_corso() {
    return nome_corso;
  }

   /**
   * Questo metodo serve per salvare il nome del corso per cui ci si prenota;
   * @param nome_corso (nome del corso)
   */
  public void setNome_corso(String nome_corso) {
    this.nome_corso = nome_corso;
  }

   /**
   * Questo metodo serve per prendere la tipologia della prenotaizone;
   * @return tipologia (tipologia della prenotazione)
   */
  public String getTipologia() {
    return tipologia;
  }

   /**
   * Questo metodo serve per salvare la tipologia della prenotazione;
   * @param tipologia (tipologia della prenotazione)
   */
  public void setTipologia(String tipologia) {
    this.tipologia = tipologia;
  }

   /**
   * Questo metodo serve per prendere l'orario riferito alla prenotazione;
   * @return orario (orario della prenotazione)
   */
  public Time getOrario() {
    return orario;
  }

  /**
   * Questo metodo serve per salvare l'orario riferito alla prenotazione;
   * @param orario (orario della prenotazione)
   */
  public void setOrario(Time orario) {
    this.orario = orario;
  }

  /**
   * Questo metodo serve per prendere il giorno della prenotazione;
   * @return giorno (giorno della prenotazione)
   */
  public Date getGiorno() {
    return giorno;
  }

  /**
   * Questo metodo serve per salvare il giorno della prenotazione;
   * @param giorno (giorno della prenotazione)
   */
  public void setGiorno(Date giorno) {
    this.giorno = giorno;
  }

  /**
   * Questo metodo serve per prendere l'e-mail dello studente che si prenota;
   * @return prenotaEmailStud (e-mail dello studente)
   */
  public String getPrenotaEmailStud() {
    return prenotaEmailStud;
  }


  /**
   * Questo metodo serve per salvare l'e-mail dello studente che si prenota;
   * @param prenotaEmailStud (e-mail dello studente)
   */
  public void setPrenotaEmailStud(String prenotaEmailStud) {
    this.prenotaEmailStud = prenotaEmailStud;
  }

    /**
   * Questo metodo serve per prendere la matricola del docente per cui si effettua la prenotazione;
   * @return prenotaMatricolaDoc (matricola del docente)
   */
  public String getPrenotaMatricolaDoc() {
    return prenotaMatricolaDoc;
  }

  /**
   * Questo metodo serve per salvare la matricola del docente per cui si effettua la prenotazione;
   * @param prenotaMatricolaDoc (matricola del docente)
   */
  public void setPrenotaMatricolaDoc(String prenotaMatricolaDoc) {
    this.prenotaMatricolaDoc = prenotaMatricolaDoc;
  }

/**
 * Questo metodo serve per prendere gli osservetori da una lista;
 * @return listOfObserver (lista degli osservatori)
 */
public List<Observer> getListOfObserver() {
	return listOfObservers;
}

/**
 * Questo metodo serve per salvare gli osservatori in una lista;
 * @param listOfObservers (lista degli osservatori)
 */
public void setListOfObserver(List<Observer> listOfObservers) {
	this.listOfObservers = listOfObservers;
}

/**
 * Questo metodo serve per creare un osservatore nella lista;
 * @param observer (osservatore)
 */
@Override
public void registerObserver(Observer observer) {
	// TODO Auto-generated method stub
	listOfObservers.add(observer);
}

/**
 * Questo metodo serve per rimuovere un osservatore dalla lista;
 * @param observer (osservatore)
 */
@Override
public void removeObserver(Observer observer) {
	// TODO Auto-generated method stub
	
	listOfObservers.remove(observer);
}

/**
 * Questo metodo serve per notificare il cambiamento dello stato dell'oggetto osservato;
 */
@Override
public void notifyObserver() {
	// TODO Auto-generated method stub
	
	List<Observer> observersLocal = null;

	        //synchronization is used to make sure any observer registered after message is received is not notified
	      synchronized (MUTEX) {
	            if (!cambiamento)
	                return;
	            observersLocal = new ArrayList<>(this.listOfObservers);
	            this.cambiamento=false;
	        }
	        for (Observer obj : observersLocal) {
	            obj.update();
	        }
}

/**
 * Questo metodo serve per prendere l'aggiornamento dell'observer e ritorna un messaggio;
 * @param observer (osservatore)
 * @return message (messaggio)
 */
@Override
public Object getUpdate(Observer observer) {
	// TODO Auto-generated method stub
	return this.message;
}

/**
 * Questo metodo serve per stampare il messaggio;
 * @param msg (messaggio)
 */  
public void postMessage(String msg){

	System.out.println("Message Posted to Teacher:"+msg);
	this.message=msg;
	this.cambiamento=true;
	notifyObserver();

}



  
}