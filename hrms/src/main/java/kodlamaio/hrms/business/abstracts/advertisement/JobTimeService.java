package kodlamaio.hrms.business.abstracts.advertisement;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.advertisement.JobTime;

public interface JobTimeService {
	DataResult<List<JobTime>> getAll();
}
