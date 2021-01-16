package com.example.academicerp5_2.dao.implementation;

import com.example.academicerp5_2.bean.Student_Courses;
import com.example.academicerp5_2.dao.Student_CoursesDao;
import com.example.academicerp5_2.utils.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Student_CoursesDaoImpl implements Student_CoursesDao {
    @Override
    public void registerStudent_CoursesDao(Student_Courses student_courses) {
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(student_courses);
            transaction.commit();
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
    }
}
