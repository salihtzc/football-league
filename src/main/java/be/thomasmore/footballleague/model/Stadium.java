package be.thomasmore.footballleague.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Stadium {

    @Id
    private Integer id;
    private int capacity;
    private String address;
    private int openingYear;
    private String location;
    private String stadiumImage;

//    @OneToOne
//    private Team team;

    public Stadium(){

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getOpeningYear() {
        return openingYear;
    }

    public void setOpeningYear(int openingYear) {
        this.openingYear = openingYear;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStadiumImage() {
        return stadiumImage;
    }

    public void setStadiumImage(String stadiumImage) {
        this.stadiumImage = stadiumImage;
    }
}
