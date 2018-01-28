package Exception;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MyExcep1 extends Exception{

    private String errorMsg;

    public MyExcep1(String errorMsg) {
        super(errorMsg);
        this.errorMsg = errorMsg;
    }

    public MyExcep1(String errorMsg,Throwable throwable) {
        super(errorMsg,throwable);
        this.errorMsg = errorMsg;
    }
}
