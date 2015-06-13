<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <link rel="stylesheet" href="<c:url value="/resources/css/global.css"/> ">
    <link rel="stylesheet" href="<c:url value="/resources/css/header.css"/> ">
    <link rel="stylesheet" href="<c:url value="/resources/css/header.css"/> ">
    <link rel="stylesheet" href="<c:url value="/resources/css/footer.css"/> ">
    <link rel="stylesheet" href="<c:url value="/resources/css/cart.css"/> ">
    <title>Магазин</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<jsp:include page="${lang.lang}/header.jsp"/>

<c:if test="${not empty basket}">
    <div id="container">
        <div id="basket-container">
            <c:if test="${not empty orderPointDTO}">
            <table id="basket">
                <form:form commandName="orderPointDTO">
                    <c:forEach items="${orderPointDTO.orderPoints}" var="orderPoint" varStatus="i">
                        <tr>
                            <td>${orderPoint.id}</td>
                            <td>${orderPoint.description}</td>
                            <td><form:input path="orderPoints[${i.index}].count"/></td>
                            <td>X ${orderPoint.price}</td>
                            <td>= ${orderPoint.price*orderPoint.count}</td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td>
                            <input type="submit" value="Пересчитать"/>
                        </td>
                    </tr>
                </form:form>
            </table>
        </div>

        <div id="order-container">
            <c:if test="${not empty user}">
                <form:form commandName="basket" method="post">
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
    </div>
</c:if>

</body>
</html>
