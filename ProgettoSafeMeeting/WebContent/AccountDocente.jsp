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
         
         
         	<div class="col-lg-12">
         		<h1 class="page-header" align="center">Modifica Account</h1>
         	</div>
 	            <div class="container-fluid">
 	            <form accept-charset="UTF-8" enctype="multipart/form-data" method="POST" action="ServletAccount" name="accountForm" style="background-color:transparent;">
 					<table align="center" >
 					<tr>
 					<td>
 						<img id="foto-docente" src="${pageContext.request.contextPath}/ImageProxyController?name=<%=db.getImmagine() %>">
 						<br><input type="file" name="file" id="file" class="inputfile" multiple="true" id="file">
						<label for="file" id="choosefile" style="background: url('img/photo.png') no-repeat center; background-size: 120px 100px;">
							<div id="image" style="overflow: hidden;"></div>
						</label>
 						<!--  <p align="center"><button class="btn btn-default">Modifica foto</button></p> -->
 					</td>
 					<td><font color="white"> ------  </font></td>
 					<td>
 						<table>
 							<tr>
 								<td>
 								<input class="form-control" placeholder="Nome" name="nome" type="text" id="id-nome" value="<%=db.getNome()%>">
 								</td>
 							</tr>
 							<tr>
 								<td>
 								<input class="form-control" placeholder="Cognome" name="cognome" type="text" id="id-cognome" value="<%=db.getCognome()%>">
 								</td>	
 							</tr>
 							<tr>
 								<td>
 								<input class="form-control" placeholder="Studio" name="studio" type="text" id="id-studio" value="<%=db.getStudio()%>">
 								</td>	
 							</tr>
 							<tr>
 								<td>
 								<input class="form-control" placeholder="Vecchia Password" name="oldPassword" type="password" id="VecchiaPassword" >
 								</td>	
 							</tr>
 							<tr>
 								<td>
 								<input class="form-control" placeholder="Nuova Password" name="newPassword" type="password" id="NuovaPassword">
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
 						<input type="hidden" name="flag1" value="salvaModificaDoc">
 						<input type="hidden" name="matricola" value="<%=db.getMatricolaDoc()%>">
 	            		<p align="center"><button type="submit" class="btn btn-default" onclick="return validateModificheDocente();">Salva modifiche</button></p>
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