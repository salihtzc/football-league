package be.thomasmore.footballleague.repositories;

import be.thomasmore.footballleague.model.Stadium;
import be.thomasmore.footballleague.model.Team;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface StadiumRepository extends CrudRepository<Stadium,Integer> {

    Optional<Stadium> findFirstByIdLessThanOrderByIdDesc(int id);
    Optional<Stadium> findFirstByIdGreaterThanOrderById(int id);
    Optional<Stadium> findFirstByOrderByIdDesc();
    Optional<Stadium> findFirstByOrderByIdAsc();

    List<Stadium> findAll();

}
