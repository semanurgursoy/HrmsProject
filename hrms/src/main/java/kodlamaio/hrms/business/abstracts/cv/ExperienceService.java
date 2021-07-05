package kodlamaio.hrms.business.abstracts.cv;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cv.Experience;
import kodlamaio.hrms.entities.dtos.cv.ExperienceDto;

public interface ExperienceService {
	Result add(ExperienceDto experienceDto);

	DataResult<List<Experience>> orderByEndDate(int cvId);

	DataResult<List<Experience>> getByExperienceIdWithOrdered(int jobSeekerId);

	DataResult<Experience> getById(int experienceId);

	DataResult<List<Experience>> getByWorkplaceContains(String name);

	DataResult<List<Experience>> getByJobPositionId(int id);
}
