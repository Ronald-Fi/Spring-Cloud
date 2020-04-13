package com.example.open_closed.book.service;

/**
 * 书籍接口
 */
public interface IBookBase {
    //书籍名称
    public String getName();

    //书籍售价
    public Long getPrice();

    //书籍作者
    public String getAuthor();
}
