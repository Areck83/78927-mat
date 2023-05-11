package com.grpc.equipo3.Test;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GrpcServer {
    public static void main(String args[]) throws IOException, InterruptedException{
        Server server = ServerBuilder.forPort(8080).addService(new HelloServiceImpl()).build();
        server.start();
        server.awaitTermination();
    }
}