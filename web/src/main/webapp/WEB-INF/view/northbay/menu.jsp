<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="menu">
    <ul id="menu-nav">
        <li class="menu-item">
            <a href="${lang.context}">Каталог</a>
        </li>
        <c:if test="${not empty categories}">
            <c:forEach var="сategory" items="${categories}">
                <li class="menu-item">
                    <a href="${lang.context}/category/${сategory.id}">${сategory.text}</a>
                </li>
            </c:forEach>
        </c:if>
    </ul>
</div>