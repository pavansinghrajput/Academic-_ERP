package com.example.academicerp5_2.service;

import com.example.academicerp5_2.bean.Course;
import com.example.academicerp5_2.dao.CourseDao;
import com.example.academicerp5_2.dao.StudentDao;
import com.example.academicerp5_2.dao.implementation.CourseDaoImpl;
import com.example.academicerp5_2.dao.implementation.StudentDaoImpl;

public class CourseService {
    private static CourseDao courseDao = new CourseDaoImpl();
    public  Course getCourseByID(Course id){
        return courseDao.getCourseByID(id);
    }
}
