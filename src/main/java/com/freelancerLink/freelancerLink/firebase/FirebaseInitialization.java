package com.freelancerLink.freelancerLink.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.FileInputStream;


@Service
public class FirebaseInitialization {

    @PostConstruct
    public void initialization(){
        FileInputStream serviceAccount = null;

        try {
            String currDir = FirebaseInitialization.class.getResource(".").getPath();
            System.out.println(currDir);
            serviceAccount = new FileInputStream("./freelancerlink-85e18-firebase-adminsdk-t89x6-4ac3fab916.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://freelancerlink-85e18-default-rtdb.firebaseio.com")
                    .build();

            FirebaseApp.initializeApp(options);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
