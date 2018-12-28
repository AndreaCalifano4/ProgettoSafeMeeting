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
		

