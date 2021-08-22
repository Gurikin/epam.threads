package org.gurikin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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

        // threadsPoolDemo(2);

        // System.out.println(callableDemo());

        Thread walkThread = new WalkThread();
        Thread talkThread = new Thread(new TalkThread());
        talkThread.setDaemon(true);
        walkThread.start();
        talkThread.start(); //If talkTread is slowly than walkThread than talkThread will not be finished and will be interrupted by main thread
        System.out.println("Main thread is end");
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

    public static String callableDemo() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> future = executor.submit(new CallThread());
        String result = "";
        try {
            result = future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        executor.shutdown(); //Stop executor. All threads will be done. After this cant run any threads from this executor.
        // executor.shutdownNow(); //Stop executor and all threads.
        return result;
    }
}
