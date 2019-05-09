<%--
  Created by IntelliJ IDEA.
  User: ehourman2019
  Date: 07/05/2019
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>

<c:forEach var="article" items="${requestScope.articles}">
    <div class="card" style="width: 18rem;" align="center">
        <div class="card-body">
            <h5 class="card-title">${article.title}</h5>
            <h6 class="card-subtitle mb-2 text-muted">${article.user.userName}</h6>
            <p class="card-text">${article.description}</p>
            <p class="card-text">${article.initPrice}€</p>
        </div>
    </div>
    <br><br>
</c:forEach>


<jsp:include page="footer.jsp"/>