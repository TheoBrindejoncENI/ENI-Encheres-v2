<%--
  Created by ehourman2019
  Date: 07/05/2019
  Time: 10:54
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>


<c:set var="user" value="${user}"/>
<div class="row">
    <div class="col-sm col-md" style="text-align: center;">
        <div class="thumbnail" style="display: inline-block; float: none; position: relative;margin: 0 auto">
            <div class="caption">
                <h3>${user.userName}</h3>
                <p>
                    ${user.firstName} ${user.lastName}
                </p>
                <p>${user.email}</p>
                <p>${user.phoneNumber}</p>
                <p>${user.street}</p>
                <p>${user.city}</p>
                <p>${user.postalCode}</p>
                <c:choose>
                    <c:when test="${user.money == null}">
                        <p>Aucun crédit</p>
                    </c:when>
                    <c:otherwise>
                        <p>${user.money} Crédits</p>
                    </c:otherwise>
                </c:choose>
                <a class="btn btn-success btn-sm mx-auto"
                   href="${pageContext.request.contextPath}/myArticle" role="button">
                    <span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span> Voir mes articles</a>
                <a class="btn btn-info btn-sm mx-auto"
                   href="${pageContext.request.contextPath}/editProfile" role="button">
                    <span class="glyphicon glyphicon-pencil " aria-hidden="true"></span> Editer</a>
                <a class="btn btn-danger btn-sm mx-auto"
                   href="${pageContext.request.contextPath}/deleteProfile" role="button">
                    <span class="glyphicon glyphicon-remove" aria-hidden="true"></span> Supprimer</a>
            </div>
        </div>
    </div>
</div>
</div>
<jsp:include page="footer.jsp"/>