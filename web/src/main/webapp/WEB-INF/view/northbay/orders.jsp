<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <link href="<c:url value="${lang.resources}/resources/css/northbay/bootstrap/css/bootstrap.min.css"/>"
          rel="stylesheet">
    <link href="<c:url value="${lang.resources}/resources/css/northbay/bootstrap/css/custom.css"/>"
          rel="stylesheet">
    <title>Мои заказы</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<jsp:include page="verticalMenu.jsp"/>
<div class="container">
    <jsp:include page="cabinetMenu.jsp"/>
    <div class="row">
        <table class="table">
            <thead>
            <tr>
                <th align="center">Номер заказа</th>
                <th align="center">Статус заказа</th>
                <th align="center">Стоимость заказа</th>
                <th align="center">Стоимость доставки</th>
                <th align="center">Общая стоимость</th>
                <th align="center">Комментарий</th>
            </tr>
            </thead>
            <c:if test="${not empty orders}">
                <tbody>
                <c:forEach items="${orders}" var="order">
                    <tr>
                        <td align="center">${order.id}</td>
                        <td align="center">
                            <c:forEach items="${statuses}" var="status">
                                <c:if test="${status.code==order.status}">
                                    ${status.message}
                                </c:if>
                            </c:forEach>
                        </td>
                        <td align="center">${order.finalPrice}</td>
                        <td align="center">${order.deliveryPrice}</td>
                        <td align="center">${order.finalPrice+order.deliveryPrice}</td>
                        <td align="center">
                            <c:if test="${order.status==2}">
                                <a href="${lang.context}/payment?order=${order.id}">Оплатить заказ</a>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </c:if>
        </table>
    </div>
</div>
<jsp:include page="footer.jsp"/>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="<c:url value="${lang.resources}/resources/css/northbay/bootstrap/js/bootstrap.min.js"/>"></script>
</body>
</html>
