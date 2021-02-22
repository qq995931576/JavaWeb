package com.achang.test;

import com.achang.bean.Book;
import com.achang.bean.Page;
import com.achang.dao.BookDao;
import com.achang.service.BookService;
import com.achang.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/******
 @author 阿昌
 @create 2020-11-28 20:43
 *******
 */
public class BookServiceTest {

    private BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(0,"水浒传",new BigDecimal(59.99),"施耐恩",5120,59,null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(23);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(22,"水浒传",new BigDecimal(29.99),"施耐恩",2000,15,null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(22));
    }

    @Test
    public void queryBooks() {
        for (Book list:bookService.queryBooks()){
            System.out.println(list);
        }
    }

    @Test
    public void page(){
        System.out.println(bookService.page(1, Page.PAGE_SIZE));
    }

    @Test
    public void pageByPrice(){
        System.out.println(bookService.pageByPrice(1, Page.PAGE_SIZE,10,50));
    }

}