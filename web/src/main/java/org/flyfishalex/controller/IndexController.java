package org.flyfishalex.controller;

import org.flyfishalex.bl.CategoryService;
import org.flyfishalex.bl.ProductService;
import org.flyfishalex.enums.Lang;
import org.flyfishalex.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/{lang}")
public class IndexController extends AbstractController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;


    @RequestMapping(value = {"/", "/index", ""})
    public ModelAndView getIndex(@PathVariable("lang") String lang) {
        ModelAndView mav = new ModelAndView(lang+"/index");
        Lang _lang=Lang.getLang(lang);
        mav.addObject("user", getCurrentUser(Lang.getLang(lang)));
        if(_lang==Lang.NORTHBAY){
            mav.addObject("rootCategories", categoryService.getCategoriesDTO(0, _lang));
            mav.addObject("childCategories", categoryService.get2ndCategories(_lang));
            mav.addObject("products", productService.getLastProducts(36, _lang));
        }
        if(_lang==Lang.VISION){
            mav.addObject("rootCategories", categoryService.getCategoriesDTO(0, _lang));
            mav.addObject("products", productService.getProductsFromCategories(_lang));
        }
        mav.addObject("lang", _lang);
        return mav;
    }

    @RequestMapping(value = "/sitemap-products.xml", method = RequestMethod.GET)
    public @ResponseBody Sitemap getSitemapProducts(@PathVariable("lang") String lang) {
        List<Product> products = productService.getProducts(Lang.getLang(lang));
        Sitemap sitemap = new Sitemap();
        if (products != null) {
            for (Product product : products) {
                SitemapURL url = new SitemapURL();
                url.setLoc(Lang.getLang(lang).getContext() + "/product/" + product.getId());
                sitemap.getUrl().add(url);
            }

        }
        return sitemap;
    }


    @RequestMapping(value = "/sitemap-categories.xml", method = RequestMethod.GET)
    public @ResponseBody Sitemap getSitemapCategories(@PathVariable("lang") String lang) {

        List<Category> categories=categoryService.getCategories(Lang.getLang(lang));
        Sitemap sitemap = new Sitemap();
        if (categories != null) {
            for (Category category : categories) {
                SitemapURL url = new SitemapURL();
                url.setLoc(Lang.getLang(lang).getContext() + "/category/" + category.getId());
                sitemap.getUrl().add(url);
            }

        }
        return sitemap;
    }

    @RequestMapping(value = "/sitemap.xml", method = RequestMethod.GET)
    public @ResponseBody
    SitemapIndex getSitemap(@PathVariable("lang") String lang) {
        SitemapIndex sitemap = new SitemapIndex();
        sitemap.getSitemap().add(new SitemapLoc(Lang.getLang(lang).getContext()+"/sitemap-categories.xml"));
        sitemap.getSitemap().add(new SitemapLoc(Lang.getLang(lang).getContext()+"/sitemap-products.xml"));
        return sitemap;
    }


    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public ModelAndView getAbout(@PathVariable("lang") String lang) {
        ModelAndView mav = new ModelAndView(lang+"/about");
        mav.addObject("rootCategories", categoryService.getCategoriesDTO(0, Lang.getLang(lang)));
        mav.addObject("childCategories", categoryService.get2ndCategories(Lang.getLang(lang)));
        mav.addObject("user", getCurrentUser(Lang.getLang(lang)));
        mav.addObject("lang", Lang.getLang(lang));
        return mav;
    }
    @RequestMapping(value = "/about/payment", method = RequestMethod.GET)
    public ModelAndView getAboutPayment(@PathVariable("lang") String lang) {
        ModelAndView mav = new ModelAndView(lang+"/aboutPayment");
        mav.addObject("rootCategories", categoryService.getCategoriesDTO(0, Lang.getLang(lang)));
        mav.addObject("childCategories", categoryService.get2ndCategories(Lang.getLang(lang)));
        mav.addObject("user", getCurrentUser(Lang.getLang(lang)));
        mav.addObject("lang", Lang.getLang(lang));
        return mav;
    }

    @RequestMapping(value = "/about/delivery", method = RequestMethod.GET)
    public ModelAndView getAboutDelivery(@PathVariable("lang") String lang) {
        ModelAndView mav = new ModelAndView(lang+"/aboutDelivery");
        mav.addObject("rootCategories", categoryService.getCategoriesDTO(0, Lang.getLang(lang)));
        mav.addObject("childCategories", categoryService.get2ndCategories(Lang.getLang(lang)));
        mav.addObject("user", getCurrentUser(Lang.getLang(lang)));
        mav.addObject("lang", Lang.getLang(lang));
        return mav;
    }
}
