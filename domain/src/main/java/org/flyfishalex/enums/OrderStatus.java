package org.flyfishalex.enums;

public enum  OrderStatus {
    BASKET(0, "в корзине"),
    CHECKING(1, "В обработке"),
    PAY(2, "Готов к оплате"),
    PAYED(3, "Оплачен");

    private final int code;

    private final String message;

    private OrderStatus(int code, final String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static OrderStatus getOrderStatus(int code) {
        for (OrderStatus c : OrderStatus.values()) {
            if (c.code==code) {
                return c;
            }
        }
        return  BASKET;
    }
}
