package org.gurikin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 *
 */
public class ThreadDemo {
    public static void main(String[] args) {
        // ==================================
        // Example of creating of threads by implements Runnable and extends Thread
        // ==================================
        /*
         * for (int t = 0; t < 5; t++) { int t = 1;
         * System.out.println("Create threadWalk-" + t); Thread threadWalk = new
         * WalkThread(); threadWalk.start(); System.out.println("ThreadWalk-" + t +
         * " is started"); System.out.println("Create threadTalk-" + t); Thread
         * threadTalk = new Thread(new TalkThread()); threadTalk.start();
         * System.out.println("ThreadTalk-" + t + " is started"); } threadsPoolDemo(2);
         */

        // ==================================
        // Example of creating of threads by implements Callable
        // ==================================
        // System.out.println(callableDemo());

        // ==================================
        // Example of creating of daemons
        // ==================================
        /*
         * Thread walkThread = new WalkThread(); Thread talkThread = new Thread(new
         * TalkThread()); talkThread.setDaemon(true); walkThread.start();
         * talkThread.start(); //If talkTread is slowly than walkThread than talkThread
         * will not be finished and will be interrupted by main thread
         * System.out.println("Main thread is end");
         */

        // ==================================
        // Example of threads exceptions
        // ==================================
        /*
         * Thread threadException = new ThreadException(); threadException.start(); //
         * Example when NOT main thread is interrupted by exception // try { //
         * TimeUnit.MILLISECONDS.sleep(100L); // } catch (InterruptedException e) { //
         * e.printStackTrace(); // } // Example when main thread is interrupted by
         * exception try { TimeUnit.MILLISECONDS.sleep(20L); } catch
         * (InterruptedException e) { e.printStackTrace(); } if (Boolean.TRUE) { throw
         * new RuntimeException(); } System.out.println("Main thread is end");
         */
        // ==================================
        // Example of synchronized
        // ==================================
        /*
         * SyncClass syncClass = new SyncClass(); // syncClass.syncBlock();
         * syncClass.syncBlockBuffer();
         */

        // ==================================
        // Example of deadlock
        // ==================================
        /*
         * InviteAction invite1 = new InviteAction("first"); InviteAction invite2 = new
         * InviteAction("second"); new Thread(() -> invite1.invite(invite2)).start();
         * new Thread(() -> invite2.invite(invite1)).start();
         */

        // ==================================
        // Example of wait/notify
        // ==================================
        Payment payment = new Payment();
        for (int i = 0; i < 5; i++) {
            final int j = i;
            new Thread(() -> payment.doPayment("pay-" + j)).start();
        }
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        payment.init();
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
        while (!executorService.isTerminated()) {
        }
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
        executor.shutdown(); // Stop executor. All threads will be done. After this cant run any threads from
                             // this executor.
        // executor.shutdownNow(); //Stop executor and all threads.
        return result;
    }
}
