package com.example.loanmanagement.repository;

import com.example.loanmanagement.entity.BranchInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchInfoRepository extends JpaRepository<BranchInfo, Long> {
}