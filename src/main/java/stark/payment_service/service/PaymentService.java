package stark.payment_service.service;

import java.util.Base64;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import stark.payment_service.configuration.RazorpayConfig;
import stark.payment_service.constants.PaymentConstants;
import stark.payment_service.dto.CreatePaymentRequest;
import stark.payment_service.dto.CreatePaymentResponse;
import stark.payment_service.dto.GetPaymentResponse;
import stark.payment_service.dto.RazorpayCreatePaymentRequest;
import stark.payment_service.dto.RazorpayCreatePaymentResponse;
import stark.payment_service.dto.VerifyPaymentRequest;
import stark.payment_service.entity.Payment;
import stark.payment_service.entity.PaymentLedger;
import stark.payment_service.repository.PaymentLedgerRepository;
import stark.payment_service.repository.PaymentsRepository;
import stark.payment_service.enums.ProviderOrderStatus;
import stark.payment_service.enums.PaymentStatus;
import stark.payment_service.enums.LedgerEventType;

@Service
public class PaymentService {

    @Autowired
    private RazorpayConfig razorpayConfig;

    @Autowired
    private RazorpayClient razorPayClient;

    @Autowired
    private PaymentsRepository paymentsRepository;

    @Autowired
    private PaymentLedgerRepository paymentledgerRepository;

    public CreatePaymentResponse createPayment(CreatePaymentRequest body, String idempotencyKey) {
        try {
            System.out.println("======>>>>>>Entered Service createPayment");
            String preAuthKey = razorpayConfig.getKeyId() +':'+ razorpayConfig.getKeySecret();
            String authKey = Base64.getEncoder().encodeToString(preAuthKey.getBytes());
            //1. create order with razor pay
            RazorpayCreatePaymentRequest payload = new RazorpayCreatePaymentRequest();
            JSONObject notes = new JSONObject();
            notes.put("cartId", body.getCartId());
            payload.setAmount(body.getAmount());
            payload.setCurrency(body.getCurrency());
            payload.setNotes(notes);
            RazorpayCreatePaymentResponse razorPayResponse = razorPayClient.createRazorpayPayment((RazorpayCreatePaymentRequest) payload, authKey);
            CreatePaymentResponse response =  CreatePaymentResponse.builder()
                                                    .amount(razorPayResponse.getAmount())
                                                    .orderId(razorPayResponse.getId())
                                                    .currency(razorPayResponse.getCurrency())
                                                    .build();


            //2. create payments table record
            Payment paymentEntity = Payment.builder()
                                            .providerOrderId(response.getOrderId())
                                            .orderStatus(ProviderOrderStatus.CREATED)
                                            .cartId(body.getCartId())
                                            .paymentStatus(PaymentStatus.CREATED)
                                            .amount(body.getAmount())
                                            .idempotencyKey(idempotencyKey)
                                            .amount(body.getAmount())
                                            .currency(PaymentConstants.DEFAULT_CURRENCY)
                                            .build();
            System.out.println("======>>>>>>Create payment entity ");
            System.out.println(paymentEntity);
            Payment savedPayment = paymentsRepository.save(paymentEntity);
            System.out.println("======>>>>>>Saved payment entity ");
            System.out.println(savedPayment);
            //3. create payment_legder table record

            PaymentLedger paymentLedgerEntity = PaymentLedger.builder()
                                                                .paymentId(savedPayment.getId())
                                                                .cartId(body.getCartId())
                                                                .eventType(LedgerEventType.ORDER_CREATED)
                                                                .status(PaymentStatus.CREATED)
                                                                .build();
            System.out.println("======>>>>>>Create payment ledger entity ");
            System.out.println(paymentLedgerEntity);
            
            paymentledgerRepository.save(paymentLedgerEntity);
            System.out.println("======>>>>>>Saved payment ledger entity ");
            //4. return response object;
            
            System.out.println("======>>>>>>Returning response");
            System.out.println(response);
            return response;
        }
        catch(Exception e){
            throw e;
        }
    }

    public GetPaymentResponse verifyPayment(VerifyPaymentRequest body) {
        return null;
    }

    public GetPaymentResponse getPayment(String paymentId) {
        return null;
    }
    
}
