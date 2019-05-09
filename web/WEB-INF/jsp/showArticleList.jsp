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


<div class="row">
        <div class="col-sm col-md" style="text-align: center;">
            <c:forEach var="article" items="${requestScope.articles}">
                <div class="thumbnail" style="display: inline-block; float: none; position: relative;margin: 0 auto">
                    <div class="caption">
                        <h5>${article.title}</h5>
                        <h6>${article.user.userName}</h6>
                        <p>${article.description}</p>
                        <p>${article.initPrice}€</p>
                        <a class="btn btn-info btn-sm mx-auto"
                           href="${pageContext.request.contextPath}/showArticle?id=${article.idArticle}" role="button"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span> Détail</a>
                    </div>
                </div>
            </c:forEach>
        </div>
</div>


<jsp:include page="footer.jsp"/>