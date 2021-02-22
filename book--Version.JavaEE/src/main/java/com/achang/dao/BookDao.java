package com.achang.dao;

import com.achang.bean.Book;

import java.util.List;

/******
 @author 阿昌
 @create 2020-11-28 19:50
 *******
 */
public interface BookDao {

    public int addBook(Book book);

    public int deleteBook(Integer id);

    public int updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    public Integer queryForPageTotalCount();

    public List<Book> queryForItems(int begin, int pageSize);

    Integer queryForPageTotalCountByPrice(int min, int max);

    List<Book> queryForItemsByPrice(int begin, int pageSize, int min, int max);
}
