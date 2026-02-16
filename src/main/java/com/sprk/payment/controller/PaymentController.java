package com.sprk.payment.controller;

import com.sprk.payment.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/order/{orderId}")
    public Cart order(@PathVariable Long orderId){
        Cart orderCart=restTemplate.getForObject("http://cart/order/"+orderId,Cart.class);

        return orderCart;
    }
}
