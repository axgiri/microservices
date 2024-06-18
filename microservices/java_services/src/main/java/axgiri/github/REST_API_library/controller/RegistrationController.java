package axgiri.github.REST_API_library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import axgiri.github.REST_API_library.DTO.AccountDTO;
import axgiri.github.REST_API_library.entity.Account;
import axgiri.github.REST_API_library.service.AccountService;
import jakarta.validation.Valid;

@Controller
public class RegistrationController {
    private final AccountService accountService;
    private static final Logger log = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    public RegistrationController(AccountService accountService){
        this.accountService = accountService;
    }

    @GetMapping("/registration")
    public String signUp(Model model){
        model.addAttribute("AccountDTO", new AccountDTO());
        return "signUp";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("AccountDTO")
    AccountDTO accountDTO, BindingResult result, Model model){
        log.info("registering acc {}", accountDTO.getLogin());
        if (result.hasErrors()){
            result.getAllErrors().forEach(error -> log.warn("validation error {}", error.getDefaultMessage()));
            return "signUp";
        }
        accountService.createAccount(accountDTO);
        log.info("redirected to index.html after successful registration");
        return "redirect:/index";
    }

    




    @GetMapping("/testWithBuilder")
    public String signUpTestWBuilder(Model model){
        Account account = Account.builder()
        .login("")
        .password("")
        .build();
        model.addAttribute("AccountDTO", account);
        return "signUp";
    }


}



    