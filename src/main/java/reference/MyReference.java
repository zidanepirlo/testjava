package reference;

import Entity.Student;

public class MyReference {


    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public final Student acqStudent(){
        return this.student;
    }
}
