package Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test_1 {

    private Lock lock = new ReentrantLock();

    public static void main(String[] args)  {

        Test_1 test_1 = new Test_1();
        MyThread thread1 = new MyThread(test_1,"A");
        MyThread thread2 = new MyThread(test_1,"B");
        thread1.start();
        thread2.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.interrupt();
    }

    public void insert(Thread thread) throws InterruptedException{
        //注意，如果需要正确中断等待锁的线程，必须将获取锁放在外面，然后将 InterruptedException 抛出
        lock.lockInterruptibly();
        try {
            System.out.println("线程 " + thread.getName()+"得到了锁...");
            long startTime = System.currentTimeMillis();
            for(    ;     ; ) {              // 耗时操作
                if(System.currentTimeMillis() - startTime >= Integer.MAX_VALUE)
                    break;
                //插入数据
            }
        }finally {
            System.out.println(Thread.currentThread().getName()+"执行finally...");
            lock.unlock();
            System.out.println("线程 " + thread.getName()+"释放了锁");
        }
        System.out.println("over");
    }
}
