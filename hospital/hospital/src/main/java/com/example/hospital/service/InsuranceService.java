package com.example.hospital.service;

import com.example.hospital.entity.Insurance;
import com.example.hospital.entity.Patient;
import com.example.hospital.repository.InsuranceRepository;
import com.example.hospital.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Patient assignInsuranceToPatient(Insurance insurance, Long patientId){
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(()-> new EntityNotFoundException("Patient Not Found for: "+patientId));

        patient.setInsurance(insurance);
        insurance.setPatient(patient);  // bidirectional consistency maintenance

        return patientRepository.save(patient);
    }

    @Transactional
    public Patient disaccociatePatientInsuranceFromPatient(Long patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(()-> new EntityNotFoundException("Patient Not Found for: "+patientId));

        patient.setInsurance(null);
        return patient;
    }

    @Transactional
    public Patient disaccociateInsuranceFromPatient(Long patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(()-> new EntityNotFoundException("Patient Not Found for: "+patientId));

        patient.setInsurance(null);

        return patient;
    }
}

