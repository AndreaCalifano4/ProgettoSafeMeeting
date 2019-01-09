<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*"
	import="safemeeting.model.*"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Ricevimento</title>

<!-- Bootstrap Core CSS -->
<link href="bootstrap/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="bootstrap/vendor/metisMenu/metisMenu.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="bootstrap/dist/css/sb-admin-2.css" rel="stylesheet">

<!-- Morris Charts CSS -->
<link href="bootstrap/vendor/morrisjs/morris.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="bootstrap/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<!-- SafeMeeting CSS -->
<link href="bootstrap/SafeMeeting.css" rel="stylesheet" type="text/css">

</head>

<body>

	<div id="wrapper">
    <!-- header -->
    	<nav class="navbar navbar-default navbar-static-top">
    		    <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".navbar-collapse">
			    	<span class="sr-only">toggle navigation</span>
			    	<span class="icon-bar"></span>
			    	<span class="icon-bar"></span>
			    	<span class="icon-bar"></span>
    			</button>
	    	<div class="navbar-brand">
	 		   	<a href="HomeDocente.jsp"><img id = "logo" src="bootstrap/images/logo.png"></a>	
	 		   	<h1 id="sm">SafeMeeting</h1> 		   		 		   	
	    	</div>
       	</nav>	       
            <!-- navbar --> 
            
            <div class="sidebar-nav navbar-collapse" aria-expanded="false" style="height: 1px;">		
	            <div class="navbar-default sidebar" role="navigation">
	            	<ul class="nav" id="side-menu">
	                	<li>
	                	<%
							HttpSession ssn = request.getSession();
							DocenteBean db = (DocenteBean) ssn.getAttribute("docbean");
							if (db == null) {

								response.sendRedirect("Login.jsp");

							}
							else{
						%>
	                	<div align="center">
	                		<img id="foto-docente" src="${pageContext.request.contextPath}/ImageProxyController?name=<%=db.getImmagine() %>">
	                	</div>
	                	<div align="center"><p style="font-size: 18px"> Benvenuto Professor/ssa <%=db.getCognome() %>!<%} %> </p></div>
	                	<br>
	                	</li>
	               		<li>
	               			<a href="#">
		                      		<form method="POST" action="ServletVisualizzaCorsi" style="background-color:transparent;">
		                      			<button type="submit" style="background-color:transparent;border-color:transparent; width:100%; height:100%;">
		                      				I tuoi Corsi
		                      			</button>
		                      		</form>
		               		</a>
	                    </li>
	                    <li>	
	                       	<a href="#">
		                      		<form method="POST" action="ServletListaPrenotatiDoc" style="background-color:transparent;">
		                      			<button type="submit" style="background-color:transparent;border-color:transparent; width:100%; height:100%;">
		                      				Lista Prenotazioni
		                      			</button>
		                      		</form>
		               		</a>
	                    </li>
	                    <li>   	   
	                    	<a href="#">
		                      		<form method="POST" action="Assenza.jsp" style="background-color:transparent;">
		                      			<button type="submit" style="background-color:transparent;border-color:transparent; width:100%; height:100%;">
		                      				Assenza
		                      			</button>
		                      		</form>
		               		</a>
	                    </li>   
	                    <li>	
	                       	<a href="#">
		                      		<form method="POST" action="ServletStampaRicevimenti" style="background-color:transparent;">
		                      			<button type="submit" style="background-color:transparent;border-color:transparent; width:100%; height:100%;">
		                      				Orari di ricevimento
		                      			</button>
		                      		</form>
		               		</a>
	                    </li>  
	            	</ul>	            	
	            	<br>
	            		<ul class="nav" id="side-menu"> 	
		                    <li>
		                      	<a href="#">
		                      		<form method="POST" action="VisualizzaDatiDocente.jsp" style="background-color:transparent;">
		                      			<input type="hidden" name="flag1" value="visualizzaDoc">            			
		                      			<button type="submit" style="background-color:transparent;border-color:transparent;width:100%; height:100%;">
		                      				Account
		                      			</button>
		                      		</form>
		                      	</a>
		                     </li>
		                     <li>
								<a href="#">
		                      		<form method="POST" action="ServletLogout" style="background-color:transparent;">
		                      			<button type="submit" style="background-color:transparent;border-color:transparent; width:100%; height:100%;" onClick="alert('Logout effettuato con successo!')">
		                      				Logout
		                      			</button>
		                      		</form>
		                      	</a>
							</li>
						</ul>
	            </div>			           
			</div>		              
                <!-- /.sidebar-collapse -->
	</div>								
            <!-- /.navbar-static-side -->

	<div id="page-wrapper">
		<br>
		<div class="col-lg-12">
			<h1 class="page-header">Il tuo ricevimento</h1>
		</div>
		<div class="container-fluid">
			<div class="form-group">
				<form method="POST" action="ServletAggiungiOrario" onsubmit="return validationRicevimento();">
					<div id="scelta-giorno">
						<label id="seleiona-giorno">Seleziona Giorno</label> 
						<select class="form-control"
							name="scelta-giorno" id="giorno">
							<option value="Giorno">Giorno</option>
							<option value="Lunedì">Lunedì</option>
							<option value="Martedì">Martedì</option>
							<option value="Mercoledì">Mercoledì</option>
							<option value="Giovedì">Giovedì</option>
							<option value="Venerdì">Venerdì</option>
						</select>


						<div id="seleziona-durata">
							<table>
								<tr>
									<td><label>Seleziona durata</label></td>
								</tr>
								<tr>
									<td>
										<p>Tesi</p>
									</td>
									<td><input id="tesi" name="tempo-tesi"
										class="form-control" placeholder="inserisci durata in minuti"
										type="text"> <input type="hidden" value="Tesi"
										name="tesi"></td>
								</tr>
								<tr>
									<td>
										<p>Informazioni</p>
									</td>
									<td><input id="info" name="tempo-info"
										class="form-control" placeholder="inserisci durata in minuti"
										type="text"> <input type="hidden" value="Informazioni"
										name="info"></td>
								</tr>
								<tr>
									<td>
										<p>Problematiche corso</p>
									</td>
									<td><input id="probl"
										name="tempo-problem-Corso" class="form-control"
										placeholder="inserisci durata in minuti" type="text">
										<input type="hidden" value="Problematiche relative al corso"
										name="problem-Corso"></td>
								</tr>
								<tr>
									<td>
										<p>Altro</p>
									<td><input id="altro" name="tempo-altro"
										class="form-control" placeholder="inserisci durata in minuti"
										type="text"> <input type="hidden" value="Altro"
										name="altro"></td>
								</tr>
							</table>
						</div>

						<div id="seleziona-orario-dalle">
							<label>Seleziona Orario</label> <select class="form-control"
								name="dalle" id="ora-dalle">
								<option value="dalle">Dalle</option>
								<option value="09:00:00">09:00:00</option>
								<option value="09:30:00">09:30:00</option>
								<option value="10:00:00">10:00:00</option>
								<option value="10:30:00">10:30:00</option>
								<option value="11:00:00">11:00:00</option>
								<option value="11:30:00">11:30:00</option>
								<option value="12:00:00">12:00:00</option>
								<option value="12:30:00">12:30:00</option>
								<option value="13:00:00">13:00:00</option>
								<option value="13:30:00">13:30:00</option>
								<option value="14:00:00">14:00:00</option>
								<option value="14:30:00">14:30:00</option>
								<option value="15:00:00">15:00:00</option>
								<option value="15:30:00">15:30:00</option>
								<option value="16:00:00">16:00:00</option>
								<option value="16:30:00">16:30:00</option>
								<option value="17:00:00">17:00:00</option>
								<option value="17:30:00">17:30:00</option>
								<option value="18:00:00">18:00:00</option>
							</select>
						</div>
						<div id="seleziona-orario-alle">
							<select class="form-control" name="ora-alle" id="ora-alle">
								<option value="alle">Alle</option>
								<option value="09:00:00">09:00:00</option>
								<option value="09:30:00">09:30:00</option>
								<option value="10:00:00">10:00:00</option>
								<option value="10:30:00">10:30:00</option>
								<option value="11:00:00">11:00:00</option>
								<option value="11:30:00">11:30:00</option>
								<option value="12:00:00">12:00:00</option>
								<option value="12:30:00">12:30:00</option>
								<option value="13:00:00">13:00:00</option>
								<option value="13:30:00">13:30:00</option>
								<option value="14:00:00">14:00:00</option>
								<option value="14:30:00">14:30:00</option>
								<option value="15:00:00">15:00:00</option>
								<option value="15:30:00">15:30:00</option>
								<option value="16:00:00">16:00:00</option>
								<option value="16:30:00">16:30:00</option>
								<option value="17:00:00">17:00:00</option>
								<option value="17:30:00">17:30:00</option>
								<option value="18:00:00">18:00:00</option>
							</select>
						</div>

						<div id="btn-salva-annulla">
							<button type="submit" class="btn btn-default" onclick="validationRicevimento();">Salva</button>
							<button type="reset" class="btn btn-default">Annulla</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- /#page-wrapper -->

	<!-- /#wrapper -->

	<!-- jQuery -->
	<script src="bootstrap/vendor/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="bootstrap/vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="bootstrap/vendor/metisMenu/metisMenu.min.js"></script>

	<!-- Morris Charts JavaScript -->
	<script src="bootstrap/vendor/raphael/raphael.min.js"></script>
	<script src="bootstrap/vendor/morrisjs/morris.min.js"></script>
	<script src="bootstrap/data/morris-data.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="bootstrap/dist/js/sb-admin-2.js"></script>

	<!-- Script SafeMeeting -->
	<script src="bootstrap/Script.js"></script>

</body>

</html>