package be.thomasmore.footballleague.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"/", "/home"})
    public String home(Model model){

        int myCalculatedValue = 34 * 62;
        model.addAttribute("abcd",myCalculatedValue);
        return "home";
    }
}
