package com.example.academicerp5_2.dao;

import com.example.academicerp5_2.bean.Course;

public interface CourseDao {

    void courseRegister(Course course);

    Course getCourseByID(Course course);

}
