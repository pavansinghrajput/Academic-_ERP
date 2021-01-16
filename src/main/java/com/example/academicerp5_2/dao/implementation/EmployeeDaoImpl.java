package com.example.academicerp5_2.dao.implementation;

import com.example.academicerp5_2.bean.Employee;
import com.example.academicerp5_2.bean.Specialization;
import com.example.academicerp5_2.dao.EmployeeDao;
import com.example.academicerp5_2.utils.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public void registerEmployee(Employee employee) {
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }

    }

    @Override
    public Employee getEmployeeByID(Employee employee) {
        try (Session session = SessionUtil.getSession()) {
            Query query = session.createQuery("from Employee where id=:id");
            query.setParameter("id", employee.getId());
            for (final Object fetch : query.list()) {
                return (Employee) fetch;
            }
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return null;
    }
}
