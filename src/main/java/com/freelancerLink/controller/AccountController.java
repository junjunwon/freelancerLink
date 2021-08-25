package com.freelancerLink.controller;

import com.freelancerLink.entity.AccountInfoDto;
import org.springframework.web.bind.annotation.*;

/***
 RestController
    - controller which returns JSON is changed from basic Controller
    - each method doesn't have to delcare @ResponseBody with @RestController
 ***/
@RestController
//@RequestMapping("/api")
public class AccountController {
//    @Autowired
//    private AccountService accountService;

//    @GetMapping("/accounts")
//    public String saveAccount() throws ExecutionException, InterruptedException {
//        AccountInfo account = new AccountInfo();
//        account.setName("nameTest");
//        account.setAddress("addressTest");
////        return accountService.saveAccountInfo(account);
//        return "saveAccount";
//    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/dto")
    public AccountInfoDto accountInfoDto(@RequestParam("name") String name,
                                         @RequestParam("address") String address){
        return new AccountInfoDto(name, address);
    }
}