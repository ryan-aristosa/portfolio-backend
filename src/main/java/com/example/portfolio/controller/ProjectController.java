package com.example.portfolio.controller;

import com.example.portfolio.dto.ProjectDTO;
import com.example.portfolio.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
