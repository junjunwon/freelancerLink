package com.freelancerLink.controller;

import com.freelancerLink.domain.user.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/***
 RestController
    - controller which returns JSON is changed from basic Controller
    - each method doesn't have to delcare @ResponseBody with @RestController
 ***/

@RequiredArgsConstructor
@RestController
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


//    @GetMapping("/hello/dto")
//    public AccountInfoDto accountInfoDto(@RequestParam("name") String name,
//                                         @RequestParam("address") String address){
//        return new AccountInfoDto(name, address);
//    }

    @GetMapping("/api/login")
    public String login(){
        System.out.print("test return1");
        return "got return data!!!!";
    }
}
