package Lambda;

import java.util.HashMap;
import java.util.Map;

/**
 * Lambda
 *
 * @author yuanqing
 * @create 2018-01-10 下午2:35
 **/
public class testLambda {

    @FunctionalInterface
    interface GreetingService
    {
        void sayMessage(String message);
    }

    @FunctionalInterface
    interface TestService
    {
        void xxx(String yyy);
    }

    @FunctionalInterface
    interface TestService1
    {
        void add(int x,int y);
    }



    public static void main(String[] args) {

//        Map<String, String> map = new HashMap<>();
//        System.out.println(map::put);

        GreetingService greetService1 = message -> System.out.println("Hello :" + message);
        greetService1.sayMessage("yuanqing");

        TestService testService = yyy -> {
            yyy = "xxxxx";
            System.out.println(yyy);
        };

        testService.xxx("yuanqing");

        TestService1 testService1 = (x,y)->{
            System.out.println(x+y);
        };
        testService1.add(1,2);

    }
}
