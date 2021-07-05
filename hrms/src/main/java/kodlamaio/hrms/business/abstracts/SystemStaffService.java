package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.http.ResponseEntity;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SystemStaff;
import kodlamaio.hrms.entities.dtos.SystemStaffDto;

public interface SystemStaffService {
	DataResult<List<SystemStaff>> getAll();

	ResponseEntity<?> getById(int id);

	Result add(SystemStaffDto systemStaffDto);

	Result changeEmployerVerify(int employerId);
}
