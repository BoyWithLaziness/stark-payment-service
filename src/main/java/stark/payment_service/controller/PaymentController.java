package stark.payment_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import stark.payment_service.dto.CreatePaymentRequest;
import stark.payment_service.dto.CreatePaymentResponse;
import stark.payment_service.dto.GetPaymentResponse;
import stark.payment_service.dto.GetServiceStatusResponse;
import stark.payment_service.dto.VerifyPaymentRequest;
import stark.payment_service.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping
    public ResponseEntity<CreatePaymentResponse> createPayment(@RequestBody CreatePaymentRequest body,
        @RequestHeader("idempotency-key") String idempotencyKey
) { 
        // return paymentService.createPayment();
        System.out.println("======>>>>>>Entered Controller createPayment");
        return ResponseEntity.ok(paymentService.createPayment(body, idempotencyKey));
        
    }

    @PostMapping("/verify")
    public GetPaymentResponse verifyPayment(@RequestBody VerifyPaymentRequest body) {
        return paymentService.verifyPayment(body);
    }

    @GetMapping("/status")
    public ResponseEntity<GetServiceStatusResponse> getServiceStatus(){
        return ResponseEntity.ok(GetServiceStatusResponse.builder()
                                        .status("OK")
                                        .build());
    }

    @GetMapping
    public GetPaymentResponse getPayment(@RequestParam String paymentId) {
         return paymentService.getPayment(paymentId);
    } 
}
