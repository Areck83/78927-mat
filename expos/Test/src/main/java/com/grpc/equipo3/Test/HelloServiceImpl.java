package com.grpc.equipo3.Test;

import com.grpc.equipo3.Test.HelloServiceGrpc.HelloServiceImplBase;

import io.grpc.stub.StreamObserver;

public class HelloServiceImpl extends HelloServiceImplBase{
    @Override
    public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver){
        String greeting = "Hello, " + request.getFirstName() +" "+request.getLastName();


        HelloResponse response = HelloResponse.newBuilder()
        .setGreeting(greeting)
        .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
