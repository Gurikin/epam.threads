package org.gurikin;

import java.util.concurrent.TimeUnit;

/**
 * This class is example of consumer-producer behavior
 * 1. Consumer check flag for equals to false.
 * 1.1. If flag == false, than set state of thread to wait
 * 1.2. else do something work and set flag to false
 * 2. Producer do something work set flag to true and notify waited thread
 */
public class ConsumerProducerWaitNotifyExample {
    private boolean flag;

    public synchronized void consumer() {
        while (!flag) {
            try {
                wait();
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Consumer: do something work...");
        System.out.println("Set flag to false.");
        // do somethig you need
        flag = false;
    }
    
    public synchronized void producer() {
        System.out.println("Producer: do something work...");
        System.out.println("Set flag to true.");
        // do something work
        flag = true;
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notify();
    }
}
