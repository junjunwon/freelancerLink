package com.freelancerLink.freelancerLink.controller;

import com.freelancerLink.freelancerLink.entity.AccountInfo;
import com.freelancerLink.freelancerLink.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/accounts")
    public String saveAccount() throws ExecutionException, InterruptedException {
        AccountInfo account = new AccountInfo();
        account.setName("nameTest");
        account.setAddress("addressTest");
        return accountService.saveAccountInfo(account);
    }
}
