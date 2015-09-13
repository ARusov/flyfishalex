package org.flyfishalex.controller.exception;

import org.flyfishalex.enums.Lang;

public class OrderNotFoundException extends RuntimeException {

    private Lang lang;

    public OrderNotFoundException(String message, Lang lang) {
        super(message);
        this.lang = lang;

    }

    public Lang getLang() {
        return lang;
    }

    public void setLang(Lang lang) {
        this.lang = lang;
    }
}
