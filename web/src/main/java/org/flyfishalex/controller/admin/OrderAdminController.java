package org.flyfishalex.controller.admin;

import org.flyfishalex.bl.OrderService;
import org.flyfishalex.enums.Lang;
import org.flyfishalex.enums.OrderStatus;
import org.flyfishalex.model.Delivery;
import org.flyfishalex.model.Order;
import org.flyfishalex.model.OrderPoint;
import org.flyfishalex.model.Payment;
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
public class OrderAdminController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public ModelAndView getOrders(@PathVariable("lang") String lang) {
        ModelAndView mav = new ModelAndView("admin/orders");
        mav.addObject("orders", orderService.getOrders());
        mav.addObject("statuses", OrderStatus.values());
        mav.addObject("lang", Lang.getLang(lang));
        return mav;
    }

    @RequestMapping(value = "/orders/{orderID}", method = RequestMethod.GET)
    public ModelAndView getOrder(@PathVariable("orderID") long orderID,
                                 @PathVariable("lang") String lang) {
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
            //TODO:send email
            orderService.saveOrder(currentOrder);
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
    public ModelAndView getDelivery() {
        ModelAndView mav = new ModelAndView("admin/delivery");
        mav.addObject("delivery", new Delivery());
        mav.addObject("deliveries", orderService.getDeliveries());
        return mav;
    }

    @RequestMapping(value = "/orders/delivery", method = RequestMethod.POST)
    public String saveDelivery(@PathVariable("lang") String lang, @ModelAttribute Delivery delivery) {
        if (delivery != null && !delivery.getDescription().isEmpty()) {
            orderService.saveDelivery(delivery);
        }
        return "redirect:" + Lang.getLang(lang).getContext() + "/admin/orders/delivery";
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
        if (payment != null && !payment.getDescription().isEmpty()) {
            orderService.savePayment(payment);
        }
        return "redirect:" + Lang.getLang(lang).getContext() + "/admin/orders/payment";
    }

}
