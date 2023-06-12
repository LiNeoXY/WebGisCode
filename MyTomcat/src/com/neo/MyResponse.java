package com.neo;

import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/**
 * Author:neo
 */
public class MyResponse {
    private OutputStream outputStream;

    //alt+insert 构造方法、set等快捷键
    public MyResponse(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void Write(String str) throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("HTTP/1.1 200 OK\n")
                .append("Content-Type:text/html\n")
                .append("\r\n")
                .append("<html>")
                .append("<body>")
                .append("<h1>" + str + "</h1>")
                .append("</body>")
                .append("</html>");
        this.outputStream.write(stringBuilder.toString().getBytes());
        this.outputStream.flush();
        this.outputStream.close();

    }
}
