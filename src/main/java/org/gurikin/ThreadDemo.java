package org.gurikin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 *
 */
public class ThreadDemo {
    public static void main(String[] args) {
        // ==================================
        // Example of wait/notify
        // ==================================
        Payment payment = new Payment();
        for (int i = 0; i < 5; i++) {
            final int j = i;
            new Thread(() -> payment.doPayment("pay-" + j)).start();
        }
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        payment.init();
    }
}
