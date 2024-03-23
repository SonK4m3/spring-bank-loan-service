package com.example.loanmanagement.controller;

import com.example.loanmanagement.entity.AccountInfo;
import com.example.loanmanagement.service.AccountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/accountInfos")
public class AccountInfoController {
    @Autowired
    private AccountInfoService accountInfoService;

    @GetMapping
    public ResponseEntity<List<AccountInfo>> getAllAccountInfos() {
        List<AccountInfo> accountInfos = accountInfoService.getAllAccountInfos();
        return ResponseEntity.ok().body(accountInfos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountInfo> getAccountInfoById(@PathVariable Long id) {
        Optional<AccountInfo> accountInfo = accountInfoService.getAccountInfoById(id);
        return accountInfo.map(info -> ResponseEntity.ok().body(info))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AccountInfo> createAccountInfo(@RequestBody AccountInfo accountInfo) {
        AccountInfo createdAccountInfo = accountInfoService.createOrUpdateAccountInfo(accountInfo);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAccountInfo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountInfo> updateAccountInfo(@PathVariable Long id, @RequestBody AccountInfo accountInfo) {
        accountInfo.setId(id);
        AccountInfo updatedAccountInfo = accountInfoService.createOrUpdateAccountInfo(accountInfo);
        return ResponseEntity.ok().body(updatedAccountInfo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccountInfo(@PathVariable Long id) {
        accountInfoService.deleteAccountInfoById(id);
        return ResponseEntity.noContent().build();
    }
}
