package be.thomasmore.footballleague.controllers;

import be.thomasmore.footballleague.model.League;
import be.thomasmore.footballleague.model.Team;
import be.thomasmore.footballleague.repositories.LeagueRepository;
import be.thomasmore.footballleague.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class LeagueController {

    @Autowired
    LeagueRepository leagueRepository;

    @Autowired
    TeamRepository teamRepository;


    @GetMapping({"/leaguedetails", "/leaguedetails/{id}"})
    public String leaguedetails(Model model, @PathVariable ( required=false) Integer id) {
        if (id==null) return "leaguedetails";

        Optional<League> optionalLeague = leagueRepository.findById(id);

        if (optionalLeague.isPresent()) {
            League league = optionalLeague.get();
            model.addAttribute("league", league);
            model.addAttribute("teams",teamRepository.findByLeague(league));
        }

        return "leaguedetails";

    }

}
