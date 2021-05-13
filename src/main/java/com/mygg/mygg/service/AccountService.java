package com.mygg.mygg.service;

import com.mygg.mygg.domain.Account;
import com.mygg.mygg.dto.AccountForm;
import com.mygg.mygg.dto.CreateUserForm;
import com.mygg.mygg.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    public void createUserForm(CreateUserForm createUserForm) {
        Account account = Account.builder().email(createUserForm.getEmail())
                .password(passwordEncoder.encode(createUserForm.getPassword()))
                .build();
        accountRepository.save(account);
    }

    @Transactional
    public Long createUser(AccountForm form) {
        Account account = form.toEntity();
        accountRepository.save(account);
        return account.getId();
    }
}