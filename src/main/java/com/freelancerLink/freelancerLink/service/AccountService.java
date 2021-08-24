package com.freelancerLink.freelancerLink.service;

import com.freelancerLink.freelancerLink.entity.AccountInfo;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class AccountService {

    private static final String COLLECTION_NAME = "AccountInfo"; //firestore collection은 table과 비슷한 개념.

    public String saveAccountInfo(AccountInfo account) throws ExecutionException, InterruptedException {
        return "finish";
    }
}
