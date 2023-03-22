package be.thomasmore.footballleague.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.Collection;

@Entity
public class Team {
@Id
private Integer id;

private String teamName;
private int teamRating;
private String teamImage;


@ManyToOne
private League league;


@ManyToMany(mappedBy = "teams")
private Collection<Stadium> stadiums;



public Team() {

}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }


    public int getTeamRating() {
        return teamRating;
    }

    public void setTeamRating(int teamRating) {
        this.teamRating = teamRating;
    }

    public String getTeamImage() {
        return teamImage;
    }

    public void setTeamImage(String teamImage) {
        this.teamImage = teamImage;
    }


    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }


    public Collection<Stadium> getStadiums() {
        return stadiums;
    }

    public void setStadiums(Collection<Stadium> stadiums) {
        this.stadiums = stadiums;
    }
}
