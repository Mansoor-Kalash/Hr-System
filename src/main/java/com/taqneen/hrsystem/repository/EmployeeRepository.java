package com.taqneen.hrsystem.repository;

import com.taqneen.hrsystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    List<Employee> findAllByCreationDateBetween(LocalDate from,LocalDate to);
    List<Employee> findAllByDepartment_Name(String name);

}
