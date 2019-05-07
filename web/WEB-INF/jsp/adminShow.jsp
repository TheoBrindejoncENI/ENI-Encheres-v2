<%--
  Created by IntelliJ IDEA.
  User: ehourman2019
  Date: 07/05/2019
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>

<h1 align="center">Toutes les categories :</h1>
<div align="center">
<a class="btn btn-info btn-lg mx-auto"
   href="${pageContext.request.contextPath}/adminAddCategory" role="button">
    <span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Ajouter une categorie</a>
</br></br>
<c:forEach var="category" items="${requestScope.category}">
    <c:out value="${category.title} "/>
        <input type="hidden" name="deleteId" />
        <a class="btn btn-danger btn-sm mx-auto"
        href="${pageContext.request.contextPath}/deleteCategory?id=${category.idCategory}" role="button">
        <span class="glyphicon glyphicon-remove " aria-hidden="true"></span></a>
        </br></br>
</c:forEach>
</div>


<jsp:include page="footer.jsp"/>