package kodlamaio.hrms.core.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.core.entities.concrete.User;

public interface UserDao extends JpaRepository<User,Integer>{
	List<User> findAllByEmail(String email);
	User findById(int userId);
	boolean existsByEmail(String email);
}
