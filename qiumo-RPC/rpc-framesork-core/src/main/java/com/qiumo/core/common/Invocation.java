package com.qiumo.core.common;

import java.io.Serializable;

/**
 * 调用方法的内容
 * @author qiumo
 * @version 1.0
 * @ClassName
 * @date Create in 2023/11/24 16:31
 */
public class Invocation implements Serializable {
    public String interfaceName;//接口名
    public String methodName;//方法名
    private Class[] parameterTypes;//参数类型
    private Object[] parameters;//参数


    public Invocation() {
    }

    public Invocation(String interfaceName, String methodName, Class[] parameterTypes, Object[] parameters) {
        this.interfaceName = interfaceName;
        this.methodName = methodName;
        this.parameterTypes = parameterTypes;
        this.parameters = parameters;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class[] getParameterTypes() {
        return parameterTypes;
    }

    public void setParameterTypes(Class[] parameterTypes) {
        this.parameterTypes = parameterTypes;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }
}
