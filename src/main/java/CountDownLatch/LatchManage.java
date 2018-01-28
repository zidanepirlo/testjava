package CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class LatchManage {


    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(1);
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println( Thread.currentThread().getName()+" running!");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" end!");
                countDownLatch.countDown();
            }
        };

        Thread thread_1 = new Thread(runnable1,"thread_1");
        thread_1.start();

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName());
    }

}
