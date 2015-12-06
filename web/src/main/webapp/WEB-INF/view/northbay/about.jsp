<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/northbay/global.css"/>">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/northbay/header.css"/>">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/northbay/footer.css"/>">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/northbay/article.css"/>">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/northbay/menu.css"/>">
    <script type="text/javascript" src="<c:url value="${lang.resources}/resources/js/jquery-2.1.4.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="${lang.resources}/resources/js/registration.js"/>"></script>
    <title>О магазине northbay</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="../vision/verticalMenu.jsp"/>

<div id="container">
    <p>Интернет-магазин рыболовных товаров со всего мира <a href="http://northbay.ru">northbay.ru</a> - нас рекомендуют.
    </p>

    <p>
        Приветствуем Вас и добро пожаловать в нашем интернет-магазин рыболовных товаров <a href="http://northbay.ru">northbay.ru</a>.
        Представляем Вашему
        вниманию широчайший ассортимент рыболовных товаров на любой вкус: снасти,
        экипировку, приманки, снаряжение, лодки, катамараны и большой выбор аксессуаров.
    </p>

    <p>В нашем интернет-магазине <a href="http://northbay.ru">northbay.ru</a> найдут товары даже самые изощренные
        рыболовы, у нас есть все для рыбалки,
        туризма и активного отдыха от ведущих мировых брендов: удочки, катушки, спиннинги, фидеры,
        все для зимней рыбалки, одежда, обувь, палатки, ледорубы, мормышки, силиконовые приманки, блесна, воблеры,
        нахлыстовые мушки и многое другое.</p>

    <p>В магазине работают исключительно практикующие рыболовы и туристы, поэтому весь наш ассортимент подобран
        исключительно с учетом самых требовательных покупателей. Разумные цены, быстрая доставка
        не только по Санкт -Петербургу, но и по Всей России.</p>

    <p>Почему рекомнедуют рыболовный интернет-магазин <a href="http://northbay.ru">northbay.ru</a> - большой ассортимент
        товара, хорошие цены, постоянные
        скидочные акции на тот или иной товар, отдельное поощрение постоянных покупателей,
        контроль посылки до момента получения. Мы рекомендуем только проверенный товар, грамотные консультанты помогут
        сделать правильный выбор, возможность получать рассылку по акциям и новинкам только по интересующей</p>
    Вас теме.

    <p>Ассортимент интернет-магазина <a href="http://northbay.ru">northbay.ru</a> для любителей: нахлыста, поплавочной
        удочки, спиннинговой ловли, донной
        рыбалки, морской рыбалки, фидера, троллинга, тенкары, зиней рыбалки. Мы против сетей и электроудочек,
        поэтому в нашем магазине любители данного развлечния ни чего не найдут.</p>

    <p>Ждем Вас в нашем магазине, с наилучшими пожеланиями и незабываемых Вам трофеев!</p>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
