package com.ambh.soap.ws;

import com.ambh.soap.dto.PaymentProcessorRequest;
import com.ambh.soap.dto.PaymentProcessorResponse;
import org.apache.cxf.feature.Features;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(name = "PaymentProcessor")
@Features(features = "org.apache.cxf.feature.LoggingFeature")
public interface PaymentProcessor {

	@WebResult(name = "response")
	PaymentProcessorResponse processPayment(@WebParam(name = "paymentProcessorRequest") PaymentProcessorRequest paymentProcessorRequest);
}
