package com.taqneen.hrsystem.service;

import com.taqneen.hrsystem.model.Employee;
import com.taqneen.hrsystem.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public Employee save(Employee employee){

        return employeeRepository.save(employee);

    }


    public Employee findById(Long id) throws Exception {

        return employeeRepository.findById(id).orElseThrow(() -> new Exception("Employee not found  with this - " + id));

    }

    public List<Employee> findAll(){

        return employeeRepository.findAll();
    }


    public List<Employee> findAllByDateBetween(LocalDate from, LocalDate to){

        return employeeRepository.findAllByCreationDateBetween(from, to);

    }

    public List<Employee> findAllByDepartmentName(String departmentName){

        return employeeRepository.findAllByDepartment_Name(departmentName);

    }
    public void delete(Long id){
        employeeRepository.deleteById(id);
    }


}
