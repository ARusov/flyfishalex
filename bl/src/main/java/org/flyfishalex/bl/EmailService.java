package org.flyfishalex.bl;


import org.flyfishalex.enums.OrderStatus;
import org.flyfishalex.model.Order;
import org.flyfishalex.model.OrderPoint;
import org.flyfishalex.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.text.MessageFormat;
import java.util.List;
import java.util.Properties;

/**
 * Created by arusov on 14.08.2015.
 */
@Service
public class EmailService {
    private static final String REGISTRATION = "Спасибо за регистрацию";
    private static final String CHANGE_STATUS = "Изменение статуса заказа";
    private static final String NEW_ORDER = "Новый заказ";
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    public void sendEmailRegistration(User user) {
        sendEmail(user.getEmail(), REGISTRATION, getMessageRegistration(user));
    }

    public void sendEmailChangeStatus(User user, Order currentOrder, OrderStatus orderStatus) {
        sendEmail(user.getEmail(), CHANGE_STATUS, getMessageChangeStatus(user, currentOrder, orderStatus));
    }

    public void sendEmailNewOrder(User user, Order order, List<OrderPoint> orderPoints) {
        sendEmail(user.getEmail(), NEW_ORDER, getMessageNewOrder(user, order, orderPoints));
    }

    private void sendEmail(String email, String subject, String text) {
        Properties props = new Properties();
//        props.put("mail.debug", "true");
        props.put("mail.smtp.host", "smtp.yandex.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        Session session = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("northbay", "R123!#%r"); //логин и пароль для аутентификации на сервере
                    }
                });
        try {
            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress("northbay@yandex.ru")); //откуда отправляю письмо
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(email)); //куда  отправляется письмо
            message.setRecipient(Message.RecipientType.CC, new InternetAddress("northbay@yandex.ru")); //куда  отправляется письмо
            message.setContent(text, "text/html; charset=utf-8");
            message.setSubject(subject);     //тема письма
            Transport.send(message);
            LOGGER.debug("Message has been sent to {}", email);
        } catch (MessagingException e) {
            LOGGER.warn("Message has not been sent to {} , error {}", email, e.getMessage());
        }
    }

    private String getMessageRegistration(User user) {
        StringBuilder sb = new StringBuilder();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<meta http-equiv=Content-Type content=\"text/html; charset=UTF-8\">");
        sb.append("</head>");
        sb.append("<body lang=RU link=blue vlink=purple style='tab-interval:36.0pt'>");
        sb.append("<div class=WordSection1>");
        sb.append("<p><span>Уважемый(ая), {0}!</span></p>");
        sb.append("<p><span>Спасибо, что зарегистрировались у нас! </span></p>");
        sb.append("<p><span>Ваш логин {1}</span></p>");
        sb.append("<p><span>Перейдите по ссылке {2}, чтобы подвердить Вашу электронную почту </span></p>");
        addSignature(sb);
        sb.append("</div>");
        sb.append("</body>");
        sb.append("</html>");
        String result = MessageFormat.format(sb.toString(), user.getName(),
                user.getEmail(), "http://northbay.ru/user/confirm?id=" + user.getUuid());
        return result;
    }

    private String getMessageNewOrder(User user, Order order, List<OrderPoint> orderPoints) {
        StringBuilder sb = new StringBuilder();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<meta http-equiv=Content-Type content=\"text/html; charset=UTF-8\">");
        sb.append("</head>");
        sb.append("<body lang=RU link=blue vlink=purple style='tab-interval:36.0pt'>");
        sb.append("<div class=WordSection1>");
        sb.append("<p><span>Уважемый(ая), {0}!</span></p>");
        sb.append("<p><span>Спасибо, за заказ </span></p>");
        sb.append("<p><span>Номер Вашего заказа: {1}</span></p>");
        sb.append("<p><span>Стоимость заказа: {2}</span></p>");
        sb.append("<p><span>Стоимость доставки: {3}</span></p>");
        sb.append("<p><span>Общая стоимость : {4}</span></p>");
        sb.append("<p><span>Ваш Заказ:</span></p>");
        sb.append("<table>");
        sb.append("<tr>");
        sb.append("<th>Наименование</th>");
        sb.append("<th>Количество</th>");
        sb.append("<th>Цена</th>");
        sb.append("<th>Сумма</th>");
        sb.append("</tr>");
        for (OrderPoint point : orderPoints) {
            sb.append("<tr>");
            sb.append("<td>");
            sb.append(point.getDescription());
            sb.append("</td>");
            sb.append("<td>");
            sb.append(point.getCount());
            sb.append("</td>");
            sb.append("<td>");
            sb.append(point.getPrice());
            sb.append("</td>");
            sb.append("<td>");
            sb.append(point.getPrice() * point.getCount());
            sb.append("</td>");
            sb.append("</tr>");
        }
        sb.append("</table>");
        addSignature(sb);
        sb.append("</div>");
        sb.append("</body>");
        sb.append("</html>");
        String result = MessageFormat.format(sb.toString(), user.getName(), order.getId(), order.getFinalPrice(), order.getDeliveryPrice(), order.getFinalPrice() + order.getDeliveryPrice());
        return result;
    }

    private String getMessageChangeStatus(User user, Order order, OrderStatus status) {
        StringBuilder sb = new StringBuilder();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<meta http-equiv=Content-Type content=\"text/html; charset=UTF-8\">");
        sb.append("</head>");
        sb.append("<body lang=RU link=blue vlink=purple style='tab-interval:36.0pt'>");
        sb.append("<div class=WordSection1>");
        sb.append("<p><span>Уважемый(ая), {0}!</span></p>");
        sb.append("<p><span>Статус Вашего заказа номер <b>{1}</b> изменился на \"{2}\" </span></p>");
        addSignature(sb);
        sb.append("</div>");
        sb.append("</body>");
        sb.append("</html>");
        String result = MessageFormat.format(sb.toString(), user.getName(), order.getId(), status.getMessage());
        return result;
    }

    private void addSignature(StringBuilder sb) {
        sb.append("<p><span>Спасибо, что Вы с нами!</span></p>");
        sb.append("<p><span>Команда <a href=\"http://northbay.ru\">northbay.ru</a></span></p>");

    }


}
