<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <img src="">


    <div class="form-group">
        <form>
            <label for="article_name">Article :</label>
                <input class="form-control" type="text" placeholder="Votre article" name="article_name" id="article_name">

            <label for="article_description">Description :</label>
                <textarea class="form-control" id="article_description" rows="3" name="article_description"></textarea>

            <label for="article_categorie">Catégorie :</label>
                <select class="form-control" id="article_categorie">
                    <option>Maison</option>
                </select>

            <label></label>
                <button type="button">Uploader</button>
            <label></label>
            <input class="form-control" type="number" placeholder="100" name="article_price" id="article_price">
        </form>
        <div class="input-group date" id="datetimepicker1" data-target-input="nearest">
            <input type="text" class="form-control datetimepicker-input" data-target="#datetimepicker1"/>
            <div class="input-group-append" data-target="#datetimepicker1" data-toggle="datetimepicker">
                <div class="input-group-text"><i class="fa fa-calendar"></i></div>
            </div>
        </div>
        <div class="input-group date" id="datetimepicker2" data-target-input="nearest">
            <input type="text" class="form-control datetimepicker-input" data-target="#datetimepicker2"/>
            <div class="input-group-append" data-target="#datetimepicker2" data-toggle="datetimepicker">
                <div class="input-group-text"><i class="fa fa-calendar"></i></div>
            </div>
        </div>
        <div>

        </div>
    </div>
</div>
<script type="text/javascript">
    $(function () {
        $('#datetimepicker1').datetimepicker('show');
    });
</script>
<script type="text/javascript">
    $(function () {
        $('#datetimepicker2').datetimepicker('show');
    });
</script>
<jsp:include page="footer.jsp"/>