package Entity;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class XXXX {

    private String id;
    private int age;

    public XXXX() {
    }

    public XXXX(String id, int age) {
        this.id = id;
        this.age = age;
    }
}
