package com.photoshare.paypal.contorller;

import com.paypal.api.payments.*;
import com.paypal.base.rest.PayPalRESTException;
import com.photoshare.paypal.config.PaypalPaymentIntent;
import com.photoshare.paypal.config.PaypalPaymentMethod;
import com.photoshare.paypal.service.PaypalService;
import com.photoshare.paypal.util.URLUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Set;

/**
 * @Author:Young
 * @Description
 * @Date: 2019/5/8 0008 11:13
 */
@Controller
@RequestMapping("/")
public class PaymentController {

    public static final String PAYPAL_SUCCESS_URL = "pay/success";
    public static final String PAYPAL_CANCEL_URL = "pay/cancel";

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private PaypalService paypalService;

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "pay")
    public String pay(HttpServletRequest request) {
        String cancelUrl = URLUtils.getBaseURl(request) + "/" + PAYPAL_CANCEL_URL;
        String successUrl = URLUtils.getBaseURl(request) + "/" + PAYPAL_SUCCESS_URL;
        try {
            Payment payment = paypalService.createPayment(
                    500.00,
                    "USD",
                    PaypalPaymentMethod.paypal,
                    PaypalPaymentIntent.sale,
                    "payment description",
                    cancelUrl,
                    successUrl);
            for (Links links : payment.getLinks()) {
                if (links.getRel().equals("approval_url")) {
                    // return "redirect:" + links.getHref();
                    return links.getHref();
                }
            }
        } catch (PayPalRESTException e) {
            log.error(e.getMessage());
        }
        return "redirect:/";
    }

    @RequestMapping(method = RequestMethod.GET, value = PAYPAL_CANCEL_URL)
    public String cancelPay() {
        return "cancel";
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = PAYPAL_SUCCESS_URL)
    public Payment successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId) {
        try {
            Payment payment = paypalService.executePayment(paymentId, payerId);
            if (payment.getState().equals("approved")) {
                return payment;
            }
        } catch (PayPalRESTException e) {
            log.error(e.getMessage());
        }
        return new Payment();
    }
}
