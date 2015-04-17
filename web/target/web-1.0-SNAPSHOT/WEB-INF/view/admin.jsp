<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <link rel="stylesheet" href="<c:url value="/resources/css/admin.css"/> ">
    <link rel="stylesheet" href="<c:url value="/resources/css/global.css"/> ">
    <link rel="stylesheet" href="<c:url value="/resources/js/themes/default/style.min.css"/> ">


    <script src="<c:url value="/resources/js/jquery-1.11.2.min.js"/> "></script>
    <script src="<c:url value="/resources/js/jstree.min.js"/> "></script>
    <script src="<c:url value="/resources/js/admin.js"/>"></script>


    <title>Магазин</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<div id="container">
    <div id="tree">
    </div>

    <div id="category">
        <div>
            <form:form method="post" commandName="category"
                       action="http://localhost:8080/flyfishalex/ru/admin/category">
                <p>Идентификатор в базе данных: <form:input path="id"/></p>

                <p>Российское наименование: <form:input path="name"/></p>

                <p>Родительская категория: <form:select path="parentId" id="id" items="${categories}"
                                                        itemValue="id" itemLabel="name"/>
                </p>
                <input type="submit"/>
            </form:form>
        </div>
        <div>
            <input id="deleteCatogory" type="button" value="Удалить"/>
        </div>
    </div>
</div>
</body>
</html>