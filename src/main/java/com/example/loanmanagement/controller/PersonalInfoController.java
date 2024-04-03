package com.example.loanmanagement.controller;

import com.example.loanmanagement.entity.PersonalInfo;
import com.example.loanmanagement.service.PersonalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personal-info")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PersonalInfoController {

    @Autowired
    private PersonalInfoService service;

    @PostMapping("/create")
    public ResponseEntity<PersonalInfo> createPersonalInfo(@RequestBody PersonalInfo personalInfo) {
        PersonalInfo createdPersonalInfo = service.savePersonalInfo(personalInfo);
        return new ResponseEntity<>(createdPersonalInfo, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PersonalInfo>> getAllPersonalInfo() {
        List<PersonalInfo> personalInfoList = service.getAllPersonalInfo();
        return new ResponseEntity<>(personalInfoList, HttpStatus.OK);
    }

    // Add more endpoints as needed

}