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

/*function validate(){
	var n = document.getElementById("nome").value;
	var c = document.getElementById("cognome").value;
	var m = document.getElementById("email").value;
	var p = document.getElementById("password").value;
	
	var nome = validationName(n);
	var cognome = validationName(c);
	var matricola = validationMatricola(m);
	var password = validationPassword(p);
	var email = validationEmail(e);
	
	if(nome == false || email == false || cognome == false || matricola == false || password == false || email == false){
		return false;
	}
}	*/
	
function validationName(){
	var nome = document.getElementById("nome").value;
	var letters = /^[a-zA-Z\s]+$/;
			
	if(nome == ''){
		document.getElementById("nome").style.borderColor = "red";
		return false;
	}
	else if (!nome.match(letters)){
		document.getElementById("errore").innerHTML = "formato non valido";
		return false;
	}
	else{
		return true;
	}

}

function validationCognome(){
	var cognome = document.getElementById("nome").value;
	var letters = /^[a-zA-Z\s]+$/;
			
	if(cognome == ''){
		document.getElementById("cognome").style.borderColor = "red";
		return false;
	}
	else if (!cognome.match(letters)){
		document.getElementById("cognome").style.borderColor = "blue";
		return false;
	}
	else{
		return true;
	}
}

function validationMatricola(){
	var matricola = document.getElementById("matricola").value;
	var letters = /^\d{5}$/;
			
	if(matricola == ''){
		document.getElementById("matricola").style.borderColor = "red";
		return false;
	}
	else if (!matricola.match(letters)){
		document.getElementById("matricola").style.borderColor = "blue";
		return false;
	}
	else{
		return true;
	}
}

function validationEmail(){
	var email = document.getElementById("email").value;
	var letters = /^\d{5}$/;
			
	if(email == ''){
		document.getElementById("email").style.borderColor = "red";
		return false;
	}
	else if (!email.match(letters)){
		document.getElementById("email").style.borderColor = "blue";
		return false;
	}
	else{
		return true;
	}
}

function validationPassword(){
	var password = document.getElementById("password").value;
	var letters = /^\d{5}$/;
			
	if(password == ''){
		document.getElementById("password").style.borderColor = "red";
		return false;
	}
	else if (!matricola.match(letters)){
		document.getElementById("password").style.borderColor = "blue";
		return false;
	}
	else{
		return true;
	}
}