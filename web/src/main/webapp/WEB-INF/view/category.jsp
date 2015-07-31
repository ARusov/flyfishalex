<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/global.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/header.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/category.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/footer.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/menu.css"/> ">
    <title>Магазин</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<jsp:include page="${lang.lang}/header.jsp"/>
<div id="container">
    <jsp:include page="menu.jsp"/>
    <div id="items">
        <c:choose>
            <%--categories--%>
            <c:when test="${not empty categories}">
                <c:forEach var="category" items="${categories}">
                    <div class="item">
                        <div class="item-image">
                            <a><img src="${lang.resources}/resources/images/nofoto.png"></a>
                        </div>
                        <span><a href="${lang.context}/category/${category.id}">${category.text}</a></span>
                    </div>
                </c:forEach>
            </c:when>
            <%--products--%>
            <c:when test="${not empty products}">
                <c:forEach var="product" items="${products}">
                    <div class="item">
                        <div class="item-image">
                            <a><img src="${lang.resources}/resources/images/nofoto.png"></a>
                        </div>
                        <span><a href="${lang.context}/product/${product.id}">${product.name}</a></span>
                    </div>
                </c:forEach>
            </c:when>
        </c:choose>
    </div>
</div>
<%--<div id="footer"></div>--%>
</body>
</html>
