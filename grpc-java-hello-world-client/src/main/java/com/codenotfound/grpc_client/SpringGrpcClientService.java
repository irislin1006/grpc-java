package com.codenotfound.grpc_client;

import com.codenotfound.grpc.lib.GreeterGrpc;
import com.codenotfound.grpc.lib.HelloWorld;
import io.grpc.Channel;
import net.devh.springboot.autoconfigure.grpc.client.GrpcClient;
import org.springframework.stereotype.Service;


@Service
public class SpringGrpcClientService {

    @GrpcClient("local-grpc-server")
    private Channel serverChannel;

    public String sendPalindrome(String name) {
        GreeterGrpc.GreeterBlockingStub stub= GreeterGrpc.newBlockingStub(serverChannel);
        HelloWorld.HelloReply response = stub.getPalindrome(HelloWorld.HelloRequest.newBuilder().setName(name).build());
        return response.getMessage();
    }

    public String sendHello(String name) {
        GreeterGrpc.GreeterBlockingStub stub= GreeterGrpc.newBlockingStub(serverChannel);
        HelloWorld.HelloReply response = stub.sayHello(HelloWorld.HelloRequest.newBuilder().setName(name).build());
        return response.getMessage();
    }
}
