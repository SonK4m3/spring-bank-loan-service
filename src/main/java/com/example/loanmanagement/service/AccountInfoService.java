package com.example.loanmanagement.service;

import com.example.loanmanagement.entity.AccountInfo;
import com.example.loanmanagement.repository.AccountInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountInfoService {
    @Autowired
    private AccountInfoRepository accountInfoRepository;

    public List<AccountInfo> getAllAccountInfos() {
        return accountInfoRepository.findAll();
    }

    public Optional<AccountInfo> getAccountInfoById(Long id) {
        return accountInfoRepository.findById(id);
    }

    public AccountInfo createOrUpdateAccountInfo(AccountInfo accountInfo) {
        return accountInfoRepository.save(accountInfo);
    }

    public void deleteAccountInfoById(Long id) {
        accountInfoRepository.deleteById(id);
    }
}