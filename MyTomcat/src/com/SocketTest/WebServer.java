package com.SocketTest;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class WebServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            while (true) {
                Socket accept = serverSocket.accept();
                //获得输入流
                InputStream inputStream = accept.getInputStream();
                byte[] buf = new byte[1024];
                int len;
                while (inputStream.available() > 0) {
                    len = inputStream.read(buf);
                    System.out.println(new String(buf, 0, len));
                }

                //给浏览器响应
                OutputStream outputStream = accept.getOutputStream();
                //按照http协议的格式封装响应报文
                String response = "HTTP/1.1 302 Moved Temporarily\r\n" +
                        "Location: https://www.baidu.com\r\n\r\n";
                //将报文返回给浏览器
                outputStream.write(response.getBytes());

                outputStream.close();
                inputStream.close();
                accept.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
