package io.soa.proxy.javassist;

import io.soa.proxy.CountService;
import io.soa.proxy.DynamicProxy;
import javassist.*;

import java.lang.reflect.Field;

/**
 * Created by percy on 7/20/16.
 */
public class JavassistByteCodeProxy implements DynamicProxy {
    @Override
    public <T> T proxy(T t) {

        ClassPool mPool = new ClassPool(true);

        CtClass mCtc = mPool.makeClass(CountService.class.getName() + "JavassistProxy");
        try {
            mCtc.addInterface(mPool.get(CountService.class.getName()));
            mCtc.addConstructor(CtNewConstructor.defaultConstructor(mCtc));
            mCtc.addField(CtField.make("public " + CountService.class.getName() + " delegate;", mCtc));
            mCtc.addMethod(CtNewMethod.make("public int count() { return delegate.count(); }", mCtc));
            Class<?> pc = mCtc.toClass();
            T bytecodeProxy = (T) pc.newInstance();
            Field filed = bytecodeProxy.getClass().getField("delegate");
            filed.set(bytecodeProxy, t);

            return bytecodeProxy;
        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (CannotCompileException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }
}
