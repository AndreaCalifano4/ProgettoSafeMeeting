<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="safemeeting.model.*"%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <html>
 
 <head>
 
     <meta charset="utf-8">
     <meta http-equiv="X-UA-Compatible" content="IE=edge">
     <meta name="viewport" content="width=device-width, initial-scale=1">
 
     <title>Modifica account</title>
 
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
	 		   	<a href="HomeStudente.jsp"><img id = "logo" src="bootstrap/images/logo.png"></a>	
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
							StudenteBean sb = (StudenteBean) ssn.getAttribute("studbean");
							if (sb == null) {

								response.sendRedirect("Login.jsp");

							}
							else{
						%>
						<div align="center"><p style="font-size: 25px"> Benvenuto <%=sb.getNome() %><%} %>! </p></div>
	                	<br>
	                	</li>
		                    <li>
		                    	<a href="#">
		                      		<form method="POST" action="ServletStampaPrenotazioni" style="background-color:transparent;">
		                      			<button type="submit" style="background-color:transparent;border-color:transparent; width:100%; height:100%;">
		                      				Prenotazioni
		                      			</button>
		                      		</form>
		               			</a>
		                     </li>
	                    <li>	
	                       	<a href="#">
		                      		<form method="POST" action="ServletPreferiti" style="background-color:transparent;">
		                      		<input type="hidden" name="flag" value="preferiti">
		                      			<button type="submit" style="background-color:transparent;border-color:transparent; width:100%; height:100%;">
		                      				Preferiti
		                      			</button>
		                      		</form>
		                      	</a>
	                    </li>
	            	</ul>
	            	<br><br><br><br><br><br><br>
	            		<ul class="nav" id="side-menu"> 	
		                    <li>
		                      	<a href="#">
		                      		<form method="POST" action="VisualizzaDatiStudente.jsp" style="background-color:transparent;">
		                      		<input type="hidden" name="flag" value="visualizza">
		                      			<button type="submit" style="background-color:transparent;border-color:transparent; width:100%; height:100%;">
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
         
         
         	<div class="col-lg-12">
         		<h1 class="page-header" align="center">Modifica Account</h1>
         	</div>
 	            <div class="container-fluid">
 	            <form method="POST" action="ServletAccount" name="accountForm" style="background-color:transparent;">
 					<table align="center" >
 					<tr>
 					<td><font color="white"> ------  </font></td>
 					<td>
 						<table>
 							<tr>
 								<td>
 									<input type="text" class="form-control" placeholder="Nome" name="nome" id="id-nome" value="<%=sb.getNome()%>">
 								</td>
 							</tr>
 							<tr>
 								<td>
 									<input type="text" class="form-control" placeholder="Cognome" name="cognome" id="id-cognome" value="<%=sb.getCognome()%>">
 								</td>	
 							</tr>
 							<tr>
 								<td>
 									<input type="text" class="form-control" placeholder="Matricola" name="matricola" id="id-matricola" value="<%=sb.getMatricolaStud()%>">
 								</td>	
 							</tr>
 							<tr>
 								<td>
 								<input type="password" class="form-control" placeholder="Vecchia Password" name="oldPassword" id="VecchiaPassword" >
 								</td>	
 							</tr>
 							<tr>
 								<td>
 								<input type="password" class="form-control" placeholder="Nuova Password" name="newPassword" id="NuovaPassword">
 								</td>	
 							</tr>
 						</table>
 					</td>
 					</tr> 					
 					</table>
 					<br><br>
                    <p id="erroreModifiche"></p>
                    <br>
 					<a href="#">
 						<input type="hidden" name="flag" value="salvaModifica">
 	            		<p align="center"><button type="submit" class="btn btn-default"  onclick="return validateModificheStudente();">Salva modifiche</button></p>
		            </a>
		            </form>
 	            </div>
 	    </div>
 	<!-- /#wrapper -->
 	
 	 				<% 
		            	String error = (String) request.getAttribute("error");
		            	if(error != null)
		            	{ %>
		            		<script>
		            			alert('Attenzione! Errore nella compilazione dei campi.');
		            		</script>
		            	<%} 
		           	 %>
 
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