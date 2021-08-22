package org.gurikin;

import java.util.concurrent.TimeUnit;

public class ThreadException extends Thread {
    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End of ThreadException's run method");
    }
}
