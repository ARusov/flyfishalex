package org.flyfishalex.controller.admin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.flyfishalex.bl.CategoryService;
import org.flyfishalex.bl.ProductService;
import org.flyfishalex.enums.Lang;
import org.flyfishalex.model.Product;
import org.flyfishalex.model.Variant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by arusov on 18.04.2015.
 */
@Controller
@RequestMapping(value = "/{lang}/admin/products")
public class ProductAdminController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;


    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public ModelAndView getProducts() {
        ModelAndView mav = new ModelAndView("admin/products");
        mav.addObject("products", productService.getProducts());
        return mav;
    }

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public ModelAndView getNewProduct() {
        ModelAndView mav = new ModelAndView("admin/product");
        Product product = new Product();
        mav.addObject("product", product);
        mav.addObject("newVariant", new Variant());
        mav.addObject("categories", categoryService.getCategories());
        return mav;
    }

    @RequestMapping(value = "/product/{productId}", method = RequestMethod.GET)
    public ModelAndView getProduct(@PathVariable(value = "productId") Long productId) {
        ModelAndView mav = new ModelAndView("admin/product");
        Product product = productService.getProduct(productId);
        mav.addObject("product", product);
        mav.addObject("variants", productService.getVariants(productId));
        mav.addObject("newVariant", new Variant());
        mav.addObject("categories", categoryService.getCategories());
        mav.addObject("stores", Lang.values());
        return mav;
    }

    @RequestMapping(value = "/product/{productId}", method = RequestMethod.POST)
    public String createProduct(@ModelAttribute Product product) {

        productService.saveProduct(product);

        ObjectMapper mapper = new ObjectMapper();
        try {
            System.out.println(mapper.writeValueAsString(product));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "redirect:http://localhost:8080/flyfishalex/ru/admin/products/product/"+product.getId();

    }


    @RequestMapping(value = "/product/{productId}/variant", method = RequestMethod.POST)
    private String saveVariant(@PathVariable("lang") String lang
            , @PathVariable("productId") long productId, Variant variant) {
        variant.setProductId(productId);
        productService.saveVariant(variant);
        return "redirect:" + Lang.getLang(lang).getContext() + "/admin/products/product/" + productId;
    }

}
