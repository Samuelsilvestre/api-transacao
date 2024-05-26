package transaction.api.api_transaction.repository;

import java.util.UUID;

import org.springframework.boot.autoconfigure.pulsar.PulsarProperties.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import transaction.api.api_transaction.entity.TransactionModel;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionModel, UUID> {
    
}
