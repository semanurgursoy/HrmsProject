package kodlamaio.hrms.business.abstracts.advertisement;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.advertisement.JobType;

public interface JobTypeService {
	DataResult<List<JobType>> getAll();
}
