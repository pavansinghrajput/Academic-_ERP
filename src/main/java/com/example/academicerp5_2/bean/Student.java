package com.example.academicerp5_2.bean;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String roll_number;
    @Column(nullable = false, unique = true)
    private String email;
    private String first_name;
    private String last_name;

    @ManyToOne
    @JoinColumn(name="specialization")
    private Specialization specialization;

    @OneToMany(mappedBy="student")
    private List<Student_Courses> student_grades;

    public Student(String roll_number, String email, String first_name, String last_name) {
        this.roll_number = roll_number;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public Student() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoll_number() {
        return roll_number;
    }

    public void setRoll_number(String roll_number) {
        this.roll_number = roll_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    @JsonbTransient
    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    @JsonbTransient
    public List<Student_Courses> getStudent_grades() {
        return student_grades;
    }

    public void setStudent_grades(List<Student_Courses> student_grades) {
        this.student_grades = student_grades;
    }
}
