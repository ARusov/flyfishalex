package org.flyfishalex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by arusov on 16.08.2015.
 */
@Controller
@RequestMapping(value = "/{lang}/")
public class YandexController {

    @RequestMapping(value = {"/{text}.html","/{text}.htm"})
    public
    @ResponseBody
    String confirmDomain(@PathVariable("text") String text) {
        if (text.equals("b62b2cfbe67b")) {
            return "21fd30b6035c";
        }
        return text;
    }
}
