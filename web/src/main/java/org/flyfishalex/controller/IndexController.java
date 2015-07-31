package org.flyfishalex.controller;

import org.flyfishalex.bl.CategoryService;
import org.flyfishalex.bl.ProductService;
import org.flyfishalex.enums.Lang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/{lang}")
public class IndexController extends AbstractController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;


    @RequestMapping(value = {"/", "/index", ""})
    public ModelAndView getIndex(@PathVariable("lang") String lang) {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("rootCategories", categoryService.getCategories(0, Lang.getLang(lang)));
        mav.addObject("user", getUser());
        mav.addObject("products", productService.getLastProducts(40,Lang.getLang(lang)));
        mav.addObject("lang", Lang.getLang(lang));
        if (Lang.EN == Lang.getLang(lang)) {
            mav.addObject("catalogue", "Catalogue");
        }else {
            mav.addObject("catalogue", "Каталог");
        }
        return mav;
    }
}
