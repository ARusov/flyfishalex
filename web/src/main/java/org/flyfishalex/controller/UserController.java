package org.flyfishalex.controller;

import org.flyfishalex.bl.ProductService;
import org.flyfishalex.controller.exception.UserNotFoundException;
import org.flyfishalex.bl.OrderService;
import org.flyfishalex.bl.UserService;
import org.flyfishalex.model.User;
import org.flyfishalex.enums.Lang;
import org.flyfishalex.enums.OrderStatus;
import org.flyfishalex.enums.Role;
import org.flyfishalex.model.Order;
import org.flyfishalex.model.Variant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by arusov on 14.05.2015.
 */
@Controller
@RequestMapping(value = "/{lang}/user")
public class UserController extends AbstractController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView getRegistration(@PathVariable("lang") String lang) {
        ModelAndView mav = new ModelAndView("registration");
        mav.addObject("user", new User());
        mav.addObject("lang", Lang.getLang(lang));
        return mav;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerUser(@PathVariable("lang") String lang, @ModelAttribute("user") User user) {
        if (user != null) {
            user.setRole(Role.USER.getCode());
            userService.createUser(user);
        }

        return "redirect:" + Lang.getLang(lang).getContext()+"/user/registration/success";
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getLogin(@PathVariable("lang") String lang) {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("user", new User());
        mav.addObject("lang", Lang.getLang(lang));
        return mav;
    }

    @RequestMapping(value = "/basket/{variantId}", method = RequestMethod.GET)
    public String addToBasket(@PathVariable("lang") String lang, @PathVariable("variantId") long variantId) {
        User user = getUser();
        if (user == null) {
            throw  new UserNotFoundException("User was not found", Lang.getLang(lang));
        }
        Variant variant = productService.getVariant(variantId);
        if (variant.getCount() <= 0) {
            //TODO: count <1
        }
        orderService.addToBasket(variant, user, Lang.getLang(lang));
        return "redirect:"+Lang.getLang(lang).getContext()+"/user/cabinet/cart";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@PathVariable("lang") String lang, @ModelAttribute("user") User login, HttpServletRequest request) {
        User user = userService.getUser(login.getEmail(), login.getPwd());
        if (user == null) {
            return "redirect:" + Lang.getLang(lang).getContext() + "/user/login?error=1";
        }
        UserDetails userDetails = userService.loadUserByUsername(user.getEmail());
        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return "redirect:" + Lang.getLang(lang).getContext();
    }

    @RequestMapping(value = "cabinet/cart", method = RequestMethod.GET)
    public ModelAndView getCart(@PathVariable("lang") String lang) {
        ModelAndView mav = new ModelAndView("cart");
        mav.addObject("lang", Lang.getLang(lang));
        User user = getUser();
        if (user == null) {
            throw new UserNotFoundException("User was not found", Lang.getLang(lang));
        }
        mav.addObject("user", user);
        Order basket = orderService.getBasket();
        if (basket != null) {
            mav.addObject("basket", basket);
            mav.addObject("orderPointDTO", orderService.getOrderPointDTO(basket.getId()));

        }
        mav.addObject("deliveries", orderService.getDeliveries());
        mav.addObject("payments", orderService.getPayments());

        return mav;
    }

    @RequestMapping(value = "cabinet/cart", method = RequestMethod.POST)
    public String doCart(@PathVariable("lang") String lang, @ModelAttribute("basket") Order order) {
        if (order != null) {
            order.setStatus(OrderStatus.CHECKING.getCode());
            User user = userService.getCurrentUser();
            order.setUserId(user.getId());
            orderService.saveOrder(order);
        }
        return "redirect:" + Lang.getLang(lang).getContext() + "/user/order/success";
    }

    @RequestMapping(value = "cabinet/orders", method = RequestMethod.GET)
    public ModelAndView getOrders(@PathVariable("lang") String lang) {
        ModelAndView mav = new ModelAndView("orders");
        mav.addObject("lang", Lang.getLang(lang));
        User user = getUser();
        if (user != null) {
            mav.addObject("user", user);
            mav.addObject("orders", orderService.getOrders(user.getId()));
        }
        return mav;
    }

}
