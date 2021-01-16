package com.example.academicerp5_2.bean;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;

@Entity
public class Student_Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="student")
    private Student student;

    @ManyToOne
    @JoinColumn(name="course")
    private Course course;

    private Double grade;

    public Student_Courses() {
    }

    public Student_Courses(Student student, Course course, Double grade) {
        this.student = student;
        this.course = course;
        this.grade = grade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonbTransient
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @JsonbTransient
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }
}
