package org.flyfishalex.parser;

import au.com.bytecode.opencsv.CSVReader;
import org.apache.poi.ss.usermodel.Row;
import org.flyfishalex.converter.Parser;
import org.flyfishalex.model.Product;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by arusov on 2/23/2015.
 */
public class VisionParser extends XLSParser {
    public VisionParser(File file) {
        super(file);
    }

    @Override
    public void convert() {
        try {
            CSVReader reader = new CSVReader(new FileReader("C:\\Projects\\flyfishalex\\converter\\input\\export.csv"), ';');
            List<String[]> allProducts = reader.readAll();
            Map<Integer, String> cat = new HashMap<Integer, String>();
            List<Product> output = new ArrayList<Product>();
            while (rows.hasNext()) {
                Row row = (Row) rows.next();
                if (row.getCell(0) == null || getCellValue(row.getCell(0)).isEmpty()) {

                    Integer ci = Integer.valueOf(getCellValue(row.getCell(8)).substring(0, 1));
                    cat.put(ci, getCellValue(row.getCell(2)).replace("(", "").replace(")", "").replace(".", "").replace(",", "").replace(",", "-"));
                    if (ci < cat.size()) {
                        for (int i = ci + 1; i <= 10; i++) {
                            cat.remove(i);
                        }
                    }

                }
                if (row.getCell(0) != null && !getCellValue(row.getCell(0)).isEmpty()) {
                    String articuls[] = getCellValue(row.getCell(2)).split(" ");

                    String articul = articuls[2];

                    Product model = new Product();
                    model.setArticul(articul + getCellValue(row.getCell(3)).trim());
                    try {
                        Double price = Double.parseDouble(getCellValue(row.getCell(4)).trim());
                        price=price*1.425;
                        model.setPrice(price.intValue());
                    } catch (NumberFormatException e) {
                        model.setPrice(0);
                    }

                    model.setVariant("\"" + getCellValue(row.getCell(2)).replaceAll("\u2122", "").replaceAll("\u00AE", "") + " " + getCellValue(row.getCell(3)).replaceAll("\u2122", "").replaceAll("\u00AE", "") + "\"");

                    if (cat != null) {
                        String categ = catToString(cat);
                        String[] names = categ.split("/");
                        model.setName("\"" + getCellValue(row.getCell(2)) + "\"");
                        model.setType(categ);

                    }
                    try {
                        String[] attributes = Parser.getLine(allProducts, articul);
                        if (attributes != null) {
//                            model.setImages(attributes[16]);
                            model.setDescription("\"" + attributes[13] + "\"");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    String count = getCellValue(row.getCell(5));
                    try {
                        count = count.replaceFirst(".*?(\\d+).*", "$1");
                        model.setCount(Integer.parseInt(count.trim()));
                    } catch (NumberFormatException e) {
                        System.err.println(articul);
                        e.printStackTrace();
                        model.setCount(0);
                    }
//                    model.setDescription("\"Доставка в течение 3-5 дней\"");
                    if (!getCellValue(row.getCell(1)).toLowerCase().contains("отсутствует")) {
                        output.add(model);
                        System.out.println(model);
                    }


                }
            }
            System.out.println("vision");
            toFile(output, "vision");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
