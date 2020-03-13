package com.example.demo;

import io.grpc.Channel;
import net.devh.boot.grpc.examples.lib.HelloRequest;
import net.devh.boot.grpc.examples.lib.MyServiceGrpc;
import net.devh.springboot.autoconfigure.grpc.client.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class FoobarService {

    @GrpcClient("local-grpc-server")
    private Channel serverChannel;

    public String receiveGreeting(String name) {
        MyServiceGrpc.MyServiceBlockingStub myServiceStub = MyServiceGrpc.newBlockingStub(this.serverChannel);

        HelloRequest request = HelloRequest.newBuilder()
                .setName(name)
                .build();

        return myServiceStub.sayHello(request).getMessage();
    }

}