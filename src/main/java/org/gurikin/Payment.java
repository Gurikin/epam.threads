package org.gurikin;

import java.util.Scanner;

public class Payment {
    private int amount;
    private String name;

    public Payment(String name) {
        this.name = name;
    }

    public synchronized void doPayment() {
        while (amount <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Released " + name);
    }
    
    public synchronized void init() {
        System.out.println("Init amount:");
        amount = new Scanner(System.in).nextInt();
        notify();
    }
}
