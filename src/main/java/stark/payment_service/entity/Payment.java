package stark.payment_service.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import org.hibernate.annotations.Type;

import stark.payment_service.enums.ProviderOrderStatus;
import stark.payment_service.enums.PaymentStatus;

@Entity
@Table( name = "payments" )
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class) 
public class Payment {
    @Id 
    @GeneratedValue
    private UUID id;

    @Column(name="provider_order_id")
    private String providerOrderId;
    
    @Column(name="provider_payment_id")
    private String providerPaymentId;

    @Enumerated(EnumType.STRING)
    @Column(name="order_status")
    private ProviderOrderStatus orderStatus;

    @Column(name="cart_id")
    private UUID cartId;
    
    @Enumerated(EnumType.STRING)
    @Column(name="payment_status")
    private PaymentStatus paymentStatus;
    
    @Column(name="idempotency_key")
    private String idempotencyKey;
    
    @Column(name="amount")
    private Long amount;

    @Column(name="currency")
    private String currency;
    
    @CreatedDate
    @Column(name="created_at")
    private LocalDateTime createdAt;
    
    @LastModifiedDate
    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    @Type(JsonType.class)
    @Column(name="metadata", columnDefinition = "jsonb")
    private Map<String, Object> metaData;



}
