package com.ambh.ws.soap.utclient.service.impl;

import com.ambh.soap.ws.PaymentProcessor;
import com.ambh.soap.ws.PaymentProcessorImplService;
import com.ambh.soap.ws.PaymentProcessorRequest;
import com.ambh.soap.ws.PaymentProcessorResponse;
import com.ambh.ws.soap.utclient.service.PaymentClient;
import com.ambh.ws.soap.utclient.service.UTPasswordCallback;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.handler.WSHandlerConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentClientImpl implements PaymentClient {

    private PaymentProcessor paymentProcessor;

    public PaymentClientImpl(
            UTPasswordCallback utPasswordCallback,
            @Value("${paymentServiceUrl}") String paymentServiceUrl,
            @Value("${paymentServiceUsername}") String username) throws MalformedURLException {
        PaymentProcessorImplService service = new PaymentProcessorImplService(new URL(paymentServiceUrl));
        paymentProcessor = service.getPaymentProcessorImplPort();

        setSecurityInterceptor(utPasswordCallback, username);
    }

    private void setSecurityInterceptor(UTPasswordCallback utPasswordCallback, @Value("${paymentServiceUsername}") String username) {
        Map<String, Object> props = new HashMap<>();
        props.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);
        props.put(WSHandlerConstants.USER, username);
        props.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
        props.put(WSHandlerConstants.PW_CALLBACK_REF, utPasswordCallback);
        WSS4JOutInterceptor outInterceptor = new WSS4JOutInterceptor(props);

        Client client = ClientProxy.getClient(paymentProcessor);
        Endpoint endpoint = client.getEndpoint();
        endpoint.getOutInterceptors().add(outInterceptor);
    }

    @Override
    public PaymentProcessorResponse processPayment(PaymentProcessorRequest request) {
        return paymentProcessor.processPayment(request);
    }
}
