<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="safemeeting.model.*"%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <html>
 
 <head>
 
     <meta charset="utf-8">
     <meta http-equiv="X-UA-Compatible" content="IE=edge">
     <meta name="viewport" content="width=device-width, initial-scale=1">
 
     <title>Visualizza dati</title>
 
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
         
         <br>
         	<div class="col-lg-12">
         		<h1 class="page-header" align="center" class="lead">I tuoi dati personali</h1>
         	</div>
 	            <div class="container-fluid">
 					<table align="center" >
 					<tr>
 						<td valign="top">
 							<img id="foto-docente" src="bootstrap/images/<%=db.getImmagine()%>"> 					
 						</td>
 					<td><font color="white"> ------  </font></td> <%-- per separare un po' le celle, alternativa a cellspacing che non funzionava --%>
 					<td>	
 						<table class="table" id="table-pref">
                          <tr>
                              <th>Nome</th>
                            <th><%=db.getNome()%></th>
                          </tr>
                          <tr>
                              <th>Cognome</th>
                            <th><%=db.getCognome() %></th> 
                          </tr>
                          <tr>
                              <th>Email</th>
                            <th><%=db.getEmail() %></th> 
                          </tr>
                          <tr>
                              <th>Studio</th>
                              <th><%=db.getStudio() %></th>
                          </tr>
                          <tr>
                              <th> </th>
                              <th> </th>
                          </tr>
                     </table>
 					</td>
 					</tr> 					
 					</table>
 					<br>
 	            	<a href="#">
 						<form method="POST" action="ServletAccount" style="background-color:transparent;">
 							<input type="hidden" name="flag1" value="modificaDoc">
 	            			<p align="center"><button type="submit" class="btn btn-default">Modifica dati</button></p>
		                </form>
		            </a>
 	            	<br><br><br>
 	            	<a href="#">
 						<form method="POST" action="ServletAccount" style="background-color:transparent;">
 							<input type="hidden" name="flag1" value="eliminaDoc">
 	            			<p align="right"><button type="submit" class="btn btn-default">Elimina Account</button></p>
 	            		</form>
		            </a>
 	            </div>
 	    </div>
 	<!-- /#wrapper -->
 
 		<% 
		            	String delete = (String) request.getAttribute("delete");
		            	if(delete != null)
		            	{ %>
		            		<script>
		            			alert('Account eliminato con successo!');
		            		</script>
		            	<%} 
		            %>
		            
		            <% 
		            	String success = (String) request.getAttribute("success");
		            	if(success != null)
		            	{ %>
		            		<script>
		            			alert('Modifica effettuata con successo.');
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