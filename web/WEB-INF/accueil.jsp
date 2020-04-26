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
        <link type="text/css" rel="stylesheet" href="<c:url value="/inc/form.css"/>" />
    </head>
    <body>
        <%@include file="/WEB-INF/template/header.jsp" %>
        <h2>Top :</h2>
        <%--
        <img id="imgAccueil" src="<c:url value ="/images/skateboard.png"/>" alt="nom">
        --%>

        <c:if test="${!empty video}"><p><c:out value="La vidéo ${video} (${description}) a été mise en ligne."/></p></c:if>
            <form method="post" action="Accueil" enctype="multipart/form-data">

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

            </form>

        <%@include file="template/footer.jsp" %>
    </body>
</html>