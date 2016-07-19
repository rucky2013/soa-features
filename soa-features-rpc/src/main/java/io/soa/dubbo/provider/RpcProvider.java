package io.soa.dubbo.provider;

import io.soa.dubbo.RpcFramework;
import io.soa.dubbo.api.HelloService;

/**
 * Created by percy on 7/19/16.
 */
public class RpcProvider {

    public static void main(String[] args) throws Exception {
        HelloService service = new HelloServiceImpl();
        RpcFramework.export(service, 1234);
    }
}
