<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/resources/css/global.css"/> ">
    <link rel="stylesheet" href="<c:url value="/resources/css/header.css"/> ">
    <link rel="stylesheet" href="<c:url value="/resources/css/product.css"/> ">
    <link rel="stylesheet" href="<c:url value="/resources/css/footer.css"/> ">
    <link rel="stylesheet" href="<c:url value="/resources/css/menu.css"/> ">
    <title>???TODO</title>
</head>
<body>

<jsp:include page="${lang}/header.jsp"/>
<div id="container">
    <jsp:include page="menu.jsp"/>
    <div id="product">
        <c:if test="${not empty product}">


            <div id="product-info">
                <div id="product-images">
                    <div class="product-image">
                        <img src="http://localhost:8080/flyfishalex/resources/images/nofoto.png">
                    </div>
                    <div class="product-image">
                        <img src="http://localhost:8080/flyfishalex/resources/images/nofoto.png">
                    </div>
                    <div class="product-image">
                        <img src="http://localhost:8080/flyfishalex/resources/images/nofoto.png">
                    </div>
                    <div class="product-image">
                        <img src="http://localhost:8080/flyfishalex/resources/images/nofoto.png">
                    </div>
                </div>
                <div id="product-price-variant">
                    <h1>${product.name}</h1>

                    <div id="product-variant">
                        <c:if test="${not empty variants}">
                            <c:forEach items="${variants}" var="variant">
                                <div class="product-variant">
                                    <h2>${variant.description} <span> ${variant.price}</span> <span> В корзину</span>
                                </h2></div>
                            </c:forEach>
                        </c:if>
                    </div>
                </div>
            </div>
            <div id="product-description">
                <article>
                    Looking for a new best friend for ventures out on the water? Looking for that ultimate all-round
                    fishing tool? Looking for an extra light (for example 9’ #5 weighs only 72 g), kick-ass rod that
                    makes your friends drool over it? Look no further. The new three piece medium action Extreme rod is
                    the answer for your quest. The perfect combination of lightness, power, sensitivity and looks in one
                    elegant package. The go-to rod series for trout, grayling, salmon or whatever swims in your rivers.
                    The smaller sizes will provide you a light and sensitive rod for your dry fly and nymph fishing,
                    with enough power from the butt of the rod to fight the elements even in the most confined spaces.
                    The bigger sizes are THE choices for streamer fishing and fishing for salmon with a single handed
                    rod. These rods have the extreme action for single handed Spey casts. Manufactured from the
                    top-of-the-line graphite and equipped with the best possible components money can buy (reel seats,
                    handles, snakes) this deep-blue beauty is ready for action. The rod is delivered in a protective
                    aluminum tube along with a cloth. And you thought that money can’t buy you a (fishing) friend.
                    Looking for a new best friend for ventures out on the water? Looking for that ultimate all-round
                    fishing tool? Looking for an extra light (for example 9’ #5 weighs only 72 g), kick-ass rod that
                    makes your friends drool over it? Look no further. The new three piece medium action Extreme rod is
                    the answer for your quest. The perfect combination of lightness, power, sensitivity and looks in one
                    elegant package. The go-to rod series for trout, grayling, salmon or whatever swims in your rivers.
                    The smaller sizes will provide you a light and sensitive rod for your dry fly and nymph fishing,
                    with enough power from the butt of the rod to fight the elements even in the most confined spaces.
                    The bigger sizes are THE choices for streamer fishing and fishing for salmon with a single handed
                    rod. These rods have the extreme action for single handed Spey casts. Manufactured from the
                    top-of-the-line graphite and equipped with the best possible components money can buy (reel seats,
                    handles, snakes) this deep-blue beauty is ready for action. The rod is delivered in a protective
                    aluminum tube along with a cloth. And you thought that money can’t buy you a (fishing) friend.
                </article>
            </div>
        </c:if>
    </div>

</div>


</body>
</html>
