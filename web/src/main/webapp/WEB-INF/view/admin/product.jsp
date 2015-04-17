<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title></title>
</head>
<body>
<div>
    <form:form commandName="product" method="post">
        <p><form:hidden path="id"/></p>

        <p>Наименование: <form:input path="name"/></p>

        <p>Наименование англ<form:input path="nameEn"/></p>

        <p>Описание: <form:textarea path="description"/></p>

        <p>Описание англ: <form:textarea path="descriptionEn"/></p>

        <p>Цена: <form:input path="price"/></p>

        <p>Цена евро: <form:input path="priceEuro"/></p>

        <p>Поставшик: <form:input path="provider"/></p>

        <p>Адрес (пока не трогать)<form:input path="url" disabled="true"/></p>

        <p>Категория: <form:select path="categoryId" id="id" items="${categories}"
                                   itemValue="id" itemLabel="name"/></p>

        <p>Количество: <form:input path="count"/></p>

        <p>Показывать на RU: <form:checkbox path="ru"/></p>

        <p>Показывать на COM: <form:checkbox path="en"/></p>

        <p><input type="submit" value="Добавить/Изменить"/></p>

    </form:form>
</div>
</body>
</html>
