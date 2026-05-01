package stark.payment_service.dto;

import java.time.LocalDateTime;

import org.json.JSONObject;

import lombok.Data;

@Data
public class RazorpayCreatePaymentResponse {
  
  private Long  amount;
  private Long amount_due;
  private Long amount_paid;
  private int attempts;
  private Long created_at;
  private String currency;
  private String entity;
  private String id;
  private JSONObject notes;
  private String offer_id;
  private String receipt;
  private String status;
}
