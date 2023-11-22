package org.mobint.models;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

public class Token {
    private static final int LIVING_TIME_MINUTES = 30; // Время жизни токена в минутах
    private String token;
    private Date expirationTime;

    public Token() throws InterruptedException {
        refresh();
    }

    private String generateToken() {
        // Для примера возьмем токен как случайно сгенерированную строку из 256 символов
        String alp = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 256; i++) {
            stringBuilder.append(alp.charAt(new Random().nextInt(0, alp.length())));
        }
        return stringBuilder.toString();
    }

    // возвращает время окончания токена
    public Date getExpirationTime() {
        return this.expirationTime;
    }

    // обновляет токен
    public void refresh() throws InterruptedException {
        this.token = generateToken();
        this.expirationTime = new Date(new Date().getTime() + (LIVING_TIME_MINUTES * 60 * 1000));

        // Имитация запрсов к сторонней системе
        Thread.sleep(new Random().nextInt(10) * 1000);
    }

    @Override
    public String toString() {
        return token;
    }
}
