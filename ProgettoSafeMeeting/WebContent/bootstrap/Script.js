/**
 * 
 */
function test() {
    var radios = document.getElementsByName("tipo-utente");
    
    for (var i = 0; i < radios.length; i++) {       
        if (radios[1].checked) {
        	document.getElementById('studio').style.display = "block"; 	
        }
        else if(radios[0].checked){
        	document.getElementById('studio').style.display = "none";
        }
   }  
}

function validate(){
	var n = document.getElementById("nome").value;
	var c = document.getElementById("cognome").value;
	var m = document.getElementById("matricola").value;
	var e = document.getElementById("email").value;
	var p = document.getElementById("password").value;
	var r = document.getElementById("ripPassword").value;
	var s = document.getElementById("studio").value;
	
	var nome = validationNome(n);
	var cognome = validationCognome(c);
	var matricola = validationMatricola(m);
	var email = validationEmail(e);
	var password = validationPassword(p);
	var ripPassword = validationRipPassword(r);
	var studio = validationStudio(s);
	var v = validateEmail(e);
	var match = matchPassword(p,r);
	
	if(nome == false || cognome == false || matricola == false || email == false || password == false || ripPassword == false || v == false || match == false){
		return false;
	}
	else window.alert('Registrazione effettuata con successo!');
}

function validationNome(nome){
	
	var letters = /^[a-zA-Z\s]+$/;
			
	if(nome == ''){
		document.getElementById("nome").style.borderColor = "red";
		return false;
	}
	else if (!nome.match(letters)){
		document.getElementById("errore").innerHTML = "Attenzione! Errore nella compilazion edei campi. Controlla che i campi siano corretti e che le due password siano uguali.";
		return false;
	}
	else{
		document.getElementById("nome").style.borderColor = "#ccc";
		return true;
	}

}

function validationCognome(cognome){
	var letters = /^[a-zA-Z\s]+$/;
			
	if(cognome == ''){
		document.getElementById("cognome").style.borderColor = "red";
		return false;
	}
	else if(!cognome.match(letters)){
		document.getElementById("errore").innerHTML = "Attenzione! Errore nella compilazione dei campi. Controlla che i campi siano corretti e che le due password siano uguali.";
		return false;
	}
	else{
		document.getElementById("cognome").style.borderColor = "#ccc";
		return true;
	}
}

function validationMatricola(matricola){
	var letters = /^\d{10}$/;
			
	if(matricola == ''){
		document.getElementById("matricola").style.borderColor = "red";
		return false;
	}
	else{
		if(!matricola.match(letters)){
			document.getElementById("errore").innerHTML = "Attenzione! Errore nella compilazione dei campi. Controlla che i campi siano corretti e che le due password siano uguali.";
			return false;
		}
	
	else{
		document.getElementById("matricola").style.borderColor = "#ccc";
		return true;
		}
	}
}

function validationEmail(email){
	var letters = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
			
	if(email == ''){
		document.getElementById("email").style.borderColor = "red";
		return false;
	}
	else if (!email.match(letters)){
		document.getElementById("errore").innerHTML = "Attenzione! Errore nella compilazione dei campi. Controlla che i campi siano corretti e che le due password siano uguali.";
		return false;
	}
	else{
		document.getElementById("email").style.borderColor = "#ccc";
		
		return true;
	}
}

function validationPassword(password){
	var letters = /^[a-zA-Z0-9\_\*\-\+\!\?\,\:\;\.\xE0\xE8\xE9\xF9\xF2\xEC\x27]{8,20}/;
			
	if(password == ''){
		document.getElementById("password").style.borderColor = "red";
		return false;
	}
	else if (!password.match(letters)){
		document.getElementById("errore").innerHTML = "Attenzione! Errore nella compilazione dei campi. Controlla che i campi siano corretti e che le due password siano uguali.";
		return false;
	}
	else{
		document.getElementById("password").style.borderColor = "#ccc";
		return true;
	}
}

