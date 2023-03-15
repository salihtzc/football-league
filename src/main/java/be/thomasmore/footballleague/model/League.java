package be.thomasmore.footballleague.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class League {

    @Id
    private Integer id;
    private String name;
    private String backgroundImage;
    private String description;


    public League() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(String backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
