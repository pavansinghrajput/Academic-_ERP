package com.example.academicerp5_2.utils;

import com.example.academicerp5_2.bean.*;
import com.example.academicerp5_2.dao.*;
import com.example.academicerp5_2.dao.implementation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class AddingData {
    public static void main(String[] args) {
        Employee employee1 = new Employee("mvn@iiitb.org", "murli", null, "professor", "academics");
        Employee employee2 = new Employee("bt@iiitb.org", "Thangaraju", null, "professor", "academics");
        Employee employee3 = new Employee("rc@iiitb.org", "Chandrashekar", null, "professor", "academics");
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        employeeDao.registerEmployee(employee1);
        employeeDao.registerEmployee(employee2);
        employeeDao.registerEmployee(employee3);

        Student student1 = new Student("MT2020001", "ck@iiitb.org", "clark", "kent");
        Student student2 = new Student("MT2020002", "bw@iiitb.org", "bruce", "wayne");
        Student student3 = new Student("MT2020003", "ba@iiitb.org", "barry", "allen");
        StudentDao studentDao = new StudentDaoImpl();
        studentDao.studentRegister(student1);
        studentDao.studentRegister(student2);
        studentDao.studentRegister(student3);

        Specialization specialization1 = new Specialization("2020-TSCD", "Theory System & CD", null, 2020, 20);
        Specialization specialization2 = new Specialization("2020-AIML", "AI & ML", null, 2020, 20);
        Specialization specialization3 = new Specialization("2020-NC", "Network Communication", null, 2020, 20);
        SpecializationDao specializationDao = new SpecializationDaoImpl();
        specializationDao.registerSpecialization(specialization1);
        specializationDao.registerSpecialization(specialization2);
        specializationDao.registerSpecialization(specialization3);

        Course course1 = new Course("2020-TS-SS", "System Software", null, 2020, false, 4, 180);
        course1.setSpecialization(specialization1);
        course1.setFaculty(employee2);
        Course course2 = new Course("2020-TS-ALGO", "Algorithm", null, 2020, false, 4, 150);
        course2.setSpecialization(specialization1);
        course2.setFaculty(employee1);
        Course course3 = new Course("2020-TS-SPE", "Software Production Engineering", null, 2020, true, 4, 250);
        course3.setSpecialization(specialization1);
        course3.setFaculty(employee2);
        Course course4 = new Course("2020-TS-DM", "Data Modeling", null, 2020, true, 4, 100);
        course4.setSpecialization(specialization1);
        course4.setFaculty(employee3);
        Course course5 = new Course("2021-TS-SD", "System Design and Architecture", null, 2021, false, 4, 100);
        course5.setSpecialization(specialization1);
        course5.setFaculty(employee3);
        CourseDao courseDao = new CourseDaoImpl();
        courseDao.courseRegister(course1);
        courseDao.courseRegister(course2);
        courseDao.courseRegister(course3);
        courseDao.courseRegister(course4);
        courseDao.courseRegister(course5);

        Student_Courses grade1 = new Student_Courses(student1, course1, 3.4);
        Student_Courses grade2 = new Student_Courses(student1, course2, 3.0);
        Student_Courses grade3 = new Student_Courses(student1, course3, 4.0);
        Student_Courses grade4 = new Student_Courses(student1, course4, 2.4);
        Student_Courses grade5 = new Student_Courses(student2, course1, 3.4);
        Student_Courses grade6 = new Student_Courses(student2, course2, 3.0);
        Student_Courses grade7 = new Student_Courses(student2, course3, 4.0);
        Student_Courses grade8 = new Student_Courses(student2, course4, 3.4);
        Student_Courses grade9 = new Student_Courses(student2, course5, 3.4);
        Student_CoursesDao student_coursesDao = new Student_CoursesDaoImpl();
        student_coursesDao.registerStudent_CoursesDao(grade1);
        student_coursesDao.registerStudent_CoursesDao(grade2);
        student_coursesDao.registerStudent_CoursesDao(grade3);
        student_coursesDao.registerStudent_CoursesDao(grade4);
        student_coursesDao.registerStudent_CoursesDao(grade5);
        student_coursesDao.registerStudent_CoursesDao(grade6);
        student_coursesDao.registerStudent_CoursesDao(grade7);
        student_coursesDao.registerStudent_CoursesDao(grade8);
        student_coursesDao.registerStudent_CoursesDao(grade9);

    }
}



