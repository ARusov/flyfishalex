<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<div id="deliveries">
    <c:if test="${not empty deliveries}">
        <table>
            <c:forEach items="${deliveries}" var="delivery">
                <tr>
                    <td>${delivery.id}</td>
                    <td>${delivery.description}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>
<div id="delivery">
    <form:form commandName="delivery" method="post">
        <form:input path="description"/>
        <input type="submit" value="Save"/>
    </form:form>
</div>

</body>
</html>
