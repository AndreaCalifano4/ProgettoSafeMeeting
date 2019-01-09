/**
 * 
 */
$( function() {

  $( "#datepicker" ).datepicker({
  closeText: 'Chiudi',
  prevText: 'Prec',
  nextText: 'Succ',
  currentText: 'Oggi',
  monthNames: ['Gennaio','Febbraio','Marzo','Aprile','Maggio','Giugno', 'Luglio','Agosto','Settembre','Ottobre','Novembre','Dicembre'],
  monthNamesShort: ['Gen','Feb','Mar','Apr','Mag','Giu', 'Lug','Ago','Set','Ott','Nov','Dic'],
  dayNames: ['Domenica','Lunedì','Martedì','Mercoledì','Giovedì','Venerdì','Sabato'],
  dayNamesShort: ['Dom','Lun','Mar','Mer','Gio','Ven','Sab'],
  dayNamesMin: ['Do','Lu','Ma','Me','Gio','Ve','Sa'],
  dateFormat: 'dd/mm/yy', 
  firstDay: 1,
  minDate: +0,
  isRTL: false
  }) ;
  $.datepicker.setDefaults($.datepicker.regional['it']);
} );

function convertiData(data){
	
	/*	
	var dateTypeVar = $('#datepicker').datepicker('getDate');
	var d = $.datepicker.formatDate('DD', dateTypeVar);

	if(d == "Monday"){
		d = "Lunedì";
	}
	if(d == "Tuesday"){
		d = "Martedì";
	}
	if(d == "Wednesday"){
		d = "Mercoledì";
	}
	if(d == "Thursday"){
		d = "Giovedì";	
	}
	if(d == "Friday"){
		d = "Venerdì";		
	}
	if(d == "Saturday"){
		return false;
	}
	if(d == "Sunday"){
		return false;
	}
	
	if(d == data){
		return true;
	}
	else {
		document.getElementById("datepicker").style.borderColor = "red";
		return false;
	}

*/
}