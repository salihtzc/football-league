package be.thomasmore.footballleague.controllers;

import be.thomasmore.footballleague.model.Team;
import be.thomasmore.footballleague.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TeamController {

    @Autowired
    TeamRepository teamRepository;

    @GetMapping("/teamlist")
    public String teamList(Model model) {
        Iterable<Team> teams = teamRepository.findAll();

        model.addAttribute("teams", teams);

        return "teamlist";
    }

}
