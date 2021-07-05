package kodlamaio.hrms.business.abstracts.cv;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cv.Education;
import kodlamaio.hrms.entities.dtos.cv.EducationDto;

public interface EducationService {
	Result add(EducationDto educationDto);

	DataResult<List<Education>> orderByGraduatedYear(int cvId);

	DataResult<List<Education>> getByJobSeekerIdWithOrdered(int jobSeekerId);

	DataResult<Education> getById(int educationId);

	DataResult<List<Education>> getBySchoolNameContains(String schoolName);

	DataResult<List<Education>> getByDepartmentContains(String department);
}
