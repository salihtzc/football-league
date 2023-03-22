package be.thomasmore.footballleague.controllers;

import be.thomasmore.footballleague.model.Stadium;
import be.thomasmore.footballleague.model.Team;
import be.thomasmore.footballleague.repositories.StadiumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class StadiumController {

    @Autowired
    StadiumRepository stadiumRepository;


    @GetMapping("/stadiumlist")
    public String stadiumList(Model model) {

        List<Stadium> allStadiums = stadiumRepository.findAll();

        model.addAttribute("stadiums",allStadiums);

        return "stadiumlist";
    }



    @GetMapping({"/stadiumdetails","/stadiumdetails/{id}"})
    public String stadiumDetails(Model model, @PathVariable(required = false) Integer id){
        if (id==null) return "stadiumdetails";

        Optional<Stadium> optionalStadium = stadiumRepository.findById(id);
        Optional<Stadium> optionalPrev = stadiumRepository.findFirstByIdLessThanOrderByIdDesc(id);
        Optional<Stadium> optionalNext = stadiumRepository.findFirstByIdGreaterThanOrderById(id);
        if (optionalStadium.isPresent()) {
            Stadium stadium = optionalStadium.get();
            model.addAttribute("stadium", stadium);
//            model.addAttribute("players",playerRepository.findByTeam(team));
        }
        if (optionalPrev.isPresent()) {
            model.addAttribute("prev", optionalPrev.get().getId());
        } else {
            model.addAttribute("prev", stadiumRepository.findFirstByOrderByIdDesc().get().getId());
        }
        if (optionalNext.isPresent()) {
            model.addAttribute("next", optionalNext.get().getId());
        } else {
            model.addAttribute("next", stadiumRepository.findFirstByOrderByIdAsc().get().getId());
        }
        return "stadiumdetails";


    }


}
