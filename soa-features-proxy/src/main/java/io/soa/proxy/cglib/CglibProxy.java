package io.soa.proxy.cglib;

import io.soa.proxy.DynamicProxy;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by percy on 7/20/16.
 */
public class CglibProxy implements DynamicProxy {
    @Override
    public <T> T proxy(T t) {
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                return methodProxy.invoke(o, objects);
            }
        });
        enhancer.setInterfaces(t.getClass().getInterfaces());
        T cglibProxy = (T) enhancer.create();
        return cglibProxy;
    }
}

//class CglibInterceptor implements MethodInterceptor {
//    final Object delegate;
//    CglibInterceptor(Object delegate) {
//        this.delegate = delegate;
//    }
//
//    public Object intercept(Object object, Method method, Object[] objects,
//                            MethodProxy methodProxy) throws Throwable {
//        return methodProxy.invoke(delegate, objects);
//    }
//}
