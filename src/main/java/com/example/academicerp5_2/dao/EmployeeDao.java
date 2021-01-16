package com.example.academicerp5_2.dao;

import com.example.academicerp5_2.bean.Employee;

public interface EmployeeDao {

    void registerEmployee(Employee employee);

    Employee getEmployeeByID(Employee employee);
}
