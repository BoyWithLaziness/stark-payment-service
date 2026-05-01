package stark.payment_service.dto;

import org.json.JSONObject;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RazorpayCreatePaymentRequest {

    @NotNull
    private Long amount;

    @NotNull
    private String currency;
    
    @NotNull
    private JSONObject notes;
}
