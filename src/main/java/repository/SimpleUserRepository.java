
package repository;

import model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface SimpleUserRepository extends CrudRepository<User, Long> , QueryByExampleExecutor<User> {

	User findByUsername(String username);

	User findByTheUsersName(String username);

	List<User> findAll();

}
