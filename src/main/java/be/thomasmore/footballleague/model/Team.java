package be.thomasmore.footballleague.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Team {
@Id
private Integer id;

private String teamName;
private int teamRating;
private String teamImage;


@ManyToOne
private League league;

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
}
