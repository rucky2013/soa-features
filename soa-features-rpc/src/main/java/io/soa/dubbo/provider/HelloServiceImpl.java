package io.soa.dubbo.provider;

import io.soa.dubbo.api.HelloService;

/**
 * Created by percy on 7/19/16.
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        return "Hello " + name;
    }
}
