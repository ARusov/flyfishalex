<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/header.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/global.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/product.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/footer.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/menu.css"/> ">
    <script src="<c:url value="${lang.resources}/resources/js/jquery-1.11.2.min.js"/> "></script>
    <script src="<c:url value="${lang.resources}/resources/js/product.js"/>"></script>
    <title>Магазин ${lang.context} купить ${product.name}</title>
</head>
<body>

<jsp:include page="${lang.lang}/header.jsp"/>
<jsp:include page="verticalMenu.jsp"/>
<div id="container">
    <div id="product">
        <c:if test="${not empty product}">
            <table>
                <tr>
                    <td style="width: 20%; vertical-align: top">
                        <div id="product-images">
                            <c:forEach items="${product.images}" var="image">
                                <div class="product-image">
                                    <img src="${image}">
                                </div>
                            </c:forEach>
                        </div>
                    </td>
                    <td style="width: 70%; vertical-align: top">
                        <h1>${product.name}</h1>

                        <div id="product-description">
                            <article>
                                    ${product.description}
                            </article>
                        </div>
                    </td>
                </tr>
            </table>
            <div id="product-variant">
                <c:if test="${not empty variants}">
                    <c:forEach items="${variants}" var="variant">
                        <div class="product-variant">
                            <h2>${variant.description}<span>${variant.price}  <img
                                    src="${lang.resources}/resources/images/rub.png"></span>
                                <c:choose>
                                    <c:when test="${variant.count>0}">
                                        <a href="${lang.context}/user/basket/${variant.id}"
                                           class="product-variant-link" name="${variant.id}">В корзину</a>
                                    </c:when>
                                    <c:otherwise>
                                        <a class="product-variant-order" name="${variant.id}">Сообщить о
                                            наличии</a>
                                    </c:otherwise>
                                </c:choose>

                            </h2>
                        </div>
                    </c:forEach>
                </c:if>
            </div>
        </c:if>
    </div>

</div>

<jsp:include page="footer.jsp"/>
</body>
</html>
