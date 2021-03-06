package org.flyfishalex.enums;

/**
 * Created by arusov on 22.07.2015.
 */
public enum  Provider {

    FLYFISHALEX(1, "FLYFISHALEX"),
    RYBOLOV(2, "RYBOLOV"),
    VISION(3, "VISION");

    private final int code;

    private final String message;

    private Provider(int code, final String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public static Provider getOrderStatus(int code) {
        for (Provider c : Provider.values()) {
            if (c.code==code) {
                return c;
            }
        }
        return  FLYFISHALEX;
    }
}
