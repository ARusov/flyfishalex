<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="navbar navbar-inverse " role="navigation">
    <div class="container">
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav pull-right">
            <c:choose>
                <c:when test="${not empty user.email}">
                <li><a href="${lang.context}/user/cabinet">Личный кабинет</a></li>
                <li><a href="${lang.context}/user/cabinet/cart">Корзина</a></li>
                <li><a href="${lang.context}/user/logout">Выход</a></li>
                </c:when>
                <c:otherwise>
                <li><a href="${lang.context}/user/registration">Регистрация</a></li>
                <li><a href="${lang.context}/user/login">Вход</a></li>
                </c:otherwise>
            </c:choose>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</div>
<!-- Static navbar -->
<div class="navbar navbar-default navbar-static-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="${lang.context}">Norhbay.ru</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <c:if test="${not empty rootCategories}">
                    <c:forEach items="${rootCategories}" var="rootCategory">
                        <li class="dropdown">
                            <a href="${lang.context}/category/${rootCategory.id}" class="dropdown-toggle"
                               data-toggle="dropdown">${rootCategory.text}<b
                                    class="caret"></b></a>
                            <c:if test="${not empty childCategories}">
                                <ul class="dropdown-menu">
                                    <c:forEach items="${childCategories}" var="child">
                                        <c:if test="${rootCategory.id==child.parent}">
                                            <li>
                                                <a href="${lang.context}/category/${child.id}">${child.text}</a>
                                            </li>
                                        </c:if>
                                    </c:forEach>
                                </ul>
                            </c:if>
                        </li>
                    </c:forEach>
                </c:if>
            </ul>
            <%--<ul class="nav navbar-nav navbar-right">--%>
            <%--<li><a href="../navbar/">Меню</a></li>--%>
            <%--<li class="active"><a href="./">Статическое</a></li>--%>
            <%--<li><a href="../navbar-fixed-top/">Фиксированное</a></li>--%>
            <%--</ul>--%>
        </div>
        <!--/.nav-collapse -->
    </div>
</div>