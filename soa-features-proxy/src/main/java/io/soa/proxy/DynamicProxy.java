package io.soa.proxy;

/**
 * Created by percy on 7/19/16.
 */
public interface DynamicProxy {

    <T> T proxy(T t);

}
