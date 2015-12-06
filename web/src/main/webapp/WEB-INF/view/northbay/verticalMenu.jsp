<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
    $(document).ready(function () {
        $(".vMenu ul").addClass("invisible");
        $(".vMenu").mouseenter(function () {
            $(this).find("ul").removeClass("invisible")
        })
        $(".vMenu").mouseleave(function () {
            $(this).find("ul").addClass("invisible")
        })

    });
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
                    <c:if test="${not empty childCategories}">
                        <ul class="invisible">
                            <c:forEach items="${childCategories}" var="child">
                                <c:if test="${rootCategory.id==child.parent}">
                                    <li>
                                        <a href="${lang.context}/category/${child.id}">${child.text}</a>
                                    </li>
                                </c:if>

                            </c:forEach>
                        </ul>
                    </c:if>
                </li>
            </c:forEach>
        </c:if>
    </ul>
</div>