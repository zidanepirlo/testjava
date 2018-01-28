package Guava_cache;

import lombok.Getter;
import lombok.Setter;

/**
 * Person
 *
 * @author yuanqing
 * @create 2018-01-28 上午9:28
 **/

@Getter
@Setter
public class Person {
    private String id;
    private String name;

    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
