package com.example.open_closed.book.domain;

public class OffNovelBookBase extends NovelBookBase {

    public OffNovelBookBase(String _name, Long _price, String _author) {
        super(_name, _price, _author);
    }

    @Override
    public Long getPrice() {
        //原价
        long selfPrice = super.getPrice();
        long offPrice = 0;
        //价格以及折扣在DB中配置
        if (selfPrice > 4000) {
            //原价大于40元，则打9折
            offPrice = selfPrice * 90 / 100;
        } else {
            offPrice = selfPrice * 80 / 100;
        }
        return offPrice;
    }
}
