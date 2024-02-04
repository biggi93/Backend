package com.l2c.ecommmerce.service;

import com.l2c.ecommmerce.dao.CustomerRepository;
import com.l2c.ecommmerce.dto.Purchase;
import com.l2c.ecommmerce.dto.PurchaseResponse;
import com.l2c.ecommmerce.enitity.Customer;
import com.l2c.ecommmerce.enitity.Order;
import com.l2c.ecommmerce.enitity.OrderItem;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService{

    private final CustomerRepository customerRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        Order order = purchase.getOrder();

        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(order::add);

        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());

        Customer customer = purchase.getCustomer();

        String email = customer.getEmail();
        Customer customerFromDB = customerRepository.findByEmail(email);
        if (customerFromDB != null){
            customer = customerFromDB;
        }

        customer.add(order);

        customerRepository.save(customer);

        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}
