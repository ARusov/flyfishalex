package org.flyfishalex.controller.admin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.flyfishalex.bl.CategoryService;
import org.flyfishalex.bl.ProductService;
import org.flyfishalex.controller.AbstractController;
import org.flyfishalex.convert.parser.rybolovorg.RybolovCategory;
import org.flyfishalex.convert.parser.rybolovorg.RybolovParser;
import org.flyfishalex.enums.Lang;
import org.flyfishalex.enums.Provider;
import org.flyfishalex.model.Category;
import org.flyfishalex.model.Product;
import org.flyfishalex.model.dto.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by arusov on 4/15/2015.
 */
@Controller
@RequestMapping(value = "/{lang}/admin")
public class CategoriesAdminController extends AbstractController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public ModelAndView getCategories(@RequestParam(value = "categoryId", required = false) Long categoryId) {
        ModelAndView mav = new ModelAndView("admin");
        if (!checkRole("ROLE_USER")) {
//            return new ModelAndView("redirect:"+ Lang.getLang("ru").getContext()+"/user/login");
        }
        Category category = null;
        if (categoryId == null) {
            category = new Category();
        } else {
            category = categoryService.getCategory(categoryId);
        }
        if (category == null) {
            category = new Category();
        }

        mav.addObject("category", category);
        List<Category> categories = categoryService.getCategories();
        categories.add(new Category());
        mav.addObject("categories", categories);
        mav.addObject("stores", Lang.values());
        return mav;
    }


    @RequestMapping(value = "/categories.json", method = RequestMethod.GET, headers = "Accept=*/*")
    public
    @ResponseBody
    List<CategoryDTO> getCategoriesJson() {
        List<CategoryDTO> categories = categoryService.getCategoriesDTO();
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId("0");
        categoryDTO.setText("Каталог");
        categories.add(0, categoryDTO);
        return categories;
    }

    @RequestMapping(value = "/category.json", method = RequestMethod.GET, headers = "Accept=*/*")
    public
    @ResponseBody
    Category getCategoriesJson(@RequestParam("categoryId") long id) {
        return categoryService.getCategory(id);

    }

    @RequestMapping(value = "/category", method = RequestMethod.POST)
    public String saveCategory(@ModelAttribute Category category) {
        if (category.getId() > 0) {
            categoryService.save(category);
        } else {
            categoryService.createCategory(category);
        }

        ObjectMapper mapper = new ObjectMapper();
        try {
            System.out.println(mapper.writeValueAsString(category));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "redirect:http://localhost:8080/flyfishalex/ru/admin/categories?categoryId=" + category.getId();
    }

    @RequestMapping(value = "/categories", method = RequestMethod.DELETE)
    public
    @ResponseBody
    String deleteCategory(@RequestParam(value = "categoryId", required = false) Long categoryId) {
        if (categoryId != null) {
            List<CategoryDTO> childs = categoryService.getCategories(categoryId, Lang.getLang("ru"));
            if (childs == null || childs.size() > 0) {
                return "Please remove child before";

            } else {
                Category category = categoryService.getCategory(categoryId);
                categoryService.delete(category);
            }

        }
        return "Category has been removed";
    }

}
