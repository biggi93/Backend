package com.l2c.ecommmerce.service;

import com.l2c.ecommmerce.dto.Purchase;
import com.l2c.ecommmerce.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);

}
