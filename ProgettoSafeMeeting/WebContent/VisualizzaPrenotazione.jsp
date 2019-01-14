<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*" import="safemeeting.model.*"%>
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
		<!-- /.row -->
		<div class="row" id="prenotazioni">
			<div class="panel panel-default" id="pci" style="overflow:auto">
				<div class="panel-heading">Prenotazioni</div>
				<!-- /.panel-heading -->
				<div class="panel-body">
					<ul class="nav" id="side-menu">
						<%
					ArrayList<PrenotaBean> arrpb = (ArrayList<PrenotaBean>) request.getSession().getAttribute("arrpb"); 
					for(int i = 0; i<arrpb.size(); i++){
					%>
					<form method="POST" action="ServletDettagliPrenot">
						<li id ="pren">
							<div align="center">
								<a href="#">
									<button type="submit" style="background-color: transparent; border-color: transparent;"><h4>Prenotazione cod: <%=arrpb.get(i).getNumero_prenotazione() %></h4></button>
									<input type="hidden" name="matrdoc" value="<%=arrpb.get(i).getPrenotaMatricolaDoc() %>">
									<input type="hidden" name="numprenot" value="<%=arrpb.get(i).getNumero_prenotazione() %>">
									<input type="hidden" name="indice" value="<%=i %>">
								</a>
							</div>
						</li>
					</form>
					<%} %>								
					</ul>
				</div>
				<!-- /.panel-body -->
			</div>
		</div>
		<div class="row" id="singola">
			<div class="panel panel-default">
				<div class="panel-heading">Dettagli prenotazione:</div>
				<!-- /.panel-heading -->
				<div class="panel-body">
					<table class="table">
					<%
						DocenteBean dbdettagli = (DocenteBean) request.getAttribute("db");
						PrenotaBean pbdettagli = (PrenotaBean) request.getAttribute("pb");
						int numprenotati = (Integer)request.getAttribute("numprenotati");
					%>
							<tr>
								<th></th>
  								<th>Nome docente:</th>
  								<th><%=dbdettagli.getNome() %>&nbsp;<%=dbdettagli.getCognome() %></th>							
  							</tr>
							<tr>
								<th></th>
  								<th>Tipologia:</th>
    							<th><%=pbdettagli.getTipologia() %></th>
  							</tr>
  							<tr>
  								<th></th>
  								<th>Orario:</th>
    							<th><%=pbdettagli.getOrario() %></th>
  							</tr>
  							<tr>
  								<th></th>
  								<th>Giorno:</th>
    							<th><%=pbdettagli.getGiorno() %></th>
  							</tr>
  							<tr>
  								<th></th>
  								<th>Numero prenotati:</th>
    							<th><%=numprenotati %></th>
  							</tr>
  							<tr>
  								<th> </th>
  								<th> </th>
    							<th> </th>
  							</tr>
					</table>
					<form method="POST" action="ServletEliminaPrenotazione">
						<input type="hidden" value="<%=pbdettagli.getNumero_prenotazione()%>" name="numeroprenotaz">
						<button type="submit" class="btn btn-default" id="btn-elimina-pren">Elimina prenotazione</button>
					</form>
				</div>
				<!-- /.row -->
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