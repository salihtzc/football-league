package be.thomasmore.footballleague.repositories;

import be.thomasmore.footballleague.model.Player;
import be.thomasmore.footballleague.model.Team;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository extends CrudRepository<Player,Integer> {

    List<Player> findAll();
    Optional<Player> findFirstByIdLessThanOrderByIdDesc(int id);
    Optional<Player> findFirstByIdGreaterThanOrderById(int id);
    Optional<Player> findFirstByOrderByIdDesc();
    Optional<Player> findFirstByOrderByIdAsc();

    List<Player> findByTeam(Team team);


    @Query("SELECT p FROM Player p " +
           "WHERE (?1 is null or p.rate >= ?1)" +
            "AND (?2 is null or p.rate <= ?2)" +
            "AND (?3 is null or p.age >= ?3)" +
            "AND (?4 is null or p.age <= ?4) " +
            "AND (?5 is null or p.preferredPosition = ?5) "
    )
    List<Player> findByQuery(Integer minRate, Integer maxRate, Integer minAge, Integer maxAge, String position);


}
