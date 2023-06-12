package com.neo;

import java.util.HashMap;

/**
 * Author:neo
 */
public class MyMapping {
    public static HashMap<String, String> mapping = new HashMap<String, String>();

    //静态代码块
    static {
        mapping.put("/mytomcat", "com.neo.MyServlet");
    }

    public HashMap<String, String> getMapping() {
        return mapping;
    }
}
