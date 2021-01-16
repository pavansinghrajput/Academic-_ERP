package com.example.academicerp5_2.service;

import com.example.academicerp5_2.bean.Employee;
import com.example.academicerp5_2.dao.EmployeeDao;
import com.example.academicerp5_2.dao.implementation.EmployeeDaoImpl;

public class EmployeeService {
    EmployeeDao employeeDao = new EmployeeDaoImpl();
    public  Employee getEmployeeByID(Employee employee){
        return employeeDao.getEmployeeByID(employee);
    }

    public void registerEmployee(Employee employee){
         employeeDao.registerEmployee(employee);
    }
}

