package kodlamaio.hrms.business.abstracts.cv;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cv.SoftwareSkill;
import kodlamaio.hrms.entities.dtos.cv.SoftwareSkillDto;

public interface SoftwareSkillService {
	Result add(SoftwareSkillDto softwareSkillDto);
	DataResult<List<SoftwareSkill>> getByTechnologyNameContains(String name);
}
