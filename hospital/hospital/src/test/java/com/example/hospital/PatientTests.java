package com.example.hospital;

import com.example.hospital.dto.BloodGroupCountResponseEntity;
import com.example.hospital.entity.Patient;
import com.example.hospital.entity.type.BloodGroupType;
import com.example.hospital.repository.PatientRepository;
import com.example.hospital.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@SpringBootTest
public class PatientTests {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void testPatientRepository(){
        List<Patient> patientList = patientRepository.findAllPatientWithAppointment();
        System.out.println(patientList);
    }

//    @Test
//    @Transactional
//    public void testTransactionMethod() {
//        Patient patient = patientService.getPatientById(1L);
//
//        System.out.println(patient);
//    }

    @Test
    @Transactional
    public void testTransactionMethods(){
//        Patient patient = patientRepository.findByName("Alice Smith");
//        List<Patient> patientList = patientRepository.findByBirthDateOrEmail(LocalDate.of(1998,3,22), "priya@example.com" );
//        List<Patient> patientList = patientRepository.findByBloodGroup(BloodGroupType.A_POSITIVE);
//
//        List<Patient> patientList = patientRepository.findByBornAfterDate(LocalDate.of(1998, 3, 14));
//        for(Patient patient : patientList) {
//            System.out.println(patient);
//        }

        Page<Patient> patientList = patientRepository.findALlPatients(PageRequest.of(1,2, Sort.by("name")));

        for(Patient patient : patientList){
            System.out.println(patient);
        }

//        List<Object[]> bloodGroupList = patientRepository.countEachBloodGroupType();
//        for(Object[] objects: bloodGroupList){
//            System.out.println(objects[0]+ " : "+objects[1]);
//        }

//        int rowsUpdated = patientRepository.updateNameWithID("Alex", 1L);
//        System.out.println(rowsUpdated);

//        List<BloodGroupCountResponseEntity> bloodGroupList = patientRepository.countEachBloodGroupType();
//        for(BloodGroupCountResponseEntity bloodGroupCount: bloodGroupList){
//            System.out.println(bloodGroupCount);
//        }
    }

}

