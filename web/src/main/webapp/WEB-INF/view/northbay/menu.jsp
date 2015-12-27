<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="navmenu navmenu-default navmenu-fixed-left col-xs-6 col-md-2">
    <%--<a class="navmenu-brand visible-md visible-lg" href="#"><h2>Каталог</h2></a>--%>
    <ul class="nav navmenu-nav">
        <c:if test="${not empty categories}">
            <c:forEach var="сategory" items="${categories}">
                <li><h2><a href="${lang.context}/category/${сategory.id}">${сategory.text}</a></h2></li>
            </c:forEach>
        </c:if>
    </ul>
</div>