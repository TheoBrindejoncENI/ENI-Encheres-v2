<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Theo
  Date: 2019-05-02
  Time: 09:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="profile" value="${requestScope.profile}"/>
<c:set var="admin" value="${requestScope.admin}"/>
<c:set var="register" value="${requestScope.register}"/>
<c:set var="connect" value="${requestScope.connect}"/>
<c:set var="disconnect" value="${requestScope.disconnect}"/--%>

<html lang="fr">
<head>

    <title>ENI Enchères</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <script src="https://use.fontawesome.com/releases/v5.6.3/css/all.css"></script>
    <link rel="stylesheet" href="../css/header.css">
</head>
<body>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<c:set var="user" value="${sessionUser}"/>
<c:set var="isConnected" value="${sessionScope.utilisateurConnecte}"/>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="home"><span class="glyphicon glyphicon-tags" aria-hidden="true"></span> ENI Encheres</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li class="active"><a href="home">Accueil</a></li>
                <li><a href="articleList">Enchères</a></li>
                <c:if test="${isConnected == true}">
                    <li><a href="createEnchere">Vendre</a></li>
                </c:if>
                <c:if test="${isConnected == true}">
                    <li><a href="profile">Mon Profil</a></li>
                </c:if>
                <c:if test="${user.userAdmin == true}">
                    <li><a href="showAdmin">Administration</a></li>
                </c:if>
            </ul>

                <ul class="nav navbar-nav navbar-right login">
                    <c:if test="${empty isConnected}">
                        <li><a href="register"><span class="glyphicon glyphicon-sign-up"></span> S'Enregistrer</a> </li>
                    </c:if>
                    <c:if test="${empty isConnected}">
                        <li><a href="login"><span class="glyphicon glyphicon-log-in"></span> Connexion</a></li>
                    </c:if>
                    <c:if test="${isConnected == true}">
                        <li><a href="logout"><span class="glyphicon glyphicon-log-out"></span>Deconnexion</a></li>
                    </c:if>
                </ul>
        </div>
    </div>
</nav>