package org.flyfishalex.controller;

import org.flyfishalex.bl.CategoryService;
import org.flyfishalex.bl.OrderService;
import org.flyfishalex.controller.exception.OrderNotFoundException;
import org.flyfishalex.enums.Lang;
import org.flyfishalex.enums.OrderStatus;
import org.flyfishalex.model.Order;
import org.flyfishalex.model.YandexAvisoResponse;
import org.flyfishalex.model.YandexCheckResponse;
import org.flyfishalex.model.YandexRequestParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping(value = "/{lang}")
public class PaymentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentController.class);

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/payment", method = RequestMethod.GET)
    public ModelAndView getPayment(@PathVariable("lang") String lang, @RequestParam("order") long orderId) {
        ModelAndView mav = new ModelAndView(lang + "/payment");
        Order order = orderService.getOrder(orderId);
        if (order != null) {
            mav.addObject("price", order.getFinalPrice() + order.getDeliveryPrice());
            mav.addObject("orderId", order.getId());
            mav.addObject("userId", order.getUserId());

        } else {
            throw new OrderNotFoundException("Order was not found", Lang.getLang(lang));
        }

        LOGGER.debug("payment");

        mav.addObject("lang", Lang.getLang(lang));
        return mav;
    }

    @RequestMapping(value = "/paymentSuccess", method = RequestMethod.GET)
    public ModelAndView getPaymentSuccess(@PathVariable("lang") String lang) {
        ModelAndView mav = new ModelAndView(lang + "/paymentSuccess");
        mav.addObject("lang", Lang.getLang(lang));
        mav.addObject("rootCategories", categoryService.getCategoriesDTO(0, Lang.getLang(lang)));
        mav.addObject("childCategories", categoryService.get2ndCategories(Lang.getLang(lang)));
        return mav;
    }

    @RequestMapping(value = "/paymentFail", method = RequestMethod.GET)
    public ModelAndView getPaymentFail(@PathVariable("lang") String lang) {
        ModelAndView mav = new ModelAndView("redirect:" + Lang.getLang(lang).getContext());
        return mav;
    }

    @RequestMapping(value = "/checkURL", method = RequestMethod.POST)
    public
    @ResponseBody
    YandexCheckResponse check(HttpServletRequest request) {
        LOGGER.debug(request.getContentType());
        YandexCheckResponse yandexCheckResponse = new YandexCheckResponse();
        return yandexCheckResponse;
    }

    @RequestMapping(value = "/paymentAvisoURL", method = RequestMethod.POST)
    public void aviso(HttpServletRequest request) {
        LOGGER.debug(request.getContentType());
    }

    @RequestMapping(value = "/checkURLDemo", method = RequestMethod.POST)
    public
    @ResponseBody
    YandexCheckResponse checkDemo(@RequestParam Map<String, Object> yandexRequestParams) {
        LOGGER.debug("Yandex request check url parameters : {}", yandexRequestParams);
        YandexCheckResponse yandexCheckResponse = new YandexCheckResponse();
        try {
            yandexCheckResponse.setPerformedDatetime((String) yandexRequestParams.get(YandexRequestParams.requestDatetime));
            Long orderId = Long.parseLong((String) yandexRequestParams.get(YandexRequestParams.orderNumber));
            Order order = orderService.getOrder(orderId);
            if (order != null) {
                double price = Double.parseDouble((String) yandexRequestParams.get(YandexRequestParams.orderSumAmount));
                if (order.getFinalPrice() + order.getDeliveryPrice() == (int) price) {
                    yandexCheckResponse.setCode(0);
                    yandexCheckResponse.setInvoiceId((String) yandexRequestParams.get(YandexRequestParams.invoiceId));
                    yandexCheckResponse.setOrderSumAmount(String.valueOf(order.getDeliveryPrice() + order.getFinalPrice()));
                    yandexCheckResponse.setOrderSumAmount((String) yandexRequestParams.get(YandexRequestParams.orderSumAmount));
                    yandexCheckResponse.setShopId((String) yandexRequestParams.get(YandexRequestParams.shopId));
                    yandexCheckResponse.setMessage("Спасибо за покупку");
                    LOGGER.debug("Yandex response checkOrder {}", yandexCheckResponse);
                    return yandexCheckResponse;
                }

            } else {
                //todo: make an exception
                yandexCheckResponse.setCode(200);
                yandexCheckResponse.setMessage("УПС");
                yandexCheckResponse.setTechMessage("Нет заказа " + (String) yandexRequestParams.get(YandexRequestParams.orderNumber));
                LOGGER.error("Order has not been found: {}", (String) yandexRequestParams.get(YandexRequestParams.orderNumber));
                return yandexCheckResponse;
            }

        } catch (Exception e) {
            yandexCheckResponse.setCode(200);
            yandexCheckResponse.setMessage("УПС");
            yandexCheckResponse.setTechMessage(e.getMessage());
            LOGGER.error("Yandex error: {}", e);
        }

        return yandexCheckResponse;
    }

    @RequestMapping(value = "/paymentAvisoURLDemo", method = RequestMethod.POST)
    public
    @ResponseBody
    YandexAvisoResponse avisoDemo(@RequestParam Map<String, Object> yandexRequestParams) {
        LOGGER.debug("Yandex request aviso parameters : {}", yandexRequestParams);
        YandexAvisoResponse yandexResponse = new YandexAvisoResponse();
        try {
            yandexResponse.setPerformedDatetime((String) yandexRequestParams.get(YandexRequestParams.requestDatetime));
            Long orderId = Long.parseLong((String) yandexRequestParams.get(YandexRequestParams.orderNumber));
            Order order = orderService.getOrder(orderId);
            if (order != null) {
                order.setStatus(OrderStatus.PAYED.getCode());
                orderService.saveOrder(order);
            }
            yandexResponse.setCode(0);
            yandexResponse.setInvoiceId((String) yandexRequestParams.get(YandexRequestParams.invoiceId));
            yandexResponse.setShopId((String) yandexRequestParams.get(YandexRequestParams.shopId));
        } catch (Exception e) {
            yandexResponse.setCode(200);
            LOGGER.error("Yandex error: {}", e);
        }

        LOGGER.debug("Yandex response AvisOrder {}", yandexResponse);
        return yandexResponse;
    }


}
