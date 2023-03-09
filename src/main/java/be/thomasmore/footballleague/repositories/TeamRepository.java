package be.thomasmore.footballleague.repositories;

import be.thomasmore.footballleague.model.Team;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team,Integer> {

}
