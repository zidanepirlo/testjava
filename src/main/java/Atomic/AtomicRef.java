package Atomic;

import Entity.Student;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicRef {

    private static Logger logger = LoggerFactory.getLogger(AtomicRef.class);

    public static void main(String[] args) {

        AtomicReference<Student> studentAtomRef =  new AtomicReference<>(new Student("1111",36));
        Student student1 = new Student("1111",36);
        Student student2 = new Student("2222",37);
        Student student3 = new Student("3333",38);

//        studentAtomRef.set(student1);

        boolean success = studentAtomRef.compareAndSet(student1,student2);
//        boolean success = studentAtomRef.compareAndSet(new Student("1111",36),student2);
//        boolean success = studentAtomRef.compareAndSet(new Student("1111",36),student2);
//        boolean success = studentAtomRef.compareAndSet(studentAtomRef.get(),student2);

        logger.info("success = {}",success);

        student1.setId("2111");
        student1.setAge(336);

        if (success){
            Student temp = studentAtomRef.get();
            logger.info("AtomicRef value, student={}",temp);
        }

//        logger.info("student1={}",student1);


//        ExecutorService pool = Executors.newFixedThreadPool(2);
//
//        pool.submit(new Runnable() {
//            @Override
//            public void run() {
//
//                boolean success = studentAtomRef.compareAndSet(student1,new Student("xxxx",80));
//                logger.info("success = {}",success);
//                if (success){
//                    Student temp = studentAtomRef.get();
//                    logger.info("AtomicRef value, student={}",temp);
//                }
//            }
//        });
//
//        pool.submit(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        });

//        ScheduledExecutorService timer1 = Executors.newSingleThreadScheduledExecutor();
//        ScheduledExecutorService timer2 = Executors.newSingleThreadScheduledExecutor();
//
//        timer1.scheduleAtFixedRate(new Runnable() {
//            @Override
//            public void run() {
//                boolean success = studentAtomRef.compareAndSet(student1, student2);
//                logger.info("success = {}", success);
//                if (success) {
//                    Student temp = studentAtomRef.get();
//                    logger.info("AtomicRef value, student={}", temp);
//                }
//            }
//        },1000, 2000, TimeUnit.MILLISECONDS);
//
//
//        timer2.scheduleAtFixedRate(new Runnable() {
//            @Override
//            public void run() {
//                student2 = new Student();
//            }
//        },1000, 2000, TimeUnit.MILLISECONDS);



    }

    @Test
    public void test(){

        AtomicReference<Integer> studentAtomRef =  new AtomicReference<>();

        Integer val = new Integer(0);
        Integer val1 = new Integer(0);

    }
}
