package se.iths.gateway.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

@Component
public class JWTUtil {
    public Jws<Claims> getAllClaimsFromToken(String authToken) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String base64EncodedKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAyfn+2PoOQU9sIVeVJIIxGElwerGNc/bGn/wp5bOIeJ7+v29MeADbyjcfaqBRJOpNdwUg6ugsQc7OiiZOP+EmgU58vpGJrIRYVjRGvTEsNelWW9oJVRFTOQeCG/mlPjTrjYUXid1igSAZsMToAg9TWUdpJYHL7w8lHb1nKGKsy5f7EcsRXmu41dQKhJ1q6LGoPpfAAjzi0PlYGLh93e00UYGYNnX8F0/qgDJPEm4St4NSSQ+asoZ4B7H1Sx1fMod4YfQdaGM3aOEk2Y7XX7YjLcyX2qq+nsiNo/0Mp1UI0rFfe7GasWGylaR8zuIH8H2gi6nGWkL6A2ZxcMRZQp3bLwIDAQAB";

        byte[] byteKey = Base64.getDecoder().decode(base64EncodedKey.getBytes());

        X509EncodedKeySpec X509publicKey = new X509EncodedKeySpec(byteKey);
        KeyFactory kf = KeyFactory.getInstance("RSA");

        PublicKey publicKey = kf.generatePublic(X509publicKey);

        return  Jwts.parserBuilder()
                .setSigningKey(publicKey)
                .build()
                .parseClaimsJws(authToken);
    }
}
