package com.qiumo.server.transport.http;


import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

/**
 * 处理http请求的中转站
 */
public class DispatcherServlet extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        new HttpServerHandler().handler(req,res);
    }
}
