package org.flyfishalex.convert.converter;

import au.com.bytecode.opencsv.CSVReader;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.flyfishalex.convert.model.Price;
import org.flyfishalex.convert.model.Product;

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
public class ChangePriceVision {
    public static void main(String[] args) {
        ChangePriceVision changePrice = new ChangePriceVision();
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

            File file = new File("C:\\Projects\\flyfishalex\\converter\\input\\наличие VISION и KEEPER.xls");
            InputStream io = new FileInputStream(file);
            Workbook wb = new HSSFWorkbook(io);
            Sheet sheet = wb.getSheetAt(0);
            Iterator<Row> rows = sheet.rowIterator();
            while (rows.hasNext()) {
                Row row = rows.next();
                if (row.getCell(0) != null && !getCellValue(row.getCell(0)).isEmpty()) {


                    String articuls[] = getCellValue(row.getCell(2)).split(" ");

                    String articul="";
                    boolean articulFlaf=false;
                    for(String item:articuls){
                        if(articulFlaf){
                            articul=item;
                            articulFlaf=false;
                        }
                        if(item.toLowerCase().equals("vision")||item.toLowerCase().equals("keeper")){
                            articulFlaf=true;
                        }
                    }
                    articul=articul + getCellValue(row.getCell(3)).trim();


                    Price price = getPrice(allProducts, articul);
                    if (price != null) {
                        Double cost = Double.parseDouble(getCellValue(row.getCell(4)).trim());
                        cost = cost * 1.525;;
                        price.setPrice(cost.intValue());
                        String countString = getCellValue(row.getCell(5));
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
        File file = new File("C:/Projects/flyfishalex/converter/output/priceVision.csv");


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
