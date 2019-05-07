<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>

<c:set var="user" value="${user}"/>
<div align="center">
<p>${user.userName}</p>
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
    <a class="btn btn-info btn-sm mx-auto"
       href="${pageContext.request.contextPath}/editProfile" role="button">
        <span class="glyphicon glyphicon-pencil " aria-hidden="true"></span> Editer
    <a class="btn btn-danger btn-sm mx-auto"
       href="${pageContext.request.contextPath}/deleteProfile" role="button">
        <span class="glyphicon glyphicon-remove" aria-hidden="true"></span> Supprimer</a>

</div>
<jsp:include page="footer.jsp"/>