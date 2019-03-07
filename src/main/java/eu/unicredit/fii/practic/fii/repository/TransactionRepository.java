package eu.unicredit.fii.practic.fii.repository;

import eu.unicredit.fii.practic.fii.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
