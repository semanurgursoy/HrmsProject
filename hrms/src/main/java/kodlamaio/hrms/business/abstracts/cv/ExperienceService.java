package kodlamaio.hrms.business.abstracts.cv;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cv.Experience;

public interface ExperienceService {
	Result add(Experience experience);
	DataResult<List<Experience>> orderByEndDate(int cvId);
	DataResult<List<Experience>> getByExperienceIdWithOrdered(int jobSeekerId);
	DataResult<Experience> getById(int experienceId);
}
