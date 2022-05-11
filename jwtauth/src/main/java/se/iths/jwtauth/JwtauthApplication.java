package se.iths.jwtauth;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.KeyPair;
import java.util.Arrays;
import java.util.Base64;

@SpringBootApplication
public class JwtauthApplication {

    public static void main(String[] args) {

        KeyPair keyPair = Keys.keyPairFor(SignatureAlgorithm.ES256);
        System.out.println(keyPair.getPrivate());
        System.out.println(Base64.getEncoder().encodeToString(keyPair.getPublic().getEncoded()));

        SpringApplication.run(JwtauthApplication.class, args);
    }

}
