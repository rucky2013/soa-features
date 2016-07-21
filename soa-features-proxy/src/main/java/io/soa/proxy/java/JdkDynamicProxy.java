package io.soa.proxy.java;

import io.soa.proxy.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by percy on 7/19/16.
 */
public class JdkDynamicProxy implements DynamicProxy {

    @Override
    public <T> T proxy(T delegate) {
        T jdkProxy = (T) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                delegate.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        return method.invoke(proxy, args);
                    }
                });
        return jdkProxy;
    }
}

//class JdkHandler implements InvocationHandler {
//
//    final Object delegate;
//
//    JdkHandler(Object delegate) {
//        this.delegate = delegate;
//    }
//
//    public Object invoke(Object object, Method method, Object[] objects)
//            throws Throwable {
//        return method.invoke(delegate, objects);
//    }
//}
