package com.example.academicerp5_2.bean;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Course implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String code;
    private String name;
    private String description;
    private Integer year;
    private Boolean term; // 0 for Term 1 and 1 for Term 2
    private Integer credits;
    private Integer capacity;

    @OneToMany(mappedBy="course")
    private List<Student_Courses> student_grades;

    @ManyToOne
    @JoinColumn(name="facutly")
    private Employee faculty;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="specialization")
    private Specialization specialization;



    public Course() {
    }

    public Course(String code, String name, String description, Integer year, Boolean term, Integer credits, Integer capacity) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.year = year;
        this.term = term;
        this.credits = credits;
        this.capacity = capacity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Boolean getTerm() {
        return term;
    }

    public void setTerm(Boolean term) {
        this.term = term;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @JsonbTransient
    public List<Student_Courses> getStudent_grades() {
        return student_grades;
    }

    public void setStudent_grades(List<Student_Courses> student_grades) {
        this.student_grades = student_grades;
    }

    @JsonbTransient
    public Employee getFaculty() {
        return faculty;
    }

    public void setFaculty(Employee faculty) {
        this.faculty = faculty;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }
}
