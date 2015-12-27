<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="now" class="java.util.Date"/>
<fmt:formatDate var="year" value="${now}" pattern="yyyy"/>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="<c:url value="${lang.resources}/resources/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">
    <title>Интернет-магазин FlyFishAlex.ru</title>
</head>
<body>

<div class="container">
    <div class="navbar navbar-inverse navbar-static-top" role="navigation">
        <div class="navbar-header">
            <%--<a class="navbar-brand" href="http://flyfishalex.com">FlyFishAlex.ru</a>--%>
            <a class=" pull-left" href="${lang.context}"><img src="${lang.resources}/resources/images/logo_ru.png"></a>
        </div>
        <div class="collapse navbar-collapse bottom">
            <form class="navbar-form navbar-right" role="form">
                <div class="form-group">
                    <input type="text" placeholder="Email" class="form-control">
                </div>
                <div class="form-group">
                    <input type="password" placeholder="Password" class="form-control">
                </div>
                <button type="submit" class="btn btn-success">Войти</button>

            </form>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#contact">Оплата</a></li>
                <li><a href="#contact">Доставка</a></li>
            </ul>
        </div>
        <!--/.nav-collapse -->
    </div>
    <ul class="nav nav-tabs">
        <li class="active"><a href="http://flyfishalex.com">Главная</a></li>
        <li><a href="#about">Школа нахлыста</a></li>
        <li><a href="#contact">Блог</a></li>
        <li><a href="#contact">Рыболовные туры</a></li>
    </ul>

        <h1>Интернет-магазин FlyFishAlex.ru</h1>
    </div>
    <div class="row">
        <div class="navmenu navmenu-default navmenu-fixed-left col-xs-6 col-md-3">
            <a class="navmenu-brand visible-md visible-lg" href="#"><h2>Каталог</h2></a>
            <ul class="nav navmenu-nav">
                <li><h2><a href="">Экипирока нахлыстовика</a></h2></li>
                <li><h2><a href="">Снасти для нахлыста</a></h2></li>
                <li><h2><a href="">Материалы для вязания мух</a></h2></li>
            </ul>
        </div>
        <div class="col-xs-6 col-md-3 ">
            <a href="#" class="thumbnail">
                <img src="${lang.resources}/resources/images/nophoto_vision.png"/>

                <div class="caption center-block">
                    <h3 class="text-center">Название товара</h3>

                    <p>
                        <button type="button" class="lnk btn-xs btn-primary center-block">50000 р.</button>
                    </p>
                </div>
            </a>
        </div>
        <div class="col-xs-6 col-md-3 ">
            <a href="#" class="thumbnail">
                <img src="${lang.resources}/resources/images/nophoto_vision.png"/>

                <div class="caption center-block">
                    <h3 class="text-center">Название товара</h3>

                    <p>
                        <button type="button" class="lnk btn-xs btn-primary center-block">50000 р.</button>
                    </p>
                </div>
            </a>
        </div>
        <div class="col-xs-6 col-md-3 ">
            <a href="#" class="thumbnail">
                <img src="${lang.resources}/resources/images/nophoto_vision.png"/>

                <div class="caption center-block">
                    <h3 class="text-center">Название товара</h3>

                    <p>
                        <button type="button" class="lnk btn-xs btn-primary center-block">50000 р.</button>
                    </p>
                </div>
            </a>
        </div>
        <div class="col-xs-6 col-md-3 ">
            <a href="#" class="thumbnail">
                <img src="${lang.resources}/resources/images/nophoto_vision.png"/>

                <div class="caption center-block">
                    <h3 class="text-center">Название товара</h3>

                    <p>
                        <button type="button" class="lnk btn-xs btn-primary center-block">50000 р.</button>
                    </p>
                </div>
            </a>
        </div>
        <div class="col-xs-6 col-md-3 ">
            <a href="#" class="thumbnail">
                <img src="${lang.resources}/resources/images/nophoto_vision.png"/>

                <div class="caption center-block">
                    <h3 class="text-center">Название товара</h3>

                    <p>
                        <button type="button" class="lnk btn-xs btn-primary center-block">50000 р.</button>
                    </p>
                </div>
            </a>
        </div>
        <div class="col-xs-6 col-md-3 ">
            <a href="#" class="thumbnail">
                <img src="${lang.resources}/resources/images/nophoto_vision.png"/>

                <div class="caption center-block">
                    <h3 class="text-center">Название товара</h3>

                    <p>
                        <button type="button" class="lnk btn-xs btn-primary center-block">50000 р.</button>
                    </p>
                </div>
            </a>
        </div>
        <div class="col-xs-6 col-md-3 ">
            <a href="#" class="thumbnail">
                <img src="${lang.resources}/resources/images/nophoto_vision.png"/>

                <div class="caption center-block">
                    <h3 class="text-center">Название товара</h3>

                    <p>
                        <button type="button" class="lnk btn-xs btn-primary center-block">50000 р.</button>
                    </p>
                </div>
            </a>
        </div>
        <div class="col-xs-6 col-md-3 ">
            <a href="#" class="thumbnail">
                <img src="${lang.resources}/resources/images/nophoto_vision.png"/>

                <div class="caption center-block">
                    <h3 class="text-center">Название товара</h3>

                    <p>
                        <button type="button" class="lnk btn-xs btn-primary center-block">50000 р.</button>
                    </p>
                </div>
            </a>
        </div>
        <div class="col-xs-6 col-md-3 ">
            <a href="#" class="thumbnail">
                <img src="${lang.resources}/resources/images/nophoto_vision.png"/>

                <div class="caption center-block">
                    <h3 class="text-center">Название товара</h3>

                    <p>
                        <button type="button" class="lnk btn-xs btn-primary center-block">50000 р.</button>
                    </p>
                </div>
            </a>
        </div>
        <div class="col-xs-6 col-md-3 ">
            <a href="#" class="thumbnail">
                <img src="${lang.resources}/resources/images/nophoto_vision.png"/>

                <div class="caption center-block">
                    <h3 class="text-center">Название товара</h3>

                    <p>
                        <button type="button" class="lnk btn-xs btn-primary center-block">50000 р.</button>
                    </p>
                </div>
            </a>
        </div>
        <div class="col-xs-6 col-md-3 ">
            <a href="#" class="thumbnail">
                <img src="${lang.resources}/resources/images/nophoto_vision.png"/>

                <div class="caption center-block">
                    <h3 class="text-center">Название товара</h3>

                    <p>
                        <button type="button" class="lnk btn-xs btn-primary center-block">50000 р.</button>
                    </p>
                </div>
            </a>
        </div>
    </div>
</div>
<div id="footer">
    <div class="container text-muted">
        <div class="row">
            <p >РЫБОЛОВНЫЙ ИНТЕРЕТ МАГАЗИН. <a href="http://flyfishalex.ru">FlyFishAlex.ru</a>. ВСЕ
                ПРАВА ЗАЩИЩЕНЫ
                &#169; ${year}.</p>
        </div>
    </div>
</div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="<c:url value="${lang.resources}/resources/bootstrap/js/bootstrap.min.js"/>"></script>
</body>
</html>