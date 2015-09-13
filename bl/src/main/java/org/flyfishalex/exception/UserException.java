package org.flyfishalex.exception;

import org.flyfishalex.enums.Lang;

/**
 * Created by arusov on 24.05.2015.
 */
public class UserException extends RuntimeException {
    private Lang lang;
    public UserException(String message, Lang lang) {
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
