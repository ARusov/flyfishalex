<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div id="header">
    <div id="nav-panel">
        <c:choose>
            <c:when test="${not empty user}">
                    <a class="nav-tab" href="${lang.context}/user/cabinet/cart">Корзина</a>
                    <a class="nav-tab" href="${lang.context}/user/logout">Выход</a>
            </c:when>
            <c:otherwise>
                    <a class="nav-tab" href="${lang.context}/user/registration">Registration</a>
                    <a class="nav-tab" href="${lang.context}/user/login" >Login</a>
            </c:otherwise>
        </c:choose>

    </div>
    <div id="logo-div">
        <a href="${lang.context}">
            <span id="logo-image-northbay"></span>
        </a>
    </div>
</div>
<div id="navigation">
    <div class="navigation">
        <a>Главная</a>
    </div>

    <div class="navigation">
        <a>Step By Step</a>
    </div>
    <div class="navigation-right">
        <a>Контакты</a>
    </div>
    <div class="navigation-right">
        <a>Доставка</a>
    </div>
    <div class="navigation-right">
        <a>Оплата</a>
    </div>

</div>