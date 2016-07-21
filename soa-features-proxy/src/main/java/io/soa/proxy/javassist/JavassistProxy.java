package io.soa.proxy.javassist;

import io.soa.proxy.DynamicProxy;
import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;

import java.lang.reflect.Method;

/**
 * Created by percy on 7/20/16.
 */
public class JavassistProxy implements DynamicProxy {
    @Override
    public <T> T proxy(T t) {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setInterfaces(t.getClass().getInterfaces());
        Class<?> proxyClass = proxyFactory.createClass();
        T javassistProxy = null;
        try {
            javassistProxy = (T) proxyClass.newInstance();
            ((ProxyObject) javassistProxy).setHandler(new MethodHandler() {
                @Override
                public Object invoke(Object o, Method method, Method method1, Object[] objects) throws Throwable {
                    return method.invoke(o, objects);
                }
            });
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return javassistProxy;
    }

}

//class JavassitInterceptor implements MethodHandler {
//
//    final Object delegate;
//
//    JavassitInterceptor(Object delegate) {
//        this.delegate = delegate;
//    }
//
//    public Object invoke(Object self, Method m, Method proceed,
//                         Object[] args) throws Throwable {
//        return m.invoke(delegate, args);
//    }
//}

