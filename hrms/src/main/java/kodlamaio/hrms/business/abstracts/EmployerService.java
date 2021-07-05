package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.http.ResponseEntity;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.dtos.EmployerDto;

public interface EmployerService {
	DataResult<List<Employer>> getAll();

	ResponseEntity<?> get(int id);

	Result add(EmployerDto employerDto);

	Result changeEmployerVerify(int id);
}
