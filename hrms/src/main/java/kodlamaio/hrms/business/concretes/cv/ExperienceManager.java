package kodlamaio.hrms.business.concretes.cv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.cv.ExperienceService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.cv.ExperienceDao;
import kodlamaio.hrms.entities.concretes.cv.Experience;

@Service
public class ExperienceManager implements ExperienceService {

	private ExperienceDao experienceDao;
	
	@Autowired
	public ExperienceManager(ExperienceDao experienceDao) {
		super();
		this.experienceDao = experienceDao;
	}

	@Override
	public Result add(Experience experience) {
		this.experienceDao.save(experience);
		return new SuccessResult(Messages.successfullyAdded);
	}

	@Override
	public DataResult<List<Experience>> orderByEndDate(int cvId) {
		return new SuccessDataResult<List<Experience>>(this.experienceDao.findAllByJobSeekerCV_IdOrderByEndDateDesc(cvId));
	}

	@Override
	public DataResult<List<Experience>> getByExperienceIdWithOrdered(int jobSeekerId) {
		return new SuccessDataResult<List<Experience>>(this.experienceDao.getByExperienceIdWithOrdered(jobSeekerId));
	}

	@Override
	public DataResult<Experience> getById(int experienceId) {
		return new SuccessDataResult<Experience>(this.experienceDao.getById(experienceId));
	}
	
}
