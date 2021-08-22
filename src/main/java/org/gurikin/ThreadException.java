package org.gurikin;

public class ThreadException extends Thread {
    @Override
    public void run() {
        boolean flag = true;
        if (flag) {
            throw new RuntimeException();
        }
        System.out.println("End of ThreadException's run method");
    }
}
