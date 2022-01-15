package com.taqneen.hrsystem.repository;

import com.taqneen.hrsystem.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

    Department findByName(String directorateName);
}
