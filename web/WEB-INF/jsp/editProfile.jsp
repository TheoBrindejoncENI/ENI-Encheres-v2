<%--
  Created by ehourman2019
  Date: 07/05/2019
  Time: 10:54
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>

<c:set var="user" value="${user}"/>
<form action="${pageContext.request.contextPath}/editProfile" method="POST">
    <div class="form-row">
        <div class="form-group col-md-4">
            <label for="userName">Pseudo</label>
            <input name="userName" type="text" class="form-control" id="userName" value="${user.userName}" required>
        </div>
        <div class="form-group col-md-4">
            <label for="firstName">Prénom</label>
            <input name="firstName" type="text" class="form-control" id="firstName" value="${user.firstName}" required>
        </div>
        <div class="form-group col-md-4">
            <label for="lastName">Nom</label>
            <input name="lastName" type="text" class="form-control" id="lastName" value="${user.lastName}" required>
        </div>
    </div>
    <div class="form_row">
        <div class="form-group col-md-6">
            <label for="email">Email</label>
            <input name="email" type="email" class="form-control" id="email" value="${user.email}" required>
        </div>
        <div class="form-group col-md-6">
            <label for="password">Password</label>
            <input name="password" type="password" class="form-control" id="password" placeholder="Mot de passe">
        </div>
    </div>
    <div class="form-group">
        <label for="street">Rue</label>
        <input name="street" type="text" class="form-control" id="street" value="${user.street}" required>
    </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="city">Ville</label>
            <input name="city" type="text" class="form-control" id="city" value="${user.city}" required>
        </div>
        <div class="form-group col-md-6">
            <label for="postalCode">Code Postal</label>
            <input name="postalCode" type="number" class="form-control" id="postalCode" value="${user.postalCode}"
                   required>
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="phoneNumber">Numero de téléphone</label>
            <input name="phoneNumber" type="number" class="form-control" id="phoneNumber" value="${user.phoneNumber}"
                   required>
        </div>
    </div>
    <button type="submit" class="btn btn-success btn-sm">
        <span class="glyphicon glyphicon-ok" aria-hidden="true"></span> Valider
    </button>
    <a class="btn btn-secondary btn-sm"
       href="${pageContext.request.contextPath}/profile" role="button">Annuler</a>

<jsp:include page="footer.jsp"/>