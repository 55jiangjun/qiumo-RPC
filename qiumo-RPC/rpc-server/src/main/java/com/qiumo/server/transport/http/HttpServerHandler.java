package com.qiumo.server.transport.http;

import com.qiumo.core.common.Invocation;
import com.qiumo.server.register.LocalRegister;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 处理http请求的实际操作
 * @author qiumo
 * @version 1.0
 * @ClassName
 * @date Create in 2023/11/24 16:20
 */
public class HttpServerHandler {
    public void handler(ServletRequest req, ServletResponse res) {
        //处理请求-->接口、方法、方法参数
        try {
            Invocation invocation = (Invocation)new ObjectInputStream(req.getInputStream()).readObject();
            String interfaceName = invocation.getInterfaceName();
            //根据接口找到对应的实现类
            Class classImpl = LocalRegister.getService(interfaceName);
            Method method = classImpl.getMethod(invocation.getMethodName(), invocation.getParameterTypes());
            String result = (String) method.invoke(classImpl.newInstance(), invocation.getParameters());

            //依赖报里的一个好用的写入结果的api
            IOUtils.write(result,res.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        }

    }
}
