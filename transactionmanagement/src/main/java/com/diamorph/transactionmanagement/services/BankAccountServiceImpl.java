package com.diamorph.transactionmanagement.services;

import com.diamorph.transactionmanagement.entities.BankAccount;
import com.diamorph.transactionmanagement.repositories.BankAccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    BankAccountRepository bankAccountRepository;

    public BankAccountServiceImpl(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    @Transactional
    public void transfer(int amount) {
        BankAccount scroogeAccount = bankAccountRepository.findByAccountNumber(1).get();
        scroogeAccount.setBalance(scroogeAccount.getBalance() - amount);
        bankAccountRepository.save(scroogeAccount);

        BankAccount tomAccount = bankAccountRepository.findByAccountNumber(2).get();
        tomAccount.setBalance(tomAccount.getBalance() + amount);
        bankAccountRepository.save(tomAccount);
    }
}
