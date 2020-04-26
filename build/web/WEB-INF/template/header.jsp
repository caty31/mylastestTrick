<%--
    Document   : header
    Created on : 22 avr. 2020, 13:30:06
    Author     : stag
--%>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>


<nav class="navbar navbar-default">
    <div class="container-fluid">

        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="<c:url value="Accueil" />">MyLatestTricks</a>
        </div>


        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a href="<c:url value="Inscription" />">Inscription <span class="sr-only">(current)</span></a></li>
            </ul>
            <form id="signin" method="post" action="Connexion" class="navbar-form navbar-right" role="form"> 
                <div class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                    <input id="email" type="email" class="form-control" name="email" value="<c:out
                           value="${utilisateur.email}"/>" placeholder="Addresse Email" >     
                </div>
 
                <div class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                    <input id="password" type="password" class="form-control" name="password" value="" placeholder="Mot De Passe">
                </div>

                <button type="submit" class="btn btn-primary">Se connecter</button>
                <p class='${empty erreurs ? 'succes': 'erreur'}'>${form.resultat}</p>
            </form>

        </div>
    </div>
</nav>
