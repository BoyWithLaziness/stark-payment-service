package stark.payment_service.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreatePaymentResponse {

    private String paymentId;
    private String orderId;
    private Long amount;
    private String currency;
}

