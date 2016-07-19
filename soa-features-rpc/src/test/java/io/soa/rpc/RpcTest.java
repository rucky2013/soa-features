package io.soa.rpc;

import io.soa.rpc.api.EchoService;
import io.soa.rpc.consumer.RpcImporter;
import io.soa.rpc.provider.EchoServiceImpl;
import io.soa.rpc.provider.RpcExporter;
import org.junit.Test;

import java.net.InetSocketAddress;

/**
 * 编写测试代码
 * <p>
 * <p>
 * Created by percy on 7/19/16.
 */
public class RpcTest {

    @Test
    public void test() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    RpcExporter.exporter("localhost", 8088);
                } catch (Exception e) {

                }
            }
        }).start();

        RpcImporter<EchoService> importer = new RpcImporter<EchoService>();

        EchoService echo = importer.importer(EchoServiceImpl.class, new InetSocketAddress("localhost", 8088));

        System.out.println(echo.echo("Are you ok ?"));
    }

}
