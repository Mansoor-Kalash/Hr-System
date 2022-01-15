package com.taqneen.hrsystem.controller;


import com.taqneen.hrsystem.model.Employee;
import com.taqneen.hrsystem.service.EmployeeService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {


    private final EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> create(@RequestBody Employee e){
    Employee employee = employeeService.save(e);
    return ResponseEntity.ok(employee);

    }

    @PutMapping("/employees")
    public ResponseEntity<Employee> update(@RequestBody Employee e){
        Employee employee = employeeService.save(e);
        return ResponseEntity.ok(employee);

    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> findById(@PathVariable Long id) throws Exception {
        Employee employee = employeeService.findById(id);
        return ResponseEntity.ok(employee);

    }

    @GetMapping("/employees")
    public List<Employee> findAll()  {
        List<Employee> employees = employeeService.findAll();
        return employees;

    }

    @GetMapping("/employees/{fromDate}/{toDate}")
    public List<Employee> findBetweenDates(@PathVariable  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fromDate , @PathVariable  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate toDate)  {
        List<Employee> employees = employeeService.findAllByDateBetween(fromDate,toDate);
        return employees;

    }


    @DeleteMapping("/employees/{id}")
    public void delete(@PathVariable Long id)  {
        employeeService.delete(id);
    }
}
