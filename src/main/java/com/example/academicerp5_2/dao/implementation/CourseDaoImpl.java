package com.example.academicerp5_2.dao.implementation;

import com.example.academicerp5_2.bean.Course;
import com.example.academicerp5_2.bean.Student;
import com.example.academicerp5_2.dao.CourseDao;
import com.example.academicerp5_2.utils.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class CourseDaoImpl implements CourseDao {
    @Override
    public void courseRegister(Course course) {
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(course);
            transaction.commit();
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
    }

    @Override
    public Course getCourseByID(Course course) {
        try (Session session = SessionUtil.getSession()) {
            Query query = session.createQuery("from Course where id=:id");
            query.setParameter("id", course.getId());
            for (final Object fetch : query.list()) {
                return (Course) fetch;
            }
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return null;
    }
}
