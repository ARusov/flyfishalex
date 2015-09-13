package org.flyfishalex.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by arusov on 07.08.2015.
 */

public class YandexAvisoResponse {

    @XmlAttribute(name = "performedDatetime")
    private String performedDatetime;
    @XmlAttribute
    private int code;
    @XmlAttribute
    private String shopId;
    @XmlAttribute
    private String invoiceId; //Идентификатор транзакции в ИС Оператора. Должен дублировать поле invoiceId запроса.

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


    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }


    public String getPerformedDatetime() {
        return performedDatetime;
    }

    public void setPerformedDatetime(String performedDatetime) {
        this.performedDatetime = performedDatetime;
    }
}
