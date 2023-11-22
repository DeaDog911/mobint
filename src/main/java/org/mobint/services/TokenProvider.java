package org.mobint.services;

import org.mobint.models.Token;

import java.util.Random;

public class TokenProvider {
    private static Token token;
    // возвращает токен
    public Token getToken() throws InterruptedException {
        // Имитация запрсов к сторонней системе
        Thread.sleep(new Random().nextInt(10) * 1000);
        if (token == null) {
            token = new Token();
        }
        return token;
    }
}
