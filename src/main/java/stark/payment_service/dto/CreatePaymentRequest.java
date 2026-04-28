package stark.payment_service.dto;

import org.antlr.v4.runtime.misc.NotNull;

import lombok.Data;

@Data
public class CreatePaymentRequest {
    @NotNull
    private Long amount;

    @NotBlank
    private String currency;

    @NotBlank
    private String userId;

    private String description;

}
