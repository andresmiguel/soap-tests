package com.ambh.ws.soap.soapclient.services.impl;

import com.ambh.soap.*;
import com.ambh.soap.ws.CustomerOrdersWSImplService;
import com.ambh.ws.soap.soapclient.services.CustomerOrderWsClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@Service
public class CustomerOrderWsClientImpl implements CustomerOrderWsClient {

    private CustomerOrdersPortType customerOrdersPortType;

    public CustomerOrderWsClientImpl(@Value("${customerOrdersServiceUrl}") String customerOrdersServiceUrl)
            throws MalformedURLException {

        CustomerOrdersWSImplService service = new CustomerOrdersWSImplService(new URL(customerOrdersServiceUrl));
        customerOrdersPortType = service.getCustomerOrdersWSImplPort();
    }

    @Override
    public List<Order> getOrders(long customerId) {
        GetOrdersRequest request = new GetOrdersRequest();
        request.setCustomerId(BigInteger.valueOf(customerId));
        GetOrdersResponse response = customerOrdersPortType.getOrders(request);

        return response.getOrder();
    }

    @Override
    public boolean createOrder(long customerId, Order order) {
        CreateOrdersRequest request = new CreateOrdersRequest();
        request.setCustomerId(BigInteger.valueOf(customerId));
        request.setOrder(order);

        return customerOrdersPortType.createOrders(request).isResult();
    }

    @Override
    public boolean deleteOrder(long customerId, long orderId) {
        DeleteOrdersRequest request = new DeleteOrdersRequest();
        request.setCustomerId(BigInteger.valueOf(customerId));
        request.setOrderId(BigInteger.valueOf(orderId));

        return customerOrdersPortType.deleteOrders(request).isResult();
    }
}
