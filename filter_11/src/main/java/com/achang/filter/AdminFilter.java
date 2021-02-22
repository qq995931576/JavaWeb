//package com.achang.filter;
//
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.util.logging.LogRecord;
//
///******
// @author 阿昌
// @create 2020-12-02 15:07
// *******
// */
//public class AdminFilter implements Filter {
//
//    public AdminFilter() {
//        System.out.println("1.Filter无参构造器");
//    }
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        System.out.println("2.Filter的init()初始化方法");
//
////        1、获取 Filter 的名词 filter-name的内容
//        System.out.println("filter-name的值："+ filterConfig.getFilterName());
////        2、获取在web.xml中配置的init-param初始化参数
//        System.out.println("初始化参数username的值是："+ filterConfig.getInitParameter("username"));
//        System.out.println("初始化参数url的值是："+ filterConfig.getInitParameter("url"));
////        3、获取ServletContext对象
//        System.out.println(filterConfig.getServletContext());
//
//    }
//
//    /**
//     * doFilter方法，专门用于拦截请求，就可以做权限检查、过滤响应。
//     * @param request
//     * @param response
//     * @param chain
//     * @throws IOException
//     * @throws ServletException
//     */
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//
//        System.out.println("3.Filter的doFilter()方法");
//
//
//
//        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
//        HttpSession session = httpServletRequest.getSession();
//
//        Object user = session.getAttribute("user");
//
//        //如果等于null，则还没有登录
//        if (user == null){
//            request.getRequestDispatcher("/login.jsp").forward(request,response);
//            return;
//        }else {
//            //让程序继续往下访问用户的目标资源
//            chain.doFilter(request,response);
//
//        }
//
//    }
//
//    @Override
//    public void destroy() {
//        System.out.println("4.Filter的destroy()销毁方法");
//    }
//}
