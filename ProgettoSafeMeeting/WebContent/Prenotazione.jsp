<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="safemeeting.model.*" import="java.util.*"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SafeMeeting Prenotazione</title>

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
            <div class="container-fluid">
	            <div class="row">	            		 
	        </div>
	        <form method="POST" action="ServletRicerca">
	        <div class="form-group input-group">
	        	<input class="form-control" type="text" name="parametro"
                        placeholder="Ricerca qui un docente per cognome o per un corso associato..." /> 
	        	<span class="input-group-btn">
	        		<button class="btn btn-default" type="submit">
	        			<i class="fa fa-search"></i>
	        		</button>
	        	</span>
	        </div>   
			</form>    
	       	</div>
            <!-- /.row -->
            <div class="row"> 
            
            </div>
            <hr>
            <div>
            <% 
            	DocenteBean db = (DocenteBean) request.getSession().getAttribute("docente"); 
            	ArrayList<CorsoBean> cb = (ArrayList<CorsoBean>) request.getSession().getAttribute("corso");
            	ArrayList<RicevimentoBean> rb = (ArrayList<RicevimentoBean>) request.getSession().getAttribute("ricevimento");
            %>
	        	<img id="foto-docente-dettagli-prenotazione" src="${pageContext.request.contextPath}/ImageProxyController?name=<%=db.getImmagine() %>" style="float:left">
	        </div>
	        &nbsp; &nbsp; &nbsp; &nbsp;
	        <div>
	        	<p>
	        		
	        	<%=db.getNome() %> <%=db.getCognome() %><br>
	        	<% for(int i = 0; i<cb.size(); i++){ %><%=cb.get(i).getNome() %><br><%} %>
	        	</p>
	       	</div>
	       	<br><br>
	       	<div>
	       	<br>
	       	<p>
	       	<h1 class="lead">Orari di ricevimento:</h1>
	       		<table class="table" id="table-pref">
	       				<br>
	       				<%for(int i = 0; i< rb.size(); i++){ %>
  						<tr>
  							<th><%=rb.get(i).getGiorno() %></th>
    						<th><%=rb.get(i).getOra_inizio().toString() %></th>
    						<th><%=rb.get(i).getOra_fine().toString() %></th> 
  						</tr>
  						<%} %>
  						<tr>
  							<th>Studio <%=db.getStudio()%> - Dipartimento di Informatica</th>
  							<th></th>
  							<th></th>
  						</tr>
 					</table>
	       	</p>
	       	</div>
	       	<div>
	       	<a href="EffettuaPrenotazione.jsp">
	       		<button class="btn btn-primary btn-lg" type="button">Prenotati</button>
	       	</a>
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