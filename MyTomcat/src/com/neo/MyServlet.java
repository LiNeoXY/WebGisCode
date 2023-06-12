package com.neo;

/**
 * Author:neo
 */
public class MyServlet extends MyHttpServlet {
    @Override
    public void doGet(MyRequest request, MyResponse response) throws Exception {
        response.Write("mytomcat");
    }

    @Override
    public void doPost(MyRequest request, MyResponse response) throws Exception {
        response.Write("post tomcat");
    }
}
