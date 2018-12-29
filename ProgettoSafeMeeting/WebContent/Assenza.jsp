<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
        		<h1 class="page-header">Assenza</h1>
        	</div>
	            <div class="container-fluid">
	            	<div class="form-group">
	            	<br>
	            		       	            		
		            		<label >Indicare il giorno dell'assenza</label> 
		            			<table>  
		            				<tr>  
		            					<td>
		            					<form name="">      	
						            		<select class="form-control" id="giorno" name="giorno" >
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
							            	</form>
				            			</td>
				            			<td>				                     	
						            		<select class="form-control" id="mese">
						            			<option value="mese">Mese</option>
							            		<option value="1">Gennaio</option>
							            		<option value="2">Febbraio</option>
							            		<option value="3">Marzo</option>
							            		<option value="4">Aprile</option>
							            		<option value="5">Maggio</option>
							            		<option value="6">Giugno</option>
							            		<option value="7">Luglio</option>
							            		<option value="8">Agosto</option>
							            		<option value="9">Settembre</option>
							            		<option value="10">Ottobre</option>
							            		<option value="11">Novembre</option>
							            		<option value="12">Dicembre</option>	            		
							            	</select>
				            			</td>
				            			<td>
							            	<select class="form-control" id="anno" onfocus="getAnno();">
							            		<option value="Anno">Anno</option>		            		
							            	</select>						            	
				            			</td>
			            			</tr>
				            	</table>
				            </div>
				            	<br>
				          	<div id="fascia-oraria">  	
				            	<label>Indicare la fascia Oraria</label>
				            		<table>
				            			<tr>
				            				<td>
								            	<select class="form-control" id="ora-dalle">
								            		<option value="dalle">Dalle</option>
								            		<option value="1">9:00</option>
								            		<option value="2">9:30</option>
								          			<option value="3">10:00</option>
								            		<option value="4">10:30</option>    
								            		<option value="5">11:00</option>
								            		<option value="6">11:30</option>
								            		<option value="7">12:00</option>
								            		<option value="8">12:30</option>
								            		<option value="9">13:00</option>
								            		<option value="10">13:30</option>
								            		<option value="11">14:00</option>
								            		<option value="12">14:30</option>
								            		<option value="13">15:00</option>
								            		<option value="14">15:30</option>
								            		<option value="15">16:00</option>
								            		<option value="16">16:30</option>
								            		<option value="17">17:00</option>
								            		<option value="18">17:30</option>
								            		<option value="19">18:00</option>
								            	</select>
						            		</td>
						            		<td>
								            	<select class="form-control" id="ora-alle">
								            		<option value="alle">Alle</option> 		
								            		<option value="1">9:00</option>
								            		<option value="2">9:30</option>
								          			<option value="3">10:00</option>
								            		<option value="4">10:30</option>    
								            		<option value="5">11:00</option>
								            		<option value="6">11:30</option>
								            		<option value="7">12:00</option>
								            		<option value="8">12:30</option>
								            		<option value="9">13:00</option>
								            		<option value="10">13:30</option>
								            		<option value="11">14:00</option>
								            		<option value="12">14:30</option>
								            		<option value="13">15:00</option>
								            		<option value="14">15:30</option>
								            		<option value="15">16:00</option>
								            		<option value="16">16:30</option>
								            		<option value="17">17:00</option>
								            		<option value="18">17:30</option>
								            		<option value="19">18:00</option>	 
								            	</select>
								            </td>
						            	</tr>
					            	</table>
					            </div>				            
		            	<br>
		            	<textarea class="form-control" rows="20" cols="100" placeholder="Inserire qui il messaggio" id="messaggio"></textarea>		  
	            	</div>
	            		<div id="button">
	            			<button class="btn btn-default" onclick="validateData(); validateOra();">Invia Messaggio</button>
	            			<button class="btn btn-default">Annulla</button>
	            		</div>
					<br>
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