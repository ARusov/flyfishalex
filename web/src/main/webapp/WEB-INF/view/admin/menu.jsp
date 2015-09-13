<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="menu">
    <ul id="menu-nav">
        <li class="menu-item-top">
            <a href="${lang.context}/admin/categories">Каталог</a>
        </li>
            <li class="menu-item-top">
                <a href="${lang.context}/admin/categories?categoryId=${category.parentId}">Назад</a>
            </li>
        <c:if test="${not empty categories}">
            <c:forEach var="сategory" items="${categories}">
                <li class="menu-item">
                    <a href="${lang.context}/admin/categories?categoryId=${сategory.id}">${сategory.name}</a>
                </li>
            </c:forEach>
        </c:if>
    </ul>
</div>