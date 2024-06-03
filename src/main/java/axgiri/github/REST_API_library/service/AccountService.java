package axgiri.github.REST_API_library.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import axgiri.github.REST_API_library.DTO.AccountDTO;
import axgiri.github.REST_API_library.entity.Account;
import axgiri.github.REST_API_library.repository.AccountRepo;
import jakarta.validation.Valid;

@Service
public class AccountService {
    private final AccountRepo accountRepo;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AccountService(AccountRepo accountRepo, PasswordEncoder passwordEncoder){
        this.accountRepo = accountRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public Account createAccount(@Valid AccountDTO accountDTO){
        Account account = Account.builder()
        .login(accountDTO.getLogin())
        .password(passwordEncoder.encode(accountDTO.getPassword()))
        .build();

        return accountRepo.save(account);
    }
}
