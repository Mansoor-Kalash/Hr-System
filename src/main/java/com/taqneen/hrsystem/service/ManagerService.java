package com.taqneen.hrsystem.service;

import com.taqneen.hrsystem.model.Manager;
import com.taqneen.hrsystem.repository.ManagerRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ManagerService {
    final private ManagerRepository managerRepository;

    public ManagerService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    public Manager save(Manager manager){
        return this.managerRepository.save(manager);
    }

    public Manager findById(Long id) throws Exception{
        return this.managerRepository.findById(id).orElseThrow(() -> new Exception("Manager not found  with this - " + id));
    }

    public List<Manager> findAll(){
        return   this.managerRepository.findAll();
    }

    public void delete(Manager manager){
        this.managerRepository.delete(manager);
    }



}
