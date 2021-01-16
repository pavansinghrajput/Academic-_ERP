package com.example.academicerp5_2.controller;

import com.example.academicerp5_2.bean.Course;
import com.example.academicerp5_2.bean.Employee;
import com.example.academicerp5_2.bean.Student;
import com.example.academicerp5_2.service.CourseService;
import com.example.academicerp5_2.service.EmployeeService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;


@Path("Employees")
public class EmployeeController {
    EmployeeService employeeService = new EmployeeService();
    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response loginEmployee(Employee employee) throws URISyntaxException {
        System.out.println(employee.getId());
        Employee result = employeeService.getEmployeeByID(employee);
        if (result == null) {
            return Response.noContent().build();
        }

        return Response.ok().entity(result).build();
    }
}
