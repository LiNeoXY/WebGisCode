package com.neo;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Author:neo
 */
public class MyServer {
    /**
     * 定义服务端的接受程序，接受socket请求
     *
     * @param port
     */
    public static void StartServer(int port) throws Exception {
        //定义服务端套接字socket
        ServerSocket serverSocket = new ServerSocket(port);
        //定义客户端套接字
        Socket socket = null;

        while (true) {
            socket = serverSocket.accept();

            //获取输入输出流
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            //定义请求对象
            MyRequest request = new MyRequest(inputStream);
            //定义响应对象
            MyResponse response = new MyResponse(outputStream);
            //class关键子当做变量名会有问题
            String clazz = new MyMapping().getMapping().get(request.getRequestUrl());
            if (clazz != null) {
                Class<MyServlet> myServletClass = (Class<MyServlet>) Class.forName(clazz);
                //根据myServletClass创建对象
                MyServlet myServlet = myServletClass.newInstance();
                myServlet.servicr(request, response);
            }

        }
    }

    public static void main(String[] args) throws Exception {
        StartServer(8000);
    }
}
