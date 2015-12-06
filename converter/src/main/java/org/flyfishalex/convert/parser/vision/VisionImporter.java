package org.flyfishalex.convert.parser.vision;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.flyfishalex.bl.CategoryService;
import org.flyfishalex.bl.ProductService;
import org.flyfishalex.convert.parser.Importer;
import org.flyfishalex.enums.Lang;
import org.flyfishalex.enums.Provider;
import org.flyfishalex.model.Category;
import org.flyfishalex.model.Product;
import org.flyfishalex.model.Variant;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;
import java.util.Iterator;

/**
 * Created by arusov on 19.09.2015.
 */
public class VisionImporter extends Importer {

    private static final String KEEPER = "KEEPER";
    private static final String VISION = "Vision";

    private CategoryService categoryService;

    private ProductService productService;

    public VisionImporter() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        categoryService = (CategoryService) applicationContext.getBean("categoryService");
        productService = (ProductService) applicationContext.getBean("productService");
    }

    public static void main(String[] args) {
        VisionImporter visionImporter = new VisionImporter();
        visionImporter.doImport();
    }

    public void doImport() {
        try {
            File file = new File("/home/tmp/VISION.xls");
//            File file = new File("C:\\tmp\\VISION.xls");
            InputStream io = new FileInputStream(file);
            Workbook wb = new HSSFWorkbook(io);
            Sheet sheet = wb.getSheetAt(0);
            Iterator<Row> rows = sheet.rowIterator();
            Category category=null;
            while (rows.hasNext()) {
                Row row = rows.next();
                if (row.getCell(1) == null || getCellValue(row.getCell(1)).isEmpty()) {
                    if (row.getCell(2) != null && !getCellValue(row.getCell(2)).isEmpty()) {
                        category = categoryService.getCategory(getCellValue(row.getCell(2)));
                        if (category == null) {
                            category = new Category();
                            category.setName(getCellValue(row.getCell(2)));
                            category.getStores().add(Lang.VISION.getId());
                            System.out.println(category.getName());
                            categoryService.createCategory(category);
                        }
                    }

                } else {
                    if (row.getCell(10) != null && !getCellValue(row.getCell(10)).isEmpty()) {
                        Product product = productService.getProduct(getCellValue(row.getCell(10)));
                        if (product == null) {
                            product = new Product();
                            product.setName(getCellValue(row.getCell(10)));
                            product.setProvider(Provider.VISION.getCode());
                            product.getStores().add(Lang.VISION.getId());
                            product.setCategoryId(category.getId());
                            System.out.println(product.getName());
                            productService.saveProduct(product);
                        }
                        Variant variant= productService.getVariantByVendor(getCellValue(row.getCell(1)));
                        if (variant==null){
                            variant= new Variant();
                            variant.setDescription(getCellValue(row.getCell(2)));
                            variant.setFullDescription(getCellValue(row.getCell(2)));
                            variant.setProductId(product.getId());
                            variant.setArticle(getCellValue(row.getCell(1)));
                        }
                        variant.setCount(0);
                        Double price = Double.parseDouble(getCellValue(row.getCell(3)).trim());
                        variant.setPrice(price.intValue());
                        System.out.println(variant.getDescription());
                        productService.saveVariant(variant);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
