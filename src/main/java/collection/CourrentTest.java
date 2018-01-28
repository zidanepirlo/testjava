package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CourrentTest {


    public static void CourrentException(){

        List<Integer> list = new ArrayList<>();
        Iterator<Integer> ite = list.iterator();

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Runnable runnable1 = new Runnable() {

            @Override
            public void run() {

                for (int i=0;i<10;i++){
                    list.add(new Integer(i));
                }
            }
        };

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {

                while (ite.hasNext()){
                    System.out.println(ite.next());
                }
            }
        };

        executorService.execute(runnable1);
        executorService.execute(runnable2);

        executorService.shutdown();
    }

    public static void CourrentExceptionSyn(){

        List<Integer> list = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Object lock = new Object();

        Runnable runnable1 = new Runnable() {

            @Override
            public void run() {
                synchronized (lock){
                System.out.println(" thread1 ");
                for (int i=0;i<10;i++){
                        list.add(new Integer(i));
                        System.out.println(" thread1 add "+ new Integer(i));
                    }
                }
            }
        };

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    Iterator<Integer> ite = list.iterator();
                    System.out.println(" thread2 ");
                while (ite.hasNext()){
                        System.out.println(" thread2 "+ite.next());
                    }
                }
            }
        };

        executorService.execute(runnable1);
        executorService.execute(runnable2);

        executorService.shutdown();
    }


    public static void CopyOnWrite(){

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        List<Integer> list = new ArrayList<>();
        List<Integer> copyOnWriteList = new CopyOnWriteArrayList<>();


        for (int i=1 ;i<=5;i++){
            list.add(new Integer(i));
        }

        copyOnWriteList.addAll(list);

        Runnable runnable1 = new Runnable() {

            @Override
            public void run() {
                    for (int i=6;i<15;i++){
                        list.add(new Integer(i));
                        System.out.println(" thread1 add "+ new Integer(i));
                    }
            }
        };

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                    Iterator<Integer> ite = copyOnWriteList.iterator();
                    while (ite.hasNext()){
                        System.out.println(" thread2 "+ite.next());
                    }
                }
        };

        executorService.execute(runnable1);
        executorService.execute(runnable2);

        executorService.shutdown();

    }


    public static void main(String[] args) {

//        CourrentTest.CourrentException();
//        CourrentTest.CourrentExceptionSyn();
        CourrentTest.CopyOnWrite();
    }
}
