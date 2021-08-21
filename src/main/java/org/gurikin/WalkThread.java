package org.gurikin;

import java.util.concurrent.TimeUnit;

public class WalkThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Walk-" + i);
            try {
                TimeUnit.MILLISECONDS.sleep(3L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
