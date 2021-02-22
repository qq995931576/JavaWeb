package com.achang.dao.impl;

import com.achang.bean.Book;
import com.achang.dao.BookDao;

import java.util.List;

/******
 @author 阿昌
 @create 2020-11-28 19:56
 *******
 */
public class BookDaoImpl extends BaseDao implements BookDao {

    @Override
    public int addBook(Book book) {
        String sql = "insert into t_book(name,price,author,sales,stock,img_path) values(?,?,?,?,?,?)";
        return update(sql,book.getName(),book.getPrice(),book.getAuthor(),book.getSales(),book.getStock(),book.getImg_Path());
    }

    @Override
    public int deleteBook(Integer id) {
        String sql = "delete from t_book where id = ? ";
        return update(sql,id);
    }

    @Override
    public int updateBook(Book book) {
        String sql = "update t_book set name=?,price=?,author=?,sales=?,stock=?,img_path=? where id=?";
        return update(sql,book.getName(),book.getPrice(),book.getAuthor(),book.getSales(),book.getStock(),book.getImg_Path(),book.getId());
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql = "select id,name,price,author,sales,stock,img_path from t_book where id = ? ";
        return (Book) queryForOne(Book.class,sql,id);
    }

    @Override
    public List<Book> queryBooks() {
        String sql = "select id,name,price,author,sales,stock,img_path from t_book ";
        return queryForList(Book.class,sql);
    }

    @Override
    public Integer queryForPageTotalCount() {
        String sql = "select count(*) from t_book";
        Number count = (Number) queryForSingleVaule(sql);
        return count.intValue();
    }

    @Override
    public List<Book> queryForItems(int begin, int pageSize) {
        String sql = "select id,name,price,author,sales,stock,img_path from t_book limit ?,?";
        return queryForList(Book.class,sql,begin,pageSize);
    }

    @Override
    public Integer queryForPageTotalCountByPrice(int min, int max) {
        String sql = "select count(*) from t_book where price between ? and ?";
        Number count = (Number) queryForSingleVaule(sql,min,max);
        return count.intValue();
    }

    @Override
    public List<Book> queryForItemsByPrice(int begin, int pageSize, int min, int max) {
        String sql = "select id,name,price,author,sales,stock,img_path from t_book where price between ? and ? order by price limit ?,? ";
        return queryForList(Book.class,sql,min,max,begin,pageSize);
    }

}
