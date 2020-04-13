package com.example.open_closed.course;

import com.example.open_closed.course.domain.*;
import com.example.open_closed.course.service.ICourseBase;

import java.text.NumberFormat;
import java.util.ArrayList;

public class OpenCloseTest {

    private final static ArrayList<ICourseBase> courseList = new ArrayList<>();

    //静态模块初始化数据
    static {
        courseList.add(new JavaCourse("Java课程", 4000l, "张三"));
        courseList.add(new PythonCourse("Python课程", 2000l, "李四"));
        courseList.add(new AICourse("AI课程", 70000l, "王五"));
        courseList.add(new JavaDiscountCourse("Java课程折扣", 4000l, "张三"));
//        courseList.add(new PythonDiscountCourse("Python课程折扣", 2000l, "李四"));
//        courseList.add(new AIDiscountCourse("AI课程折扣", 70000l, "王五"));
    }

    public static void main(String[] args) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        formatter.setMaximumFractionDigits(2);
        System.out.println("课程如下:");
        for (ICourseBase course : courseList) {
            System.out.println("课程名称：" + course.getCourseName() +
                    "\t课程讲师：" + course.getCourseTeacher() +
                    "\t课程价格：" + formatter.format(course.getCoursePrice() / 100.0) + "元");
        }
//        JavaDiscountCourse discountCourse = new JavaDiscountCourse("Java课程折扣", 4000l, "张三");
//        System.out.println("课程名称：" + discountCourse.getCourseName() +
//                "\t课程讲师：" + discountCourse.getCourseTeacher() +
//                "\t课程原价：" + formatter.format(discountCourse.getCoursePrice() / 100.0) + "元" +
//                "\t课程折扣价：" + formatter.format(discountCourse.getDiscountPrice() / 100.0) + "元");
    }
}
