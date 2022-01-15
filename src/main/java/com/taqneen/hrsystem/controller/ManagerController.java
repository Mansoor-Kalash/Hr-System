package com.taqneen.hrsystem.controller;

import com.taqneen.hrsystem.model.Manager;
import com.taqneen.hrsystem.service.ManagerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ManagerController {

    final private ManagerService managerService;

    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @PostMapping("/managers")
    public ResponseEntity<Manager> create(@RequestBody Manager m){
       Manager manager = managerService.save(m);
        return ResponseEntity.ok(manager);
    }

    @PutMapping("/managers")
    public ResponseEntity<Manager> update(@RequestBody Manager m){
        Manager manager = managerService.save(m);
        return ResponseEntity.ok(manager);
    }

    @GetMapping("/managers/{id}")
    public ResponseEntity<Manager> findById(@PathVariable Long id) throws Exception {
        Manager manager = managerService.findById(id);
        return ResponseEntity.ok(manager);
    }

    @GetMapping("/managers")
    public List<Manager> findAll()  {
        List<Manager> managers = managerService.findAll();
        return managers;
    }

    @DeleteMapping("/managers/{id}")
    public void delete(@PathVariable Long id) throws Exception {
        Manager manager = managerService.findById(id);
        managerService.delete(manager);
    }



}
