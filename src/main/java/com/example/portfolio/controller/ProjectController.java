package com.example.portfolio.controller;

import com.example.portfolio.dto.ProjectDTO;
import com.example.portfolio.dto.ProjectSaveDTO;
import com.example.portfolio.exception.RecordNotFoundException;
import com.example.portfolio.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
@CrossOrigin(origins = "http://localhost:3000")
public class ProjectController {

    @Autowired
    private ProjectService projectService;


    @GetMapping
    public ResponseEntity<List<ProjectDTO>> getProjectData() {
        List<ProjectDTO> projectDTOList = projectService.getProjectData();
        return new ResponseEntity<>(projectDTOList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProjectSaveDTO> saveProject(@RequestBody ProjectSaveDTO newProjectSaveDTO) {
        return new ResponseEntity<>(projectService.saveProjectData(newProjectSaveDTO), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProjectSaveDTO> updateProject
            (@PathVariable Long id, @RequestBody ProjectSaveDTO newProjectSaveDTO) throws RecordNotFoundException {
        return new ResponseEntity<>
                (projectService.updateProjectData(id, newProjectSaveDTO), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable Long id) throws RecordNotFoundException {
        projectService.deleteProjectData(id);
        return new ResponseEntity<>("Deleted", HttpStatus.ACCEPTED);
    }

}
