package org.flyfishalex.model;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by arusov on 2/23/2015.
 */
public class Product {

    private static final Map<String, String> letters = new HashMap<String, String>();
    public static String SPLIT = ";";


    private String articul;

    private String name;

    private int price;

    private String Type;

    private String variant;

    private String description = "";

    private String images = "";

    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getArticul() {
        return articul;
    }

    public void setArticul(String articul) {
        this.articul = articul;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        sb.append(getName1());
        sb.append(SPLIT);
        sb.append(getPrice());
        sb.append(SPLIT);
        sb.append(getType());
        sb.append(SPLIT);
        sb.append(getVariant());
        sb.append(SPLIT);
        sb.append(getDescription());
        sb.append(SPLIT);
        sb.append(getAddress());
        sb.append(SPLIT);
        sb.append(getImages());
        sb.append(SPLIT);
        sb.append(getDescription());
        sb.append(SPLIT);
        sb.append(getCount());
        sb.append("\n");
        return sb.toString();
    }

    public String getAddress() {
        return toTranslit(getName().toLowerCase());
    }


    static {
        letters.put("А", "A");
        letters.put("Б", "B");
        letters.put("В", "V");
        letters.put("Г", "G");
        letters.put("Д", "D");
        letters.put("Е", "E");
        letters.put("Ё", "E");
        letters.put("Ж", "ZH");
        letters.put("З", "Z");
        letters.put("И", "I");
        letters.put("Й", "I");
        letters.put("К", "K");
        letters.put("Л", "L");
        letters.put("М", "M");
        letters.put("Н", "N");
        letters.put("О", "O");
        letters.put("П", "P");
        letters.put("Р", "R");
        letters.put("С", "S");
        letters.put("Т", "T");
        letters.put("У", "U");
        letters.put("Ф", "F");
        letters.put("Х", "H");
        letters.put("Ц", "C");
        letters.put("Ч", "CH");
        letters.put("Ш", "SH");
        letters.put("Щ", "SH");
        letters.put("Ъ", "'");
        letters.put("Ы", "Y");
        letters.put("Ъ", "'");
        letters.put("Э", "E");
        letters.put("Ю", "U");
        letters.put("Я", "YA");
        letters.put("а", "a");
        letters.put("б", "b");
        letters.put("в", "v");
        letters.put("г", "g");
        letters.put("д", "d");
        letters.put("е", "e");
        letters.put("ё", "e");
        letters.put("ж", "zh");
        letters.put("з", "z");
        letters.put("и", "i");
        letters.put("й", "i");
        letters.put("к", "k");
        letters.put("л", "l");
        letters.put("м", "m");
        letters.put("н", "n");
        letters.put("о", "o");
        letters.put("п", "p");
        letters.put("р", "r");
        letters.put("с", "s");
        letters.put("т", "t");
        letters.put("у", "u");
        letters.put("ф", "f");
        letters.put("х", "h");
        letters.put("ц", "c");
        letters.put("ч", "ch");
        letters.put("ш", "sh");
        letters.put("щ", "sh");
        letters.put("ь", "");
        letters.put("ы", "y");
        letters.put("ъ", "");
        letters.put("э", "e");
        letters.put("ю", "u");
        letters.put("я", "ya");
        letters.put("(", "");
        letters.put(")", "");
        letters.put(".", "");
        letters.put(",", "");
        letters.put(" ", "-");
        letters.put("\"", "");
        letters.put("'", "");
        letters.put("«", "");
        letters.put("»", "");
    }


    public String toTranslit(String text) {
        StringBuilder sb = new StringBuilder(text.length());
        for (int i = 0; i < text.length(); i++) {
            String l = text.substring(i, i + 1);
            if (letters.containsKey(l)) {
                sb.append(letters.get(l));
            } else {
                sb.append(l);
            }
        }
        return sb.toString();
    }


    public String getName1() {
        return getName().replace("(", "").replace(")", "").replace(".", "").replace(",", "").replace("«", "").replace("»", "");
    }


}
