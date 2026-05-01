package stark.payment_service.dto;

import jakarta.validation.constraints.*;

public class VerifyPaymentRequest {

    @NotBlank
    @NotNull
    private String orderId;

    private String paymentId;
    @NotBlank
    @NotNull
    
    private String signature;

}
