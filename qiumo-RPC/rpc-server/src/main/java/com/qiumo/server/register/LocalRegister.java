package com.qiumo.server.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 注册我们的服务实体类
 * @author qiumo
 * @version 1.0
 * @ClassName
 * @date Create in 2023/11/24 16:39
 */
public class LocalRegister {
        public static Map<String,Class> map = new ConcurrentHashMap<>();
        public static void registerService(String interfaceName,Class ImplClass){
            map.put(interfaceName,ImplClass);
        }

        public static Class getService(String interfaceName){
            return map.get(interfaceName);
        }

        public static void removeService(String interfaceName){
            map.remove(interfaceName);
        }

}
