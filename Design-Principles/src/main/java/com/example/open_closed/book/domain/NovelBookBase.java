package com.example.open_closed.book.domain;

import com.example.open_closed.book.service.IBookBase;

/**
 * 小说类
 */
public class NovelBookBase implements IBookBase {
    //书籍名称
    private String name;
    //书籍售价
    private Long price;
    //书籍作者
    private String author;

    public NovelBookBase(String _name, Long _price, String _author) {
        this.name = _name;
        this.price = _price;
        this.author = _author;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Long getPrice() {
        return this.price;
    }

    @Override
    public String getAuthor() {
        return this.author;
    }
}
