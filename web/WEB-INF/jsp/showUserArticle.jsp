<%--
  Created by ehourman2019
  Date: 07/05/2019
  Time: 10:54
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>

<h1 align="center">Mes articles</h1>
<a class="btn btn-info mx-auto"
   href="${pageContext.request.contextPath}/createEnchere" role="button">
    <span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Ajouter un article</a>

<c:forEach var="article" items="${requestScope.articles}">
    <div class="card" style="width: 18rem;" align="center">
        <div class="card-body">
            <h5 class="card-title">${article.title}</h5>
            <h6 class="card-subtitle mb-2 text-muted">${article.user.userName}</h6>
            <p class="card-text">${article.description}</p>
            <p class="card-text">${article.initPrice} €</p>
            <a class="btn btn-info btn-sm mx-auto"
               href="${pageContext.request.contextPath}/editArticle?id=${article.idArticle}" role="button">
                <span class="glyphicon glyphicon-pencil " aria-hidden="true"></span></a>
            <a class="btn btn-danger btn-sm mx-auto"
               href="${pageContext.request.contextPath}/deleteArticle?id=${article.idArticle}" role="button">
                <span class="glyphicon glyphicon-remove " aria-hidden="true"></span></a>
            </br></br>
        </div>
    </div>
    <br><br>
</c:forEach>

<jsp:include page="footer.jsp"/>