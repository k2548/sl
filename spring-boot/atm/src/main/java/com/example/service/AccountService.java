package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Account;
import com.example.repository.AccountRepository;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account save(Account account) {
    	return this.accountRepository.save(account);
    }

    public Account insert(Integer id, Integer amount) {
    	Account account = new Account();
    	account.setId(id);
    	account.setAmount(amount);
    	return this.save(account);
    }

    public Account findById(Integer id) {
    	return this.accountRepository.findById(id).get();
    }

    public Account update(Integer id, Integer amount) {
    	Account account = new Account();
    	account = this.findById(id);
    	account.setAmount(account.getAmount()+amount);
    	return this.save(account);
    }
}