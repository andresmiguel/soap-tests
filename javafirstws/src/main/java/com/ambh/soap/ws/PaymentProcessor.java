package com.ambh.soap.ws;

import com.ambh.soap.dto.PaymentProcessorRequest;
import com.ambh.soap.dto.PaymentProcessorResponse;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(name = "PaymentProcessor")
public interface PaymentProcessor {

	@WebResult(name = "response")
	PaymentProcessorResponse processPayment(@WebParam(name = "paymentProcessorRequest") PaymentProcessorRequest paymentProcessorRequest);
}
