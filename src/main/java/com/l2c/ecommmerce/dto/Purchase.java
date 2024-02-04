package com.l2c.ecommmerce.dto;

import com.l2c.ecommmerce.enitity.Address;
import com.l2c.ecommmerce.enitity.Customer;
import com.l2c.ecommmerce.enitity.Order;
import com.l2c.ecommmerce.enitity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;
}
