package com.qiumo.client.transport.http;


import com.qiumo.core.common.Invocation;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.*;

/**
 * @author qiumo
 * @version 1.0
 * @ClassName
 * @date Create in 2023/11/25 09:04
 */
public class HttpClient {
    public String sendRpcRequest(String hostname, Integer port, Invocation invocation) {
        try {
            //建立连接
            URL url = new URL("http", hostname, port, "/");
            HttpURLConnection httpURLConnectionurlConnection = (HttpURLConnection) url.openConnection();
            //设置连接方式
            httpURLConnectionurlConnection.setRequestMethod("POST");
            httpURLConnectionurlConnection.setDoOutput(true);

            //配置
            OutputStream outputStream = httpURLConnectionurlConnection.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream((outputStream));

            oos.writeObject(invocation);
            oos.flush();
            oos.close();

            InputStream inputStream = httpURLConnectionurlConnection.getInputStream();
            String s = IOUtils.toString(inputStream);
            return s;
        } catch (ProtocolException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