function validationRipPassword(ripPassword){
	
	var letters = /^[a-zA-Z0-9\_\*\-\+\!\?\,\:\;\.\xE0\xE8\xE9\xF9\xF2\xEC\x27]{8,20}/;
			
	if(ripPassword == ''){
		document.getElementById("ripPassword").style.borderColor = "red";
		return false;
	}
	else if (!ripPassword.match(letters)){
		document.getElementById("errore").innerHTML = "Attenzione! Errore nella compilazione dei campi. Controlla che i campi siano corretti e che le due password siano uguali.";
		return false;
	}
	else{
		document.getElementById("ripPassword").style.borderColor = "#ccc";
		return true;
	}
}

function validationStudio(studio){
	
	var letters = /^[A-Z0-9\\'\\s{0,4}]+$/;
	
	if(studio == ''){
		document.getElementById("studio").style.borderColor = "red";
		return false;
	}
	else if (!studio.match(letters)){
		document.getElementById("errore").innerHTML = "Attenzione! Errore nella compilazione dei campi. Controlla che i campi siano corretti e che le due password siano uguali.";
		return false;
	}
	else{
		document.getElementById("studio").style.borderColor = "#ccc";
		return true;
	}
}

function matchPassword(p,r){
	if(p == r){
		return true;
	}
	else if(p != r){
		document.getElementById("errore").innerHTML = " Attenzione! Errore nella compilazione dei campi. Controlla che i campi siano corretti e che le due password siano uguali.";
		return false;
	}
}

function validateEmail(email) {	
	
	var radio = document.getElementsByName("tipo-utente");
	
	if(radio[0].checked){
		  if(email.includes("@studenti.unisa.it"))
			  return true;
		  else{
			  document.getElementById("errore").innerHTML = " Attenzione! Errore nella compilazione dei campi. Controlla che i campi siano corretti e che le due password siano uguali.";
			  return false;
		  }
	}
	
	if(radio[1].checked){
		if(email.includes("@unisa.it"))
			return true;
		else { 
			document.getElementById("errore").innerHTML = " Attenzione! Errore nella compilazione dei campi. Controlla che i campi siano corretti e che le due password siano uguali.";
			return false;
		}
			  
	}
		  
	if(!radio[0].checked && !radio[1].checked){
		document.getElementById("errore").innerHTML = " Attenzione indicare se sei uno studente o un docente.";
		return false;
	}   	
}

//validazione Registrazione

function getAnno(){
	var data = new Date();
	var a = data.getYear();
	var anno = a + 1900; 
	document.getElementById("anno").innerHTML = '<option> Anno </option>' + '<option>'+ anno + '</option>' + '<option>'+ (anno + 1) + '</option>'+ '<option>'+ (anno+2) +'</option>';
}

function validateData(){
	var opzioneGiorno = document.getElementById("giorno").value;
	var opzioneMese = document.getElementById("mese").value;
	var opzioneAnno = document.getElementById("anno").value;
	
	var sceltaGiorno = validationGiorno(opzioneGiorno);
	var sceltaMese = validationMese(opzioneMese);
	var sceltaAnno = validationAnno(opzioneAnno);
	var r = controllaGiorno(opzioneGiorno, opzioneMese, opzioneAnno);

	if(sceltaGiorno == false || sceltaMese == false || sceltaAnno == false || r == false  ){
		return false;
	}
}


function validationGiorno(opzioneGiorno){
	if(opzioneGiorno == 'giorno'){	
		document.getElementById("giorno").style.borderColor = "red";
		alert("errore da giorno ");
		return false;
	}
	else{
		alert("ok da giorno");
		document.getElementById("giorno").style.borderColor = "#ccc";
		return true;
	}
}

function validationMese(opzioneMese){
	if(opzioneMese == 'mese'){
		document.getElementById("mese").style.borderColor = "red";
		alert("errore da mese");
		return false;
	}
	else{
		alert("ok da mese");
		document.getElementById("mese").style.borderColor = "#ccc";
		return true;
	}
}

function validationAnno(opzioneAnno){
	if(opzioneAnno == 'Anno'){
		document.getElementById("anno").style.borderColor = "red";
		alert("errore da anno");
		return false;
	}
	else{
		document.getElementById("anno").style.borderColor = "#ccc";
		alert("ok da anno");
		return true;
	}
}

//controllo anno bisestile
function isLeap(opzioneAnno){
	var result = false;
	
	if ( ( opzioneAnno % 4 ) == 0 ) {
		if ( ( opzioneAnno % 100 ) != 0 ) {
			result = true;
		}
		else if ( ( opzioneAnno % 400 ) == 0 ) {
			result = true;
			}
		}
		return result;
	}

function controllaGiorno(opzioneGiorno, opzioneMese, opzioneAnno){
	
	var bisestile = isLeap(opzioneAnno);
		
	if(opzioneMese == 4 || opzioneMese == 6 || opzioneMese == 9 || opzioneMese == 11){
		if(opzioneGiorno == 31)
			alert (" errore il mese e' di 30 giorni");
			return false;
	}
	else if(opzioneMese == 2 && !bisestile ) {		
			if(opzioneGiorno == 30 || opzioneGiorno == 31 || opzioneGiorno == 29)		
			alert (" errore il mese e' di 28 giorni");
			return false;
	}
	else if(opzioneMese == 2 && bisestile) {		
		if(opzioneGiorno == 30 || opzioneGiorno == 31 )
		alert (" errore il mese e' di 29 giorni");
		return false;
	}
	else if(opzioneMese == 1 || opzioneMese == 3 || opzioneMese == 5 || opzioneMese == 7 || opzioneMese == 8 || opzioneMese == 10 || opzioneMese == 12){
		if(opzioneGiorno == 31)
		alert("ok il mese e' di 31 giorni");
		return true;
	}
}

/*validazione orario*/
function validateOra(){
	var opzioneDalle = document.getElementById("ora-dalle").value;
	var opzioneAlle = document.getElementById("ora-alle").value;
	
	var scelta1 = parseInt(opzioneDalle,10);
	var scelta2 = parseInt(opzioneAlle,10);
	
	var Ora = validationOra(scelta1, scelta2);

	var dalle = controllaDalle(opzioneDalle);
	var alle = controllaAlle(opzioneAlle);
	
	if(Ora == false || dalle == false || alle == false){
		return false;
	}
}

function validationOra(scelta1, scelta2){	
		
	if(scelta1 >= scelta2){
		alert("errore da ora");
		document.getElementById("ora-alle").style.borderColor = "#ccc";
		document.getElementById("ora-dalle").style.borderColor = "#ccc";
		return false;
	}
	else if (scelta1 < scelta2) {
		alert("ok da ora");
		document.getElementById("ora-alle").style.borderColor = "#ccc";
		document.getElementById("ora-dalle").style.borderColor = "#ccc";
		return true;
	}
	
}

function controllaDalle(opzioneDalle){
	if(opzioneDalle == 'dalle'){
		alert('campo 1 mancante');
		document.getElementById("ora-dalle").style.borderColor = "red";
		return true;
	}
	else
		document.getElementById("ora-dalle").style.borderColor = "#ccc";
		return true;	
}
function controllaAlle(opzioneAlle){	
		if(opzioneAlle == 'alle'){
			alert('campo 2 mancante');
			document.getElementById("ora-alle").style.borderColor = "red";
			return false;
		}	
		else
			document.getElementById("ora-alle").style.borderColor = "#ccc";
			return true;
}

// script validazione Orario di ricevimento

function validateGiorno(){
	var opzioneGiorno = document.getElementById("giorno").value;
	
	if(opzioneGiorno == 'giorno'){	
		document.getElementById("giorno").style.borderColor = "red";
		return false;
	}
	else{
		alert("ok da giorno");
		document.getElementById("giorno").style.borderColor = "#ccc";
		return true;
	}
}

function validationInput(){
	var opzioneTesi = document.getElementById("tesi").value;
	var opzioneInfo = document.getElementById("info").value;
	var opzioneProbl = document.getElementById("probl").value;
	var opzioneAltro = document.getElementById("altro").value;
	
	var t = validateTesi(opzioneTesi);
	var i = validateInfo(opzioneInfo);
	var p = validateProbl(opzioneProbl);
	var a = validateAltro(opzioneAltro);
	
	if(t == false || i == false || p == false || a == false){
		return false;
	}
}

function validateTesi(opzioneTesi){
	
	var letters = /^([0-6]{1}[0-9]{1})$/;
	
	if(opzioneTesi == ''){
		document.getElementById("tesi").style.borderColor = "red";
		return false
	}
	
	else if(opzioneTesi.match(letters) ){
		alert ("ok da tesi");
		document.getElementById("tesi").style.borderColor = "#ccc";
		return true;
	}
	else{
		alert("formato non valido da tesi");
		return false;
	}
}

function validateInfo(opzioneInfo){
	
	var letters = /^([0-6]{1}[0-9]{1})$/;
	
	if(opzioneInfo == ''){
		document.getElementById("info").style.borderColor = "red";
		return false
	}
	
	else if(opzioneInfo.match(letters) ){
		alert ("ok da info");
		document.getElementById("info").style.borderColor = "#ccc";
		return true;
	}
	else{
		alert("formato non valido da info");
		return false;
	}
}

function validateProbl(opzioneProbl){
	
	var letters = /^([0-6]{1}[0-9]{1})$/;
	
	if(opzioneProbl == ''){
		document.getElementById("probl").style.borderColor = "red";
		return false
	}
	
	else if(opzioneProbl.match(letters) ){
		alert ("ok da probl");
		document.getElementById("probl").style.borderColor = "#ccc";
		return true;
	}
	else{
		alert("formato non valido da probl");
		return false;
	}
}

function validateAltro(opzioneAltro){
		
	var letters = /^([0-6]{1}[0-9]{1})$/;
	
	if(opzioneAltro == ''){
		document.getElementById("altro").style.borderColor = "red";
		return false
	}
	
	else if(opzioneAltro.match(letters) ){
		alert ("ok da altro");
		document.getElementById("altro").style.borderColor = "#ccc";
		return true;
	}
	else{
		alert("formato non valido da altro");
		return false;
	}
}

//script validazione effettua prenotazione
function validateCorso(){
	var opzioneCorso = document.getElementById("corso").value;
	var opzioneTipologia = document.getElementById("tipologia").value;
	var opzioneData = document.getElementById("datepicker").value;
	
	var d = validationData(opzioneData);
	var c = validationCorso(opzioneCorso);
	var t = validationTipologia(opzioneTipologia);
	
	if(c == false || t == false || d == false){
		return false;
	}
}

function validationCorso(opzioneCorso){
	if(opzioneCorso == 'corso'){
		alert('errore da corso');
		document.getElementById("corso").style.borderColor = "red";
		return false;
	}
	else{
		alert('ok da corso');
		document.getElementById("corso").style.borderColor = "#ccc";
		return true;
	}
}

function validationTipologia(opzioneTipologia){
	if(opzioneTipologia == 'tipologia'){
		alert('errore da tipologia');
		document.getElementById("tipologia").style.borderColor = "red";
		return false;
	}
	else{
		alert('ok da tipologia');
		document.getElementById("tipologia").style.borderColor = "#ccc";
		return true;
	}
}

function validationData(){
	if($('#datepicker').val() == ''){
		alert('errore da data')
		document.getElementById("datepicker").style.borderColor = "red";
		return false;
	}
	else{
		alert('ok da data')
		document.getElementById("datepicker").style.borderColor = "#ccc";		
		return true;
	}
}

var boolean = false;
function addPreferiti(){
	boolean = !boolean
	
	if(boolean){
		document.getElementById("prefers").innerHTML = "<img id ='preferiti' src='bootstrap/images/preferiti.png' >";
	}
	if(boolean == false){
		document.getElementById("prefers").innerHTML = "<img id ='preferiti' src='bootstrap/images/!preferiti.png' >";
	}
}