package Atomic.AtomicReference;

import Entity.Student;

import java.util.concurrent.atomic.AtomicReference;

public class Test_2 {

    public static void main(String[] args) {

        Student stu1 = new Student("1111",30);
        Student stu2 = new Student("1111",30);
        Student stu3 = new Student("2222",31);

        AtomicReference<Student> ar = new AtomicReference<Student>(stu1);

        Student stu4 = ar.getAndSet(stu3);
        System.out.println(stu4.getId());
        System.out.println(stu4.getAge());

        stu4 = ar.get();
        System.out.println(stu4.getId());
        System.out.println(stu4.getAge());
    }
}
