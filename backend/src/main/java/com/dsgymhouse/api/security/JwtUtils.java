package com.dsgymhouse.api.security;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtUtils {

    private final byte[] secretBytes;
    private final SecretKeySpec signingKey;

    @Value("${jwt.expiration-ms:3600000}")
    private long expirationMs;

    public JwtUtils(@Value("${jwt.secret:ds-gym-house-secret-key-for-dev}") String secret) {
        this.secretBytes = secret.getBytes(StandardCharsets.UTF_8);
        this.signingKey = new SecretKeySpec(secretBytes, "HmacSHA256");
    }

    private String hmac(String data) {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(signingKey);
            byte[] sig = mac.doFinal(data.getBytes(StandardCharsets.UTF_8));
            return Base64.getUrlEncoder().withoutPadding().encodeToString(sig);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String generateToken(String username) {
        long now = System.currentTimeMillis();
        String payload = username + ":" + now;
        String sig = hmac(payload);
        String token = payload + ":" + sig;
        return Base64.getUrlEncoder().withoutPadding().encodeToString(token.getBytes(StandardCharsets.UTF_8));
    }

    public String getUsernameFromToken(String token) {
        try {
            String decoded = new String(Base64.getUrlDecoder().decode(token), StandardCharsets.UTF_8);
            String[] parts = decoded.split(":");
            return parts.length >= 1 ? parts[0] : null;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean validateToken(String token) {
        try {
            String decoded = new String(Base64.getUrlDecoder().decode(token), StandardCharsets.UTF_8);
            String[] parts = decoded.split(":");
            if (parts.length != 3) return false;
            String username = parts[0];
            long ts = Long.parseLong(parts[1]);
            String sig = parts[2];
            String payload = username + ":" + ts;
            String expected = hmac(payload);
            if (!expected.equals(sig)) return false;
            long now = System.currentTimeMillis();
            return now - ts <= expirationMs;
        } catch (Exception e) {
            return false;
        }
    }
}
