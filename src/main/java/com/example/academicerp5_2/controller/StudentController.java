package com.example.academicerp5_2.controller;


import com.example.academicerp5_2.bean.Specialization;
import com.example.academicerp5_2.bean.Student;
import com.example.academicerp5_2.service.StudentService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;

@Path("students")
public class StudentController {
    StudentService studentService = new StudentService();
    @GET
    @Path("id")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudentByID(Student student){
        Student result = studentService.getStudentByID(student);
        if (result == null) {
            return Response.noContent().build();
        }

        return Response.ok().entity(result).build();
    }
    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response loginStudent(Student student) throws URISyntaxException {
        Student result = studentService.getStudentByID(student);
        if (result == null) {
            return Response.noContent().build();
        }

        return Response.ok().entity(result).build();
    }

    @GET
    @Path("/passed")
    @Produces(MediaType.APPLICATION_JSON)
    public Response passeCourses(Student student) throws URISyntaxException {
        Student result = studentService.getPassedCourses(student);
        if (result == null) {
            return Response.noContent().build();
        }

        return Response.ok().entity(result).build();
    }

    @PUT
    @Path("/updatedspecailisation")
    public Response updatedStudentSpecialization(Student student) throws URISyntaxException {
        Student result = studentService.getStudentByID(student);
        studentService.update_specailzation(result);
        Specialization specailization = studentService.getStudentSpecialization(result);
        studentService.updateStudentSpecialization(result, specailization);
        return Response.ok().build();
    }

    @GET
    @Path("/getspecialisation")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudentSpecialization(Student student) throws URISyntaxException {
        Student result = studentService.getStudentByID(student);
        Specialization result1 = studentService.getStudentSpecialization(result);
        if (result1 == null) {
            return Response.noContent().build();
        }

        return Response.ok().entity(result1).build();
    }
    @GET
    @Path("/getstudentdetails")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudentDetails(Student student) throws URISyntaxException {
        Student result = studentService.getStudentByID(student);
        if (result == null) {
            return Response.noContent().build();
        }

        return Response.ok().entity(result).build();
    }


}

