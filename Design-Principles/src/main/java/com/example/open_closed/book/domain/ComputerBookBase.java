package com.example.open_closed.book.domain;

import com.example.open_closed.book.service.IComputerBookBase;

/**
 * 电脑相关书籍
 */
public class ComputerBookBase implements IComputerBookBase {
    //书籍名称
    private String name;
    //书籍售价
    private Long price;
    //书籍作者
    private String author;
    //书籍范围
    private String scope;

    public ComputerBookBase(String name, Long price, String author, String scope) {
        this.name = name;
        this.price = price;
        this.author = author;
        this.scope = scope;
    }

    @Override
    public String getScope() {
        return this.scope;
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
