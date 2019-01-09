/**
 * 
 */
function validateLogin(){
  
  var e = document.getElementById("mail").value;
  var p = document.getElementById("id-password").value;
  
  var email = validationLoginEmail(e)
  var password = validationLoginPass(p);
  
  if(email == false || password == false){
    return false;
  }
}

function validationLoginPass(password){
  if(password == ""){
    document.getElementById("id-password").style.borderColor = "red";
    return false;
  }
  else{
    document.getElementById("id-password").style.borderColor = "#ccc";
    return true;
  }
}

function validationLoginEmail(email){
  if(email == ""){
    document.getElementById("mail").style.borderColor = "red";
    return false;
  }
  else if(email.includes("@unisa.it") || email.includes("@studenti.unisa.it")){
    document.getElementById("mail").style.borderColor = "#ccc";
    return true;
  }
  else{
    return false;
  }
}


//validazione registrazione
function test() {
	var radios = document.getElementsByName("tipo-utente");

	for (var i = 0; i < radios.length; i++) {       
		if (radios[1].checked) {
			document.getElementById('id_studio').style.display = "block"; 	
		}
		else if(radios[0].checked){
			document.getElementById('id_studio').style.display = "none";
		}
	}  
}

function validateRegistrazione(){
	var n = document.getElementById("id_nome").value;
	var c = document.getElementById("id_cognome").value;
	var m = document.getElementById("id_matricola").value;
	var e = document.getElementById("id_email").value;
	var p = document.getElementById("id_password").value;
	var r = document.getElementById("id_ripPassword").value;
	var s = document.getElementById("id_studio").value;

	var nome = validationNomeReg(n);
	var cognome = validationCognomeReg(c);
	var matricola = validationMatricolaReg(m);
	var email = validationEmailReg(e);
	var password = validationPasswordReg(p);
	var ripPassword = validationRipPasswordReg(r);
	var studio = validationStudioReg(s);
	var v = validateEmailReg(e);
	var match = matchPasswordReg(p,r);

	if(nome == false || cognome == false || matricola == false || email == false || password == false || ripPassword == false || v == false || match == false){
		return false;
	}
	else window.alert('Registrazione effettuata con successo!');
}

function validationNomeReg(nome){

	var letters = /^[a-zA-Z\s]+$/;

	if(nome == ''){
		document.getElementById("id_nome").style.borderColor = "red";
		return false;
	}
	else if (!nome.match(letters)){
		document.getElementById("errore").innerHTML = "Attenzione! Errore nella compilazion edei campi. Controlla che i campi siano corretti e che le due password siano uguali.";
		return false;
	}
	else{
		document.getElementById("id_nome").style.borderColor = "#ccc";
		return true;
	}

}

function validationCognomeReg(cognome){
	var letters = /^[a-zA-Z\s]+$/;

	if(cognome == ''){
		document.getElementById("id_cognome").style.borderColor = "red";
		return false;
	}
	else if(!cognome.match(letters)){
		document.getElementById("errore").innerHTML = "Attenzione! Errore nella compilazione dei campi. Controlla che i campi siano corretti e che le due password siano uguali.";
		return false;
	}
	else{
		document.getElementById("id_cognome").style.borderColor = "#ccc";
		return true;
	}
}

function validationMatricolaReg(matricola){
	var letters = /^\d{10}$/;

	if(matricola == ''){
		document.getElementById("id_matricola").style.borderColor = "red";
		return false;
	}
	else{
		if(!matricola.match(letters)){
			document.getElementById("errore").innerHTML = "Attenzione! Errore nella compilazione dei campi. Controlla che i campi siano corretti e che le due password siano uguali.";
			return false;
		}

		else{
			document.getElementById("id_matricola").style.borderColor = "#ccc";
			return true;
		}
	}
}

function validationEmailReg(email){
	var letters = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;

	if(email == ''){
		document.getElementById("id_email").style.borderColor = "red";
		return false;
	}
	else if (!email.match(letters)){
		document.getElementById("errore").innerHTML = "Attenzione! Errore nella compilazione dei campi. Controlla che i campi siano corretti e che le due password siano uguali.";
		return false;
	}
	else{
		document.getElementById("id_email").style.borderColor = "#ccc";

		return true;
	}
}

function validationPasswordReg(password){
	var letters = /^[a-zA-Z0-9\_\*\-\+\!\?\,\:\;\.\xE0\xE8\xE9\xF9\xF2\xEC\x27]{8,20}/;

	if(password == ''){
		document.getElementById("id_password").style.borderColor = "red";
		return false;
	}
	else if (!password.match(letters)){
		document.getElementById("errore").innerHTML = "Attenzione! Errore nella compilazione dei campi. Controlla che i campi siano corretti e che le due password siano uguali.";
		return false;
	}
	else{
		document.getElementById("id_password").style.borderColor = "#ccc";
		return true;
		
	}
}

