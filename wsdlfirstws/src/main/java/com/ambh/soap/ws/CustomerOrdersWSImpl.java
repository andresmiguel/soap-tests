package com.ambh.soap.ws;

import com.ambh.soap.*;
import org.apache.cxf.feature.Features;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Features(features = "org.apache.cxf.feature.LoggingFeature")
public class CustomerOrdersWSImpl implements CustomerOrdersPortType {

    private Map<BigInteger, List<Order>> customerOrders = new HashMap<>();

    public CustomerOrdersWSImpl() {
        init();
    }

    public void init() {
        List<Order> orders = new ArrayList<>();
        Order order = new Order();
        order.setId(BigInteger.ONE);

        Product product = new Product();
        product.setId("Prod1");
        product.setQuantity(BigInteger.valueOf(10));
        product.setDescription("Laptop");

        order.getProduct().add(product);

        orders.add(order);

        customerOrders.put(BigInteger.ONE, orders);
    }

    @Override
    public GetOrdersResponse getOrders(GetOrdersRequest request) {
        GetOrdersResponse response = new GetOrdersResponse();
        response.getOrder().addAll(customerOrders.get(request.getCustomerId()));

        return response;
    }

    @Override
    public CreateOrdersResponse createOrders(CreateOrdersRequest request) {

        BigInteger customerId = request.getCustomerId();

        if (!customerOrders.containsKey(customerId)) {
            customerOrders.put(customerId, new ArrayList<>());
        }
        customerOrders.get(customerId).add(request.getOrder());

        CreateOrdersResponse response = new CreateOrdersResponse();
        response.setResult(true);

        return response;
    }
}
