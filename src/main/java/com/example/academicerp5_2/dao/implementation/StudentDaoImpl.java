package com.example.academicerp5_2.dao.implementation;

import com.example.academicerp5_2.bean.Course;
import com.example.academicerp5_2.bean.Specialization;
import com.example.academicerp5_2.bean.Student;
import com.example.academicerp5_2.bean.Student_Courses;
import com.example.academicerp5_2.dao.StudentDao;
import com.example.academicerp5_2.utils.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl  implements StudentDao {

    @Override
    public void studentRegister(Student student) {
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }

    }

    @Override
    public Student getStudentByID(Student student) {
        try (Session session = SessionUtil.getSession()) {
            Query query = session.createQuery("from Student where id=:id");
            query.setParameter("id", student.getId());
            for (final Object fetch : query.list()) {
                return (Student) fetch;
            }
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return null;
    }

    @Override
    public Specialization getStudentSpecialization(Student student) {
        try (Session session = SessionUtil.getSession()) {
            Query query = session.createQuery("from Student where id=:id");
            query.setParameter("id", student.getId());
            for (final Object fetch : query.list()) {
                return ((Student)fetch).getSpecialization();
            }
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return null;
    }

    @Override
    public List<Course> getPassedCourses(Student student) {
        List<Course> courses = new ArrayList<>();
        try (Session session = SessionUtil.getSession()) {
            Query query = session.createQuery("from Student where id=:id");
            query.setParameter("id", student.getId());
            for (final Object fetch : query.list()) {
                for(final Object grade: ((Student)fetch).getStudent_grades()){
                    if(((Student_Courses)grade).getGrade()>2.8){
                        courses.add(((Student_Courses)grade).getCourse());
                    }
                }
            }
            return courses;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return courses;
    }

    @Override
    public void updateStudentSpecialization(Student student, Specialization specialization) {
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            student.setSpecialization(specialization);
            session.saveOrUpdate(student);
            transaction.commit();
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
    }
}
