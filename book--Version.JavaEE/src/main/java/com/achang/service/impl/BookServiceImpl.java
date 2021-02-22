package com.achang.service.impl;

import com.achang.bean.Book;
import com.achang.bean.Page;
import com.achang.dao.BookDao;
import com.achang.dao.impl.BookDaoImpl;
import com.achang.service.BookService;

import java.util.List;

/******
 @author 阿昌
 @create 2020-11-28 20:37
 *******
 */
public class BookServiceImpl implements BookService {

    private BookDao bookDao = new BookDaoImpl();


    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page = new Page<>();

        //设置每页显示数量
        page.setPageSize(pageSize);
        //求总记录数
        Integer pageToalCount = bookDao.queryForPageTotalCount();
        //设置总记录数
        page.setPageTotalCount(pageToalCount);
        //求总页码
        int pageTotal = pageToalCount/pageSize;
        if (pageToalCount % pageSize > 0 ){
            pageTotal+=1;
        }
        //设置总页码
        page.setPageTotal(pageTotal);


        //设置当前页码
        page.setPageNo(pageNo);

        //求当前页数据的开始索引
        int begin = (page.getPageNo()-1) * pageSize;
        //求当前页数据
        List<Book> items = bookDao.queryForItems(begin,pageSize);
        //设置当前页数据
        page.setItems(items);

        return page;
    }

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(int id) {
        bookDao.deleteBook(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(int id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Book> page = new Page<>();

        //设置每页显示数量
        page.setPageSize(pageSize);
        //求总记录数
        Integer pageToalCount = bookDao.queryForPageTotalCountByPrice(min,max);
        //设置总记录数
        page.setPageTotalCount(pageToalCount);
        //求总页码
        int pageTotal = pageToalCount/pageSize;
        if (pageToalCount % pageSize > 0 ){
            pageTotal+=1;
        }
        //设置总页码
        page.setPageTotal(pageTotal);


        //设置当前页码
        page.setPageNo(pageNo);

        //求当前页数据的开始索引
        int begin = (page.getPageNo()-1) * pageSize;
        //求当前页数据
        List<Book> items = bookDao.queryForItemsByPrice(begin,pageSize,min,max);
        //设置当前页数据
        page.setItems(items);

        return page;
    }


}
