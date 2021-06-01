package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosition;

public interface PositionService {
	DataResult<List<JobPosition>> getAll();
	Result add(JobPosition position);
	Result checkPosition(JobPosition position);
}