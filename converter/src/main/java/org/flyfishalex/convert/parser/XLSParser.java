package org.flyfishalex.convert.parser;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.flyfishalex.convert.model.Product;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by arusov on 2/23/2015.
 */
public abstract class XLSParser {

    protected Iterator<Row> rows;

    public XLSParser(File file) {
        if (file.exists() && file.getName().endsWith(".xls")) ;
        {
            init(file);
        }

    }

    private void init(File file) {

        try {
            InputStream io = new FileInputStream(file);
            Workbook wb = new HSSFWorkbook(io);
            Sheet sheet = wb.getSheetAt(0);
            rows = sheet.rowIterator();
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

    public abstract void convert();

    protected void toFile(List<Product> output, String name) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        File file = new File("C:/Projects/flyfishalex/converter/output/" + name + ".csv");


        try {
            if (file.exists()) {
                file.delete();
            }
            FileWriter writer = new FileWriter(file);
//            Writer writer = new BufferedWriter(new OutputStreamWriter(
//                    new FileOutputStream(file), Charset.forName("UTF-8").newEncoder()));
            writer.append("\"Артикул\"");
            writer.append(Product.SPLIT);
            writer.append("\"Товар\"");
            writer.append(Product.SPLIT);
            writer.append("\"Цена\"");
            writer.append(Product.SPLIT);
            writer.append("\"Категория\"");
            writer.append(Product.SPLIT);
            writer.append("\"Вариант\"");
            writer.append(Product.SPLIT);
            writer.append("\"Описание\"");
            writer.append(Product.SPLIT);
            writer.append("\"Адрес\"");
            writer.append(Product.SPLIT);
            writer.append("\"Изображения\"");
            writer.append(Product.SPLIT);
            writer.append("\"Описание\"");
            writer.append(Product.SPLIT);
            writer.append("\"Склад\"");

            writer.append("\n");
            for (Product product : output) {
                writer.append(product.toString());
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected String catToString(Map<Integer, String> map) {
        String result = "\"";
        for (int key : map.keySet()) {
            result = result + map.get(key) + "/";
        }
        result = result.substring(0, result.length() - 1).replaceAll("\u2122", "").replaceAll("\u00AE", "");
        return result + "\"";
    }

}
