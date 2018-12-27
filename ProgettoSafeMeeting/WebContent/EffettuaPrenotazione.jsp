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
  							<th><br></th>
    						<th><br><div class="dropdown">
  								<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
   								Scegli Corso
    							<span class="caret"></span>
  								</button>
  								<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
    								<li><a href="#">Corso1</a></li>
    								<li><a href="#">Corso2</a></li>
  								</ul>
							</div></th>
							<th><br><div class="dropdown">
  								<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
   								Scegli Tipologia
    							<span class="caret"></span>
  								</button>
  								<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
    								<li><a href="#">Tesi</a></li>
    								<li><a href="#">Informazioni</a></li>
    								<li><a href="#">Problematiche corso</a></li>
    								<li><a href="#">Altro</a></li>
  								</ul>
							</div></th>
    						<th><br></th> 
  						</tr>
  				</table>
	       	
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