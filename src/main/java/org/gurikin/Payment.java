package org.gurikin;

import java.util.Scanner;

public class Payment {
    private int amount;

    public Payment() {
    }

    public synchronized void doPayment(String paymentName) {
        while (amount <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Released " + paymentName);
    }

    public synchronized void init() {
        System.out.println("Init amount:");
        try (Scanner scanner = new Scanner(System.in)) {
            amount = scanner.nextInt();
        }
        notifyAll();
    }
}
