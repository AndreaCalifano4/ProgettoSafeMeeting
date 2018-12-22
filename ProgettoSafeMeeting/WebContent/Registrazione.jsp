<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Registrazione</title>

    <!-- Bootstrap Core CSS -->
    <link href="bootstrap/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="bootstrap/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="bootstrap/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="bootstrap/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    
    <!-- SafeMeeting CSS -->
    <link href="bootstrap/SafeMeeting.css" rel="stylesheet" type="text/css">

</head>

<body id ="sfondo">
  
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div  class="panel-heading">
                      <p id="errore"> </p>
                        <img id="logoReg" src="bootstrap/images/logo.png">
                    </div>
                    <div class="panel-body">
                        <form role="form" method="POST" action="ServletRegistraAccount">
                            <fieldset>
                              <div class = "form-group">
                                <label>Sei uno: </label>
                                <label class="radio-inline">
                                  <input type="radio" name="tipo-utente" id="utente1" value="studente" onclick="test()" >Studente
                                </label>
                                <label class="radio-inline">                                                                                            
                                  <input type="radio" name="tipo-utente" id="utente2" value="docente" onclick="test()">Docente
                                </label>
                              </div>  
                              <div class="form-group" id="nome-div">
                                <input class="form-control" placeholder="Nome" name="nome" id="nome" type="text" autofocus required>
                              </div>
                              
                              <div class="form-group">
                                <input class="form-control" placeholder="Cognome" name="cognome" id="cognome" type="text">
                              </div>
                              <div class="form-group">
                                <input class="form-control" placeholder="Matricola" name="matricola" id="matricola" type="text">
                              </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="E-mail istituzionale" name="email" id="email" type="email">
                                </div>
                                <div class="form-group">
                                    <input class="form-control" id="studio" placeholder="Studio" name="studio" id="studio" type="text" >
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Password" name="password" id="password" type="password" value="">
                                </div>
                                <div class="form-group">
                                  <input class="form-control" placeholder="Ripeti Password" name="ripPassword" id="ripPassword" type="password" value="">  
                                </div>
                                
                                <!-- Change this to a button or input when using this as a form -->

								<button type="submit" class="btn btn-lg btn-success btn-block" onClick="if(validate()==false){return false;}">Registrati</button>
       
                                <div id="enpmlp">
                                  <p class="fa fa-arrow-circle-o-left"> </p>
                                  <a href="Login.jsp"><button  class= "btn btn-default" type="button">Accedi</button></a>
                                </div>
                            </fieldset>
                        </form>
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
    
    <script src="bootstrap/Script.js"></script>

</body>

</html>