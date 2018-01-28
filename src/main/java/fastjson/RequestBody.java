package fastjson;

import java.util.ArrayList;
import java.util.List;

public class RequestBody extends RemotingSerializable{

    private MySerializeWrapper mySerializeWrapper = new MySerializeWrapper();
    private List<String> strs = new ArrayList<String>();

    public MySerializeWrapper getMySerializeWrapper() {
        return mySerializeWrapper;
    }

    public List<String> getStrs() {
        return strs;
    }

    public void setMySerializeWrapper(MySerializeWrapper mySerializeWrapper) {
        this.mySerializeWrapper = mySerializeWrapper;
    }

    public void setStrs(List<String> strs) {
        this.strs = strs;
    }
}
