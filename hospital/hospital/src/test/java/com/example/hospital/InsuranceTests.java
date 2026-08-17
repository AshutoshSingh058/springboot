package com.example.hospital;

import com.example.hospital.entity.Appointment;
import com.example.hospital.entity.Patient;
import com.example.hospital.entity.type.BloodGroupType;
import com.example.hospital.repository.PatientRepository;
import com.example.hospital.service.AppointmentService;
import com.example.hospital.service.InsuranceService;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class InsuranceTests {

    @Autowired
    private InsuranceService insuranceService;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void createPatientAddAppointment(){
        Patient patient = new Patient();
        patient.setName("Ashu");
        patient.setEmail("ashu@gmail.com");
        patient.setBloodGroup(BloodGroupType.A_POSITIVE);
        patient.setGender("MALE");

        patient = patientRepository.save(patient);

        Appointment appointment1 =  Appointment.builder()
                .appointmentTime(LocalDateTime.of(2026, 3, 26 ,14 ,0 ,0))
                .reason("Bone")
                .build();

        Appointment appointment2 =  Appointment.builder()
                .appointmentTime(LocalDateTime.of(2026, 3, 27 ,14 ,0 ,0))
                .reason("Blood")
                .build();
        Appointment appointment3 =  Appointment.builder()
                .appointmentTime(LocalDateTime.of(2026, 3, 28 ,14 ,0 ,0))
                .reason("Brain")
                .build();

        var newAppointment1 =appointmentService.createNewAppointment(appointment1, 1L, patient.getId());
        var newAppointment2 =appointmentService.createNewAppointment(appointment2, 2L, patient.getId());
        var newAppointment3 =appointmentService.createNewAppointment(appointment3, 3L, patient.getId());

        patient = patientRepository.findById(patient.getId()).get();

//        patient.setAppointments();
        System.out.println(patient);
        List<Appointment> appointments = patient.getAppointments();
        for(Appointment appointment: appointments ){
            System.out.println(appointment);
        }
        patientRepository.deleteById(patient.getId());
//        System.out.println();
    }
//    @Test
//    public void testInsurance(){
//        Insurance insurance = Insurance.builder()
//                .policyNumber("HDFC_1234")
//                .provider("HDFC")
//                .validUntil(LocalDate.of(2030, 12,12))
//                .build();
//
//        Pati ent patient = insuranceService.assignInsuranceToPatient(insurance, 1L);
//
//        System.out.println(patient);
//        var newPatient = insuranceService.disaccociatePatientInsuranceFromPatient(patient.getId());
//        System.out.println(newPatient);
//    }

//    @Test
//    public void testCreateAppointment() {
//        Appointment appointment = Appointment.builder()
//                .appointmentTime(LocalDateTime.of(2025, 11, 1, 14, 0, 0))
//                .reason("Cancer")
//                .build();
//
//        var newAppointment = appointmentService.createNewAppointment(appointment, 1L, 2L);
//        System.out.println(newAppointment);
//
//        var  updatedAppointment = appointmentService.reAssignAppointmentToAnotherDoctor(newAppointment.getId(), 3L);
//        System.out.println(updatedAppointment);
//    }
}
