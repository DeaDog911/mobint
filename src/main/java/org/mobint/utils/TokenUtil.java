package org.mobint.utils;

import org.mobint.models.Token;
import org.mobint.services.TokenProvider;

import java.util.Date;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class TokenUtil {
    private static final ReentrantLock lock = new ReentrantLock();
    public Token getToken() {
        Token token = null;
        try {
            TokenProvider tokenProvider = new TokenProvider();
            lock.lock();
            Callable callable = () -> {
                Token token1 = tokenProvider.getToken();
                if (new Date().after(token1.getExpirationTime())) {
                    token1.refresh();
                };
                return token1;
            };
            FutureTask<Token> task = new FutureTask<>(callable);
            Thread thread = new Thread(task);
            thread.start();
            token = task.get(15, TimeUnit.SECONDS);
        } catch (TimeoutException | InterruptedException e) {
            System.out.println("Не удалось получить токен");
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
        return token;
    }
}
