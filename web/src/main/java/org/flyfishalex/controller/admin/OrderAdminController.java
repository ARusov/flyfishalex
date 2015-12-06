package org.flyfishalex.controller.admin;

import org.flyfishalex.bl.EmailService;
import org.flyfishalex.bl.OrderService;
import org.flyfishalex.bl.UserService;
import org.flyfishalex.controller.AbstractController;
import org.flyfishalex.controller.exception.UserNotFoundException;
import org.flyfishalex.enums.Lang;
import org.flyfishalex.enums.OrderStatus;
import org.flyfishalex.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by arusov on 18.04.2015.
 */
@Controller
@RequestMapping(value = "/{lang}/admin")
public class OrderAdminController extends AbstractController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public ModelAndView getOrders(@PathVariable("lang") String lang) {
        User user = getCurrentUser(Lang.getLang(lang));
        if (user == null) {
            throw new UserNotFoundException("User was not found", Lang.getLang(lang));
        }
        ModelAndView mav = new ModelAndView("admin/orders");
        mav.addObject("orders", orderService.getOrders());
        mav.addObject("statuses", OrderStatus.values());
        mav.addObject("lang", Lang.getLang(lang));
        return mav;
    }

    @RequestMapping(value = "/orders/{orderID}", method = RequestMethod.GET)
    public ModelAndView getOrder(@PathVariable("orderID") long orderID,
                                 @PathVariable("lang") String lang) {
        User user = getCurrentUser(Lang.getLang(lang));
        if (user == null) {
            throw new UserNotFoundException("User was not found", Lang.getLang(lang));
        }
        ModelAndView mav = new ModelAndView("admin/order");
        mav.addObject("order", orderService.getOrderById(orderID));
        mav.addObject("orderPoints", orderService.getOrderPoints(orderID));
        mav.addObject("statuses", OrderStatus.values());
        mav.addObject("lang", Lang.getLang(lang));
        return mav;
    }

    @RequestMapping(value = "/orders/{orderID}", method = RequestMethod.POST)
    public String doOrder(@PathVariable("orderID") long orderID,
                          @ModelAttribute("order") Order order,
                          @PathVariable("lang") String lang) {
        Order currentOrder = orderService.getOrderById(orderID);
        if (currentOrder != null) {
            currentOrder.setStatus(order.getStatus());
            currentOrder.setDeliveryPrice(order.getDeliveryPrice());
            orderService.saveOrder(currentOrder);
            User user=userService.getUser(currentOrder.getUserId());
            if(user!=null){
                emailService.sendEmailChangeStatus(user,currentOrder,OrderStatus.getOrderStatus(currentOrder.getStatus()));
            }
        }
        return "redirect:" + Lang.getLang(lang).getContext() + "/admin/orders/" + orderID;
    }

    @RequestMapping(value = "/orders/{orderID}/point/{pointId}", method = RequestMethod.POST)
    public String doOrderPoint(@PathVariable("orderID") long orderID,
                               @PathVariable("pointId") long pointId,
                               OrderPoint point,
                               @PathVariable("lang") String lang) {
        Order currentOrder = orderService.getOrderById(orderID);
        if (currentOrder != null) {
        OrderPoint currentPoint= orderService.getOrderPoint(pointId);
            if(currentPoint!=null){
                currentPoint.setCount(point.getCount());
                orderService.saveOrderPoint(currentPoint);
            }
            List<OrderPoint>points=orderService.getOrderPoints(orderID);
            int finalPrice=0;
            for(OrderPoint orderPoint:points){
                finalPrice=finalPrice+orderPoint.getCount()*orderPoint.getPrice();
            }
            currentOrder.setFinalPrice(finalPrice);
            orderService.saveOrder(currentOrder);
        }
        return "redirect:" + Lang.getLang(lang).getContext() + "/admin/orders/" + orderID;
    }

    @RequestMapping(value = "/orders/{orderID}/point/{pointId}", method = RequestMethod.GET)
    public String deleteOrderPoint(@PathVariable("orderID") long orderID,
                               @PathVariable("pointId") long pointId,
                               @PathVariable("lang") String lang) {
        User user = getCurrentUser(Lang.getLang(lang));
        if (user == null) {
            throw new UserNotFoundException("User was not found", Lang.getLang(lang));
        }
        Order currentOrder = orderService.getOrderById(orderID);
        if (currentOrder != null) {
            OrderPoint currentPoint= orderService.getOrderPoint(pointId);
            orderService.removeOrderPoint(currentPoint);
            List<OrderPoint>points=orderService.getOrderPoints(orderID);
            int finalPrice=0;
            for(OrderPoint orderPoint:points){
                finalPrice=finalPrice+orderPoint.getCount()*orderPoint.getPrice();
            }
            currentOrder.setFinalPrice(finalPrice);
            orderService.saveOrder(currentOrder);
        }
        return "redirect:" + Lang.getLang(lang).getContext() + "/admin/orders/" + orderID;
    }

    @RequestMapping(value = "/orders/delivery", method = RequestMethod.GET)
    public ModelAndView getDelivery( @PathVariable("lang") String lang) {
        User user = getCurrentUser(Lang.getLang(lang));
        if (user == null) {
            throw new UserNotFoundException("User was not found", Lang.getLang(lang));
        }
        ModelAndView mav = new ModelAndView("admin/delivery");
        mav.addObject("delivery", new Delivery());
        mav.addObject("deliveries", orderService.getDeliveries(lang));
        return mav;
    }

    @RequestMapping(value = "/orders/delivery", method = RequestMethod.POST)
    public String saveDelivery(@PathVariable("lang") String lang, @ModelAttribute Delivery delivery) {
        if (delivery != null && !delivery.getDescription().isEmpty()) {
            delivery.setLang(lang);
            orderService.saveDelivery(delivery);
        }
        return "redirect:" + Lang.getLang(lang).getContext() + "/admin/orders/delivery";
    }


    @RequestMapping(value = "/orders/payment", method = RequestMethod.GET)
    public ModelAndView getPayment( @PathVariable("lang") String lang) {
        User user = getCurrentUser(Lang.getLang(lang));
        if (user == null) {
            throw new UserNotFoundException("User was not found", Lang.getLang(lang));
        }
        ModelAndView mav = new ModelAndView("admin/payment");
        mav.addObject("payment", new Payment());
        mav.addObject("payments", orderService.getPayments(lang));
        return mav;
    }

    @RequestMapping(value = "/orders/payment", method = RequestMethod.POST)
    public String savePayment(@PathVariable("lang") String lang, @ModelAttribute Payment payment) {
        if (payment != null && !payment.getDescription().isEmpty()) {
            payment.setLang(lang);
            orderService.savePayment(payment);
        }
        return "redirect:" + Lang.getLang(lang).getContext() + "/admin/orders/payment";
    }

}
