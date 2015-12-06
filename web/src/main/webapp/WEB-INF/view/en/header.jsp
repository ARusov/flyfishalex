<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div id="header">
    <div id="nav-panel">
        <c:choose>
            <c:when test="${not empty user.email}">
                <a class="nav-tab" href="${lang.context}/user/cabinet">Личный кабинет</a>
                <a class="nav-tab" href="${lang.context}/user/cabinet/cart">Корзина</a>
                <a class="nav-tab" href="${lang.context}/user/logout">Выход</a>
            </c:when>
            <c:otherwise>
                <a class="nav-tab" href="${lang.context}/user/registration">Регистрация</a>
                <a class="nav-tab" href="${lang.context}/user/login" >Вход</a>
            </c:otherwise>
        </c:choose>

    </div>
    <div id="logo-div">
        <a href="${lang.context}">en Fishing</a>
    </div>
</div>
<jsp:include page="navigation.jsp"/>