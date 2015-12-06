<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/en/header.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/en/global.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/en/product.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/en/footer.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/en/menu.css"/> ">
    <script src="<c:url value="${lang.resources}/resources/js/jquery-1.11.2.min.js"/> "></script>
    <script src="<c:url value="${lang.resources}/resources/js/product.js"/>"></script>
    <title>${product.name} в магазине en Fishing</title>
</head>
<body>

<jsp:include page="header.jsp"/>
<jsp:include page="verticalMenu.jsp"/>
<div id="container">
    <div id="product">
        <c:if test="${not empty product}">
            <table>
                <tr>
                    <td style="width: 20%; vertical-align: top">
                        <div id="product-images">
                                <%--<c:forEach items="${product.images}" var="image">--%>
                            <div class="product-image">
                                <c:choose>
                                    <c:when test="${not empty product.image}">
                                        <img width="300px" src="http://images.enfishing.ru/products/${product.id}/${product.image}">
                                    </c:when>
                                    <c:otherwise>
                                        <img src="${lang.resources}/resources/images/nophoto_en.png">
                                    </c:otherwise>
                                </c:choose>
                            </div>
                                <%--</c:forEach>--%>
                        </div>
                    </td>
                    <td style="width: 70%; vertical-align: top">
                        <h1>${product.name}
                            <c:if test="${user.role=='ROLE_ADMIN'}">
                                <a href="${lang.context}/admin/products/product/${product.id}"> В админку</a>
                            </c:if>
                        </h1>

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
                    <table>
                        <c:forEach items="${variants}" var="variant">
                            <tr>
                                <td align="left" width="65%">${variant.description}</td>
                                <td align="right" width="15%">${variant.price}<span><img
                                        src="${lang.resources}/resources/images/rub.png"></span>
                                <td align="center" width="20%">
                                    <c:choose>
                                        <c:when test="${variant.count>0}">
                                            <div class="product-variant-link">
                                                <a href="${lang.context}/user/basket/${variant.id}"
                                                   name="${variant.id}">В корзину</a>
                                            </div>
                                        </c:when>
                                        <c:otherwise>
                                            <div class="product-variant-link">
                                                <a name="${variant.id}">Нет в наличии</a>
                                            </div>
                                        </c:otherwise>
                                    </c:choose></td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:if>
            </div>
        </c:if>
    </div>

</div>

<jsp:include page="footer.jsp"/>
</body>
</html>
