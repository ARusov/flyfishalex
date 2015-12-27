<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <link href="<c:url value="${lang.resources}/resources/css/northbay/bootstrap/css/bootstrap.min.css"/>"
          rel="stylesheet">
    <link href="<c:url value="${lang.resources}/resources/css/northbay/bootstrap/css/custom.css"/>"
          rel="stylesheet">
    <title>Моя карзина</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<jsp:include page="verticalMenu.jsp"/>
<div class="container">
    <jsp:include page="cabinetMenu.jsp"/>
    <c:if test="${not empty basket}">
        <div class="row">
            <c:if test="${not empty orderDTO}">
                <form:form commandName="orderDTO" method="GET" action="${lang.context}/user/cabinet/cart/recalculate">
                    <table class="table" id="basket">
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
            </c:if>
        </div>

        <div class="row">
            <div class="col-xs-0 col-md-2"></div>
            <div class="col-xs-12 col-md-8 center-block">
                <c:if test="${not empty user}">
                    <form class="form" role="form" name="basket" method="post"
                          action="${lang.context}/user/cabinet/cart">
                        <input name="id" type="hidden" value="${basket.id}">
                        <h2 class="form-signin-heading">Способ доставки:</h2>
                        <div class="input-group">
                        <span class="input-group-addon">
                            <c:forEach items="${deliveries}" var="delivery">
                                <div class="radio">
                                    <label><input required=""  type="radio" name="deliveryId"
                                                  value="${delivery.id}">${delivery.description}</label>
                                </div>
                            </c:forEach>
                        </span>
                        </div>
                        <h2 class="form-signin-heading">Способ оплаты:</h2>
                        <div class="input-group">
                        <span class="input-group-addon">
                            <c:forEach items="${payments}" var="payment">
                                <div class="radio">
                                    <label><input required="" type="radio" name="paymentId"
                                                  value="${payment.id}">${payment.description}</label>
                                </div>
                            </c:forEach>
                        </span>
                        </div>
                        <h2 class="form-signin-heading">Адрес доставки:</h2>
                        <input name="address.zip" type="text" class="form-control" placeholder="Индекс" autofocus="" required="" value="${user.address.zip}">
                        <input name="address.country" type="text" class="form-control" placeholder="Страна"  autofocus="" required="" value="${user.address.country}">
                        <input name="address.region" type="text" class="form-control" placeholder="Область / регион"  autofocus="" value="${user.address.region}">
                        <input name="address.city" type="text" class="form-control" placeholder="Город"  autofocus="" required="" value="${user.address.city}">
                        <input name="address.street" type="text" class="form-control" placeholder="Улица"  autofocus="" required="" value="${user.address.street}">
                        <input name="address.building" type="text" class="form-control" placeholder="Здание / дом"  autofocus="" required="" value="${user.address.building}">
                        <input name="address.flat" type="text" class="form-control" placeholder="Квартира"  autofocus="" value="${user.address.flat}">
                        <input name="address.tel" type="text" class="form-control" placeholder="Телефон"  autofocus="" required="" value="${user.address.tel}">
                        <input name="comment" type="textarea" class="form-control" placeholder="Комментарий"  autofocus="">
                        <button class="btn btn-lg btn-primary btn-block" type="submit">Оформить заказ</button>
                    </form>
                </c:if>
            </div>
            <div class="col-xs-0 col-md-2"></div>
        </div>
    </c:if>
</div>
<jsp:include page="footer.jsp"/>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="<c:url value="${lang.resources}/resources/css/northbay/bootstrap/js/bootstrap.min.js"/>"></script>
</body>
</html>
