package com.achang.web;

import com.achang.bean.User;
import com.achang.service.impl.UserServiceImpl;
import com.achang.utils.WebUtils;
import com.google.gson.Gson;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/******
 @author 阿昌
 @create 2020-11-28 13:40
 *******
 */
public class UserServlet extends BaseServlet {

    private UserServiceImpl userService = new UserServiceImpl();

    //登录处理
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //2.调用 userService.Login()登录处理业务
        User loginUser = userService.login(new User(0, username, password, null));

        //3.根据login()方法返回结果判断登录是否成功
        if (loginUser ==null){
            //4.如果等于null，登入失败
            //把错误信息，和回显的表单项信息，保存到Request域中
            req.setAttribute("msg","用户名或密码错误!");
            req.setAttribute("username",username);


            //5.转跳login登入页面
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }else {
            System.out.println("登录成功");

            //保存用户登录的信息到Session域中
            req.getSession().setAttribute("user",loginUser);

            //6.不为null，登入成功，跳转login_success页面
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }

    }


    //注册处理
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        // 获取 Session 中的验证码
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        // 删除 Session 中的验证码
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        String code = req.getParameter("code");



        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());


        //2.检查验证码是否正确，先写死，要求，验证码为:abcde
        if ( (token.equalsIgnoreCase(code)) && (token != null) ){
            //检查用户名是否可用
            if (userService.existsUsername(username)){
                //把错误信息，和回显的表单项信息，保存到Request域中
                req.setAttribute("errorMsg","用户名已存在");
                req.setAttribute("username",username);
                req.setAttribute("email",email);

                //跳转到注册页面
                req.getRequestDispatcher("pages/user/regist.jsp").forward(req,resp);
            }else {
                //调用Service保存到数据库
                userService.registUser(new User(0,username,password,email));
                //跳转到注册成功页面
                req.getRequestDispatcher("pages/user/regist_success.jsp").forward(req,resp);
            }

        }else {
            //把回显信息，保存到Request域中
            req.setAttribute("errorMsg","验证码错误!!!");
            req.setAttribute("username",username);
            req.setAttribute("email",email);

            //跳转到注册页面
            System.out.println("验证码 ["+code+"] 错误");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }

    }

    //注销处理
    protected void logOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1、销毁Seesion中用户登录的信息（或销毁Session）
        req.getSession().invalidate();
//        2、重定向到首页或登录页面。
        resp.sendRedirect(req.getContextPath());
    }




    protected void ajaxExistsUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取请求参数username
        String username = req.getParameter("username");
        //2、调用userService.existUsername();
        boolean existsUsername = userService.existsUsername(username);
        //把返回的结果封装成Map对象
        Map<String,Object> map = new Hashtable<>();
        map.put("existsUsername",existsUsername);

        Gson gson = new Gson();
        String mapJson = gson.toJson(map);

        resp.getWriter().write(mapJson);


    }







}
