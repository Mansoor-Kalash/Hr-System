package com.taqneen.hrsystem.repository;

import com.taqneen.hrsystem.model.Directorate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorateRepository extends JpaRepository<Directorate,Long> {
    Directorate findByName(String name);
}
