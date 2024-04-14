package com.webapp.projeto.application.security;

import org.springframework.stereotype.Component;

@Component
public class AuthManager {

    public String[] decodeBasicAuth(String basicAuth) {
        String encodedCredentials = basicAuth.substring(6);
        byte[] decodedBytes = java.util.Base64.getDecoder().decode(encodedCredentials);
        String decodedCredentials = new String(decodedBytes);
        return decodedCredentials.split(":");
    }
}
