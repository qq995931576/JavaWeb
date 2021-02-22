package com.achang.bean;

import java.math.BigDecimal;

/******
 @author 阿昌
 @create 2020-11-28 19:37
 *******
 */
public class Book {

    private int id;
    private String name;
    private BigDecimal price;
    private String author;
    private int sales;
    private int stock;
    private String img_Path="static/img/default.jpg";

    public Book() {
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                ", sales=" + sales +
                ", stock=" + stock +
                ", imgPath='" + img_Path + '\'' +
                '}';
    }
    

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getImg_Path() {
        return img_Path;
    }

    public void setImg_Path(String imgPath) {
        //要求给定的图书封面路径不能为空
        if (imgPath!=null && "".equals(imgPath)){
            this.img_Path = imgPath;
        }
    }

    public Book(int id, String name, BigDecimal price, String author, int sales, int stock, String img_Path) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.author = author;
        this.sales = sales;
        this.stock = stock;

        //要求给定的图书封面路径不能为空
        if (img_Path!=null && "".equals(img_Path)){
            this.img_Path = img_Path;
        }
    }

}
