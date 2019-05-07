<%--
  Created by IntelliJ IDEA.
  User: ehourman2019
  Date: 07/05/2019
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="header.jsp"/>

<h1 align="center">Ajouter une categorie</h1>

<form action="${pageContext.request.contextPath}/adminAddCategory" method="POST">
    <div class="form-group">
        <label for="titleCategory">Titre de la catégorie :</label>
        <input name="titleCategory" type="text" class="form-control" id="titleCategory" placeholder="Titre de category" required>
    </div>
    <button type="submit" class="btn btn-success btn-sm">
        <span class="glyphicon glyphicon-ok" aria-hidden="true"></span> Valider
    </button>
</form>

<jsp:include page="footer.jsp"/>
