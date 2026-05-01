package stark.payment_service.dto;

import lombok.Data;

import java.util.UUID;

import jakarta.validation.constraints.*;
@Data
public class CreatePaymentRequest {
    
    @NotNull
    private Long amount;

    @NotBlank
    private String currency;

    @NotBlank
    private UUID cartId;

}
