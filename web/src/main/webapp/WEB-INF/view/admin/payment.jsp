<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<div id="payments">
    <c:if test="${not empty payments}">
        <table>
            <c:forEach items="${payments}" var="payment">
                <tr>
                    <td>${payment.id}</td>
                    <td>${payment.description}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>
<div id="payment">
    <form:form commandName="payment" method="post">
        <form:input path="description"/>
        <input type="submit" value="Save"/>
    </form:form>
</div>

</body>
</html>
