package axgiri.github.REST_API_library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import axgiri.github.REST_API_library.DTO.AccountDTO;
import axgiri.github.REST_API_library.DTO.BookDTO;
import axgiri.github.REST_API_library.entity.Account;
import axgiri.github.REST_API_library.entity.Book;
import axgiri.github.REST_API_library.repository.AccountRepo;
import axgiri.github.REST_API_library.repository.BookRepo;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@ToString
public class MainController {

    @GetMapping("/index")
    public String login(){
        return "index";
    }

    @GetMapping("/signUp")
    public String signUp(){
        return "signUp";
    }





    

    //TODO: create new controllers for them
    private final AccountRepo accountRepo;
    private final BookRepo bookRepo;

    @Autowired
    public MainController(ObjectMapper objectMapper, AccountRepo accountRepo, BookRepo bookRepo) {
        this.accountRepo = accountRepo;
        this.bookRepo = bookRepo;
    }

    @PostMapping("/user/add")
    public void AddUser(@RequestBody AccountDTO accountDTO){
        Account savedAccount = accountRepo.save(Account.builder()
        .login(accountDTO.getLogin())
        .password(accountDTO.getPassword())
        .build());
        log.info(String.format("acc saved %d", savedAccount.getLogin()));
    }

    @PostMapping("/book/add")
    public void AddBook(@RequestBody BookDTO bookDTO){
        Book savedBook = bookRepo.save(Book.builder()
        .name(bookDTO.getName())
        .author(bookDTO.getAuthor())
        .build());
        log.info(String.format("book saved %s", savedBook.getName()));
    }
}
