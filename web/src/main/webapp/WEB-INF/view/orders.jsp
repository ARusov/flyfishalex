<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/global.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/header.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/menu.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/footer.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/cabinet.css"/> ">
    <script type="text/javascript" src="<c:url value="${lang.resources}/resources/js/jquery-2.1.4.min.js"/>"></script>
    <title>Мои заказы</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<jsp:include page="${lang.lang}/header.jsp"/>
<jsp:include page="verticalMenu.jsp"/>
<div id="container">
    <jsp:include page="cabinetMenu.jsp"/>
    <div id="orders">

        <table>
            <tr>
                <th align="center">Номер заказа</th>
                <th align="center">Статус заказа</th>
                <th align="center">Общая стоимость</th>
                <th align="center">Комментарий</th>
            </tr>
            <c:if test="${not empty orders}">
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
                    <td align="center">${order.finalPrice+order.deliveryPrice}</td>
                    <td align="center">
                        <c:if test="${order.status==2}">
                            <a href="${lang.context}/payment?order=${order.id}">Оплатить заказ</a>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </table>
        </c:if>
    </div>
</div>
</body>
</html>
