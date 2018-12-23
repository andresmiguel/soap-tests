package com.ambh.ws.soap.utclient.controllers;

import com.ambh.soap.ws.PaymentProcessorResponse;
import com.ambh.ws.soap.utclient.dto.ProcessPaymentDto;
import com.ambh.ws.soap.utclient.dto.mappers.ProcessPaymentMapper;
import com.ambh.ws.soap.utclient.service.PaymentClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private PaymentClient paymentClient;
    private ProcessPaymentMapper processPaymentMapper;

    public PaymentController(PaymentClient paymentClient, ProcessPaymentMapper processPaymentMapper) {
        this.paymentClient = paymentClient;
        this.processPaymentMapper = processPaymentMapper;
    }

    @PostMapping("/process")
    public PaymentProcessorResponse processPayment(@RequestBody ProcessPaymentDto processPaymentDto) {
        return paymentClient.processPayment(processPaymentMapper.toPaymentProcessorRequest(processPaymentDto));
    }
}
