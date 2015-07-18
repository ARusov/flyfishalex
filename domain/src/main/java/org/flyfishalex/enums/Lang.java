package org.flyfishalex.enums;

/**
 * Created by arusov on 17.04.2015.
 */
public enum Lang {

        RU(1,"ru","http://flyfishalex.com","http://resources.flyfishalex.com"),
//    RU(1, "ru", "http://localhost:8080/flyfishalex/ru","http://localhost:8080/flyfishalex"),
    EN(2, "en", "http://flyfishalex.com","http://resources.flyfishalex.com"),
    NORTHBAY(3, "norhbay", "http://norhbay.ru","http://resources.norhbay.com");

    private final int id;
    private final String lang;
    private final String context;
    private final String resources;

    private Lang(int id, final String lang, String context, String resources) {
        this.id = id;
        this.lang = lang;
        this.context = context;
        this.resources = resources;
    }


    public String getContext() {
        return context;
    }

    public String getLang() {
        return lang;
    }

    public int getId() {
        return id;
    }

    public String getResources() {
        return resources;
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
