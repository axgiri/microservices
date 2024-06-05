package axgiri.github.REST_API_library.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import axgiri.github.REST_API_library.entity.Account;

public interface AccountRepo extends JpaRepository<Account, Integer>{
    Optional<Account> findByLogin(String login);
}
