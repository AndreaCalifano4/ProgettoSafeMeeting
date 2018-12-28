<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SafeMeeting HomeDocente</title>

    <!-- Bootstrap Core CSS -->
    <link href="bootstrap/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="bootstrap/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="bootstrap/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="bootstrap/vendor/morrisjs/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="bootstrap/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    
    <!-- CSS Calendario -->
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  	<link rel="stylesheet" href="/resources/demos/style.css">

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
	 		   	<a href="index.html"><img id = "logo" src="bootstrap/images/logo.png"></a>	
	 		   	<h1 id="sm">SafeMeeting</h1> 		   		 		   	
	    	</div>
       	</nav>	       
            <!-- navbar --> 
            
            <div class="sidebar-nav navbar-collapse" aria-expanded="false" style="height: 1px;">		
	            <div class="navbar-default sidebar" role="navigation">
	            	<ul class="nav" id="side-menu">
	                	<li>
	                	<img id="foto-studente" src="bootstrap/images/User.jpg">
	                	<div align="center"><p style="font-size: 18px"> Benvenuto </p></div>
	                	<br>
	                	</li>
	               		<li>
	                    	<a href="#">Prenotazioni</a> 
	                    </li>
	                    <li>	
	                       	<a href="#">Preferiti</a>
	                    </li>
	            	</ul>
	            	<br><br><br><br><br><br><br>
	            		<ul class="nav" id="side-menu"> 	
		                    <li>
		                      	<a href="#">
		                      		<form method="POST" action="" style="background-color:transparent;">
		                      			<button type="submit" style="background-color:transparent;border-color:transparent;">
		                      				Account
		                      			</button>
		                      		</form>
		                      	</a>
								<a href="#">
		                      		<form method="POST" action="ServletLogout" style="background-color:transparent;">
		                      			<button type="submit" style="background-color:transparent;border-color:transparent;" onClick="alert('Logout effettuato con successo!')">
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
            <div class="container-fluid">
	            <div class="row">	            		 
	            </div>
	        <div class="form-group input-group">
	        	<input class="form-control" type="text" />
	        	<span class="input-group-btn">
	        		<button class="btn btn-default" type="button">
	        			<i class="fa fa-search"></i>
	        		</button>
	        	</span>
	        </div>   
	       	</div>
            <!-- /.row -->
            <div class="row"> 
            
            </div>
            <hr>
            <div>
	        	<img id="foto-docente-dettagli-prenotazione" src="bootstrap/images/Abate.jpg" style="float:left"> <!-- è una cafonata ma non mi funziona nel css -->
	        </div>
	        &nbsp; &nbsp; &nbsp; &nbsp;
	        <div>
	        	<p>	
	        	Nome Cognome<br>
	        	Corso
	        	</p>
	       	</div>
	       	<br><br>
	       	<div>
	       	<p>
	       	<h1 class="lead">Orario di ricevimento:</h1>
	       		<table class="table" id="table-pref">
  						<tr>
  							<th>Lunedì</th>
    						<th>12-13</th>
    						<th>Studio 48 Stecca F</th> 
  						</tr>
  						<tr>
  							<th>Mercoledì</th>
    						<th>15-16</th>
    						<th>Studio 48 Stecca F</th> 
  						</tr>
 					</table>
	       	</p>
	       	</div>
	       	<div>
	       		<table class="table" id="table-pref">
  						<tr>
  							<th id="calendario"><br> 
							 <input class="form-control" placeholder="Seleziona giorno" type="text" id="datepicker">

							</th>
    						<th><br><select class="form-control" id="corso">
								<option value="corso">Corso</option>
								<option value="1">Corso1</option>
								<option value="2">Corso2</option>
							</select></th>
							<th><br><select class="form-control" id="tipologia">
								<option value="tipologia">Tipologia</option>
								<option value="1">Tesi</option>
								<option value="2">Informazioni</option>
								<option value="3">Problematiche corso</option>
								<option value="4">Altro</option>
							</select></th>
    						<th><br></th> 
  						</tr>
  				</table>
  				<br><br>
	       		<button onclick="validateCorso();" class="btn btn-primary btn-lg" type="button">Completa</button>
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
    
    <!-- Script Calendario  -->
  	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script src="bootstrap/Jquery.js"></script>
		
    <!-- Script SafeMeeting -->
    <script src="bootstrap/Script.js"></script>

</body>

</html>