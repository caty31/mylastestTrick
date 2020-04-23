<%-- 
    Document   : inscription
    Created on : 21 avr. 2020, 12:59:47
    Author     : stag
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta charset="utf-8" />
        <title>Inscription</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/inc/form.css"/>" />
    </head>
    <body class="formInscription">
        <form method="post" action="inscription">
            <fieldset>
                <legend>Inscription</legend>
                <p>Pour ouvrir un compte remplissez notre formulaire.</p>

                <img src="<c:url value ="/images/nom.jpg"/>" width="50" height="50" alt="nom">
                <span class="requis">*</span>
                <input type="text" id="nom" name placeholder="nom" value="<c:out value="${utilisateur.nom}" />" size="20" maxlength="20" />              
                <span class='erreur'>${form.erreurs.nom}</span>
                <br />

                <img src="<c:url value ="/images/nom.jpg"/>" width="50" height="50" alt="prenom">
                <span class="requis">*</span>
                <input type="text" id="nom" name placeholder="prenom" value="<c:out value="${utilisateur.prenom}" />" size="20" maxlength="20" />              
                <span class='erreur'>${form.erreurs.prenom}</span>
                <br />

                <img src="<c:url value="/images/email2.png"/>" width="50" height="50" alt="email">
                <span class="requis">*</span>
                <input type="text" id="email" name placeholder="email" value="<c:out value="${utilisateur.email}" />" size="20" maxlength="60" />
                <span class='erreur'>${form.erreurs.email}</span>
                <br />

                <img src="<c:url value ="/images/password.jpg"/>" width="50" height="50" alt="motDePasse">
                <span class="requis">*</span>
                <input type="password" id="motDePasse" name placeholder="motdepasse" value="<c:out value="${utilisateur.motDePasse}"/>" size="20" maxlength="20" />  
                <span class='erreur'>${form.erreurs.motdepasse}</span>
                <br />

                <img src="<c:url value ="/images/confirme.jpg"/>" width="50" height="50" alt="motDePasse">
                <span class="requis">*</span></label>
                <input type="password" id="confirmation" confirmation placeholder="confirmation" value="" size="20" maxlength="20" />
                <br />

                <input type="submit" value="Inscription" class="sansLabel" />

                <p>Les champs marqués d'un <span class="requis">*</span> sont obligatoires.</p>
                <p class='${empty erreurs ? 'succes' : 'erreur'}'>${form.resultat}</p>


            </fieldset>

        </form>
    </body>
</html>
