package com.ambh.ws.soap.soapclient.services;

import com.ambh.soap.Order;

import java.util.List;

public interface CustomerOrderWsClient {
    List<Order> getOrders(long customerId);
    boolean createOrder(long customerId, Order order);
    boolean deleteOrder(long customerId, long orderId);
}
