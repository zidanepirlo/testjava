package fastjson;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Group {

    private Long id;
    private String name;
    private List<User> users = new ArrayList<User>();
}
