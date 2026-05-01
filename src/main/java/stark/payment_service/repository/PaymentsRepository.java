package stark.payment_service.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import stark.payment_service.entity.Payment;

@Repository
public interface PaymentsRepository extends JpaRepository<Payment, UUID> {

}
