package be.thomasmore.footballleague.repositories;

import be.thomasmore.footballleague.model.Player;
import be.thomasmore.footballleague.model.Team;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository extends CrudRepository<Player,Integer> {
    Optional<Player> findFirstByIdLessThanOrderByIdDesc(int id);
    Optional<Player> findFirstByIdGreaterThanOrderById(int id);
    Optional<Player> findFirstByOrderByIdDesc();
    Optional<Player> findFirstByOrderByIdAsc();

    List<Player> findByTeam(Team team);
}
