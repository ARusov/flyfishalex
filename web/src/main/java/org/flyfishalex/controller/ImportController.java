package org.flyfishalex.controller;

import org.flyfishalex.bl.CategoryService;
import org.flyfishalex.model.Category;
import org.flyfishalex.model.dto1c.Categories1c;
import org.flyfishalex.model.dto1c.Category1c;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by arusov on 4/7/2015.
 */
@Controller
@RequestMapping(value = "/import")
public class ImportController {

    @Autowired
    private Environment environment;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView getImport() {
        ModelAndView mav = new ModelAndView("import");
        mav.addObject("env", environment.getActiveProfiles()[0]);
        return mav;
    }


    @RequestMapping(value = "/import1c", method = RequestMethod.POST, produces = {"application/xml; charset=UTF-8"})
    public
    @ResponseBody
    String import1c(@RequestBody(required = true) Categories1c categories1c) throws Exception {
        if (categories1c != null) {
            transform1c(categories1c, 0);
        }
        return "Ok";
    }


    public void transform1c(Categories1c categories1c, long root) {

        if (categories1c != null) {
            List<Category1c> rootCats1c = categories1c.getCategories();
            if (rootCats1c == null) {
                return;
            }


            for (Category1c item : rootCats1c) {
                Category category = new Category();
                category.setName(item.getName());
                category.setParentId(root);
                categoryService.createCategory(category);
                System.out.println(item.getName() + "---" + root);
                transform1c(item.getCategories(), category.getId());

            }
        }
    }
}
