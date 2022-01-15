package com.taqneen.hrsystem.controller;

import com.taqneen.hrsystem.model.Directorate;
import com.taqneen.hrsystem.service.DirectorateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DirectorateController {
    final private DirectorateService directorateService;

    public DirectorateController(DirectorateService directorateService) {
        this.directorateService = directorateService;
    }

    @PostMapping("/directorates")
    public ResponseEntity<Directorate> create(@RequestBody Directorate d){
        Directorate directorate = directorateService.save(d);
        return ResponseEntity.ok(directorate);

    }

    @PutMapping("/directorates")
    public ResponseEntity<Directorate> update(@RequestBody Directorate d){
        Directorate directorate = directorateService.save(d);
        return ResponseEntity.ok(directorate);

    }

    @GetMapping("/directorates/{id}")
    public ResponseEntity<Directorate> findById(@PathVariable Long id) throws Exception {
        Directorate directorate = directorateService.findById(id);
        return ResponseEntity.ok(directorate);

    }

    @GetMapping("/directorates")
    public List<Directorate> findAll()  {
        List<Directorate> directorates = directorateService.findAll();
        return directorates;

    }

    @DeleteMapping("/directorates/{id}")
    public void delete(@PathVariable Long id)  {
        directorateService.delete(id);
    }

}
