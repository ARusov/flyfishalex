<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/admin.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/global.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/menu.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/admin.css"/> ">
    <script type="text/javascript" src="<c:url value="${lang.resources}/resources/js/jquery-2.1.4.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="${lang.resources}/resources/js/admin.js"/>"></script>
    <title>Магазин</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<div id="container">
    <jsp:include page="menu.jsp"/>
    <div id="category">
        <div id="selectCategoryForm" class="invisible">
            <table id="selectCategoryTable">
                <c:forEach items="${allCategories}" var="category">
                    <tr>
                        <td>${category.id}</td>
                        <td>${category.name}</td>
                    </tr>
                </c:forEach>
            </table>
            <div><span id="selectCategoryFormClose">Close</span></div>
        </div>
        <div>
            <form:form method="post" commandName="category"
                       action="${lang.context}/admin/category">
                <p>Идентификатор в базе данных: <form:input path="id"/></p>

                <p>Российское наименование: <form:input path="name"/></p>

                <p>Родительская категория: <form:input path="parentId"/><span id="parentName">${parentCategory.name}</span> <a
                        id="selectCategory">...</a>
                </p>

                <form:checkboxes path="stores" items="${stores}" itemValue="id" itemLabel="lang"/>

                <p>Вендор <form:input path="vendorId"/></p>

                <input type="submit" value="Изменить/Добавить"/>
                <input id="deleteCatogory" type="button" value="Удалить"/>
            </form:form>

        </div>
    </div>
</div>
</body>
</html>
