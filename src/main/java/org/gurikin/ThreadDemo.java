package org.gurikin;

public class ThreadDemo {
    public static void main(String[] args) {
        // ==================================
        // Example of wait/notify and producer/consumer behavior
        // ==================================
        ConsumerProducerWaitNotifyExample consumerProducerExample = new ConsumerProducerWaitNotifyExample();
        int iterNums = 5;
        int cnt = 0;
        while (cnt++ < iterNums) {
            new Thread(() -> consumerProducerExample.consumer()).start();
            new Thread(() -> consumerProducerExample.producer()).start();
        }
    }
}
