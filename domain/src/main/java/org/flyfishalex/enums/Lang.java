package org.flyfishalex.enums;

/**
 * Created by arusov on 17.04.2015.
 */
public enum Lang {

    RU(1, "ru", "http://flyfishalex.com", "http://resources.flyfishalex.com"),
//    EN(2, "en", "http://flyfishalex.com", "http://resources.flyfishalex.com"),
    EN(2, "en", "http://localhost:8080/flyfishalex/en", "http://localhost:8080/flyfishalex"),
        NORTHBAY(3, "northbay", "http://northbay.ru", "http://resources.northbay.ru"),
//    NORTHBAY(3, "northbay", "http://localhost:8080/flyfishalex/northbay", "http://localhost:8080/flyfishalex"),
        VISION(4, "vision", "http://visionfishing.ru", "http://resources.visionfishing.ru");
//    VISION(4, "vision", "http://localhost:8080/flyfishalex/vision", "http://localhost:8080/flyfishalex");
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

    public static Lang getLang(String langCode) {
        for (Lang c : Lang.values()) {
            if (c.lang.equals(langCode)) {
                return c;
            }
        }
        return RU;
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
}
