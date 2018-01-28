package Lock;

import Entity.Student;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockEntity {

    private Student student;

    private Lock lock;

    public LockEntity(){
        student = new Student("0",0);
        lock = new ReentrantLock();
    }

    public LockEntity(Student student){
        this.student = student;
        lock = new ReentrantLock();
    }

    public LockEntity(Lock lock){
        student = new Student("0",0);
        this.lock = lock;
    }

    public LockEntity(Student student,Lock lock){
        this.student = student;
        this.lock = lock;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Lock getLock() {
        return lock;
    }

    public void setLock(Lock lock) {
        this.lock = lock;
    }

}
