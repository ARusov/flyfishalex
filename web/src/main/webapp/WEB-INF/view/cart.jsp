<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/global.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/header.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/footer.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/cabinet.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/menu.css"/> ">
    <script type="text/javascript" src="<c:url value="${lang.resources}/resources/js/jquery-2.1.4.min.js"/>"></script>
    <title>Магазин</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<jsp:include page="${lang.lang}/header.jsp"/>
<jsp:include page="verticalMenu.jsp"/>


<div id="container">
    <jsp:include page="cabinetMenu.jsp"/>
    <c:if test="${not empty basket}">
        <div id="basket-container">
        <c:if test="${not empty orderDTO}">
            <form:form commandName="orderDTO" method="GET" action="${lang.context}/user/cabinet/cart/recalculate">
                <table id="basket">
                    <c:set var="summ" value="0"/>
                    <c:if test="${not empty orderDTO.orderPoints}">
                        <c:forEach items="${orderDTO.orderPoints}" var="orderPoint" varStatus="i">
                            <tr>
                                <td width="0%">
                                    <form:hidden path="orderPoints[${i.index}].id"/>
                                </td>
                                <td width="65%">
                                        ${orderPoint.description}
                                </td>
                                <td>
                                    <form:input path="orderPoints[${i.index}].count" cssStyle="width: 30px"/>
                                </td>
                                <td>
                                    X
                                </td>
                                <td>
                                        ${orderPoint.price}
                                </td>
                                <td>
                                    = ${orderPoint.price*orderPoint.count}
                                </td>
                            </tr>
                            <c:set var="summ" value="${summ+orderPoint.price*orderPoint.count}"/>
                        </c:forEach>
                    </c:if>
                    <tr>
                        <td></td>
                        <td>
                            <input type="submit" value="Пересчитать"/>
                        </td>
                        <td></td>
                        <td></td>
                        <td>Сумма:</td>
                        <td>${summ}</td>
                    </tr>
                </table>
            </form:form>

            </div>

            <div id="order-container">
                <c:if test="${not empty user}">
                    <form:form commandName="basket" method="post" action="${lang.context}/user/cabinet/cart">
                        <form:input path="id" cssClass="invisible"/>

                        <div id="deliveries">
                            <span>Способ доставки:</span>
                            <c:if test="${not empty deliveries}">
                                <form:radiobuttons path="deliveryId" items="${deliveries}" itemLabel="description"
                                                   itemValue="id"/>
                            </c:if>
                        </div>
                        <div id="payments">
                            <span>Способ оплаты:</span>
                            <c:if test="${not empty payments}">
                                <form:radiobuttons path="paymentId" items="${payments}" itemLabel="description"
                                                   itemValue="id"/>
                            </c:if>
                        </div>
                        <div id="address">
                            <table>
                                <tr>
                                    <td>Индекс:</td>
                                    <td><form:input path="address.zip"/></td>
                                </tr>
                                <tr>
                                    <td>Странна:</td>
                                    <td><form:input path="address.country"/></td>
                                </tr>
                                <tr>
                                    <td>Регион:</td>
                                    <td><form:input path="address.region"/></td>
                                </tr>
                                <tr>
                                    <td>Город:</td>
                                    <td><form:input path="address.city"/></td>
                                </tr>
                                <tr>
                                    <td>Улица:</td>
                                    <td><form:input path="address.street"/></td>
                                </tr>
                                <tr>
                                    <td>Здание:</td>
                                    <td><form:input path="address.building"/></td>
                                </tr>
                                <tr>
                                    <td>Квартира:</td>
                                    <td><form:input path="address.flat"/></td>
                                </tr>
                                <tr>
                                    <td>Телефон:</td>
                                    <td><form:input path="address.tel"/></td>
                                </tr>
                            </table>

                        </div>
                        <div>
                            <input type="submit" value="Оформить заказ"/>
                        </div>
                    </form:form>
                </c:if>
            </div>
        </c:if>

    </c:if>
</div>
</body>
</html>
