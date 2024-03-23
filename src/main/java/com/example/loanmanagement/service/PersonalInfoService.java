package com.example.loanmanagement.service;

import com.example.loanmanagement.entity.PersonalInfo;
import com.example.loanmanagement.repository.PersonalInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalInfoService {

    @Autowired
    private PersonalInfoRepository repository;

    public PersonalInfo savePersonalInfo(PersonalInfo personalInfo) {
        return repository.save(personalInfo);
    }

    public List<PersonalInfo> getAllPersonalInfo() {
        return repository.findAll();
    }

    // Add more methods as needed

}