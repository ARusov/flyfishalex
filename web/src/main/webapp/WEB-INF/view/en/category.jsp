<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="random" class="java.util.Random" scope="application" />

<html>
<head>
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/en/global.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/en/header.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/en/category.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/en/footer.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/en/menu.css"/> ">
    <script type="text/javascript" src="<c:url value="${lang.resources}/resources/js/jquery-2.1.4.min.js"/>"></script>
    <title>Магазин</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="verticalMenu.jsp"/>
<div id="container">
    <div id="image">
        <a href="${lang.context}/category/${category.id}"><img src="http://images.enfishing.ru/en/carousel/image_carousel_${random.nextInt(3)+1}.jpg"></a>
    </div>
    <div id="items" class="${itemsClass}">
        <h1>${category.name} на <a href="${lang.context}">en Fishing</a></h1>
                <%--products--%>
        <c:forEach var="product" items="${products}">
            <div class="item">
                <div class="item-image">
                    <c:choose>
                        <c:when test="${not empty product.image}">
                            <a href="${lang.context}/product/${product.id}"><img
                                    src="http://images.enfishing.ru/products/${product.id}/${product.image}" width="170px"></a>
                        </c:when>
                        <c:otherwise>
                            <a href="${lang.context}/product/${product.id}"><img
                                    src="${lang.resources}/resources/images/nophoto_en.png"></a>
                        </c:otherwise>
                    </c:choose>


                </div>
                <a href="${lang.context}/product/${product.id}">${product.name}</a>
            </div>
        </c:forEach>
    </div>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
