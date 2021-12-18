package fr.uga.im2ag.prisonnier;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@SpringBootApplication
public class RestServer {
    public static void main(String[] args) {
        SpringApplication.run(RestServer.class, args);
    }

}
