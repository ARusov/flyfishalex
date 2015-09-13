package org.flyfishalex.convert.parser.rybolovorg;

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

import java.io.File;
import java.util.List;

/**
 * Created by arusov on 02.08.2015.
 */
public class RybolovImporter extends Importer {

    private CategoryService categoryService;

    private ProductService productService;

    public RybolovImporter() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        categoryService = (CategoryService) applicationContext.getBean("categoryService");
        productService = (ProductService) applicationContext.getBean("productService");
    }

    @Override
    public void doImport() {
        final File file = new File("C:\\tmp\\yml_rybolov.xml");
//        File file = new File("/home/tmp/yml_rybolov.xml");
        RybolovParser rybolovParser = new RybolovParser(file);
        List<RybolovCategory> categories = rybolovParser.getCategories();
        for (RybolovCategory rybolovCategory : categories) {
            if (lookingChildRybolov(categories, rybolovCategory)) {
                Category category = categoryService.getByVendorParentId(String.valueOf(rybolovCategory.getId()));
                if (category == null) {
                    category = new Category();
                }
                category.setName(rybolovCategory.getName());
                category.getStores().add(Lang.NORTHBAY.getId());
                category.setParentId(getParentIdRybolov(String.valueOf(rybolovCategory.getParentId())));
                if (rybolovCategory.getParentId() == 2) {
                    category.setParentId(0);
                }
                category.setVendorId(String.valueOf(rybolovCategory.getId()));
                if (rybolovCategory.getId() != 2) {
                    categoryService.createCategory(category);
                    System.out.println("Updated category id: " + category.getId() + " name: " + category.getName());
                }
            } else {
                if (rybolovCategory.getId() != 2) {
                    Product product = productService.getProductByVendor(String.valueOf(rybolovCategory.getId()));
                    if (product == null) {
                        product = new Product();
                    }
                    if (rybolovCategory.getName() != null) {
                        product.setName(rybolovCategory.getName());
                    }
                    Category category = categoryService.getByVendorParentId(String.valueOf(rybolovCategory.getParentId()));
                    if (category != null) {
                        product.setCategoryId(category.getId());
                    }
                    product.setArticle(String.valueOf(rybolovCategory.getId()));
                    product.setProvider(Provider.RYBOLOV.getCode());
                    product.getStores().add(Lang.NORTHBAY.getId());

                    productService.saveProduct(product);
                    System.out.println("Updated product id: " + product.getId() + " name: " + product.getName());
                }

            }

        }
        List<RybolovModel> rybolovModels = rybolovParser.getOffers();
        for (RybolovModel model : rybolovModels) {
            Product product = productService.getProductByVendor(String.valueOf(model.getCategoryId()));
            if (product != null) {
                Variant variant = productService.getVariantByVendor(String.valueOf(model.getId()));
                if (variant == null) {
                    variant = new Variant();
                }
                if (model.getName() != null) {
                    variant.setDescription(model.getName());
                    variant.setFullDescription(model.getName());
                } else {
                    variant.setDescription(model.getModel());
                    variant.setFullDescription(model.getModel());
                }
                variant.setPrice(model.getPrice());
                variant.setProductId(product.getId());
                variant.setCount(10);
                variant.setArticle(String.valueOf(model.getId()));


                boolean flagImage = true;
                for (String image : product.getImages()) {
                    if (image.equals(model.getPicture())) {
                        flagImage = false;
                    }
                }
                if (flagImage) {
                    product.getImages().add(model.getPicture());
                }
                productService.saveProduct(product);
                productService.saveVariant(variant);
                System.out.println("Updated variant id: " + variant.getId() + " name: " + variant.getDescription());
            }

        }
    }


    private long getParentIdRybolov(String vendorParentId) {
        Category category = categoryService.getByVendorParentId(vendorParentId);
        if (category != null) {
            return category.getId();
        }
        return 0;
    }

    private boolean lookingChildRybolov(List<RybolovCategory> categories, RybolovCategory category) {
        for (RybolovCategory rybolovCategory : categories) {
            if (category.getId() == rybolovCategory.getParentId()) {
                return true;
            }
        }
        return false;
    }
}
