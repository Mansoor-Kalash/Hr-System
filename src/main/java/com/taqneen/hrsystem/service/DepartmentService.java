package com.taqneen.hrsystem.service;

import com.taqneen.hrsystem.model.Department;
import com.taqneen.hrsystem.model.Employee;
import com.taqneen.hrsystem.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }
    public Department findById(Long id) throws Exception {
        return departmentRepository.findById(id).orElseThrow(() -> new Exception("Directorate not found  with this - " + id));
    }
    public List<Department> findAll (){
        return departmentRepository.findAll();
    }
    public void delete(Long id){

        departmentRepository.deleteById(id);

    }
    public Department findByName(String name){
        return departmentRepository.findByName(name);
    }
    public Department save(Department department){
        return departmentRepository.save(department);
    }

}
