package org.flyfishalex.controller.exception;

import org.flyfishalex.enums.Lang;

public class UserNotFoundException extends RuntimeException {

    private Lang lang;

    public UserNotFoundException(String message, Lang lang) {
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
