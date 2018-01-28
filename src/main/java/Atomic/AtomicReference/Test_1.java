package Atomic.AtomicReference;

import Entity.Student;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

public class Test_1 {

    public static void main(String[] args) {

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);
        Student student = new Student("1111",34);
        AtomicReference<Student> atomicReference = new AtomicReference<Student>();
        atomicReference.set(student);


        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {

                Student stu1 =  atomicReference.get();
                stu1.setId("2222");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                stu1.setAge(20);
                atomicReference.getAndSet(stu1);
            }
        };

        Runnable runnable2 = new
                Runnable() {
                    @Override
                    public void run() {

                        Student stu1 =  atomicReference.get();
                        stu1.setId("2222");
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        stu1.setAge(20);
                        atomicReference.getAndSet(stu1);
                    }
                };

        fixedThreadPool.execute(runnable1);
        fixedThreadPool.execute(runnable2);

        fixedThreadPool.shutdown();

        System.out.println(student.getId());
        System.out.println(student.getAge());
    }
}
