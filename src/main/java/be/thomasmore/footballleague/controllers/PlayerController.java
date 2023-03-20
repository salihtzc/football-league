package be.thomasmore.footballleague.controllers;

import be.thomasmore.footballleague.model.Player;
import be.thomasmore.footballleague.model.Team;
import be.thomasmore.footballleague.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

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


    @GetMapping("/allplayers/{filter}")
    public String allPlayersWithFilter(Model model, @RequestParam(required = false) Integer minimumRate,
                                                    @RequestParam(required = false) Integer maximumRate,
                                                    @RequestParam(required = false) Integer minimumAge,
                                                    @RequestParam(required = false) Integer maximumAge,
                                                    @RequestParam(required = false) String position
    ) {


        List<Player> allPlayers = playerRepository.findByQuery(minimumRate,maximumRate,minimumAge,maximumAge,position);


        model.addAttribute("minimumRate",minimumRate);
        model.addAttribute("maximumRate",maximumRate);
        model.addAttribute("minimumAge",minimumAge);
        model.addAttribute("maximumAge",maximumAge);
        model.addAttribute("position",position);

        model.addAttribute("allPlayers",allPlayers);
        model.addAttribute("showFilter",true);

        return "allplayers";
    }



    @GetMapping({"/playerdetails","/playerdetails/{id}"})
    public String teamDetails(Model model, @PathVariable(required = false) Integer id){
        if (id==null) return "playerdetails";

        Optional<Player> optionalPlayer = playerRepository.findById(id);
        Optional<Player> optionalPrev = playerRepository.findFirstByIdLessThanOrderByIdDesc(id);
        Optional<Player> optionalNext = playerRepository.findFirstByIdGreaterThanOrderById(id);
        if (optionalPlayer.isPresent()) {
            Player player = optionalPlayer.get();
            model.addAttribute("player", player);
        }
        if (optionalPrev.isPresent()) {
            model.addAttribute("prev", optionalPrev.get().getId());
        } else {
            model.addAttribute("prev", playerRepository.findFirstByOrderByIdDesc().get().getId());
        }
        if (optionalNext.isPresent()) {
            model.addAttribute("next", optionalNext.get().getId());
        } else {
            model.addAttribute("next", playerRepository.findFirstByOrderByIdAsc().get().getId());
        }
        return "playerdetails";


    }


}
