package org.flyfishalex.model;

/**
 * Created by arusov on 17.04.2015.
 */
public enum  Lang {

    RU("ru"),
    EN("en");
    private final String lang;

    private Lang(final String lang) {
        this.lang = lang;
    }
    public String getCode() {
        return lang;
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
