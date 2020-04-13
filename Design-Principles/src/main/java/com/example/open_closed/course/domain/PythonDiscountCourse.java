package com.example.open_closed.course.domain;

public class PythonDiscountCourse extends JavaCourse {

    public PythonDiscountCourse(String courseName, Long coursePrice, String courseTeacher) {
        super(courseName, coursePrice, courseTeacher);
    }

    @Override
    public Long getCoursePrice() {
        long selfPrice = super.getCoursePrice();
        long offPrice = 0;
        //价格以及折扣在DB中配置
        if (selfPrice > 2000) {
            //原价大于20元，则打9折
            offPrice = selfPrice * 70 / 100;
        } else {
            offPrice = selfPrice * 85 / 100;
        }
        return offPrice;
    }
}
