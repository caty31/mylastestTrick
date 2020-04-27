<%--
    Document   : accueil
    Created on : 21 avr. 2020, 13:00:03
    Author     : stag
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>MyLatestTricks</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link type="text/css" rel="stylesheet" href="<c:url value="/inc/form2.css"/>" />
    </head>
    <body>
        <%@include file="/WEB-INF/template/header.jsp" %>
        <div class="row">
            <div class="col-xs-6"> 

                <%--
                <img id="imgAccueil" src="<c:url value ="/images/skateboard.png"/>" alt="nom">
                --%>

                <c:if test="${!empty video}"><p><c:out value="La vidéo ${video} (${description}) a été mise en ligne."/></p></c:if>
                    <form method="post" action="Accueil" enctype="multipart/form-data">
                        <fieldset class="form1">

                            <h3>Mettre en ligne une vidéo</h3>
                            <p>
                                <label for="video">Selectionner une vidéo : </label>
                                <input type="file" name="video" id="video"/>
                            </p>
                            <p>
                                <label for="description">Description de la vidéo : </label>
                                <input type="text" name="description" id="description"/>
                            </p>

                            <input type="submit"/>
                        </fieldset>

                    </form>
                    
                    <form action="Comment" method="post">
                        <fieldset class="form2">

                        <h3>Commentez une video</h3>
                        <p>
                            <label for="nom"> Saisissez votre Nom : </label>
                            <input id="nom" type="text" name="nom" value="<c:out value="${utilisateur.nom}" />" size="40" maxlength="50"/>
                        </p>
                        
                        <p>
                            <label for="contenu"> Tapez votre commentaire : </label>
                            <input id="contenu" type="text" name="contenu" required value="<c:out value="${commentaire.contenu}"/>" size="20" maxlength="50" />
                        </p>

                        <input type="submit"/>
                        </fieldset>
                    </form>
                    


            </div>


            <div  class="col-xs-6" > 

                <h1>Top trois des  Videos du mois  :</h1>



                <video width="800" height="600" controls>
                    <source src= <c:url value="/images/video2.mp4"/> type="video/mp4">
                </video>
                <p class="videoPoste"> <h2>MyLastest Tricks: video numero 1 </h2> </p>

                <video width="800" height="600" controls>
                    <source src= <c:url value="/images/video1.mp4"/> type="video/mp4">
                </video>
                <p class="videoPoste"> <h2>MyLastest Tricks: video numero 2 </h2></p>
                <video width="800" height="600" controls>
                    <source src= <c:url value="/images/video3.mp4"/> type="video/mp4">
                </video>
                <p class="videoPoste"><h2>MyLastest Tricks: video numero 3</h2> </p>

            </div>
        </div>


        <%@include file="template/footer.jsp" %>
    </body>
</html>