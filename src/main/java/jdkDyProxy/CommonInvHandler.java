package jdkDyProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CommonInvHandler  implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object target = null;
        if (proxy.getClass()== OneServiceImpl.class){
            target =  new OneServiceImpl();
        }
        if(proxy.getClass()==TwoServiceImpl.class){
            target =  new TwoServiceImpl();
        }

        System.out.println("------------------before------------------");
        Object result = method.invoke(target, args);
        System.out.println("-------------------after------------------");

        return result;
    }
}
