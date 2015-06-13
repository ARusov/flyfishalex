<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <link rel="stylesheet" href="<c:url value="/resources/css/global.css"/> ">
    <link rel="stylesheet" href="<c:url value="/resources/css/header.css"/> ">
    <link rel="stylesheet" href="<c:url value="/resources/css/footer.css"/> ">
    <title>Магазин</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<jsp:include page="${lang}/header.jsp"/>
<div id="orders">
    <c:if test="${not empty orders}">
        <table>
            <c:forEach items="${orders}" var="order">
                <tr>
                    <td>${order.id}</td>
                    <td>${order.status}</td>
                    <td>Подробнее</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>
</body>
</html>
