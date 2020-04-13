package com.example.open_closed.book;

import com.example.open_closed.book.domain.ComputerBookBase;
import com.example.open_closed.book.domain.NovelBookBase;
import com.example.open_closed.book.domain.OffNovelBookBase;
import com.example.open_closed.book.service.IBookBase;

import java.text.NumberFormat;
import java.util.ArrayList;

/**
 * 书店售书类
 */
public class BookStoreTest {

    private final static ArrayList<IBookBase> bookList = new ArrayList<>();

    //静态模块初始化数据
    static {
        bookList.add(new NovelBookBase("天龙八部", 3200l, "金庸"));
        bookList.add(new NovelBookBase("巴黎圣母院", 5600l, "雨果"));
        bookList.add(new NovelBookBase("悲惨世界", 3500l, "雨果"));
        bookList.add(new NovelBookBase("金瓶梅", 4300l, "兰陵笑笑生"));
        bookList.add(new OffNovelBookBase("天龙八部", 3200l, "金庸"));
        bookList.add(new OffNovelBookBase("巴黎圣母院", 5600l, "雨果"));
        bookList.add(new OffNovelBookBase("悲惨世界", 3500l, "雨果"));
        bookList.add(new OffNovelBookBase("金瓶梅", 4300l, "兰陵笑笑生"));
        bookList.add(new ComputerBookBase("Java虚拟机", 7000l, "xx", "编程语言"));
    }

    //模拟书店买书
    public static void main(String[] args) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        formatter.setMaximumFractionDigits(2);
        System.out.println("书店卖出的书籍记录如下:");
        for (IBookBase book : bookList) {
            System.out.println("书籍名称：" + book.getName() + "\t书籍作者：" + book.getAuthor() + "\t书籍价格：" + formatter.format(book.getPrice() / 100.0) + "元");
        }
    }
}
