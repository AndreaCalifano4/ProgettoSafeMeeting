<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
    <link href="Bootstrap/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="Bootstrap/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="Bootstrap/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="Bootstrap/vendor/morrisjs/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="Bootstrap/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    
    <!-- SafeMeeting CSS -->
    <link href="SafeMeeting.css" rel="stylesheet" type="text/css">

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
	 		   	<a href="index.html"><img id = "logo" src="Images/logo.png""></a>	
	 		   	<h1 id="sm">SafeMeeting</h1> 		   		 		   	
	    	</div>
       	</nav>	       
            <!-- navbar --> 
            
            <div class="sidebar-nav navbar-collapse" aria-expanded="false" style="height: 1px;">		
	            <div class="navbar-default sidebar" role="navigation">
	            	<ul class="nav" id="side-menu">
	                	<li>
	                	<img id="foto-studente" src="Images/User.jpg">
	                	<p>Benvenuto </p>
	                	<br>
	                	</li>
	               		<li>
	                    	<a href="#">Prenotazioni</a> 
	                    </li>
	                    <li>	
	                       	<a href="#">Preferiti</a>
	                    </li>
	            	</ul>
	            	<br><br><br><br><br><br><br>
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
            <div class="container-fluid">
	            <div class="row">	            		 
	            </div>
	        <div class="form-group input-group">
	        	<input class="form-control" type="text" />
	        	<span class="input-group-btn">
	        		<button class="btn btn-default" type="button">
	        			<i class="fa fa-search"></i>
	        		</button>
	        	</span>
	        </div>   
	       	</div>
            <!-- /.row -->
            <div class="row"> 
            
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="Boostrap/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="Bootstrap/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="Bootstrap/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="Bootstrap/vendor/raphael/raphael.min.js"></script>
    <script src="Bootstrap/vendor/morrisjs/morris.min.js"></script>
    <script src="Bootstrap/data/morris-data.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="Bootstrap/dist/js/sb-admin-2.js"></script>
    
    <!-- Script SafeMeeting -->
    <script src="Script.js"></script>

</body>

</html>