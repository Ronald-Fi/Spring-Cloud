package com.example.open_closed.course.domain;

public class JavaDiscountCourse extends JavaCourse {

    public JavaDiscountCourse(String courseName, Long coursePrice, String courseTeacher) {
        super(courseName, coursePrice, courseTeacher);
    }

    public long getDiscountPrice() {
        long selfPrice = super.getCoursePrice();
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
