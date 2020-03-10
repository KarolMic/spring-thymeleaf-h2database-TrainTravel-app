package pl.karolmic.model;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQuery(name = "City.findByTheName", query = "from City c where c.name = ?1")
public class City {

    @Id
    private String city_id;

    @Column(unique = true)
    private String name;

    private String creation_date;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user_id;

    @OneToMany
    private List<TrainConnection> departureCities;

    @OneToMany
    private List<TrainConnection> arrivalCities;

    public City() {
        this(null);
    }

    public City(String city_id) {
        this.city_id = city_id;
    }

    public String getCity_id() {
        return city_id;
    }

    public void setCity_id(String city_id) {
        this.city_id = city_id;
    }

    public String getName() {
        return name;
    }

    public String getCreation_date() {
        return creation_date;
    }

    public String getUser_id() {
        return user_id.getUser_id();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreation_date(String creation_date) {
        this.creation_date = creation_date;
    }

    public void setUser_id(String user_id) {
        this.user_id.setUser_id(user_id);
    }

    @Override
    public String toString() {
        return "City{" +
                "id='" + city_id + '\'' +
                ", name='" + name + '\'' +
                ", creation_date='" + creation_date + '\'' +
                ", user_id='" + user_id + '\'' +
                '}';
    }
}
