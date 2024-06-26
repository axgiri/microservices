package axgiri.github.REST_API_library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PhpController {
    @GetMapping("/blog")
        public String showBlog(){
            return "redirect:http://127.0.0.1:8000";
        
    }
}
