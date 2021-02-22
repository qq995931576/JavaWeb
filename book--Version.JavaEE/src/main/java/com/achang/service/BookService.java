package com.achang.service;

import com.achang.bean.Book;
import com.achang.bean.Page;

import java.util.List;

/******
 @author 阿昌
 @create 2020-11-28 20:35
 *******
 */
public interface BookService {



    Page<Book> page(int pageNo, int pageSize);

    public void addBook(Book book);

    public void deleteBookById(int id);

    public void updateBook(Book book);

    public Book queryBookById(int id);

    public List<Book> queryBooks();


    Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max);
}
