package Lock;

public class MyThread extends Thread {

    private Test_1 test_1 = null;

    public MyThread(Test_1 Test_1,String name) {
        super(name);
        this.test_1 = test_1;
    }

    @Override
    public void run() {
        try {
            test_1.insert(Thread.currentThread());
        } catch (InterruptedException e) {
            System.out.println("线程 " + Thread.currentThread().getName() + "被中断...");
        }
    }
}
