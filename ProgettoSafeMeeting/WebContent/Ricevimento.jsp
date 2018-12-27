<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Ricevimento</title>

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
	                	<img id="foto-docente" src="bootstrap/images/Abate.jpg">
	                	<p>Benvenuto </p> 
	                	<br>
	                	</li>
	               		<li>
	                    	<a href="#">I tuoi corsi</a> 
	                    </li>
	                    <li>	
	                       	<a href="#">Ricevimenti</a>
	                    </li>
	                    <li>   	   
	                       	<a href="#">Assenza</a>
	                    </li>   
	                    <li>	
	                       	<a href="#">Orario di ricevimento</a>
	                    </li>  
	            	</ul>	            	
	            	<br>
	            		<ul class="nav" id="side-menu"> 	
		                    <li>
		                      	<a href="#">Account</a>
		                      	<a href="#">Logout</a>
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
			    	<table>
			    		<tr>
			    			<td>
			    				<div id="scelta-giorno">
						        	<label  id ="seleiona-giorno">Seleziona Giorno</label>
						        		<select onblur="validateGiorno();" class="form-control" id="giorno">
						        			<option value ="giorno">Giorno</option>
						        			<option>Lunedi</option>
						        			<option>Martedi</option>
						        			<option>Mercoledi</option>
						        			<option>Giovedi</option>		        			
						        			<option>Venerdi</option>
						            	</select>
						       	</div>
					    	</td> 				    		
					     	<td id="spazio">
					     	</td>
					        <td>					        				        
						        <table>
						        	<tr>
						        		<td>						     
								      		<label>Seleziona durata</label>	
								      	</td>
						      		</tr>
						      		<tr>
						      			<td>
						      				<p>Tesi</p>	
						      			</td>	
						      			<td>
						      				<input id="input-seleziona-durata" class="form-control" placeholder="inserisci durata" type="text">	
						      			</td>
						      		</tr>
						      		<tr>
						      			<td>
							            	<p>Informazioni</p>
							            </td>
						      			<td>
						      				<input id="input-seleziona-durata" class="form-control" placeholder="inserisci durata" type="text">	
						      			</td>							            				 
						      		</tr>							           				 
									<tr>
										<td>
											<p>Problematiche corso</p>
										</td>
						      			<td>
						      				<input id="input-seleziona-durata" class="form-control" placeholder="inserisci durata" type="text">		
						      			</td>										
							       	</tr>
							       	<tr>
							       		<td>
											<p>Altro</p>	
						      			<td>
						      				<input id="input-seleziona-durata" class="form-control" placeholder="inserisci durata" type="text">								      																								       			
							       		</td>
							       	</tr>
						        </table>
				          	</td>				          	
				     	</tr>				            	
				        <tr>
				        	<td>
				        		<div>    	
					            	<label>Seleziona Orario</label>
						            	<input class="form-control" placeholder="Dalle" name="dalle" id="dalle" type="text" >
						            	<input class="form-control" placeholder="Alle" name="alle" id="alle" type="text">
						       	</div>
					      	</td>
					      	<td>
					      	</td>
					  	</tr>
					  	<tr>
					  		<td>
					  		</td>
					  		<td id="spazio">
					     	</td>
					  		<td>
					  			<div>
									<button onclick="validateOrario();" class="btn btn-default">Salva</button>
		            				<button class="btn btn-default">Annulla</button>
		            			</div>
					  		</td>
					  	</tr>			            
			        </table>
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