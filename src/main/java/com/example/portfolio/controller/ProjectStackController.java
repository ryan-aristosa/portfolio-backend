package com.example.portfolio.controller;

import com.example.portfolio.dto.ProjectStackDTO;
import com.example.portfolio.exception.RecordNotFoundException;
import com.example.portfolio.service.ProjectStackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/project-stack")
@CrossOrigin(origins = "http://localhost:3000")
public class ProjectStackController {

    @Autowired
    private ProjectStackService projectStackService;


    @PostMapping
    public ResponseEntity<ProjectStackDTO> saveProjectStack(@RequestBody ProjectStackDTO newProjectStackDTO)
            throws RecordNotFoundException {
        return new ResponseEntity<>(projectStackService.saveProjectStackData(newProjectStackDTO), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProjectStackDTO> updateProjectStack
            (@PathVariable Long id, @RequestBody ProjectStackDTO newProjectStackDTO) throws RecordNotFoundException {
        return new ResponseEntity<>
                (projectStackService.updateProjectStackData(id, newProjectStackDTO), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProjectDescription(@PathVariable Long id) throws RecordNotFoundException {
        projectStackService.deleteProjectStackData(id);
        return new ResponseEntity<>("Deleted", HttpStatus.ACCEPTED);
    }

}
