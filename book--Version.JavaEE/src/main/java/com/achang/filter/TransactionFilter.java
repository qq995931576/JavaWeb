package com.achang.filter;

import com.achang.utils.JDBCUtils;

import javax.servlet.*;
import java.io.IOException;

/******
 @author 阿昌
 @create 2020-12-03 14:14
 *******
 */
public class TransactionFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {


        try {
            chain.doFilter(request,response);

            JDBCUtils.commitAndClose();//提交事务

        } catch (Exception e) {

            JDBCUtils.robackAndClose();//回滚事务

            e.printStackTrace();
            throw new RuntimeException(e);//把异常抛给Tomcat服务器展示友好的错误页面
        }

    }

    @Override
    public void destroy() {

    }
}
