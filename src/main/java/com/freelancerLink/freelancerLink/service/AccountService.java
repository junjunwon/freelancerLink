package com.freelancerLink.freelancerLink.service;

import com.freelancerLink.freelancerLink.entity.AccountInfo;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class AccountService {

    private static final String COLLECTION_NAME = "AccountInfo"; //firestore collection은 table과 비슷한 개념.

    public String saveAccountInfo(AccountInfo account) throws ExecutionException, InterruptedException {

        Firestore dbFirestore = FirestoreClient.getFirestore();

        ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection(COLLECTION_NAME).document(account.getName()).set(account);

        return collectionApiFuture.get().getUpdateTime().toString();

    }
}
