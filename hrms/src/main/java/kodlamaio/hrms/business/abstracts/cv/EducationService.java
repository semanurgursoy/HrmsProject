package kodlamaio.hrms.business.abstracts.cv;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cv.Education;

public interface EducationService {
	Result add(Education education);
	DataResult<List<Education>> orderByGraduatedYear(int cvId);
	DataResult<List<Education>> getByJobSeekerIdWithOrdered(int jobSeekerId);
	DataResult<Education> getById(int educationId);
}
