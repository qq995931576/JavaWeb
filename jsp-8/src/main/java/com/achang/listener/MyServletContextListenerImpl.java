package com.achang.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/******
 @author 阿昌
 @create 2020-11-26 21:22
 *******
 */
public class MyServletContextListenerImpl implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ServletContext对象被创建了");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ServletContext对象被销毁了");

    }
}
