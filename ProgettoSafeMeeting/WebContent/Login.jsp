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

    <title>Login Administrator</title>
	
	<link type="text/css" rel="stylesheet" href="bootstrap/vendor/bootstrap/css/admin.css">
	
    <!-- Bootstrap Core CSS -->
    <link href="bootstrap/vendor/bootstrap/css/bootstrap.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="bootstrap/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="bootstrap/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="bootstrap/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="bootstrap/SafeMeeting.css" rel="stylesheet" type="text/css">
    <style>
	body {
	 background: url("bootstrap/images/unisa.jpg") no-repeat center center fixed;
	 -webkit-background-size: cover;
	 -moz-background-size: cover;
	 -o-background-size: cover;
	 background-size: cover;
	}
	</style>
</head>

<body>
	
	<div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    
                    <div class="panel-body">
						<div align="center"><a href = "#"> <img width = "40%" src="bootstrap/images/logo.png" alt ="Logo"></img> </a></div> <br>
                        <form name='login_form' action="ServletLogin" method="POST">
                        <input type="hidden" name="action" value="login_admin">
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="E-mail istituzionale" required name="email" type="text" value ="" autofocus>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Password" required name="password" id="password" type="password" value="" required>
                                </div>
								
								<% 
								if(request.getAttribute("errorLogin")==null){ }
								else{
								%>
										<p style="color:red" align="center">E-mail o password errati, riprovare.</p>
                            	<%
                            		}
								%>
                            
                                <!-- Change this to a button or input when using this as a form -->
                                <button type="submit" value="Send" class="btn btn-lg btn-success btn-block" onclick="validationPassword()">Accedi</button>
                            </fieldset>
                        </form> <br>
						<a href="Registrazione.jsp"><button id="btnRegistrazione" class="btn btn-lg btn-warning btn-block bottone">Registrati</button></a> <br>
						<a href="#"><button style="background-color: transparent;border-color:transparent;" onclick="alert('Invio password temporanea per la email inserita...')">Password dimenticata?</button></a>
                    </div>
                </div>
         
            </div>
        </div>
    </div>

    <!-- jQuery -->
    <script src="bootstrap/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="bootstrap/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="bootstrap/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="bootstrap/dist/js/sb-admin-2.js"></script>
    
    <script>
    function validationPassword(){
    			
    	var password = document.getElementById("password").value;
    	
    	if(password == ''){
    		document.getElementById("password").style.borderColor = "red";
    		return false;
    	}
    	else{
    		document.getElementById("password").style.borderColor = "#ccc";
    		return true;
    	}
    }
    </script>
</body>

</html>