package com.ambh.ws.soap.soapclient.controllers;

import com.ambh.soap.Order;
import com.ambh.ws.soap.soapclient.services.CustomerOrderWsClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerOrdersController {

    private CustomerOrderWsClient customerOrderWsClient;

    public CustomerOrdersController(CustomerOrderWsClient customerOrderWsClient) {
        this.customerOrderWsClient = customerOrderWsClient;
    }

    @GetMapping("/{customerId}/orders")
    public List<Order> getOrders(@PathVariable Long customerId) {
        return customerOrderWsClient.getOrders(customerId);
    }

    @PostMapping("/{customerId}/orders")
    public Boolean createOrder(@PathVariable Long customerId, @RequestBody Order order) {
        return customerOrderWsClient.createOrder(customerId, order);
    }

    @DeleteMapping("/{customerId}/orders/{orderId}")
    public Boolean deleteOrder(@PathVariable Long customerId, @PathVariable Long orderId) {
        return customerOrderWsClient.deleteOrder(customerId, orderId);
    }
}
