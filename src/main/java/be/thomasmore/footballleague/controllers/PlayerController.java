package be.thomasmore.footballleague.controllers;

import be.thomasmore.footballleague.model.Player;
import be.thomasmore.footballleague.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlayerController {

    @Autowired
    PlayerRepository playerRepository;

    @GetMapping("/playerlist")
    public String playerList(Model model) {

        return "home";
    }

    @GetMapping("/allplayers")
    public String allPlayers(Model model) {
        Iterable<Player> allPlayers = playerRepository.findAll();


        model.addAttribute("allPlayers", allPlayers);
        return "allplayers" ;
    }
}
