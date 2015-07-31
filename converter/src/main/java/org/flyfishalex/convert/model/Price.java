package org.flyfishalex.convert.model;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by arusov on 2/23/2015.
 */
public class Price {



    private static final Map<String, String> letters = new HashMap<String, String>();
    public static String SPLIT = ";";


    private String articul;

    private int price;

    private int count;


    public Price(String articul, int price, int count) {
        this.articul = articul;
        this.price = price;
        this.count = count;
    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getArticul() {
        return articul;
    }

    public void setArticul(String articul) {
        this.articul = articul;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getArticul());
        sb.append(SPLIT);
        sb.append(getPrice());
        sb.append(SPLIT);
        sb.append(getCount());
        sb.append("\n");
        return sb.toString();
    }








}
