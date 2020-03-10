package repository;

import model.City;
import model.TrainConnection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface SimpleTrainConnectionRepository extends CrudRepository<TrainConnection, Long>,
        QueryByExampleExecutor<TrainConnection> {

    TrainConnection findById(String id);

    List<TrainConnection> findAll();

    List<TrainConnection> findByDepartureCityOrArrivalCity(City departureCity, City arrivalCity);

}
