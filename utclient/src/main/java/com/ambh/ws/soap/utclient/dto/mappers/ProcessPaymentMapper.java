package com.ambh.ws.soap.utclient.dto.mappers;

import com.ambh.soap.ws.CreditCardInfo;
import com.ambh.soap.ws.PaymentProcessorRequest;
import com.ambh.ws.soap.utclient.dto.ProcessPaymentDto;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ProcessPaymentMapper {

    public PaymentProcessorRequest toPaymentProcessorRequest(ProcessPaymentDto processPaymentDto) {
        PaymentProcessorRequest request = new PaymentProcessorRequest();
        request.setAmount(processPaymentDto.amount);
        CreditCardInfo creditCard = new CreditCardInfo();
        creditCard.setAddress(processPaymentDto.address);
        creditCard.setCardNumber(processPaymentDto.cardNumber);
        creditCard.setFirstName(processPaymentDto.firstName);
        creditCard.setLastName(processPaymentDto.lastName);
        creditCard.setSecCode(processPaymentDto.secCode);
        creditCard.setExpiryDate(new Date(processPaymentDto.expiryDate));

        request.setCreditCardInfo(creditCard);

        return request;
    }
}
