package axgiri.github.REST_API_library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/index")
    public String login(){
        return "index";
    }

    @GetMapping("login?err")
    public String loginErr(Model model){
        model.addAttribute("loginError", true);
        return "index";
    }

}
