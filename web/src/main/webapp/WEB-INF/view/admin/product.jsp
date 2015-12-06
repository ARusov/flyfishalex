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
        <form:form commandName="product" method="post" action="${lang.context}/admin/products/product/${product.id}">
            <p><form:hidden path="id"/></p>

            <p>Наименование: <form:input path="name"/></p>

            <p>Наименование англ<form:input path="nameEn"/></p>

            <p>Описание: <form:textarea path="description"/></p>

            <p>Описание англ: <form:textarea path="descriptionEn"/></p>

            <p>Поставшик: <form:input path="provider"/></p>

            <p>Адрес (пока не трогать)<form:input path="url" disabled="true"/></p>

            <p>Категория: <form:select path="categoryId" id="id" items="${categories}"
                                       itemValue="id" itemLabel="name"/></p>

            <form:checkboxes path="stores" items="${stores}" itemValue="id" itemLabel="lang"/>

            <p><input type="submit" value="Добавить/Изменить"/></p>
        </form:form>
        <form method="post" action="${lang.context}/admin/products/product/${product.id}/uploadImage" enctype="multipart/form-data">
            File to upload: <input type="file" name="file"/>
            <input type="submit"value="Upload"/>
        </form>
        <img src="http://images.visionfishing.ru/products/${product.id}/${product.image}"/>
        <div id="variants">
            <c:if test="${not empty variants}">
                <c:forEach items="${variants}" var="variant">
                    <div class="variant">
                        <form id="variant" action="${lang.context}/admin/products/product/${product.id}/variant"
                              method="post">
                            <input name="id" value="${variant.id}" path="id"/>
                            <input name="description" value="${variant.description}"/>
                            <input name="count" value="${variant.count}"/>
                            <input type="submit" value="Add/Save"/>
                        </form>
                    </div>
                </c:forEach>
            </c:if>
            <div class="variant">
                <form:form commandName="newVariant" action="./${product.id}/variant" method="post">
                    <form:input path="id"/>
                    <form:input path="description"/>
                    <input name="count" value="${variant.count}"/>
                    <input type="submit" value="Add/Save"/>
                </form:form>
            </div>
        </div>
    </c:if>
</div>
</body>
</html>
