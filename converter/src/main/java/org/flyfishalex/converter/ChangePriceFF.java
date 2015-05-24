package org.flyfishalex.converter;

import au.com.bytecode.opencsv.CSVReader;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.flyfishalex.model.Price;
import org.flyfishalex.model.Product;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by arusov on 2/28/2015.
 */
public class ChangePriceFF {
    public static void main(String[] args) {
        ChangePriceFF changePrice = new ChangePriceFF();
        changePrice.start();
    }

    public Price getPrice(List<String[]> allProducts, String articul) {

        for (String[] item : allProducts) {
            if (articul.equals(item[9]) && !articul.trim().isEmpty()) {
                Double cost = Double.parseDouble(item[2].trim());
                Price price = new Price(item[9], cost.intValue(), 0);
                return price;
            }
        }
        return null;
    }

    public void start() {
        try {
            List<Price> prices = new ArrayList<Price>();
            CSVReader reader = new CSVReader(new FileReader("C:\\Projects\\flyfishalex\\converter\\input\\export.csv"), ';');
            List<String[]> allProducts = reader.readAll();
            allProducts.remove(0);

            File file = new File("C:\\Projects\\flyfishalex\\converter\\input\\Свободные-остатки-на-20.04.2014.xls");
            InputStream io = new FileInputStream(file);
            Workbook wb = new HSSFWorkbook(io);
            Sheet sheet = wb.getSheetAt(0);
            Iterator<Row> rows = sheet.rowIterator();
            while (rows.hasNext()) {
                Row row = rows.next();
                if (row.getCell(2) != null && !getCellValue(row.getCell(2)).isEmpty()) {
                    String articul = getCellValue(row.getCell(2));
                    Price price = getPrice(allProducts, articul);
                    if (price != null) {
                        Double cost = Double.parseDouble(getCellValue(row.getCell(8)).trim());
                        cost = cost * 0.99;
                        price.setPrice(cost.intValue());
                        String countString = getCellValue(row.getCell(4));
                        int count = 0;
                        try {
                            countString = countString.replaceAll("[^\\d]", "");

                            count = Integer.parseInt(countString.trim());

                        } catch (NumberFormatException e) {
                            System.err.println(articul + " " + row.getRowNum());
                            e.printStackTrace();
                            count = 0;
                        }
                        if (count < 5) {
                            count = 0;
                        }

                        price.setCount(count);
                        prices.add(price);
                        System.out.println(price);
                        toFile(prices, "");
                    }
                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    protected void toFile(List<Price> output, String name) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        File file = new File("C:/Projects/flyfishalex/converter/output/priceFF.csv");


        try {
            if (file.exists()) {
                file.delete();
            }
            FileWriter writer = new FileWriter(file);
//            Writer writer = new BufferedWriter(new OutputStreamWriter(
//                    new FileOutputStream(file), Charset.forName("UTF-8").newEncoder()));
            writer.append("\"Артикул\"");
            writer.append(Product.SPLIT);
            writer.append("\"Цена\"");
            writer.append(Product.SPLIT);
            writer.append("\"Склад\"");
            writer.append("\n");
            for (Price price : output) {
                writer.append(price.toString());
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected String getCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                return cell.getRichStringCellValue().getString();
            case Cell.CELL_TYPE_NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return String.valueOf(cell.getDateCellValue());
                } else {
                    return String.valueOf(cell.getNumericCellValue());
                }
            case Cell.CELL_TYPE_BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case Cell.CELL_TYPE_FORMULA:
                return cell.getCellFormula();
            default: {
                return "";
            }
        }

    }
}
