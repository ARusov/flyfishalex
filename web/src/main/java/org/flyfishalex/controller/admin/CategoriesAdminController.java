package org.flyfishalex.controller.admin;

import org.flyfishalex.bl.CategoryService;
import org.flyfishalex.controller.AbstractController;
import org.flyfishalex.enums.Lang;
import org.flyfishalex.model.Category;
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
    public ModelAndView getCategories(@PathVariable("lang") String lang,
                                      @RequestParam(value = "categoryId", required = false, defaultValue = "0") long categoryId) {
        ModelAndView mav = new ModelAndView("admin/categories");
        Category category = null;
        if (categoryId == 0) {
            category = new Category();
        } else {
            category = categoryService.getCategory(categoryId);
        }
        if (category == null) {
            category = new Category();
        }

        mav.addObject("category", category);
        mav.addObject("parentCategory", categoryService.getCategory(category.getParentId()));
        mav.addObject("allCategories", categoryService.getCategories(Lang.getLang(lang)));
        List<Category> categories = categoryService.getCategories(categoryId, Lang.getLang(lang));
        mav.addObject("categories", categories);
        mav.addObject("stores", Lang.values());
        mav.addObject("lang", Lang.getLang(lang));
        return mav;
    }


    @RequestMapping(value = "/category", method = RequestMethod.POST)
    public String saveCategory(@PathVariable("lang") String lang,
                               @ModelAttribute Category category) {
        if (category.getId() > 0) {
            categoryService.save(category);
        } else {
            categoryService.createCategory(category);
        }

        return "redirect:" + Lang.getLang(lang).getContext() + "/admin/categories?categoryId=" + category.getId();
    }

    @RequestMapping(value = "/categories", method = RequestMethod.DELETE)
    public
    @ResponseBody
    String deleteCategory(@RequestParam(value = "categoryId", required = false) Long categoryId) {
        if (categoryId != null) {
            List<CategoryDTO> childs = categoryService.getCategoriesDTO(categoryId, Lang.getLang("ru"));
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
