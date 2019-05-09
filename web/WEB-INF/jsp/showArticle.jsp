<%--
  Created by IntelliJ IDEA.
  User: ehourman2019
  Date: 09/05/2019
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>

<div class="card" style="width: 18rem;" align="center">
<div class="card-body">
    <h5 class="card-title">${article.title}</h5>
    <h6 class="card-subtitle mb-2 text-muted">${article.user.userName}</h6>
    <p class="card-text">${article.description}</p>
    <p class="card-text">${article.category.title}</p>
    <p class="card-text">Prix initial : ${article.initPrice}€</p>
    <c:choose>
        <c:when test="${article.sellPrice == 0}">
            <p class="card-text">Prix de vente : ${article.initPrice}€</p>
        </c:when>
        <c:otherwise>
            <p class="card-text">Prix de vente :${article.sellPrice}€</p>
        </c:otherwise>
    </c:choose>
    <p class="card-text">Date de début d'enchère : ${article.auctionStartDate}</p>
    <p class="card-text">Date de fin d'enchère : ${article.auctionEndDate}</p>
</div>
</div>


<jsp:include page="footer.jsp"/>