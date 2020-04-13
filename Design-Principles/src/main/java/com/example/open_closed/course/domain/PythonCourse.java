package com.example.open_closed.course.domain;

import com.example.open_closed.course.service.ICourseBase;

public class PythonCourse implements ICourseBase {
    //课程名称
    private String courseName;
    //课程售价
    private Long coursePrice;
    //课程讲师
    private String courseTeacher;

    public PythonCourse(String courseName, Long coursePrice, String courseTeacher) {
        this.courseName = courseName;
        this.coursePrice = coursePrice;
        this.courseTeacher = courseTeacher;
    }

    @Override
    public String getCourseName() {
        return this.courseName;
    }

    @Override
    public Long getCoursePrice() {
        return this.coursePrice;
    }

    @Override
    public String getCourseTeacher() {
        return this.courseTeacher;
    }
}
