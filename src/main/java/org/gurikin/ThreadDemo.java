package org.gurikin;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

public class ThreadDemo {
    public static void main(String[] args) {
        // ==================================
        // Example of exchanger
        // ==================================
        ItemAction itemAction = new ItemAction();
        Item item1 = new Item(1, new BigDecimal("5.0"), "Item-1");
        Item item2 = new Item(2, new BigDecimal("7.0"), "Item-2");
        System.out.printf("%s%s%n%n%n", item1, item2);
        new Thread(() -> itemAction.doActionPrice(item1, new BigDecimal("0.9"))).start();
        new Thread(() -> itemAction.doActionDescription(item2, " with discount")).start();
        try {
            TimeUnit.SECONDS.timedJoin(Thread.currentThread(), 1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s%s%n%n%n", item1, item2);
    }
}
