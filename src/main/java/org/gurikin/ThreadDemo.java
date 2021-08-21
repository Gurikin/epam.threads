package org.gurikin;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Hello world!
 *
 */
public class ThreadDemo {
    public static void main(String[] args) {
        // for (int t = 0; t < 5; t++) {
            // int t = 1;
            // System.out.println("Create threadWalk-" + t);
            // Thread threadWalk = new WalkThread();
            // threadWalk.start();
            // System.out.println("ThreadWalk-" + t + " is started");
            // System.out.println("Create threadTalk-" + t);
            // Thread threadTalk = new Thread(new TalkThread());
            // threadTalk.start();
            // System.out.println("ThreadTalk-" + t + " is started");
        // }

        threadsPoolDemo(2);
    }

    public static void threadsPoolDemo(int poolSize) {
        ExecutorService executorService = Executors.newFixedThreadPool(poolSize);
        executorService.execute(new TalkThread());
        executorService.execute(new TalkThread());
        executorService.execute(new TalkThread());
        executorService.execute(new TalkThread());
        executorService.execute(new TalkThread());
        executorService.execute(new TalkThread());
        executorService.shutdown();
        while (!executorService.isTerminated()) {}
    }
}
