package stark.payment_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import stark.payment_service.dto.CreatePaymentRequest;
import stark.payment_service.dto.CreatePaymentResponse;
import stark.payment_service.dto.GetPaymentResponse;
import stark.payment_service.dto.VerifyPaymentRequest;
import stark.payment_service.service.PaymentService;

@Component
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping
    public CreatePaymentResponse createPayment(@RequestBody CreatePaymentRequest body) {
        // return paymentService.createPayment();
        return null;
        
    }

    @PostMapping
    public GetPaymentResponse verifyPayment(@RequestBody VerifyPaymentRequest body) {
        // return paymentService.verifyPayment();
        return null;
    }

    @GetMapping
    public GetPaymentResponse getPayment(@RequestParam String paymentId) {
         // return paymentService.getPayment();
        return null;  
    } 
}
