package stark.payment_service.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import stark.payment_service.enums.LedgerEventType;
import stark.payment_service.enums.PaymentStatus;

@Entity
@Table(name="payment_ledger")
@Builder
@EntityListeners(AuditingEntityListener.class) 
public class PaymentLedger {

    @Id 
    @GeneratedValue
    private UUID id;

    @Column(name="payments_id")
    private UUID paymentId;

    @Column(name="cart_id")
    private UUID cartId;

    @Column(name="event_type")
    @Enumerated(EnumType.STRING)
    private LedgerEventType eventType;
    /**
     *  
     * event_type: PAYMENT_CREATED
        status: CREATED

        event_type: ORDER_CREATED
        status: PENDING

        event_type: SIGNATURE_VERIFIED
        status: PENDING

        event_type: PAYMENT_SUCCESS
        status: SUCCESS
     */

    @Column(name="amount")
    private Long amount;

    @Column(name="status")
    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    @Column(name="created_at")
    @CreatedDate
    private LocalDateTime createdAt;

}
