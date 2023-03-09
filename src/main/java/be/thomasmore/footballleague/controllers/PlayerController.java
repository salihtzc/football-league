package be.thomasmore.footballleague.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlayerController {

    @GetMapping("/playerlist")
    public String playerList(Model model) {

        return "home";
    }
}
