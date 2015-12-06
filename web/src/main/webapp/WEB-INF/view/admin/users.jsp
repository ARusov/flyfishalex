<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/global.css"/>"/>
    <title></title>
</head>
<body>

<div id="users">
    <c:if test="${not empty users}">
        <table>
            <c:forEach items="${users}" var="user">
                <form id="user" method="post" action="${lang.context}/admin/users">
                    <tr>
                        <td><input width="0" type="text" name="id" value="${user.id}" class="invisible"/>${user.id}</td>
                        <td>${user.name}</td>
                        <td>${user.email}</td>
                        <td><input type="text" name="role" value="${user.role}"/></td>
                        <td><input type="submit" value="Изменить"></td>
                    </tr>
                </form>
            </c:forEach>
        </table>
    </c:if>
</div>

</body>
</html>
