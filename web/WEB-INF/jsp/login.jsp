<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style><%@include file="/WEB-INF/css/login.css"%></style>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<jsp:include page="header.jsp"/>
<div class="row">
    <aside class="col-sm-4">
        <div class="card">
            <article class="card-body">
                <a href="register" class="float-right btn btn-outline-primary">Sign up</a>
                <h4 class="card-title mb-4 mt-1">Sign in</h4>
                <form method="post">
                    <div class="form-group">
                        <label for="identifiant">Your email</label>
                        <input name="identifiant" class="form-control" placeholder="Email" type="text" id="identifiant">
                    </div> <!-- form-group// -->
                    <div class="form-group">
                        <label for="password">Your password</label>
                        <input name="password" id="password" class="form-control" placeholder="******" type="password">
                    </div><!-- form-group// -->
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary btn-block"> Login  </button>
                    </div> <!-- form-group// -->
                </form>
            </article>
        </div> <!-- card.// -->
    </aside>
</div>
<jsp:include page="footer.jsp"/>