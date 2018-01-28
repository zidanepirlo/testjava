package Entity;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Student {

    private String id;
    private int age;

    public Student() {
    }

    public Student(String id, int age) {
        this.id = id;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                ", id=" + id +
                ", age='" + age + '\'' +
                '}';
    }
}
