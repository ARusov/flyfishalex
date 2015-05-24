<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title></title>
</head>
<body>
<div>
    <c:if test="${not empty product}">
        <form:form commandName="product" method="post">
            <p><form:hidden path="id"/></p>

            <p>Наименование: <form:input path="name"/></p>

            <p>Наименование англ<form:input path="nameEn"/></p>

            <p>Описание: <form:textarea path="description"/></p>

            <p>Описание англ: <form:textarea path="descriptionEn"/></p>

            <p>Поставшик: <form:input path="provider"/></p>

            <p>Адрес (пока не трогать)<form:input path="url" disabled="true"/></p>

            <p>Категория: <form:select path="categoryId" id="id" items="${categories}"
                                       itemValue="id" itemLabel="name"/></p>

            <p>Показывать на RU: <form:checkbox path="ru"/></p>

            <p>Показывать на COM: <form:checkbox path="en"/></p>

            <p><input type="submit" value="Добавить/Изменить"/></p>
        </form:form>
        <div id="variants">
            <c:if test="${not empty variants}">
                <c:forEach items="${variants}" var="variant">
                    <div class="variant">
                        <form id="variant" action="./${product.id}/variant" method="post">
                            <input name="id" value="${variant.id}" path="id"/>
                            <input name="description" value="${variant.description}"/>
                            <input type="submit" value="Add/Save"/>
                        </form>
                    </div>
                </c:forEach>

            </c:if>
            <div class="variant">
                <form:form commandName="newVariant" action="./${product.id}/variant" method="post">
                    <form:input path="id"/>
                    <form:input path="description"/>
                    <input type="submit" value="Add/Save"/>
                </form:form>
            </div>
        </div>
    </c:if>
</div>
</body>
</html>
