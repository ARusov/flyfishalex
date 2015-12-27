<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="now" class="java.util.Date"/>
<fmt:formatDate var="year" value="${now}" pattern="yyyy"/>


<div class="container text-muted" id="footer">
    <div class="container">
        <div class="row">
            <div class="col-xs-4 col-md-4">
                <ul>
                    <li><a href="${lang.context}/about" title="О рыболовном интернет магазине">О магазине</a></li>
                    <li><a href="${lang.context}" title="О рыболовном интернет магазине">Как сделать заказ?</a></li>
                    <li><a href="${lang.context}" title="Доставка рыболовных товаров">Доставка</a></li>
                    <li><a href="${lang.context}" title="Оплата">Оплата</a></li>
                </ul>
            </div>
            <div class="col-xs-4 col-md-4">
                <ul>
                    <li><span>Email:</span><a href="mailto:northbay@yandex.ru" title="Электронная почта">northbay@yandex.ru</a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-12 col-md-12">
                <p>РЫБОЛОВНЫЙ ИНТЕРЕТ МАГАЗИН. <a
                        href="http://northbay.ru/">NORTHBAY</a>. ВСЕ ПРАВА ЗАЩИЩЕНЫ &#169; ${year}.</p>
            </div>
        </div>
    </div>
    <!-- Yandex.Metrika counter -->
    <script type="text/javascript">
        (function (d, w, c) {
            (w[c] = w[c] || []).push(function () {
                try {
                    w.yaCounter32106869 = new Ya.Metrika({
                        id: 32106869,
                        clickmap: true,
                        trackLinks: true,
                        accurateTrackBounce: true
                    });
                } catch (e) {
                }
            });

            var n = d.getElementsByTagName("script")[0],
                    s = d.createElement("script"),
                    f = function () {
                        n.parentNode.insertBefore(s, n);
                    };
            s.type = "text/javascript";
            s.async = true;
            s.src = "https://mc.yandex.ru/metrika/watch.js";

            if (w.opera == "[object Opera]") {
                d.addEventListener("DOMContentLoaded", f, false);
            } else {
                f();
            }
        })(document, window, "yandex_metrika_callbacks");
    </script>
    <noscript>
        <div><img src="https://mc.yandex.ru/watch/32106869" style="position:absolute; left:-9999px;" alt=""/></div>
    </noscript>
    <!-- /Yandex.Metrika counter -->
</div>
