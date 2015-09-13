package org.flyfishalex.controller;

import org.flyfishalex.bl.*;
import org.flyfishalex.controller.exception.UserNotFoundException;
import org.flyfishalex.enums.Lang;
import org.flyfishalex.enums.OrderStatus;
import org.flyfishalex.enums.Role;
import org.flyfishalex.exception.UserException;
import org.flyfishalex.model.Order;
import org.flyfishalex.model.OrderPoint;
import org.flyfishalex.model.User;
import org.flyfishalex.model.Variant;
import org.flyfishalex.model.dto.OrderDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by arusov on 14.05.2015.
 */
@Controller
@RequestMapping(value = "/{lang}/user")
public class UserController extends AbstractController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView getRegistration(@PathVariable("lang") String lang,
                                        @RequestParam(value = "error", required = false, defaultValue = "0") int error) {
        ModelAndView mav = new ModelAndView("registration");
        mav.addObject("user", new User());
        mav.addObject("lang", Lang.getLang(lang));
        if (error == 1) {
            mav.addObject("error", "Вы уже зарегистрированы на на нашем сайте");
        }
        return mav;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerUser(@PathVariable("lang") String lang, @ModelAttribute("user") User user) {
        if (user != null) {
            user.setRole(Role.USER.getCode());
            try {
                userService.createUser(user, Lang.getLang(lang));
            } catch (UserException ex) {
                return "redirect:" + Lang.getLang(lang).getContext() + "/user/registration?error=1";
            }
        }
        emailService.sendEmailRegistration(user);
        return "redirect:" + Lang.getLang(lang).getContext() + "/user/registration/success";
    }

    @RequestMapping(value = "/confirm", method = RequestMethod.GET)
    private ModelAndView confirmEmail(@PathVariable("lang") String lang) {
        ModelAndView mav = new ModelAndView("confirmEmail");
        mav.addObject("lang", Lang.getLang(lang));
        return mav;
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getLogin(@PathVariable("lang") String lang,
                                 @RequestParam(value = "error", required = false, defaultValue = "0") int error) {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("user", new User());
        mav.addObject("lang", Lang.getLang(lang));
        if (error == 1) {
            mav.addObject("error", "Неправильный email или пароль");
        }
        return mav;
    }

    @RequestMapping(value = "/basket/{variantId}", method = RequestMethod.GET)
    public String addToBasket(@PathVariable("lang") String lang, @PathVariable("variantId") long variantId) {
        User user = getCurrentUser();
        if (user == null) {
            throw new UserNotFoundException("User was not found", Lang.getLang(lang));
        }
        Variant variant = productService.getVariant(variantId);
        if (variant.getCount() <= 0) {
            //TODO: count <1
        }
        orderService.addToBasket(variant, user, Lang.getLang(lang));
        return "redirect:" + Lang.getLang(lang).getContext() + "/user/cabinet/cart";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@PathVariable("lang") String lang,
                        @ModelAttribute("user") User login) {
        User user = userService.getUser(login.getEmail(), login.getPwd());
        if (user == null) {
            return "redirect:" + Lang.getLang(lang).getContext() + "/user/login?error=1";
        }
        LOGGER.debug("User has ben found: {}", user.getEmail());
        session.setAttribute(SESSION_USER, user.getEmail());
        return "redirect:" + Lang.getLang(lang).getContext();
    }

    @RequestMapping(value = "cabinet/cart", method = RequestMethod.GET)
    public ModelAndView getCart(@PathVariable("lang") String lang, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("cart");
        mav.addObject("lang", Lang.getLang(lang));
        mav.addObject("rootCategories", categoryService.getCategoriesDTO(0, Lang.getLang(lang)));
        mav.addObject("childCategories", categoryService.get2ndCategories(Lang.getLang(lang)));
        String email = (String) request.getSession().getAttribute(SESSION_USER);
        User user = getCurrentUser();
        if (user == null) {
            throw new UserNotFoundException("User was not found", Lang.getLang(lang));
        }
        mav.addObject("user", user);
        Order basket = orderService.getBasket(user);
        if (basket != null) {
            mav.addObject("basket", basket);
            mav.addObject("orderDTO", orderService.getOrderPointDTO(basket.getId()));

        }
        mav.addObject("deliveries", orderService.getDeliveries());
        mav.addObject("payments", orderService.getPayments());

        return mav;
    }

    @RequestMapping(value = "cabinet/cart", method = RequestMethod.POST)
    public String doCart(@PathVariable("lang") String lang, @ModelAttribute("basket") Order order) {
        if (order != null) {
            order.setStatus(OrderStatus.CHECKING.getCode());
            List<OrderPoint> orderPoints = orderService.getOrderPoints(order.getId());
            User user = getCurrentUser();
            if (user == null) {
                throw new UserNotFoundException("User was not found", Lang.getLang(lang));
            }
            int finalPrice = 0;
            for (OrderPoint orderPoint : orderPoints) {
                finalPrice = finalPrice + orderPoint.getPrice() * orderPoint.getCount();
            }
            order.setFinalPrice(finalPrice);
            order.setUserId(user.getId());
            orderService.saveOrder(order);
        }
        return "redirect:" + Lang.getLang(lang).getContext() + "/user/order/success";
    }

    @RequestMapping(value = "cabinet/cart/recalculate")
    public String doCartRecalculate(@PathVariable("lang") String lang, @ModelAttribute("orderDTO") OrderDTO orderDTO) {
        if (orderDTO != null) {
            for (OrderPoint orderPoint : orderDTO.getOrderPoints()) {
                OrderPoint currentPoint=orderService.getOrderPoint(orderPoint.getId());
                if(currentPoint!=null){
                    currentPoint.setCount(orderPoint.getCount());
                    orderService.saveOrderPoint(currentPoint);
                }
            }
        }
        return "redirect:" + Lang.getLang(lang).getContext() + "/user/cabinet/cart";
    }

    @RequestMapping(value = "cabinet/orders", method = RequestMethod.GET)
    public ModelAndView getOrders(@PathVariable("lang") String lang) {
        ModelAndView mav = new ModelAndView("orders");
        mav.addObject("rootCategories", categoryService.getCategoriesDTO(0, Lang.getLang(lang)));
        mav.addObject("childCategories", categoryService.get2ndCategories(Lang.getLang(lang)));
        mav.addObject("lang", Lang.getLang(lang));
        User user = getCurrentUser();
        if (user != null) {
            mav.addObject("user", user);
            mav.addObject("statuses", OrderStatus.values());
            mav.addObject("orders", orderService.getOrders(user.getId()));
        } else {
            return new ModelAndView("redirect:" + Lang.getLang(lang).getContext() + "/user/login");
        }
        return mav;
    }


    @RequestMapping(value = "cabinet", method = RequestMethod.GET)
    public ModelAndView getCabinet(@PathVariable("lang") String lang) {
        ModelAndView mav = new ModelAndView("cabinet");
        mav.addObject("lang", Lang.getLang(lang));
        mav.addObject("rootCategories", categoryService.getCategoriesDTO(0, Lang.getLang(lang)));
        mav.addObject("childCategories", categoryService.get2ndCategories(Lang.getLang(lang)));
        User user = getCurrentUser();
        if (user != null) {
            mav.addObject("user", user);
        } else {
            return new ModelAndView("redirect:" + Lang.getLang(lang).getContext() + "/user/login");
        }
        return mav;
    }


    @RequestMapping(value = "cabinet", method = RequestMethod.POST)
    public String doCabinet(@PathVariable("lang") String lang,
                            @ModelAttribute("user") User user) {

        User currentUser=userService.getUser(user.getId());
        if(currentUser!=null){
            currentUser.setName(user.getName());
            currentUser.setPwd(user.getPwd());
            currentUser.setAddress(user.getAddress());
            userService.updateUser(currentUser);
        }
        LOGGER.debug("User has been changed {} {}", currentUser.getId(), currentUser.getEmail() );

        return "redirect:" + Lang.getLang(lang).getContext() + "/user/cabinet";
    }

}
