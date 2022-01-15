package com.taqneen.hrsystem.controller;


import com.taqneen.hrsystem.model.Department;
import com.taqneen.hrsystem.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/departments")
    public ResponseEntity<Department> create(@RequestBody Department d){
        Department department = departmentService.save(d);
        return ResponseEntity.ok(department);

    }

    @PutMapping("/departments")
    public ResponseEntity<Department> update(@RequestBody Department d){
        Department department = departmentService.save(d);
        return ResponseEntity.ok(department);

    }

    @GetMapping("/departments/{id}")
    public ResponseEntity<Department> findById(@PathVariable Long id) throws Exception {
        Department department = departmentService.findById(id);
        return ResponseEntity.ok(department);

    }

    @GetMapping("/departments")
    public List<Department> findAll()  {
        List<Department> departments = departmentService.findAll();
        return departments;
    }

    @DeleteMapping("/departments/{id}")
    public void delete(@PathVariable Long id)  {
        departmentService.delete(id);
    }


}
