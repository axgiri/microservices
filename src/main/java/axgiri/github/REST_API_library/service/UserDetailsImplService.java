package axgiri.github.REST_API_library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import axgiri.github.REST_API_library.entity.Account;
import axgiri.github.REST_API_library.repository.AccountRepo;
import axgiri.github.REST_API_library.security.UserDetailsImpl;

@Service
public class UserDetailsImplService implements UserDetailsService{
    private final AccountRepo accountRepo;

    @Autowired
    public UserDetailsImplService(AccountRepo accountRepo){
        this.accountRepo = accountRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Account account = accountRepo.findByLogin(username)
        .orElseThrow(() -> new UsernameNotFoundException("user " + username + "not found"));
        return new UserDetailsImpl(account);
    }
}
