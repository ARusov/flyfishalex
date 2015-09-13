<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Заказы</title>
</head>
<body>
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
                <td align="center"><a href="${lang.context}/admin/orders/${order.id}">${order.id}</a></td>
                <td align="center">
                    <c:forEach items="${statuses}" var="status">
                        <c:if test="${status.code==order.status}">
                            ${status.message}
                        </c:if>
                    </c:forEach>
                </td>
                <td align="center">${order.finalPrice+order.deliveryPrice}</td>
                <td align="center">

                </td>
            </tr>
        </c:forEach>
    </table>
    </c:if>
</div>
</div>
</body>
</html>
