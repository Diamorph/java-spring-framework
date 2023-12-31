package com.diamorph.transactionmanagement.repositories;

import com.diamorph.transactionmanagement.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BankAccountRepository extends JpaRepository<BankAccount, Integer> {
    Optional<BankAccount> findByAccountNumber(int accountNumber);
}
