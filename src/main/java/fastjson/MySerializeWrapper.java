package fastjson;

import java.util.concurrent.ConcurrentHashMap;

public class MySerializeWrapper extends RemotingSerializable {

    private ConcurrentHashMap<String,User>  userMaps = new ConcurrentHashMap<String,User>();

    private DataVersion dataVersion = new DataVersion();

    public void setUserMaps(ConcurrentHashMap<String, User> userMaps) {
        this.userMaps = userMaps;
    }

    public void setDataVersion(DataVersion dataVersion) {
        this.dataVersion = dataVersion;
    }

    public ConcurrentHashMap<String, User> getUserMaps() {
        return userMaps;
    }

    public DataVersion getDataVersion() {
        return dataVersion;
    }

}
