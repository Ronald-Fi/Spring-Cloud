package com.example.open_closed.course.service;

/**
 * 课程接口
 */
public interface ICourseBase {
    //课程名称
    public String getCourseName();

    //课程售价
    public Long getCoursePrice();

    //课程讲师
    public String getCourseTeacher();
}
