<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Заказ</title>
</head>
<body>
<div id="order">
    <h1>Номер заказа: ${order.id}</h1>
    <table>
        <tr>
            <th>ID</th>
            <th>description</th>
            <th>count</th>
            <th>price</th>
            <th>sum price</th>
            <th>variantId</th>
        </tr>
        <c:forEach items="${orderPoints}" var="point">
            <form id="point" method="post" action="${lang.context}/admin/orders/${order.id}/point/${point.id}">
                <tr>
                    <td><input disabled name="id" value="${point.id}"/></td>
                    <td>${point.description}</td>
                    <td><input name="count" value="${point.count}"/></td>
                    <td>${point.price}</td>
                    <td>${point.price*point.count}</td>
                    <td>${point.variantId}</td>
                    <td><input type="submit" value="Change"/></td>
                    <td><a href="${lang.context}/admin/orders/${order.id}/point/${point.id}">Delete</a></td>
                </tr>
            </form>
        </c:forEach>
    </table>
    <div id="address">
        <table>
            <tr>
                <td>Индекс:</td>
                <td>${order.address.zip}</td>
            </tr>
            <tr>
                <td>Странна:</td>
                <td>${order.address.country}</td>
            </tr>
            <tr>
                <td>Регион:</td>
                <td>${order.address.region}</td>
            </tr>
            <tr>
                <td>Город:</td>
                <td>${order.address.city}</td>
            </tr>
            <tr>
                <td>Улица:</td>
                <td>${order.address.street}</td>
            </tr>
            <tr>
                <td>Здание:</td>
                <td>${order.address.building}</td>
            </tr>
            <tr>
                <td>Квартира:</td>
                <td>${order.address.flat}</td>
            </tr>
            <tr>
                <td>Телефон:</td>
                <td>${order.address.tel}</td>
            </tr>
        </table>
    </div>
    <form:form commandName="order" method="post" action="${lang.context}/admin/orders/${order.id}">
        <div class="row">
            <form:hidden path="id"/>
        </div>

        <div class="row">
            <div>Клиент:</div>
            <form:input path="userId" disabled="true"/>
        </div>

        <div class="row">
            <div>Статус:</div>
            <form:select path="status">
                <form:options items="${statuses}" itemLabel="message" itemValue="code"/>
            </form:select>
        </div>

        <div class="row">
            <div>Дата</div>
            <form:input disabled="true" path="date"/>
        </div>

        <div class="row">
            <div>Скидка:</div>
            <form:input path="discount"/>
        </div>

        <div class="row">
            <div>Стоимость:</div>
            <form:input path="finalPrice"/>
        </div>
        <div class="row">
            <div>Доставка:</div>
            <form:input path="deliveryPrice"/>
        </div>
        <div class="row">
            <div>Общая стоимость:</div>
            <span>${order.finalPrice+order.deliveryPrice}</span>
        </div>

        <div class="row">
            <input type="submit" value="Применить"/>
        </div>


    </form:form>
</div>


</body>
</html>
