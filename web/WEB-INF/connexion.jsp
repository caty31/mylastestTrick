<%-- 
    Document   : connexion
    Created on : 21 avr. 2020, 12:59:17
    Author     : stag
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Connexion</title>
        <link type="text/css" rel="stylesheet" href="inc/form.css" />
    </head>
    <body>
        <%@include file="/WEB-INF/template/header.jsp" %>
        <form method="post" action="Connexion">
            <fieldset>
                <legend>Connexion</legend>
                <p>Veuillez vous connectez à votre compte.</p>
                <label for="email">Adresse email <span
                        class="requis">* </span></label>
                <input type="email" id="email" name="email" value="<c:out
                           value="${utilisateur.email}"/>" size="8" maxlength="25" />
                <span class="erreur">${form.erreurs['email']}</span>
                <br /><label for="motdepasse">Mot de passe <span
                        class="requis">*</span></label>
                <input type="password" id="motdepasse" name="motdepasse" value=""
                       size="8" maxlength="20" />
                <span class="erreur">${form.erreurs['motdepasse']}</span>

                <div id="basduformulaire">
                    <button type="submit"class="sansLabel"> Connexion</button>
                </div>
                <p class="${empty form.erreurs ? 'succes' :
                            'erreur'}">${form.resultat}</p>
                <c:if test="${!empty sessionScope.sessionUtilisateur}">
                    <%-- Si l'utilisateur existe en session, alors on affiche son adresse
                   email. --%>
                    <p class="succes">Vous êtes connecté(e) avec l'adresse :
                        ${sessionScope.sessionUtilisateur.email}</p>

                </c:if>
            </fieldset>
        </form>
        <%@include file="/WEB-INF/template/footer.jsp" %>
    </body>
</html>