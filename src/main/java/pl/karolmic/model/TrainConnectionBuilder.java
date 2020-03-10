package pl.karolmic.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.karolmic.repository.SimpleCityRepository;

@Component
public class TrainConnectionBuilder {

    private String id;
    private City departureCity;
    private City arrivalCity;
    private String transportDate;

    @Autowired
    private SimpleCityRepository cityRepository;

    public TrainConnectionBuilder withId(String id) {
        this.id = id;
        return this;
    }

    public TrainConnectionBuilder withDepartureCity(String departureCity) {
        this.departureCity = cityRepository.findByName(departureCity);
        return this;
    }

    public TrainConnectionBuilder withArrivalCity(String arrivalCity) {
        this.arrivalCity = cityRepository.findByName(arrivalCity);
        return this;
    }

    public TrainConnectionBuilder withTransportDate(String transportDate) {
        this.transportDate = transportDate;
        return this;
    }

    public TrainConnection build() {
        TrainConnection trainConnection = new TrainConnection(departureCity, arrivalCity, transportDate);
        trainConnection.setId(id);
        return trainConnection;
    }

}
