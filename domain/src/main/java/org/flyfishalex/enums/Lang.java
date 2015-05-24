package org.flyfishalex.enums;

/**
 * Created by arusov on 17.04.2015.
 */
public enum Lang {

    //    RU("ru","http://flyfishalex.ru"),
    RU("ru", "http://localhost:8080/flyfishalex/ru"),
    EN("en", "http://flyfishalex.com");
    private final String lang;
    private final String context;

    private Lang(final String lang, String context) {
        this.lang = lang;
        this.context = context;
    }

    public String getCode() {
        return lang;
    }

    public String getContext() {
        return context;
    }

    public static Lang getLang(String langCode) {
        for (Lang c : Lang.values()) {
            if (c.lang.equals(langCode)) {
                return c;
            }
        }
        return RU;
    }
}
