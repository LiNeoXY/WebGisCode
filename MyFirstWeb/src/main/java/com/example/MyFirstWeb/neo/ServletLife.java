package com.example.MyFirstWeb.neo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletLife extends HttpServlet {
    /**
     * 再第一次请求是实例化servlet对象
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        System.out.println("servlet初始化！");
    }

    /**
     * 请求发送默认调用service
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("request successful！");
        System.out.println("请求成功！");
    }

    /**
     * tomcat停止时释放内存
     */
    @Override
    public void destroy() {
        System.out.println("对象清除！");
    }
}
