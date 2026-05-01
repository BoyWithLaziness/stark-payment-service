package stark.payment_service.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import stark.payment_service.entity.PaymentLedger;

@Repository
public interface PaymentLedgerRepository extends JpaRepository<PaymentLedger, UUID>{

}
