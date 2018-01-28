package Exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void test() throws Exception{

        try {
            int a = 1/0;
        }catch (Exception ex){
            throw new MyExcep1("myException");
//            throw new MyExcep1("myException",ex);
        }
    }


    public static void main(String[] args) {

        try {
            Main.test();
        }catch (Exception ex){
            logger.error(ex.getMessage(),ex);
        }
    }
}
