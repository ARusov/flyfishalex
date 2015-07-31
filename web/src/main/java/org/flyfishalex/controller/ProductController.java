package org.flyfishalex.controller;

import org.flyfishalex.bl.CategoryService;
import org.flyfishalex.bl.ProductService;
import org.flyfishalex.model.Product;
import org.flyfishalex.enums.Lang;
import org.flyfishalex.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by arusov on 4/2/2015.
 */
@Controller
@RequestMapping(value = "/{lang}/product")
public class ProductController extends AbstractController {

    @Autowired
    private CategoryService categoryService;


    @Autowired
    private ProductService productService;


    @RequestMapping(value = "/{productId}")
    public ModelAndView getProduct(@PathVariable("lang") String lang, @PathVariable("productId") long productId) {
        ModelAndView mav = new ModelAndView("product");

        Product product = productService.getProduct(productId);
        if (product != null) {
            long categoryId=product.getCategoryId();
            mav.addObject("product", product);
            mav.addObject("variants", productService.getVariants(productId));
            mav.addObject("rootCategories", categoryService.getCategories(0, Lang.getLang(lang)));
            mav.addObject("categories", categoryService.getCategories(categoryId, Lang.getLang(lang)));
            mav.addObject("parent", categoryService.getCategory(categoryId, lang));
            mav.addObject("parentCategories", categoryService.getParentCategories(categoryId, Lang.getLang(lang)));
            mav.addObject("products", productService.getProducts(categoryId, Lang.getLang(lang)));
            mav.addObject("lang", Lang.getLang(lang));
            if (Lang.EN == Lang.getLang(lang)) {
                mav.addObject("catalogue", "Catalogue");
            } else {
                mav.addObject("catalogue", "Каталог");
            }
            User user= getUser();
            if(user!=null){
                mav.addObject("user", user);
            }
            return mav;
        }
        //TODO: 404
        return mav;
    }
}
