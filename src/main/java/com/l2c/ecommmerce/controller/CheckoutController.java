package com.l2c.ecommmerce.controller;

import com.l2c.ecommmerce.dto.Purchase;
import com.l2c.ecommmerce.dto.PurchaseResponse;
import com.l2c.ecommmerce.service.CheckoutService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {
    private CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {

        return checkoutService.placeOrder(purchase);
    }
}
