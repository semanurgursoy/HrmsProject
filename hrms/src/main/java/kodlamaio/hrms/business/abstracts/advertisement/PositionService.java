package kodlamaio.hrms.business.abstracts.advertisement;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.advertisement.JobPosition;
import kodlamaio.hrms.entities.dtos.advertisement.JobPositionDto;

public interface PositionService {
	DataResult<List<JobPosition>> getAll();

	Result add(JobPositionDto positionDto);
}
