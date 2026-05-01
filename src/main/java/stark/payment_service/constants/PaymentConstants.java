package stark.payment_service.constants;

import lombok.Data;

@Data
public class PaymentConstants {

    public static final String DEFAULT_CURRENCY = "INR" ;
    public static final String IDEMPOTENCY_KEY_HEADER = "idempotency-key";
    
    private PaymentConstants() {} 

}
