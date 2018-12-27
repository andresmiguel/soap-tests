package com.ambh.soap.ws;

import com.ambh.soap.dto.PaymentProcessorRequest;
import com.ambh.soap.dto.PaymentProcessorResponse;

public class PaymentProcessorImpl implements PaymentProcessor {

	@Override
	public PaymentProcessorResponse processPayment(PaymentProcessorRequest paymentProcessorRequest) throws ServiceException {
		PaymentProcessorResponse paymentProcessorResponse = new PaymentProcessorResponse();

		if (paymentProcessorRequest.getCreditCardInfo().getCardNumber() == null ||
				paymentProcessorRequest.getCreditCardInfo().getCardNumber().isEmpty()) {
			throw new ServiceException("Invalid Credit Card Number");
		}

		// Business Logic or a call to a Business Logic Class Goes Here.
		paymentProcessorResponse.setResult(true);
		return paymentProcessorResponse;
	}

}
