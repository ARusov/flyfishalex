<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="menu">
    <ul id="menu-nav">
        <li class="menu-item-top">
            <a href="${env}">${catalogue}</a>
        </li>
        <c:if test="${not empty rootCategory}">
            <c:set var="child"  value="menu-item-child"/>
            <li class="menu-item menu-item-root">
                <a href="${env}/category/${rootCategory.id}">${rootCategory.text}</a>
            </li>
        </c:if>
        <c:if test="${not empty categories}">
            <c:forEach var="category" items="${categories}">
                <li class="menu-item">
                    <a class="${child}" href="${env}/category/${category.id}">${category.text}</a>
                </li>
            </c:forEach>
        </c:if>
    </ul>
</div>