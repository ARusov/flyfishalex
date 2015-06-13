package org.flyfishalex.controller.admin;

import org.flyfishalex.bl.OrderService;
import org.flyfishalex.enums.Lang;
import org.flyfishalex.model.Delivery;
import org.flyfishalex.model.Payment;
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
@RequestMapping(value = "/{lang}/admin")
public class OrderAdminController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/orders/delivery", method = RequestMethod.GET)
    public ModelAndView getDelivery() {
        ModelAndView mav = new ModelAndView("admin/delivery");
        mav.addObject("delivery", new Delivery());
        mav.addObject("deliveries", orderService.getDeliveries());
        return mav;
    }

    @RequestMapping(value = "/orders/delivery", method = RequestMethod.POST)
    public String saveDelivery(@PathVariable("lang") String lang, @ModelAttribute Delivery delivery) {
        if(delivery!=null && !delivery.getDescription().isEmpty()){
            orderService.saveDelivery(delivery);
        }
        return "redirect:"+ Lang.getLang(lang).getContext()+"/admin/orders/delivery";
    }



    @RequestMapping(value = "/orders/payment", method = RequestMethod.GET)
    public ModelAndView getPayment() {
        ModelAndView mav = new ModelAndView("admin/payment");
        mav.addObject("payment", new Payment());
        mav.addObject("payments", orderService.getPayments());
        return mav;
    }

    @RequestMapping(value = "/orders/payment", method = RequestMethod.POST)
    public String savePayment(@PathVariable("lang") String lang, @ModelAttribute Payment payment) {
        if(payment!=null && !payment.getDescription().isEmpty()){
            orderService.savePayment(payment);
        }
        return "redirect:"+ Lang.getLang(lang).getContext()+"/admin/orders/payment";
    }

}
