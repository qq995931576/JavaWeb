package com.achang.test;

import com.achang.bean.Book;
import com.achang.bean.Page;
import com.achang.dao.BookDao;
import com.achang.dao.impl.BaseDao;
import com.achang.dao.impl.BookDaoImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/******
 @author 阿昌
 @create 2020-11-28 20:16
 *******
 */
public class BookDaoTest {
    private BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        bookDao.addBook(new Book(0,"三国演义",new BigDecimal(39.99),"罗贯中",3300,30,null));
    }

    @Test
    public void deleteBook() {
        bookDao.deleteBook(20);
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(21,"三国演义",new BigDecimal(49.99),"罗贯中",6600,80,null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(21));
    }

    @Test
    public void queryBooks() {
        for (Book list : bookDao.queryBooks()){
            System.out.println(list);
        }
    }

    @Test
    public void queryForPageTotalCount() {
        System.out.println(bookDao.queryForPageTotalCount());

    }

    @Test
    public void queryForItems() {
        for (Book queryForItem : bookDao.queryForItems(8, Page.PAGE_SIZE)) {
            System.out.println(queryForItem);
        }

    }

    @Test
    public void queryForPageTotalCountByPrice() {
        System.out.println(bookDao.queryForPageTotalCountByPrice(10,50));
    }

    @Test
    public void queryForItemsByPrice() {
        for (Book queryForItemByPrice : bookDao.queryForItemsByPrice(1, Page.PAGE_SIZE,10,50)) {
            System.out.println(queryForItemByPrice);
        }

    }
}