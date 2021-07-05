package kodlamaio.hrms.business.abstracts.cv;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cv.JobSeekerCV;
import kodlamaio.hrms.entities.dtos.cv.CVDto;

public interface JobSeekerCVService {
	Result add(CVDto cvDto);

	DataResult<List<JobSeekerCV>> getAll();

	DataResult<JobSeekerCV> getById(int id);

	DataResult<List<JobSeekerCV>> getAllSortedExperience();

	DataResult<List<JobSeekerCV>> getAllSortedEducation();
}
