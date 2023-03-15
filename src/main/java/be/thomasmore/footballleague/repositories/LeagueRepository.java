package be.thomasmore.footballleague.repositories;

import be.thomasmore.footballleague.model.League;
import org.springframework.data.repository.CrudRepository;

public interface LeagueRepository extends CrudRepository<League,Integer> {

}
