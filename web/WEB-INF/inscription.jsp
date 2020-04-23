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
        <%@include file="/WEB-INF/template/header.jsp" %>
        <form method="post" action="inscription">
            <fieldset>
                <legend>Inscription</legend>
                <p>Vous pouvez vous inscrire via ce formulaire.</p>

                <img src="<c:url value ="/images/nom.jpg"/>" width="50" height="50" alt="nom">
                <span class="requis">*</span>
                <label for="nom">Nom d'utilisateur</label>
                <input type="text" id="nom" name="nom" value="<c:out value="${utilisateur.nom}" />" size="20" maxlength="20" />              
                <span class='erreur'>${form.erreurs.nom}</span>
                <br />

                <img src="<c:url value ="/images/nom.jpg"/>" width="50" height="50" alt="prenom">
                <span class="requis">*</span>
                <label for="prenom">Prenom d'utilisateur</label>
                <input type="text" id="nom" name="prenom" value="<c:out value="${utilisateur.nom}" />" size="20" maxlength="20" />              
                <span class='erreur'>${form.erreurs.prenom}</span>
                <br />

                <img src="<c:url value="/images/email2.png"/>" width="50" height="50" alt="email">
                <span class="requis">*</span>
                <label for="email">Adresse email </label>
                <input type="text" id="email" name="email" value="<c:out value="${utilisateur.email}" />" size="20" maxlength="60" />
                <span class='erreur'>${form.erreurs.email}</span>
                <br />
                <img src="<c:url value ="/images/password.jpg"/>" width="50" height="50" alt="motDePasse">
                <span class="requis">*</span>
                <label for="motdepasse">Mot de passe </label>
                <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />                
                <span class='erreur'>${form.erreurs.motdepasse}</span>
                <br />
                <img src="<c:url value ="/images/confirme.jpg"/>" width="50" height="50" alt="confirme">
                <span class="requis">*</span>
                <label for="confirmation">Confirmation </label>
                <input type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="20" />
                <br />

                <input type="submit" value="Valider" class="sansLabel" />
                <input type="reset" value="Annuler" class="sansLabel"/>

                <p>Les champs marqués d'un <span class="requis">*</span> sont obligatoires.</p>
                <p class='${empty erreurs ? 'succes' : 'erreur'}'>${form.resultat}</p>
                <%-- Vérification de la présence d'un objet utilisateur en session --%>

            </fieldset>

        </form>
        <%@include file="/WEB-INF/template/footer.jsp" %>
    </body>
</html>
