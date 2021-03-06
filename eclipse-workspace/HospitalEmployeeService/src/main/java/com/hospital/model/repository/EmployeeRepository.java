package com.hospital.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
