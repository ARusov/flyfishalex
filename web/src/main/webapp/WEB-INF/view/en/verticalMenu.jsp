<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

</script>
<div id="verticalMenu">
<ul id="jMenu">
<li class="vMenu">
<a href="${lang.context}">Главная</a>
</li>
<c:if test="${not empty rootCategories}">
    <c:forEach items="${rootCategories}" var="rootCategory">
        <li class="vMenu">
        <a href="${lang.context}/category/${rootCategory.id}">${rootCategory.text}</a>
        </li>
    </c:forEach>
</c:if>
</ul>
</div>