function validationRipPasswordReg(ripPassword){

	var letters = /^[a-zA-Z0-9\_\*\-\+\!\?\,\:\;\.\xE0\xE8\xE9\xF9\xF2\xEC\x27]{8,20}/;

	if(ripPassword == ''){
		document.getElementById("id_ripPassword").style.borderColor = "red";
		return false;
	}
	else if (!ripPassword.match(letters)){
		document.getElementById("errore").innerHTML = "Attenzione! Errore nella compilazione dei campi. Controlla che i campi siano corretti e che le due password siano uguali.";
		return false;
	}
	else{
		document.getElementById("id_ripPassword").style.borderColor = "#ccc";
		return true;
	}
}

function validationStudioReg(studio){

	var letters = /^[A-Z0-9\\'\\s{0,4}]+$/;

	if(studio == ''){
		document.getElementById("id_studio").style.borderColor = "red";
		return false;
	}
	else if (!studio.match(letters)){
		document.getElementById("errore").innerHTML = "Attenzione! Errore nella compilazione dei campi. Controlla che i campi siano corretti e che le due password siano uguali.";
		return false;
	}
	else{
		document.getElementById("id_studio").style.borderColor = "#ccc";
		return true;
	}
}

function matchPasswordReg(p,r){
	if(p == r){
		return true;
	}
	else if(p != r){
		document.getElementById("errore").innerHTML = " Attenzione! Errore nella compilazione dei campi. Controlla che i campi siano corretti e che le due password siano uguali.";
		return false;
	}
}

function validateEmailReg(email) {	

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

//validazione Assenza

function getAnno(){
	var data = new Date();
	var a = data.getYear();
	var anno = a + 1900;
	document.getElementById("anno").innerHTML = '<option> Anno </option>' + '<option value="'+a+'">'+ anno + '</option>' + '<option value="'+(a+1)+'">'+ (anno + 1) + '</option>'+ '<option value="'+(a+2)+'">'+ (anno+2) +'</option>';
}

function validateAssenza(){
	var opzioneGiorno = document.getElementById("giorno").value;
	var opzioneMese = document.getElementById("mese").value;
	var opzioneAnno = document.getElementById("anno").value;
	var opzioneMessaggio = document.getElementById("messaggio").value;

	var sceltaGiorno = validationGiorno(opzioneGiorno);
	var sceltaMese = validationMese(opzioneMese);
	var sceltaAnno = validationAnno(opzioneAnno);
	var r = controllaGiorno(opzioneGiorno, opzioneMese, opzioneAnno);
	var o = validateOra();
	var m = validationMessaggio(opzioneMessaggio);
	
	if(sceltaGiorno == false || sceltaMese == false || sceltaAnno == false || r == false || o == false || m == false){
		return false;
	}
}

function validationGiorno(opzioneGiorno){
	if(opzioneGiorno == 'giorno'){	
		document.getElementById("giorno").style.borderColor = "red";
		return false;
	}
	else{
		document.getElementById("giorno").style.borderColor = "#ccc";
		return true;
	}
}

function validationMese(opzioneMese){
	if(opzioneMese == 'mese'){
		document.getElementById("mese").style.borderColor = "red";
		return false;
	}
	else{
		document.getElementById("mese").style.borderColor = "#ccc";
		return true;
	}
}

function validationAnno(opzioneAnno){
	if(opzioneAnno == 'Anno'){
		document.getElementById("anno").style.borderColor = "red";
		return false;
	}
	else{
		document.getElementById("anno").style.borderColor = "#ccc";
		return true;
	}
}

function validationMessaggio(opzioneMessaggio){
	if(opzioneMessaggio == ''){
		document.getElementById("messaggio").style.borderColor = "red";
		return false;
	}
	else{
		document.getElementById("messaggio").style.borderColor = "#ccc";
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

	if(opzioneMese == 3 || opzioneMese == 5 || opzioneMese == 8 || opzioneMese == 10){
		if(opzioneGiorno == 31)
			alert ("Errore il mese e' di 30 giorni.");
		return false;
	}
	else if(opzioneMese == 1 && !bisestile ) {		
		if(opzioneGiorno == 30 || opzioneGiorno == 31 || opzioneGiorno == 29)		
			alert("Errore il mese e' di 28 giorni.");
		return false;
	}
	else if(opzioneMese == 1 && bisestile) {		
		if(opzioneGiorno == 30 || opzioneGiorno == 31 )
			alert ("Errore il mese e' di 29 giorni.");
		return false;
	}
	else if(opzioneMese == 0 || opzioneMese == 2 || opzioneMese == 4 || opzioneMese == 6 || opzioneMese == 7 || opzioneMese == 9 || opzioneMese == 11){
		if(opzioneGiorno == 31)
		return true;
	}
}

/*validazione orario*/
function validateOra(){
	var opzioneDalle = document.getElementById("ora-dalle").value;
	var opzioneAlle = document.getElementById("ora-alle").value;

	var str = opzioneDalle.split(":");
	var str1 = opzioneAlle.split(":");

	var scelta1 = parseInt(str[0],10) + parseInt(str[1],10)/60;
	var scelta2 = parseInt(str1[0],10) + parseInt(str1[1],10)/60;
	var Ora = validationOra(scelta1, scelta2);

	var dalle = controllaDalle(opzioneDalle);
	var alle = controllaAlle(opzioneAlle);

	if(Ora == false || dalle == false || alle == false){
		return false;
	}
}

function validationOra(scelta1, scelta2){	

	if(scelta1 >= scelta2){
		document.getElementById("ora-alle").style.borderColor = "#ccc";
		document.getElementById("ora-dalle").style.borderColor = "#ccc";
		return false;
	}
	else if (scelta1 < scelta2) {
		document.getElementById("ora-alle").style.borderColor = "#ccc";
		document.getElementById("ora-dalle").style.borderColor = "#ccc";
		return true;
	}

}

function controllaDalle(opzioneDalle){
	if(opzioneDalle == 'dalle'){
		document.getElementById("ora-dalle").style.borderColor = "red";
		return true;
	}
	else
		document.getElementById("ora-dalle").style.borderColor = "#ccc";
	return true;	
}
function controllaAlle(opzioneAlle){	
	if(opzioneAlle == 'alle'){
		document.getElementById("ora-alle").style.borderColor = "red";
		return false;
	}	
	else
		document.getElementById("ora-alle").style.borderColor = "#ccc";
	return true;
}

//script validazione Orario di ricevimento

function validationRicevimento(){
  var g = validateGiorno();
  var i = validationInput();
  var o = validateOra();
  
  if( g == false || i == false || o == false){
    return false;
  }
}

function validateGiorno(){
  var opzioneGiorno = document.getElementById("giorno").value;

  if(opzioneGiorno == 'Giorno'){  
    document.getElementById("giorno").style.borderColor = "red";
    return false;
  }
  else{
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
    document.getElementById("tesi").style.borderColor = "#ccc";
    return true;
  }
  else{
	  document.getElementById("tesi").style.borderColor = "red";
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
    document.getElementById("info").style.borderColor = "#ccc";
    return true;
  }
  else{
	  document.getElementById("tesi").style.borderColor = "red";
	  return false;
  }
}

function validateProbl(opzioneProbl){

  var letters = /^([0-6]{1}[0-9]{1})$/;

  if(opzioneProbl == ''){
    document.getElementById("probl").style.borderColor = "red";
    return false;
  }

  else if(opzioneProbl.match(letters) ){
    document.getElementById("probl").style.borderColor = "#ccc";
    return true;
  }
  else{
	  document.getElementById("tesi").style.borderColor = "red";
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
    document.getElementById("altro").style.borderColor = "#ccc";
    return true;
  }
  else{
	  document.getElementById("tesi").style.borderColor = "red";
	  return false;
  }
}

//script validazione effettua prenotazione
function validatePrenotazione(){
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
		document.getElementById("corso").style.borderColor = "red";
		return false;
	}
	else{
		document.getElementById("corso").style.borderColor = "#ccc";
		return true;
	}
}

function validationTipologia(opzioneTipologia){
	if(opzioneTipologia == 'tipologia'){
		document.getElementById("tipologia").style.borderColor = "red";
		return false;
	}
	else{
		document.getElementById("tipologia").style.borderColor = "#ccc";
		return true;
	}
}

function validationData(){
	if($('#datepicker').val() == ''){
		document.getElementById("datepicker").style.borderColor = "red";
		return false;
	}
	else{
		document.getElementById("datepicker").style.borderColor = "#ccc";		
		return true;
	}
}
//script aggiungi preferiti
var boolean = true;
function addPreferiti(){
	
	boolean = !boolean
	if(boolean){
		document.getElementById("prefers").innerHTML = "<input type='image' alt='' class='preferiti' onclick='addPreferiti();' src='bootstrap/images/!preferiti.png'>";
	}
	if(boolean == false){
		document.getElementById("prefers").innerHTML = "<input type='image' alt='' class='preferiti' onclick='addPreferiti();' src='bootstrap/images/preferiti.png'>";
	}
}

//validazione Account
function validateModificheDocente(){
	var n = document.getElementById("id-nome").value;
	var c = document.getElementById("id-cognome").value;
	var s = document.getElementById("id-studio").value;
	var p = document.getElementById("VecchiaPassword").value;
	var np = document.getElementById("NuovaPassword").value;

	var nome = validationNome(n);
	var cognome = validationCognome(c);
	var password = validationVecchiaPassword(p);
	var nuovaPassword = validationNuovaPassword(np);
	var studio = validationStudio(s);


	if(nome == false || cognome == false || password == false || nuovaPassword == false || studio == false ){
		return false;
	}
	else return true;
}

function validationNome(nome){
	var letters = /^[a-zA-Z\s]+$/;

	if(nome == ''){
		document.getElementById("id-nome").style.borderColor = "red";
		return false;
	}
	else if(!nome.match(letters)){
		document.getElementById("erroreModifiche").innerHTML = 'Attenzione! Errore nella compilazione dei campi.';
		return false;
	}
	else{
		document.getElementById("id-nome").style.borderColor = "#ccc";
		return true;
	}
}


function validationCognome(cognome){
	var letters = /^[a-zA-Z\s]+$/;

	if(cognome == ''){
		document.getElementById("id-cognome").style.borderColor = "red";
		return false;
	}
	else if(!cognome.match(letters)){
		document.getElementById("erroreModifiche").innerHTML = 'Attenzione! Errore nella compilazione dei campi.';
		return false;
	}
	else{
		document.getElementById("id-cognome").style.borderColor = "#ccc";
		return true;
	}
}

function validationMatricola(matricola){
	var letters = /^\d{10}$/;

	if(matricola == ''){
		document.getElementById("id-matricola").style.borderColor = "red";
		return false;
	}
	else{
		if(!matricola.match(letters)){
			document.getElementById("erroreModifiche").innerHTML = 'Attenzione! Errore nella compilazione dei campi.';
			return false;
		}

		else{
			document.getElementById("id-matricola").style.borderColor = "#ccc";
			return true;
		}
	}
}

function validationStudio(studio){

	var letters = /^[A-Z0-9\\'\\s{0,4}]+$/;

	if(studio == ''){
		document.getElementById("id-studio").style.borderColor = "red";
		return false;
	}
	else if (!studio.match(letters)){
		document.getElementById("erroreModifiche").innerHTML = 'Attenzione! Errore nella compilazione dei campi.';
		return false;
	}
	else{
		document.getElementById("id-studio").style.borderColor = "#ccc";
		return true;
	}
}

function validationVecchiaPassword(password){
	var letters = /^[a-zA-Z0-9\_\*\-\+\!\?\,\:\;\.\xE0\xE8\xE9\xF9\xF2\xEC\x27]{8,20}/;

	if(password == ''){
		document.getElementById("VecchiaPassword").style.borderColor = "red";
		return false;
	}
	else if (!password.match(letters)){
		document.getElementById("erroreModifiche").innerHTML = 'Attenzione! Errore nella compilazione dei campi.';
		return false;
	}
	else{
		document.getElementById("VecchiaPassword").style.borderColor = "#ccc";
		return true;
	}
}

function validationNuovaPassword(nuovaPassword){
	var letters = /^[a-zA-Z0-9\_\*\-\+\!\?\,\:\;\.\xE0\xE8\xE9\xF9\xF2\xEC\x27]{8,20}/;

	if(nuovaPassword == ''){
		document.getElementById("NuovaPassword").style.borderColor = "red";
		return false;
	}
	else if (!nuovaPassword.match(letters)){
		document.getElementById("erroreModifiche").innerHTML = 'Attenzione! Errore nella compilazione dei campi.';
		return false;
	}
	else{
		document.getElementById("NuovaPassword").style.borderColor = "#ccc";
		return true;
	}
}
/*validazione modifiche account studente*/
function validateModificheStudente(){
	
	var n = document.getElementById("id-nome").value;
	var c = document.getElementById("id-cognome").value;
	var m = document.getElementById("id-matricola").value;
	var p = document.getElementById("VecchiaPassword").value;
	var np = document.getElementById("NuovaPassword").value;

	var nome = validationNome(n);
	var cognome = validationCognome(c);
	var matricola = validationMatricola(m);
	var password = validationVecchiaPassword(p);
	var nuovaPassword = validationNuovaPassword(np);

	if(nome == false || cognome == false || matricola == false ||  password == false || nuovaPassword == false ){
		return false;
	}
	else return true;
}