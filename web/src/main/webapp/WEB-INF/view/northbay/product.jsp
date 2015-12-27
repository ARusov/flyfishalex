<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value="${lang.resources}/resources/css/northbay/bootstrap/css/bootstrap.min.css"/>"
          rel="stylesheet">
    <link href="<c:url value="${lang.resources}/resources/css/northbay/bootstrap/css/custom.css"/>"
          rel="stylesheet">
    <script src="<c:url value="${lang.resources}/resources/js/product.js"/>"></script>
    <title>${product.name} в магазине Northbay</title>
</head>
<body>

<jsp:include page="verticalMenu.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-xs-6 col-md-6 thumbnail">
            <img src="${product.image}">
        </div>
        <div class="col-xs-6 col-md-6">
            <div class="page-header">
                <h1>${product.name}</h1>
            </div>
            <p>${product.description}</p>
        </div>
    </div>
    <div class="row">
        <%--<div class="panel panel-default">--%>
        <%--<!-- Default panel contents -->--%>
        <%--<div class="panel-heading"><h2>Варианты товара ${product.name}</h2></div>--%>
        <c:if test="${not empty variants}">
            <table class="table">
                <thead>
                <tr>
                    <th>Артикул</th>
                    <th>Наименование</th>
                    <th>Цена</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${variants}" var="variant">
                    <tr>
                        <td>
                                ${variant.id}
                        </td>
                        <td>
                                ${variant.description}
                        </td>
                        <td>
                                ${variant.price} Р.
                        </td>
                        <td>
                            <c:choose>
                                <c:when test="${variant.count>0}">
                                    <a href="${lang.context}/user/basket/${variant.id}"
                                       class="btn btn-lg btn-primary" name="${variant.id}">В корзину</a>
                                </c:when>
                                <c:otherwise>
                                    <a class="btn btn-lg btn-primary" name="${variant.id}">Сообщить о
                                        наличии</a>
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>

    </div>

</div>

<jsp:include page="footer.jsp"/>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="<c:url value="${lang.resources}/resources/css/northbay/bootstrap/js/bootstrap.min.js"/>"></script>
</body>
</html>
