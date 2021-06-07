package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeekerCV;

public interface JobSeekerCVService {
	Result add(JobSeekerCV cv);
	DataResult<List<JobSeekerCV>> getAll();
	DataResult<List<JobSeekerCV>> getAllSortedExperience();
	DataResult<List<JobSeekerCV>> getAllSortedEducation();
}
