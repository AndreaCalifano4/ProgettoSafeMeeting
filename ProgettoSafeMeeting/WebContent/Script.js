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
	var s = document.getElementById("studio").value
	
	var nome = validationNome(n);
	var cognome = validationCognome(c);
	var matricola = validationMatricola(m);
	var email = validationEmail(e);
	var password = validationPassword(p);
	var ripPassword = validationRipPassword(r)
	var studio = validationStudio(s);
	var v = validateEmail(e);
	var match = matchPassword(p,r);
	if(nome == false || cognome == false || matricola == false || email == false || password == false || studio == false || ripPassword == false || v == false || match == false){
		return false;
	}
	
}

function validationNome(nome){
	
	var letters = /^[a-zA-Z\s]+$/;
			
	if(nome == ''){
		document.getElementById("nome").style.borderColor = "red";
		return false;
	}
	else if (!nome.match(letters)){
		document.getElementById("errore").innerHTML = "Attenzione! Errore nella compilazionedei campi. Controlla che i campi siano corretti e che le due password siano uguali.";
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
	else if (!cognome.match(letters)){
		document.getElementById("errore").innerHTML = "Attenzione! Errore nella compilazionedei campi. Controlla che i campi siano corretti e che le due password siano uguali.";
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
		if (!matricola.match(letters)){
			document.getElementById("errore").innerHTML = "Attenzione! Errore nella compilazionedei campi. Controlla che i campi siano corretti e che le due password siano uguali.";
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
		document.getElementById("errore").innerHTML = "Attenzione! Errore nella compilazionedei campi. Controlla che i campi siano corretti e che le due password siano uguali.";
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
		document.getElementById("errore").innerHTML = "Attenzione! Errore nella compilazionedei campi. Controlla che i campi siano corretti e che le due password siano uguali.";
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
		document.getElementById("errore").innerHTML = "Attenzione! Errore nella compilazionedei campi. Controlla che i campi siano corretti e che le due password siano uguali.";
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
		document.getElementById("errore").innerHTML = "Attenzione! Errore nella compilazionedei campi. Controlla che i campi siano corretti e che le due password siano uguali.";
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
		document.getElementById("errore").innerHTML = " Attenzione! Errore nella compilazionedei campi. Controlla che i campi siano corretti e che le due password siano uguali.";
		return false
	}
}

function validateEmail(email) {	
	
	var radio = document.getElementsByName("tipo-utente");
	
	if(radio[0].checked){
		  if(email.includes("@studenti.unisa.it"))
			  return true;
		  else{
			  document.getElementById("errore").innerHTML = " Attenzione! Errore nella compilazionedei campi. Controlla che i campi siano corretti e che le due password siano uguali.";
			  return false;
		  }
	}
		  if(radio[1].checked){
			  if(email.includes("@unisa.it"))
			  return true;
		  else { 
			  document.getElementById("errore").innerHTML = " Attenzione! Errore nella compilazionedei campi. Controlla che i campi siano corretti e che le due password siano uguali.";
			  return false;
		  }
			  
	   }
		  
		if(!radio[0].checked && !radio[1].checked){
			document.getElementById("errore").innerHTML = " Attenzione indicare se sei uno studente o un docente.";
			return false;
		}   	
}
