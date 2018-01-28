package mock;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by yuan on 2017/6/29.
 */
@Setter
@Getter
public class AdvertiserAndMediaStatViewModel {

    private String id;
    private String name;

    public AdvertiserAndMediaStatViewModel(String id,String name){
        this.id = id;
        this.name = name;
    }
}
