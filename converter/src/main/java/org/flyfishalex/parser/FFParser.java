package org.flyfishalex.parser;

import org.apache.poi.ss.usermodel.Row;
import org.flyfishalex.model.Product;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by arusov on 2/23/2015.
 */
public class FFParser extends XLSParser {
    public FFParser(File file) {
        super(file);
    }

    @Override
    public void convert() {
        Map<Integer, String> cat = new HashMap<Integer, String>();
        List<Product> output = new ArrayList<Product>();
        while (rows.hasNext()) {
            Row row = (Row) rows.next();
            if (row.getCell(0) != null) {
                if (!getCellValue(row.getCell(0)).isEmpty()) {
                    Integer ci = Integer.valueOf(getCellValue(row.getCell(0)).substring(0, 1));
                    cat.put(ci, getCellValue(row.getCell(1)).replace("(", "").replace(")", "").replace(".", "").replace(",", "").replace(",", "-"));
                    if (ci < cat.size()) {
                        for (int i = ci + 1; i <= 10; i++) {
                            cat.remove(i);
                        }
                    }
                }
            }
            if (row.getCell(0) == null || getCellValue(row.getCell(0)).isEmpty()) {
                String articul = getCellValue(row.getCell(2)).trim();
                Product model = new Product();
                model.setArticul(articul);
                try {
                    Double price = Double.parseDouble(getCellValue(row.getCell(8)).trim());
                    price = price * 0.99;
                    model.setPrice(price.intValue());
                } catch (NumberFormatException e) {
                    model.setPrice(0);
                }

                model.setVariant("\"" + getCellValue(row.getCell(3)).replaceAll("\u2122", "").replaceAll("\u00AE", "") + "\"");

                if (cat != null) {
                    String categ = catToString(cat);
                    String[] names = categ.split("/");
                    model.setName("\"" + names[names.length - 1]);
                    model.setType(categ.replaceAll("/" + names[names.length - 1], "") + "\"");

                }
                model.setDescription("\"Доставка в течение 3-5 дней\"");

                String count = getCellValue(row.getCell(4));
                try {
                    count = count.replaceAll("[^\\d]", "");
//                    count = count.replaceFirst(".*?(\\d+).*", "$1");
                    model.setCount(Integer.parseInt(count.trim()));
                } catch (NumberFormatException e) {
                    System.err.println(articul + " " + row.getRowNum());
                    e.printStackTrace();
                    model.setCount(0);
                }
                if (model.getCount() < 5) {
                    model.setCount(0);
                }

                output.add(model);
            }
        }
        System.out.println("ff");
        toFile(output, "ff");
    }


}
