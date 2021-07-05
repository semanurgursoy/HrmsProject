package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.entities.concrete.User;
import kodlamaio.hrms.core.utilities.results.DataResult;

public interface UserService {
	
	DataResult<List<User>> getAll();
	boolean existsByEmail(String email);
}
