package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeekerCV;
import kodlamaio.hrms.entities.dtos.CreateCvDto;

public interface JobSeekerCVService {
	Result add(CreateCvDto cvAddDto);
	DataResult<List<JobSeekerCV>> getAll();
	DataResult<List<JobSeekerCV>> getAllSortedExperience();
	DataResult<List<JobSeekerCV>> getAllSortedEducation();
}
