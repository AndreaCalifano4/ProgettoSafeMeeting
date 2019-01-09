<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="safemeeting.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Assenza</title>

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
        		<h1 class="page-header">Assenza</h1>
        	</div>
	            <div class="container-fluid">
	            	<div class="form-group">
	            	<br>
	            		<form method="POST" action="ServletAssenza" onsubmit="if(validateAssenza() == false) return false;">
	            		<div id="giorno-mese-anno">		            		
		            		<label >Indicare il giorno dell'assenza</label>
		            			<table>  
		            				<tr>  
		            					<td>      	
						            		<select onfocus="if(validateData()) == false{return false;}" name="giorno" class="form-control" id="giorno" >
						            			<option value="giorno">Giorno</option>
							            		<option>1</option>
							            		<option>2</option>
							            		<option>3</option>
							            		<option>4</option>
							            		<option>5</option>
							            		<option>6</option>
							            		<option>7</option>
							            		<option>8</option>
							            		<option>9</option>
							            		<option>10</option>
							            		<option>11</option>
							            		<option>12</option>
							            		<option>13</option>
							            		<option>14</option>
							            		<option>15</option>
							            		<option>17</option>
							            		<option>18</option>
							            		<option>19</option>
							            		<option>20</option>
							            		<option>21</option>
							            		<option>22</option>
							            		<option>23</option>
							            		<option>24</option>
							            		<option>25</option>
							            		<option>26</option>
							            		<option>27</option>
							            		<option>28</option>
							            		<option>29</option>
							            		<option>30</option>
							            		<option>31</option>
							            	</select> 
				            			</td>
				            			<td>				                     	
						            		<select class="form-control" name="mese" id="mese">
						            			<option value="mese">Mese</option>
							            		<option value="0">Gennaio</option>
							            		<option value="1">Febbraio</option>
							            		<option value="2">Marzo</option>
							            		<option value="3">Aprile</option>
							            		<option value="4">Maggio</option>
							            		<option value="5">Giugno</option>
							            		<option value="6">Luglio</option>
							            		<option value="7">Agosto</option>
							            		<option value="8">Settembre</option>
							            		<option value="9">Ottobre</option>
							            		<option value="10">Novembre</option>
							            		<option value="11">Dicembre</option>	            		
							            	</select>
				            			</td>
				            			<td>
							            	<select class="form-control" name="anno" id="anno" onfocus="getAnno();">
							            		<option>Anno</option>			            		
							            	</select>
				            			</td>
			            			</tr>
				            	</table>
				            </div>
				            	<br>
				            	
			            	<label>Indicare la fascia Oraria</label>
			            		<table>
			            			<tr>
			            				<td>
							            	<select class="form-control" name="dalle" id="ora-dalle">
							            		<option value="dalle">Dalle</option>
							            		<option>9:00:00</option>
							            		<option>9:30:00</option>
							          			<option>10:00:00</option>
							            		<option>10:30:00</option>    
							            		<option>11:00:00</option>
							            		<option>11:30:00</option>
							            		<option>12:00:00</option>
							            		<option>12:30:00</option>
							            		<option>13:00:00</option>
							            		<option>13:30:00</option>
							            		<option>14:00:00</option>
							            		<option>14:30:00</option>
							            		<option>15:00:00</option>
							            		<option>15:30:00</option>
							            		<option>16:00:00</option>
							            		<option>16:30:00</option>
							            		<option>17:00:00</option>
							            		<option>17:30:00</option>
							            		<option>18:00:00</option>
							            	</select>
					            		</td>
					            		<td>
							            	<select class="form-control" name="alle" id="ora-alle">
							            		<option value="alle">Alle</option> 		
							            		<option>9:00:00</option>
							            		<option>9:30:00</option>
							          			<option>10:00:00</option>
							            		<option>10:30:00</option>    
							            		<option>11:00:00</option>
							            		<option>11:30:00</option>
							            		<option>12:00:00</option>
							            		<option>12:30:00</option>
							            		<option>13:00:00</option>
							            		<option>13:30:00</option>
							            		<option>14:00:00</option>
							            		<option>14:30:00</option>
							            		<option>15:00:00</option>
							            		<option>15:30:00</option>
							            		<option>16:00:00</option>
							            		<option>16:30:00</option>
							            		<option>17:00:00</option>
							            		<option>17:30:00</option>
							            		<option>18:00:00</option>	 
							            	</select>
							            </td>
					            	</tr>
				            	</table>				            
		            	<br>
		            	<textarea class="form-control" rows="20" cols="100" placeholder="Inserire qui il messaggio" id="messaggio" name="messag" ></textarea>
	            		<div id="button">
	            			<button class="btn btn-default" type="submit">Invia Messaggio</button>
	            			<button class="btn btn-default" type="refresh">Annulla</button>
	            		</div>
	            	</form>
	            	</div>
	            		<br>
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