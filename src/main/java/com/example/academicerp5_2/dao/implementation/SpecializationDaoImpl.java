package com.example.academicerp5_2.dao.implementation;

import com.example.academicerp5_2.bean.Course;
import com.example.academicerp5_2.bean.Specialization;
import com.example.academicerp5_2.dao.SpecializationDao;
import com.example.academicerp5_2.utils.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class SpecializationDaoImpl implements SpecializationDao {
    @Override
    public void registerSpecialization(Specialization specialization) {
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(specialization);
            transaction.commit();
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
    }

    @Override
    public Specialization getSpecializationByID(Specialization specialization) {
        try (Session session = SessionUtil.getSession()) {
            Query query = session.createQuery("from Specialization where id=:id");
            query.setParameter("id", specialization.getId());
            for (final Object fetch : query.list()) {
                return (Specialization) fetch;
            }
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return null;
    }

    @Override
    public Specialization getSpecializationByCode(String code) {
        try (Session session = SessionUtil.getSession()) {
            Query query = session.createQuery("from Specialization where code=:code");
            query.setParameter("code", code);
            for (final Object fetch : query.list()) {
                return (Specialization) fetch;
            }
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return null;
    }
}
