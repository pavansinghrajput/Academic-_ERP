package com.example.academicerp5_2.service;
import com.example.academicerp5_2.bean.*;
import com.example.academicerp5_2.dao.*;
import com.example.academicerp5_2.dao.implementation.*;
import com.example.academicerp5_2.bean.Course;
import com.example.academicerp5_2.bean.Specialization;
import com.example.academicerp5_2.bean.Student;
import com.example.academicerp5_2.dao.StudentDao;
import com.example.academicerp5_2.dao.implementation.StudentDaoImpl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class StudentService {
    StudentDao studentDao = new StudentDaoImpl();
    //static StudentDao studentDao = new StudentDaoImpl();

    public Student getPassedCourses(Student student) {
        return (Student) studentDao.getPassedCourses(student);
    }

    public Student getStudentByID(Student student) {
        return studentDao.getStudentByID(student);
    }



public void updateStudentSpecialization(Student student, Specialization specialization) {
        studentDao.updateStudentSpecialization(student, specialization);
    }

    public Specialization getStudentSpecialization(Student student) {
        return studentDao.getStudentSpecialization(student);
    }


    public void  update_specailzation(Student student){
        StudentDao studentDao = new StudentDaoImpl();
        SpecializationDao specializationDao = new SpecializationDaoImpl();
        CourseDao courseDao = new CourseDaoImpl();
        Student_CoursesDao student_coursesDao = new Student_CoursesDaoImpl();
        List<Course> courses = studentDao.getPassedCourses(student);
        HashMap<String, Integer> courseGrade = new LinkedHashMap<>();
        HashMap<String, Integer> specializationCredit = new LinkedHashMap<>();

        for (Course course : courses) {
            System.out.println("Course Code " + course.getCode() + "\t-------\tSpecialization Code" + course.getSpecialization().getCode());
            if (!courseGrade.containsKey(course.getSpecialization().getCode())) {
                courseGrade.put(course.getSpecialization().getCode(), course.getCredits());
            } else {
                courseGrade.replace(course.getSpecialization().getCode(), courseGrade.get(course.getSpecialization().getCode()) + course.getCredits());
            }
            specializationCredit.put(course.getSpecialization().getCode(), course.getSpecialization().getCredits());
        }

        for (String specializationCode : specializationCredit.keySet()) {
            if (courseGrade.get(specializationCode) >= specializationCredit.get(specializationCode)) {
                System.out.println(student.getEmail() + " has specialization in " + specializationCode);
                studentDao.updateStudentSpecialization(student, specializationDao.getSpecializationByCode(specializationCode));
                break;
            }
        }

    }
}



