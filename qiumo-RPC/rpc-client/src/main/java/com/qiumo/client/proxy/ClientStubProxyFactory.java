package com.qiumo.client.proxy;

import com.qiumo.client.transport.http.HttpClient;
import com.qiumo.core.common.Invocation;
import com.qiumo.core.service.HelloService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理对象，使用户能够向调用本地方法一样去使用rpc框架来调用远程方法
 * @author qiumo
 * @version 1.0
 * @ClassName
 * @date Create in 2023/11/25 14:09
 */
public class ClientStubProxyFactory {
    public  static <T>T getProxy(Class interfaceClass){
        Object proxyInstance = Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Invocation invocation = new Invocation(interfaceClass.getName(),method.getName(), method.getParameterTypes(),args);
                HttpClient httpClient = new HttpClient();
                //服务发现
                //负载均衡
                String result = httpClient.sendRpcRequest("localhost", 8080, invocation);
                return result;
            }
        });
        return (T) proxyInstance;

    }

}
