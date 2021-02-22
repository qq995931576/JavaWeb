package com.achang.web;

import com.achang.bean.Book;
import com.achang.bean.Page;
import com.achang.service.BookService;
import com.achang.service.impl.BookServiceImpl;
import com.achang.utils.WebUtils;
import org.apache.taglibs.standard.tag.common.fmt.RequestEncodingSupport;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/******
 @author 阿昌
 @create 2020-11-29 16:06
 *******
 */
public class BookServlet extends BaseServlet{

    BookService bookService = new BookServiceImpl();


    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo=WebUtils.parseInt(req.getParameter("pageNo"),0);
        pageNo+=1;
        //1、获取请求的参数--->封装成Book对象
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        //2、调用BookService.addBook()保存图书
        bookService.addBook(book);
        //3、跳到图书列表页面
//        req.getRequestDispatcher("/manager/bookServlet?action=list").forward(req,resp);出现Bug
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + pageNo );

    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //1、获取请求的参数id，图书编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //2、调用bookService.deleteBookById(),删除图书
        bookService.deleteBookById(id);
        //3、重定向回图书管理页面
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo="+req.getParameter("pageNo"));

    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //1、获取请求的参数--->封装成为Book对象
        Book book = WebUtils.copyParamToBean(req.getParameterMap(),new Book());
        //2、调用BookService.updateBook(Book)；修改图书信息
        bookService.updateBook(book);
        //3、重定向回图书列表管理页面 地址： /工程名/manager/bookServlet?action=list
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo="+req.getParameter("pageNo"));

    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、通过BookServlet查询全部图书
        List<Book> books = bookService.queryBooks();
        //2、把全部图书保存到Request域中
        req.setAttribute("books",books);
        //3、请求转发到/pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);

    }

    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取请求的参数图书编号
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        //2、调用bookService.queryBookById查询图书
        Book book = bookService.queryBookById(id);
        //3、保存图书信息到Request域中
        req.setAttribute("book",book);
        //4、请求转发到： pages/manager/book_edit.jsp
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req,resp);
    }


    public void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //1、获取请求的参数 pageNo和pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //2、调用BookService.page(pageNo,pageSize) --->page对象
        Page<Book> page = bookService.page(pageNo, pageSize);

            //设置服务端分页条地址
        page.setUrl("manager/bookServlet?action=page");

        //3、保存到Request域中
        req.setAttribute("page",page);
        //4、请求转发到/pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);




    }


}
