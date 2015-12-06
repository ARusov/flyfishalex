<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/northbay/global.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/northbay/header.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/northbay/category.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/northbay/footer.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/northbay/menu.css"/> ">
    <script type="text/javascript" src="<c:url value="${lang.resources}/resources/js/jquery-2.1.4.min.js"/>"></script>
    <title>Магазин</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="verticalMenu.jsp"/>
<div id="container">
    <c:set var="itemsClass" value="full"/>
    <c:if test="${not empty categories}">
        <jsp:include page="menu.jsp"/>
        <c:set var="itemsClass" value="short"/>
    </c:if>

    <div id="items" class="${itemsClass}">
        <h1>${category.name} на <a href="http://northbay.ru/">northbay.ru</a></h1>
        <%--categories--%>
        <c:forEach var="category" items="${categories}">
            <div class="item">
                <div class="item-image">
                    <a href="${lang.context}/category/${category.id}"><img
                            src="${lang.resources}/resources/images/nofoto.png"></a>
                </div>
                <a href="${lang.context}/category/${category.id}">${category.text}</a>
            </div>
        </c:forEach>
        <%--products--%>
        <c:set var="i" value="0"/>
        <c:forEach var="product" items="${products}">
            <c:if test="${i==0}">
                <div class="row-item">
            </c:if>
            <div class="item">
                <div class="item-image">
                    <c:choose>
                        <c:when test="${not empty product.image}">
                            <a href="${lang.context}/product/${product.id}"><img
                                    src="${product.image}" width="170px"></a>
                        </c:when>
                        <c:otherwise>
                            <a href="${lang.context}/product/${product.id}"><img
                                    src="${lang.resources}/resources/images//nofoto.png"></a>
                        </c:otherwise>
                    </c:choose>
                </div>
                <a href="${lang.context}/product/${product.id}">${product.name}</a>
            </div>
            <c:set var="i" value="${i+1}"/>
            <c:if test="${i==5}">
                </div>
                <c:set var="i" value="0"/>
            </c:if>
        </c:forEach>

    </div>
    <jsp:include page="footer.jsp"/>
</body>
</html>
