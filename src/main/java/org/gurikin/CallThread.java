package org.gurikin;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class CallThread implements Callable<String> {
    
    @Override
    public String call() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            System.out.println("Call-" + i);
            builder.append("Call:\t" + i + "\n");
            try {
                TimeUnit.MILLISECONDS.sleep(1L);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }    
        return builder.toString();    
    }
}
