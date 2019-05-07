<jsp:include page="header.jsp"/>


    <form action="${pageContext.request.contextPath}/register" method="POST">
    <div class="form-row">
        <div class="form-group col-md-4">
            <label for="userName">Pseudo</label>
            <input name="userName" type="text" class="form-control" id="userName" placeholder="Pseudo" required>
        </div>
        <div class="form-group col-md-4">
            <label for="firstName">Prénom</label>
            <input name="firstName" type="text" class="form-control" id="firstName" placeholder="Jean" required>
         </div>
        <div class="form-group col-md-4">
            <label for="lastName">Nom</label>
            <input name="lastName" type="text" class="form-control" id="lastName" placeholder="Dupont" required>
        </div>
    </div>
    <div class="form_row">
        <div class="form-group col-md-6">
            <label for="email">Email</label>
            <input name="email" type="email" class="form-control" id="email" placeholder="Email" required>
        </div>
        <div class="form-group col-md-6">
            <label for="password">Password</label>
            <input name="password" type="password" class="form-control" id="password" placeholder="Mot de passe" required>
        </div>
    </div>
    <div class="form-group">
        <label for="street">Rue</label>
        <input name="street" type="text" class="form-control" id="street" placeholder="12 Rue de Paris" required>
    </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="city">Ville</label>
            <input name="city" type="text" class="form-control" id="city" placeholder="Paris" required>
        </div>
        <div class="form-group col-md-6">
            <label for="postalCode">Code Postal</label>
            <input name="postalCode" type="number" class="form-control" id="postalCode" placeholder="35000" required>
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="phoneNumber">Numero de téléphone</label>
            <input name="phoneNumber" type="number" class="form-control" id="phoneNumber" placeholder="0123456789" required>
        </div>
    </div>

    <button type="submit" class="btn btn-primary">S'enregister</button>
</form>
<jsp:include page="footer.jsp"/>