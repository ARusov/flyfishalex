<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="menu">
    <ul id="menu-nav">
        <li class="menu-item-top">
            <a href="${lang.context}">${catalogue}</a>
        </li>
        <c:if test="${not empty rootCategories}">
            <c:forEach var="rootCategory" items="${rootCategories}">
                <li class="menu-item">
                    <a href="${lang.context}/category/${rootCategory.id}">${rootCategory.text}</a>
                </li>
                <c:choose>
                    <c:when test="${not empty parentCategories}">
                        <c:if test="${parentCategories[0].parent==rootCategory.id}">
                            <c:set var="i" value="${2}"/>
                            <c:forEach items="${parentCategories}" var="parentCategory">
                                <li class="menu-item">
                                    <a class="menu-item-${i}"
                                       href="${lang.context}/category/${parentCategory.id}">${parentCategory.text}</a>
                                </li>
                                <c:if test="${not empty parent}">
                                    <c:if test="${parent.id==parentCategory.id}">
                                        <c:forEach items="${categories}" var="category">
                                            <li class="menu-item">
                                                <a class="menu-item-${i+1}"
                                                   href="${lang.context}/category/${category.id}">${category.text}</a>
                                            </li>
                                        </c:forEach>
                                    </c:if>
                                </c:if>
                                <c:set var="i" value="${i+1}"/>
                            </c:forEach>
                        </c:if>
                    </c:when>
                    <c:otherwise>
                        <c:if test="${not empty parent}">
                            <c:if test="${parent.id==rootCategory.id}">
                                <c:forEach items="${categories}" var="category">
                                    <li class="menu-item">
                                        <a class="menu-item-2"
                                           href="${lang.context}/category/${category.id}">${category.text}</a>
                                    </li>
                                </c:forEach>
                            </c:if>
                        </c:if>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </c:if>
    </ul>
</div>