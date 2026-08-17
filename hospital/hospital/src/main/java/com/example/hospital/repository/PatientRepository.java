package com.example.hospital.repository;

import com.example.hospital.dto.BloodGroupCountResponseEntity;
import com.example.hospital.entity.Patient;
import com.example.hospital.entity.type.BloodGroupType;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;


public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByName(String name);

    List<Patient> findByBirthDateOrEmail(LocalDate birthDate, String email);

    List<Patient> findByBirthDateBetween(LocalDate startDate, LocalDate endDate);

    List<Patient> findByNameContaining(String d);

    List<Patient> findByNameContainingOrderByIdDesc(String q);

    @Query("SELECT p FROM Patient p WHERE p.bloodGroup =?1")
    List<Patient> findByBloodGroup(@Param("bloodGroup")BloodGroupType bloodGroup);

    @Query("SELECT p FROM Patient p WHERE p.birthDate > :birthDate")
    List<Patient> findByBornAfterDate(@Param("birthDate")LocalDate birthDate);

    @Query("SELECT NEW com.example.hospital.dto.BloodGroupCountResponseEntity( p.bloodGroup," + " COUNT(p) )FROM Patient p GROUP BY p.bloodGroup")
//    List<Object[]> countEachBloodGroupType();
    List<BloodGroupCountResponseEntity> countEachBloodGroupType();


    @Query(value = "SELECT * FROM patient", nativeQuery = true)
    Page<Patient> findALlPatients(Pageable pageable);

    @Transactional
    @Modifying
    @Query("UPDATE Patient p SET p.name = :name WHERE p.id = :id")
    int updateNameWithId(@Param("name") String name, @Param("id") Long id);

//    @Query("SELECT p FROM Patient p LEFT JOIN FETCH p.appointments a LEFT JOIN FETCH a.doctor")
    @Query("SELECT p FROM Patient p LEFT JOIN FETCH p.appointments")
    List<Patient> findAllPatientWithAppointment();
}
