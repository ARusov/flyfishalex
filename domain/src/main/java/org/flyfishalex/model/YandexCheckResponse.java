package org.flyfishalex.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Calendar;

/**
 * Created by arusov on 07.08.2015.
 */
@XmlRootElement(name = "checkOrderResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class YandexCheckResponse {

    @XmlAttribute(name = "performedDatetime")
    private String performedDatetime;
    @XmlAttribute
    private int code;
    @XmlAttribute
    private String shopId;
    @XmlAttribute
    private String invoiceId; //Идентификатор транзакции в ИС Оператора. Должен дублировать поле invoiceId запроса.
    @XmlAttribute
    private String orderSumAmount;
    @XmlAttribute
    private String message;
    @XmlAttribute
    private String techMessage;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getOrderSumAmount() {
        return orderSumAmount;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }


    public void setOrderSumAmount(String orderSumAmount) {
        this.orderSumAmount = orderSumAmount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTechMessage() {
        return techMessage;
    }

    public void setTechMessage(String techMessage) {
        this.techMessage = techMessage;
    }

    public String getPerformedDatetime() {
        return performedDatetime;
    }

    public void setPerformedDatetime(String performedDatetime) {
        this.performedDatetime = performedDatetime;
    }
}
