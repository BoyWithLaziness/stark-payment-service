package stark.payment_service.dto;
import lombok.Data;


@Data
public class GetPaymentResponse {

    private String status;
    private String orderId;
    private String paymentId;
    private Long amount;
    

}
