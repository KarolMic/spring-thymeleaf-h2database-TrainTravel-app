package repository;

import model.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Transactional
public interface SimpleCityRepository extends CrudRepository<City, Long>, QueryByExampleExecutor<City> {

    List<City> findAll();

    City findByName(String name);

}
