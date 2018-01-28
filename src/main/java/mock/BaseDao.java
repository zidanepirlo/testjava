package mock;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuan on 2017/6/30.
 */
@Component("baseDao")
public class BaseDao {

    public Map<String, Object> getUser(String userName){
        Map<String, Object>  map = new HashMap<String, Object>();
        map.put("userName", userName);
        return map;
    }

    public Map<String, Object> getUserThrow(String userName) throws Exception {
        Map<String, Object>  map = new HashMap<String, Object>();
        map.put("userName", userName);
        return map;
    }

    public String getUserCard(String userName) {
        return userName == null || userName.length() ==0 ? "userName is null" : userName + "4502399489548283848";
    }
}
