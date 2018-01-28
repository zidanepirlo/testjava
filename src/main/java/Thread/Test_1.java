package Thread;

public class Test_1 {

    public static void main(String[] args) {

        Runnable runnable = new Runnable() {

            private int count=0;
            private int count1=0;
            private int count2=0;

            @Override
            public void run() {
                while (++count2<900000000){
                    while (++count1<900000000){
                        while (++count<900000000);
                    };
                };

                System.out.println(Thread.currentThread().getName()+" running!");
            }
        };


        System.out.println(Thread.currentThread().getName());
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        Thread thread = new Thread(runnable);
//        thread.start();
//        try {
//            thread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
