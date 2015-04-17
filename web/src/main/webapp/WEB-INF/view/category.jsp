<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <link rel="stylesheet" href="<c:url value="/resources/css/global.css"/> ">
    <link rel="stylesheet" href="<c:url value="/resources/css/header.css"/> ">
    <link rel="stylesheet" href="<c:url value="/resources/css/category.css"/> ">
    <link rel="stylesheet" href="<c:url value="/resources/css/footer.css"/> ">
    <link rel="stylesheet" href="<c:url value="/resources/css/menu.css"/> ">
    <title>Магазин</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>


<jsp:include page="header.jsp"/>
<div id="container">
    <jsp:include page="menu.jsp"/>
    <div id="items">
        <%--categories--%>
        <c:if test="${not empty categories}">
            <c:forEach var="category" items="${categories}">
                <div class="item">
                    <div class="item-image">
                        <a><img src="http://localhost:8080/flyfishalex/resources/images/nofoto.png"></a>
                    </div>
                    <span><a href="${env}/category/${category.id}">${category.name}</a></span>
                </div>
            </c:forEach>
        </c:if>
        <%--products--%>
        <c:if test="${not empty products}">
            <c:forEach var="product" items="${products}">
                <div class="item">
                    <span><a href="${env}/product/${product.id}">${product.name}</a></span>
                </div>
            </c:forEach>
        </c:if>

    </div>
</div>
<%--<div id="footer"></div>--%>
</body>
</html>
