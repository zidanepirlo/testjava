package mock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by yuan on 2017/6/30.
 */
@Component("baseBiz")
public class BaseBiz {

    @Autowired
    private BaseDao baseDao;

    public Map<String, Object> getUser(String userName){
        return baseDao.getUser(userName);
    }

    public Map<String, Object> getUserThrow(String userName) throws Exception {
        return baseDao.getUser(userName);
    }
    public String getUserCard(String userName){
        return baseDao.getUserCard(userName);
    }
}
