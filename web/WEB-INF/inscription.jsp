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
    <body>
        <%@include file="/WEB-INF/template/header.jsp" %>
        <div class="row">
            <div class="col-xs-6"> 
                <form method="post" action="Inscription">
                    <fieldset>
                        <legend>Inscription</legend>

                        <p>Vous pouvez vous inscrire via ce formulaire.</p>

                        <img src="<c:url value ="/images/nom.jpg"/>" width="50" height="50" alt="nom">          
                        <label for="nom">Nom d'utilisateur <span class="requis">*</span> </label>
                        <input type="text" id="nom" name="nom" value="<c:out value="${utilisateur.nom}" />" size="20" maxlength="20" />              
                        <span class='erreur'>${form.erreurs.nom}</span>
                        <br />

                        <img src="<c:url value ="/images/nom.jpg"/>" width="50" height="50" alt="prenom">            
                        <label for="prenom">Prenom d'utilisateur <span class="requis">*</span> </label>
                        <input type="text" id="prenom" name="prenom" value="<c:out value="${utilisateur.prenom}" />" size="20" maxlength="20" />              
                        <span class='erreur'>${form.erreurs.prenom}</span>
                        <br />

                        <img src="<c:url value="/images/email2.png"/>" width="50" height="50" alt="email">
                        <label for="email">Adresse email <span class="requis">*</span> </label>
                        <input type="text" id="email" name="email" value="<c:out value="${utilisateur.email}" />" size="20" maxlength="60" />
                        <span class='erreur'>${form.erreurs.email}</span>
                        <br />

                        <img src="<c:url value ="/images/password.jpg"/>" width="50" height="50" alt="motDePasse">
                        <label for="motdepasse">Mot de passe <span class="requis">*</span> </label>
                        <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />                
                        <span class='erreur'>${form.erreurs.motdepasse}</span>
                        <br />

                        <img src="<c:url value ="/images/confirme.jpg"/>" width="50" height="50" alt="confirme">
                        <label for="confirmation">Confirmation <span class="requis">*</span> </label>
                        <input type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="20" />
                        <br />

                        <div id="basduformulaire">
                            <button  type="submit" value="submit" class="sansLabel"> VALIDER </button>
                            <button  type="reset" value="clear form"  class="sansLabel"> ANNULER </button>
                        </div>

                        <p>Les champs marqués d'un <span class="requis">*</span> sont obligatoires.</p>
                        <p class='${empty erreurs ? 'succes': 'erreur'}'>${form.resultat}</p>
                        <%-- Vérification de la présence d'un objet utilisateur en session --%>

                    </fieldset>

                </form>
            </div>
            <div class="col-xs-6"> <img src="<c:url value ="/images/photoskatefille.jpg"/>" width="800" height="500" alt="photo"></div>
        </div>




        <%@include file="/WEB-INF/template/footer.jsp" %>
    </body>
</html>
