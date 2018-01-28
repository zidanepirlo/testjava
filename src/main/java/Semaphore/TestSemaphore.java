package Semaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class TestSemaphore {

    public static void main(String[] args) {

        ExecutorService exec = Executors.newCachedThreadPool();
        final Semaphore semp = new Semaphore(1);
        int size = 3;
        Runnable[] runnables = new Runnable[size];

        for (int index = 0; index < size; index++) {

            final int NO = index;
            Runnable run = new Runnable() {
                public void run() {
                    try {
                        semp.acquire();
//                        semp.acquireUninterruptibly();
                        System.out.println("begin: " + NO);
                        System.out.println("doing something: " + NO);
                        Thread.sleep((long) (Math.random() * 10000));
                        System.out.println("end: " + NO);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    finally {
                        semp.release();
                    }
                }
            };

            runnables[index] = run;
        }

//        for (int i = 0; i<size;i++){
//            exec.execute(runnables[i]);
//        }

        Thread thread1 = new Thread(runnables[0]);
        Thread thread2 = new Thread(runnables[1]);
        Thread thread3 = new Thread(runnables[2]);

        thread1.start();
        thread2.start();
        thread2.interrupt();
        thread3.start();


//        exec.shutdown();
    }
}
