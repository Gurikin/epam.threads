package org.gurikin;

import java.util.concurrent.TimeUnit;

public class TalkThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Talk-" + i);
            try {
                TimeUnit.MILLISECONDS.sleep(1L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }        
    }
    
}
