package com.example.loanmanagement.repository;

import com.example.loanmanagement.entity.PersonalInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalInfoRepository extends JpaRepository<PersonalInfo, Long> {
    // Add custom query methods if needed
}
