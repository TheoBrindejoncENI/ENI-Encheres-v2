<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <h1 align="center">Ajouter une echère</h1>
    <div class="form-group">
        <form action="${pageContext.request.contextPath}/createEnchere" method="POST">
            <label for="title">Titre :</label>
            <input class="form-control" type="text" placeholder="Titre de l'article" name="title" id="title" required/>

            <label for="description">Description :</label>
            <textarea class="form-control" id="description" rows="3" name="description" placeholder="Description de l'article" required></textarea>

            <label for="category">Catégorie :</label>
            <select class="form-control" id="category" name="category" required>
                <option disabled selected>Choisir une categorie</option>
                <c:forEach var="category" items="${requestScope.category}">
                    <option value="${category.idCategory}">${category.title}</option>
                </c:forEach>
            </select>

            <label for="initPrice">Prix :</label>
            <input class="form-control" type="number" placeholder="100" name="initPrice" id="initPrice" required/>

            <label for="auctionStartDate">Début de l'enchère :</label>
            <input type="date" class="form-control" name="auctionStartDate" id="auctionStartDate" required/>

            <label for="auctionEndDate">Fin de l'enchère :</label>
            <input type="date" class="form-control" name="auctionEndDate" id="auctionEndDate" required/>

            <button type="submit" class="btn btn-success btn-sm">
                <span class="glyphicon glyphicon-ok" aria-hidden="true"></span> Valider
            </button>
            <a class="btn btn-secondary btn-sm"
               href="${pageContext.request.contextPath}/home" role="button">Annuler</a>
        </form>
    </div>
<jsp:include page="footer.jsp"/>