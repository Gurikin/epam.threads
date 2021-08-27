package org.gurikin;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SyncClass {
    private static int cnt = 0;

    synchronized public int syncCountMethod(int iterNum) {
        int count = 0;
        for (int i = 0; i < iterNum; i++) {
            count++;
        }
        return count;
    }

    public void syncBlock() {
        StringBuilder info = new StringBuilder();
        new Thread(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(new Random().nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (info) {
                do {
                    info.append('*');
                    System.out.println(info);
                } while (cnt++ < 2);
            }
        }).start();
        new Thread(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(new Random().nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (info) {
                while(cnt++ < 6) {
                    info.append('$');
                    System.out.println(info);
                }
            }
        }).start();
    }

    public void syncBlockBuffer() {
        StringBuffer info = new StringBuffer();
        new Thread(() -> {
            synchronized (info) {
                do {
                    info.append('*');
                    System.out.println(info);
                    try {
                        TimeUnit.MILLISECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } while (cnt++ < 6);
            }
        }).start();

        while(cnt++ < 3) {
            info.append('$');
            System.out.println(info);
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    } /* will output
    $
    $*
    $**
    $***
    $****
    $*****
    $******
    $******$
    */
}
