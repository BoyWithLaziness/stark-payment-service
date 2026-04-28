package stark.payment_service.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table( name = "payments" )
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name="order_id")
    private String orderId;
    
    @Column(name="payment_id")
    private String paymentId;
    
    @Column(name="user_id")
    private String userId;
    
    @Enumerated(EnumType.STRING)
    @Column(name="order_status")
    private String orderStatus;
    
    @Enumerated(EnumType.STRING)
    @Column(name="payment_status")
    private String paymentStatus;
    
    @Column(name="idompotency_key")
    private String idompotencyKey;
    
    @Column(name="amount")
    private Long amount;
    
    @Column(name="created_at")
    private LocalDateTime createdAt;
    
    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    @Lob
    @Column(name="metadata")
    private String metaData;


}
