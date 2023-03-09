package be.thomasmore.footballleague.controllers;

import be.thomasmore.footballleague.model.Team;
import be.thomasmore.footballleague.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

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


    @GetMapping({"/teamdetails","/teamdetails/{id}"})
    public String teamDetails(Model model, @PathVariable(required = false) Integer id){
        if (id==null) return "teamdetails";

        Optional<Team> optionalTeam = teamRepository.findById(id);
        Optional<Team> optionalPrev = teamRepository.findFirstByIdLessThanOrderByIdDesc(id);
        Optional<Team> optionalNext = teamRepository.findFirstByIdGreaterThanOrderById(id);
        if (optionalTeam.isPresent()) {
            model.addAttribute("team", optionalTeam.get());
        }
        if (optionalPrev.isPresent()) {
            model.addAttribute("prev", optionalPrev.get().getId());
        } else {
            model.addAttribute("prev", teamRepository.findFirstByOrderByIdDesc().get().getId());
        }
        if (optionalNext.isPresent()) {
            model.addAttribute("next", optionalNext.get().getId());
        } else {
            model.addAttribute("next", teamRepository.findFirstByOrderByIdAsc().get().getId());
        }
        return "teamdetails";


    }

}
