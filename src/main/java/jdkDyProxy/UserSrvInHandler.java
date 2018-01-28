package jdkDyProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class UserSrvInHandler implements InvocationHandler {



    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println(proxy.getClass().getSimpleName());

        UserService userService = new UserServiceImpl();

        System.out.println("------------------before------------------");
        Object result = method.invoke(userService, args);
        System.out.println("-------------------after------------------");

        return result;
    }
}
