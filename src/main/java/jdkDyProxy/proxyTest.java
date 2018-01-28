package jdkDyProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class proxyTest {


    public static Object getProxy(Class clz,InvocationHandler invocationHandler){
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                clz.getInterfaces(), invocationHandler);
    }

    public static void main(String[] args) {

//        UserService userService = new UserServiceImpl();
//        MyInvocationHandler invocationHandler = new MyInvocationHandler(userService);
//        UserService userServiceProxy = (UserService) proxyTest.getProxy(UserServiceImpl.class,invocationHandler);
//        TwoService twoService = new TwoServiceImpl();
//        MyInvocationHandler invocationHandler1 = new MyInvocationHandler(twoService);
//        TwoService twoServiceProxy = (TwoService) proxyTest.getProxy(TwoServiceImpl.class,invocationHandler1);
//        userService.setTwoService(twoServiceProxy);
//        userServiceProxy.add();

        UserService userService = new UserServiceImpl();
        MyInvocationHandler invocationHandler = new MyInvocationHandler(userService);
        UserService userServiceProxy = (UserService) proxyTest.getProxy(UserServiceImpl.class,invocationHandler);
        userServiceProxy.add();


//        userServiceProxy.sum();


//        UserSrvInHandler userSrvInHandler = new UserSrvInHandler();
//        UserService proxy = (UserService) proxyTest.getProxy(UserServiceImpl.class,userSrvInHandler);
//        proxy.add();

    }
}
