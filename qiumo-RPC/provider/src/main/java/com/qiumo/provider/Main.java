package com.qiumo.provider;


import com.qiumo.core.service.HelloService;
import com.qiumo.provider.service.HelloServiceImpl;
import com.qiumo.server.register.LocalRegister;
import com.qiumo.server.transport.http.HttpRpcServer;

public class Main {
    public static void main(String[] args) {
        LocalRegister.registerService(HelloService.class.getName(), HelloServiceImpl.class);
        HttpRpcServer httpRpcServer = new HttpRpcServer();
        httpRpcServer.start("localhost",8080);
    }
}