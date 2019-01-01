<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="safemeeting.model.*"%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <html>
 
 <head>
 
     <meta charset="utf-8">
     <meta http-equiv="X-UA-Compatible" content="IE=edge">
     <meta name="viewport" content="width=device-width, initial-scale=1">
 
     <title>Modifica dati</title>
 
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
	                	<%DocenteBean db = (DocenteBean) request.getSession().getAttribute("docbean"); %>
	                	<div align="center"><p style="font-size: 18px"> Benvenuto Professor/ssa <%=db.getCognome() %>! </p></div>  
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
         
         
         	<div class="col-lg-12">
         		<h1 class="page-header" align="center">I tuoi dati personali</h1>
         	</div>
 	            <div class="container-fluid">
 					<table align="center" >
 					<tr>
 					<td>
 					<img id="foto-docente" src="bootstrap/images/Abate.jpg">
 					<br> <p align="center"><button class="btn btn-default">Modifica foto</button></p>
 					
 					</td>
 					<td><font color="white"> ------  </font></td> <%-- per separare un po' le celle, alternativa a cellspacing che non funzionava --%>
 					<td>
 						<table>
 							<tr>
 								<td>
 								<h5 align="center">Nome:</h5>
 								</td>
 							</tr>
 							<tr>
 								<td>
 								<h5 align="center">Cognome:</h5>
 								</td>	
 							</tr>
 							<tr>
 								<td>
 								<h5 align="center">E-mail:</h5>
 								</td>	
 							</tr>
 							<tr>
 								<td>
 								<h5 align="center">Matricola:</h5>
 								</td>	
 							</tr>
 							<tr>
 								<td>
 								<h5 align="center">Studio:</h5>
 								</td>	
 							</tr>
 						</table>
 					</td>
 					<td>
 						<table>
 							<tr>
 								<td>
 								<input class="form-control" placeholder="Nome" type="text" id="NomeDoc">
 								</td>
 							</tr>
 							<tr>
 								<td>
 								<input class="form-control" placeholder="Cognome" type="text" id="CognomeDoc">
 								</td>	
 							</tr>
 							<tr>
 								<td>
 								<input class="form-control" placeholder="E-mail" type="text" id="EmailDoc">
 								</td>	
 							</tr>
 							<tr>
 								<td>
 								<input class="form-control" placeholder="Matricola" type="text" id="MatricolaDoc">
 								</td>	
 							</tr>
 							<tr>
 								<td>
 								<input class="form-control" placeholder="Studio" type="text" id="StudioDoc">
 								</td>	
 							</tr>
 						</table>
 					</td>
 					</tr> 					
 					</table>
 					<br>
 	            	<p align="center"><button class="btn btn-default">Modifica dati</button></p>
 	            	<br><br><br>
 	            	<p align="right"><button class="btn btn-default">Elimina Account</button></p>
 	            	
 	            </div>
 	    </div>
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