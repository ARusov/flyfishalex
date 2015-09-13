<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/global.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/header.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/category.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/footer.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/menu.css"/> ">
    <script type="text/javascript" src="<c:url value="${lang.resources}/resources/js/jquery-2.1.4.min.js"/>"></script>
    <title>Магазин</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<jsp:include page="${lang.lang}/header.jsp"/>
<jsp:include page="verticalMenu.jsp"/>
<div id="container">
    <c:set var="itemsClass" value="full"/>
    <c:if test="${not empty categories}">
        <jsp:include page="menu.jsp"/>
        <c:set var="itemsClass" value="short"/>
    </c:if>

    <div id="items" class="${itemsClass}">
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
        <c:forEach var="product" items="${products}">
            <div class="item">
                <div class="item-image">
                    <a href="${lang.context}/product/${product.id}"><img
                            src="${lang.resources}/resources/images/nofoto.png"></a>
                </div>
                <a href="${lang.context}/product/${product.id}">${product.name}</a>
            </div>
        </c:forEach>
    </div>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
