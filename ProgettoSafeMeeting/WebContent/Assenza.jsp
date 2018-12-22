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
	            	
	            		<div id="giorno-mese-anno">		            		
		            		<label >Indicare il giorno dell'assenza</label> 
		            			<table>  
		            				<tr>  
		            					<td>      	
						            		<select onfocus="if(validateData()) == false{return false;}" class="form-control" id="giorno" >
						            			<option value="">Giorno</option>
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
						            		<select class="form-control" id="mese">
						            			<option>Mese</option>
							            		<option>Gennaio</option>
							            		<option>Febbraio</option>
							            		<option>Marzo</option>
							            		<option>Aprile</option>
							            		<option>Maggio</option>
							            		<option>Giugno</option>
							            		<option>Luglio</option>
							            		<option>Agosto</option>
							            		<option>Settembre</option>
							            		<option>Ottobre</option>
							            		<option>Novembre</option>
							            		<option>Dicembre</option>	            		
							            	</select>
				            			</td>
				            			<td>
							            	<select class="form-control" id="anno" onfocus="getAnno();">
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
							            	<select class="form-control" id="ora-dalle">
							            		<option>Dalle</option>
							            		<option>9:00</option>
							            		<option>9:30</option>
							          			<option>10:00</option>
							            		<option>10:30</option>    
							            		<option>11:00</option>
							            		<option>11:30</option>
							            		<option>12:00</option>
							            		<option>12:30</option>
							            		<option>13:00</option>
							            		<option>13:30</option>
							            		<option>14:00</option>
							            		<option>14:30</option>
							            		<option>15:00</option>
							            		<option>15:30</option>
							            		<option>16:00</option>
							            		<option>16:30</option>
							            		<option>17:00</option>
							            		<option>17:30</option>
							            		<option>18:00</option>
							            	</select>
					            		</td>
					            		<td>
							            	<select class="form-control" id="ora-alle">
							            		<option>Alle</option> 		
							            		<option>9:00</option>
							            		<option>9:30</option>
							          			<option>10:00</option>
							            		<option>10:30</option>    
							            		<option>11:00</option>
							            		<option>11:30</option>
							            		<option>12:00</option>
							            		<option>12:30</option>
							            		<option>13:00</option>
							            		<option>13:30</option>
							            		<option>14:00</option>
							            		<option>14:30</option>
							            		<option>15:00</option>
							            		<option>15:30</option>
							            		<option>16:00</option>
							            		<option>16:30</option>
							            		<option>17:00</option>
							            		<option>17:30</option>
							            		<option>18:00</option>	 
							            	</select>
							            </td>
					            	</tr>
				            	</table>				            
		            	<br>
		            	<textarea class="form-control" rows="20" cols="100" placeholder="Inserire qui il messaggio" id="messaggio"></textarea>
	            	</div>
	            		<div id="button">
	            			<button class="btn btn-default">Invia Messaggio</button>
	            			<button class="btn btn-default">Annulla</button>
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