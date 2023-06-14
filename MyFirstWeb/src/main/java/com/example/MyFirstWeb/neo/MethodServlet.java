package com.example.MyFirstWeb.neo;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class MethodServlet extends HttpServlet {
    /**
     * 以后尽量用doget和dopost，不用service
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("这是get方法");
//    }
    //TODO:方法测试
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("这是post方法");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("这是service方法");
        super.service(req, resp);//调用父类service方法时若子类没实现对应类型的方法，则会报错

    }
}
