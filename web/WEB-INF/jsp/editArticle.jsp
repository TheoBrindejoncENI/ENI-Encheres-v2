<%--
  Created by IntelliJ IDEA.
  User: ehourman2019
  Date: 09/05/2019
  Time: 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>

<c:set var="article" value="${article}"/>
<form action="${pageContext.request.contextPath}/editArticle?id=${article.idArticle}" method="POST">
    <div class="form-row">
        <div class="form-group col-md-4">
            <label for="title">Titre</label>
            <input name="title" type="text" class="form-control" id="title" value="${article.title}" required>
        </div>
        <div class="form-group col-md-4">
            <label for="description">Description :</label>
            <textarea class="form-control" id="description" rows="3" name="description" required>${article.description}</textarea>
        </div>
        <div>
            <label for="category">Catégorie :</label>
            <select class="form-control" id="category" name="category" required>
                <option disabled selected>Choisir une categorie</option>
                <c:forEach var="category" items="${category}">
                    <option value="${category.idCategory}">${category.title}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="form_row">
        <div class="form-group col-md-6">
            <label for="initPrice">Prix :</label>
            <input class="form-control" type="number" placeholder="100" name="initPrice" id="initPrice" value="${article.initPrice}" required>
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="auctionStartDate">Début de l'enchère :</label>
            <input type="date" class="form-control" name="auctionStartDate" id="auctionStartDate" value="${article.auctionStartDate}" required/>
        <div class="form-group col-md-6">
            <label for="auctionEndDate">Fin de l'enchère :</label>
            <input type="date" class="form-control" name="auctionEndDate" id="auctionEndDate" value="${article.auctionEndDate}" required/></div>
        </div>
    </div>
    <button type="submit" class="btn btn-success btn-sm">
        <span class="glyphicon glyphicon-ok" aria-hidden="true"></span> Valider
    </button>
    <a class="btn btn-secondary btn-sm"
       href="${pageContext.request.contextPath}/myArticle" role="button">Annuler</a>

<jsp:include page="footer.jsp"/>