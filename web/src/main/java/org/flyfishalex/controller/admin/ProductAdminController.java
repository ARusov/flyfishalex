package org.flyfishalex.controller.admin;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.flyfishalex.bl.CategoryService;
import org.flyfishalex.bl.ProductService;
import org.flyfishalex.controller.AbstractController;
import org.flyfishalex.controller.exception.UserNotFoundException;
import org.flyfishalex.enums.Lang;
import org.flyfishalex.model.Product;
import org.flyfishalex.model.User;
import org.flyfishalex.model.Variant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by arusov on 18.04.2015.
 */
@Controller
@RequestMapping(value = "/{lang}/admin/products")
public class ProductAdminController extends AbstractController {

    private  final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;


    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public ModelAndView getProducts(@PathVariable("lang") String lang,
                                    @RequestParam(value = "p", required = false, defaultValue = "0") int page) {
        User user = getCurrentUser(Lang.getLang(lang));
        if (user == null) {
            throw new UserNotFoundException("User was not found", Lang.getLang(lang));
        }
        ModelAndView mav = new ModelAndView("admin/products");
        mav.addObject("products", productService.getProducts(page));
        mav.addObject("lang", Lang.getLang(lang));
        mav.addObject("page", page);
        return mav;
    }

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public ModelAndView getNewProduct(@PathVariable("lang") String lang) {
        User user = getCurrentUser(Lang.getLang(lang));
        if (user == null) {
            throw new UserNotFoundException("User was not found", Lang.getLang(lang));
        }
        ModelAndView mav = new ModelAndView("admin/product");
        Product product = new Product();
        mav.addObject("product", product);
        mav.addObject("newVariant", new Variant());
        mav.addObject("categories", categoryService.getCategories());
        mav.addObject("lang", Lang.getLang(lang));
        return mav;
    }

    @RequestMapping(value = "/product/{productId}", method = RequestMethod.GET)
    public ModelAndView getProduct(@PathVariable(value = "productId") Long productId,
                                   @PathVariable("lang") String lang) {
        User user = getCurrentUser(Lang.getLang(lang));
        if (user == null) {
            throw new UserNotFoundException("User was not found", Lang.getLang(lang));
        }
        ModelAndView mav = new ModelAndView("admin/product");
        Product product = productService.getProduct(productId);
        mav.addObject("product", product);
        mav.addObject("variants", productService.getVariants(productId));
        mav.addObject("newVariant", new Variant());
        mav.addObject("categories", categoryService.getCategories());
        mav.addObject("stores", Lang.values());
        mav.addObject("lang", Lang.getLang(lang));
        return mav;
    }

    @RequestMapping(value = "/product/{productId}", method = RequestMethod.POST)
    public String createProduct(@ModelAttribute Product product,
                                @PathVariable("lang") String lang) {


        if (product != null) {
            Product currentProduct = productService.getProduct(product.getId());
            if (currentProduct != null) {
                currentProduct.setDescription(product.getDescription());
                currentProduct.setName(product.getName());
                productService.saveProduct(currentProduct);
            }
        }

        return "redirect:" + Lang.getLang(lang).getContext() + "/admin/products/product/" + product.getId();

    }


    @RequestMapping(value = "/product/{productId}/variant", method = RequestMethod.POST)
    private String saveVariant(@PathVariable("lang") String lang
            , @PathVariable("productId") long productId, Variant variant) {

        if (variant != null) {
            if (variant.getId() == 0) {
                variant.setProductId(productId);
                productService.saveVariant(variant);
            } else {
                Variant currentVariant = productService.getVariant(variant.getId());
                if (currentVariant != null) {
                    currentVariant.setDescription(variant.getDescription());
                    currentVariant.setCount(variant.getCount());
                    productService.saveVariant(currentVariant);
                }
            }

        }


        return "redirect:" + Lang.getLang(lang).getContext() + "/admin/products/product/" + productId;
    }


    @RequestMapping(value = "/product/{productId}/uploadImage", method = RequestMethod.POST)
    public String uploadImage(@PathVariable("lang") String lang,
                              @PathVariable("productId") long productId,
                              @RequestParam("file") MultipartFile file) {

        LOGGER.debug("Upload image {}", productId);
        if (!file.isEmpty()) {
//            String name="/home/images/products/"+String.valueOf(productId);

            File folder=new File("/home/images/products/"+String.valueOf(productId));
//            File folder=new File("C:\\tmp\\images\\products\\"+String.valueOf(productId));
            folder.mkdirs();
            LOGGER.debug("Create folders {}", folder);
            String ext = FilenameUtils.getExtension(file.getOriginalFilename());
            String name=folder+"/"+productId+"."+ext;
            LOGGER.debug("Image name {}", name);
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(name)));
                stream.write(bytes);
                stream.close();
                Product product=productService.getProduct(productId);
                if (product!=null){
                    product.setImage(productId+"."+ext);
                    productService.saveProduct(product);
                }
            } catch (Exception e) {
                LOGGER.debug("Error of upload image {}", e.getMessage());
            }
        } else {
        }
        return "redirect:" + Lang.getLang(lang).getContext() + "/admin/products/product/" + productId;
    }


}
