package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Account;
import com.example.resource.RequestAccount;
import com.example.resource.RequestAmount;
import com.example.resource.ResponseAmount;
import com.example.service.AccountService;

@RestController
@RequestMapping(value="/bankTrading", produces="application/json;charset=UTF-8")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/open")
    public Account open(@RequestBody RequestAccount requestAccount) {
    	return this.accountService.insert(requestAccount.getId(), requestAccount.getAmount());
    }

    @GetMapping("/{account_id}")
    public ResponseAmount getAmount(@PathVariable("account_id") Integer accountId) {
    	ResponseAmount requestAmount = new ResponseAmount();
    	requestAmount.setAmount(this.accountService.findById(accountId).getAmount());
    	return requestAmount;
    }

    @PostMapping("/deposit/{account_id}")
    public ResponseAmount deposit(@PathVariable("account_id") Integer id, @RequestBody RequestAmount requestAmount) {
    	ResponseAmount responseAmount = new ResponseAmount();
    	responseAmount.setAmount(
    			this.accountService
    			    .update(id, requestAmount.getAmount())
    			    .getAmount()
    			);

    	return responseAmount;
    }

    @PostMapping("/withdraw/{account_id}")
    public ResponseAmount withdraw(@PathVariable("account_id") Integer id, @RequestBody RequestAmount requestAmount) {
    	Account account = this.accountService.findById(id);
    	if(account.getAmount()<requestAmount.getAmount()) {
    		return this.getAmount(id);
    	}

    	ResponseAmount responseAmount = new ResponseAmount();
    	responseAmount.setAmount(
    			this.accountService
    			    .update(id, -requestAmount.getAmount())
    			    .getAmount()
    			);

    	return responseAmount;

    }
}