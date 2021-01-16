package com.example.academicerp5_2.dao;

import com.example.academicerp5_2.bean.Course;
import com.example.academicerp5_2.bean.Specialization;
import com.example.academicerp5_2.bean.Student;
import com.example.academicerp5_2.bean.Student_Courses;

import java.util.List;

public interface StudentDao {

    void studentRegister(Student student);

    Student getStudentByID(Student student);

    Specialization getStudentSpecialization(Student student);

    List<Course> getPassedCourses(Student student);

    void updateStudentSpecialization(Student student, Specialization specialization);


}
