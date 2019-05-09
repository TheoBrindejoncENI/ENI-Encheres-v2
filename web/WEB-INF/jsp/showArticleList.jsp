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
<style><%@include file="../css/cards.css"%></style>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script src="https://use.fontawesome.com/releases/v5.6.3/css/all.css"></script>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<div class="row">
    <div class="col-sm col-md" style="text-align: center;">
        <div class="thumbnail" style="display: inline-block; float: none; position: relative;margin: 0 auto">
            <div class="caption">
                <c:forEach var="article" items="${requestScope.articles}">
                    <div>
                        <a href="article">
                            <div class="card-body">
                                    <h5 class="card-title">${article.name}</h5>
                                    <br>
                                    <p class="card-text">${article.description}</p>
                                    <p class="card-text">${article.initPrice}</p>
                                    <h6 class="card-subtitle mb-2 text-muted">${article.user.userName}</h6>
                            </div>
                    </a>
                    </div>
            </div>

                </c:forEach>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(function () {
        $('[data-toggle="tooltip"]').tooltip()
    })

    // Initialize popover component
    $(function () {
        $('[data-toggle="popover"]').popover()
    })
</script>

<jsp:include page="footer.jsp"/>