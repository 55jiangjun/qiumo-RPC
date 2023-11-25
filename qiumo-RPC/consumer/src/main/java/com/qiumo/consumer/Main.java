package com.qiumo.consumer;

import com.qiumo.client.proxy.ClientStubProxyFactory;
import com.qiumo.core.service.HelloService;


public class Main {
    public static void main(String[] args) {
        HelloService helloService = ClientStubProxyFactory.getProxy(HelloService.class);
        String result = helloService.sayHello("qiumo");

        System.out.println(result);
    }
}