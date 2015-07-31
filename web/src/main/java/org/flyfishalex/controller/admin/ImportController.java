package org.flyfishalex.controller.admin;

import org.flyfishalex.bl.CategoryService;
import org.flyfishalex.bl.ProductService;
import org.flyfishalex.convert.parser.rybolovorg.RybolovCategory;
import org.flyfishalex.convert.parser.rybolovorg.RybolovModel;
import org.flyfishalex.convert.parser.rybolovorg.RybolovParser;
import org.flyfishalex.enums.Lang;
import org.flyfishalex.enums.Provider;
import org.flyfishalex.model.Category;
import org.flyfishalex.model.Product;
import org.flyfishalex.model.Variant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by arusov on 4/7/2015.
 */
@Controller
@RequestMapping(value = "/{lang}/admin/import")
public class ImportController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/categories/initRybolov", method = RequestMethod.GET)
    public ModelAndView initRybolov(@RequestParam(value = "init", required = false, defaultValue = "false") boolean init) {
        ModelAndView mav = new ModelAndView("admin/initCategories");
        RybolovParser rybolovParser = new RybolovParser();
        List<RybolovCategory> categories = rybolovParser.getCategories();
        for (RybolovCategory rybolovCategory : categories) {

            if (lookingChildRybolov(categories, rybolovCategory)) {
                Category category = new Category();
                category.setName(rybolovCategory.getName());
                category.getStores().add(3);
                category.setParentId(getParentIdRybolov(String.valueOf(rybolovCategory.getParentId())));
                if (rybolovCategory.getParentId() == 2) {
                    category.setParentId(0);
                }
                category.setVendorId(String.valueOf(rybolovCategory.getId()));
                if (init && rybolovCategory.getId() != 2) {
//                    categoryService.createCategory(category);
                }
            } else {
                if (rybolovCategory.getId() != 2) {
                    Product product = new Product();
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
                    if (init) {
//                        productService.saveProduct(product);
                    }
                }

            }

        }
        mav.addObject("categories", categories);
        return mav;
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

    @RequestMapping(value = "/products/initRybolov", method = RequestMethod.GET)
    public ModelAndView initRybolovProducts(@RequestParam(value = "init", required = false, defaultValue = "false") boolean init) {
        ModelAndView mav = new ModelAndView("admin/initProducts");
        RybolovParser rybolovParser= new RybolovParser();
        List<RybolovModel> rybolovModels=rybolovParser.getOffers();
        for(RybolovModel model:rybolovModels){
            Product product= productService.getProductByVendor(String.valueOf(model.getCategoryId()));
            if(product!=null){
                Variant variant= new Variant();
                if(model.getName()!=null){
                    variant.setDescription(model.getName());
                }else{
                    variant.setDescription(model.getModel());
                }
                variant.setPrice(model.getPrice());
                variant.setProductId(product.getId());
                variant.setCount(10);
                variant.setArticle(String.valueOf(model.getId()));
                if(init){
//                    productService.saveVariant(variant);
                }
            }

        }
        mav.addObject("products", rybolovModels);
        return mav;
    }

}
