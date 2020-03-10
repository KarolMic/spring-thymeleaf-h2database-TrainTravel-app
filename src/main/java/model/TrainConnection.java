package model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@NamedQuery(name = "TrainConnection.findByTheDepartureCity", query = "from TrainConnection t where t.departureCity = ?1")
@Component
public class TrainConnection {

    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name="departureCity")
    private City departureCity;

    @ManyToOne
    @JoinColumn(name="arrivalCity")
    private City arrivalCity;

    private String transportDate;

    @Transient
    @Autowired
    private SimpleTrainConnectionRepository trainConnectionRepository;

    public TrainConnection() {

    }

    public TrainConnection(City departureCity, City arrivalCity, String transportDate) {
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.transportDate = transportDate;
    }

    public String getId() {
        return id;
    }

    public String getDepartureCity() {
        return departureCity.getName();
    }

    public String getArrivalCity() {
        return arrivalCity.getName();
    }

    public String getTransportDate() {
        return transportDate;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDepartureCity(City departureCity) {
        this.departureCity = departureCity;
    }

    public void setArrivalCity(City arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public void setTransportDate(String transportDate) {
        this.transportDate = transportDate;
    }

    @Override
    public String toString() {
        return "TrainConnection{" +
                "id='" + id + '\'' +
                ", departureCity='" + departureCity + '\'' +
                ", arrivalCity='" + arrivalCity + '\'' +
                ", transportDate='" + transportDate + '\'' +
                '}';
    }

    @PrePersist
    private void ensureId(){
        if(id==null) {
            int maxId = trainConnectionRepository.findAll().stream().mapToInt(e -> Integer.valueOf(e.getId()))
                            .max().orElse(-1);
            int countId = maxId + 1;
            this.setId(String.valueOf(countId));
        }
    }

}
