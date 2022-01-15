package com.taqneen.hrsystem.service;

import com.taqneen.hrsystem.model.Department;
import com.taqneen.hrsystem.model.Directorate;
import com.taqneen.hrsystem.repository.DepartmentRepository;
import com.taqneen.hrsystem.repository.DirectorateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorateService {
final private DirectorateRepository directorateRepository;

    public DirectorateService(DirectorateRepository directorateRepository) {
        this.directorateRepository = directorateRepository;
    }


    public Directorate findById(Long id) throws Exception {
        return directorateRepository.findById(id).orElseThrow(() -> new Exception("Directorate not found  with this - " + id));
    }
    public List<Directorate> findAll (){
        return directorateRepository.findAll();
    }
    public void delete(Long id){

        directorateRepository.deleteById(id);

    }
    public Directorate findByName(String name){
        return directorateRepository.findByName(name);
    }
    public Directorate save(Directorate directorate){
        return directorateRepository.save(directorate);
    }
}
