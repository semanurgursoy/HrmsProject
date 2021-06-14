package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.dataAccess.UserDao;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.entities.concretes.User;

public class UserManager implements UserService {

private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao=userDao;
	}
	
	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(userDao.findAll(),Messages.successfullyAdded);
	}

}
