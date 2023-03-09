package be.thomasmore.footballleague.repositories;

import be.thomasmore.footballleague.model.Team;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TeamRepository extends CrudRepository<Team,Integer> {
    Optional<Team> findFirstByIdLessThanOrderByIdDesc(int id);
    Optional<Team> findFirstByIdGreaterThanOrderById(int id);
    Optional<Team> findFirstByOrderByIdDesc();
    Optional<Team> findFirstByOrderByIdAsc();
}
