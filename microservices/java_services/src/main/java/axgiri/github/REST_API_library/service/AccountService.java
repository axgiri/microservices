package axgiri.github.REST_API_library.service;


import org.hibernate.service.spi.ServiceException;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import axgiri.github.REST_API_library.DTO.AccountDTO;
import axgiri.github.REST_API_library.entity.Account;
import axgiri.github.REST_API_library.repository.AccountRepo;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
public class AccountService {
    private final AccountRepo accountRepo;
    private final PasswordEncoder passwordEncoder;
    private static final Logger log = LoggerFactory.getLogger(AccountService.class);


    @Autowired
    public AccountService(AccountRepo accountRepo, PasswordEncoder passwordEncoder){
        this.accountRepo = accountRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public Account createAccount(@Valid AccountDTO accountDTO){
        Account account = Account.builder()
        .login(accountDTO.getLogin())
        .password(passwordEncoder.encode(accountDTO.getPassword()))
        .build();
        try{
            return accountRepo.save(account);
        } catch (DataAccessException e){
            log.error("error " + e.getMessage());
            throw new ServiceException("can not save acc", e);
        }
    }
}