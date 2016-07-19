package io.soa.rpc.provider;

import io.soa.rpc.api.EchoService;

/**
 * Created by percy on 7/19/16.
 */
public class EchoServiceImpl implements EchoService {

    @Override
    public String echo(String ping) {
        return null != ping ? ping + " --> I am ok." : " I am ok.";
    }

}
