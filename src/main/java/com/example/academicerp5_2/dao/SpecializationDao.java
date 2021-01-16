package com.example.academicerp5_2.dao;

import com.example.academicerp5_2.bean.Specialization;

public interface SpecializationDao {

    void registerSpecialization(Specialization specialization);

    Specialization getSpecializationByID(Specialization specialization);

    Specialization getSpecializationByCode(String code);
}
