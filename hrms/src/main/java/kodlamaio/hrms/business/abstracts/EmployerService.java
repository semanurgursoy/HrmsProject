package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerService {
	DataResult <List<Employer>> getAll();
	Result add(Employer employer);
	
	Result checkEmail(Employer employer);
	Result areThereEmpty(Employer employer);
	Result confirmByStaff(Employer employer);
}
