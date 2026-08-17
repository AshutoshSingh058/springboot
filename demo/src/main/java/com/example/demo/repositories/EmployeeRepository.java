package com.example.demo.repositories;


import com.example.demo.entities.EmployeeEntity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

}
