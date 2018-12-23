package com.ambh.ws.soap.utclient.service;

import com.ambh.soap.ws.PaymentProcessorRequest;
import com.ambh.soap.ws.PaymentProcessorResponse;

public interface PaymentClient {

    PaymentProcessorResponse processPayment(PaymentProcessorRequest request);
}
