package com.sb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sb.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
}
