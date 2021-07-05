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
import kodlamaio.hrms.entities.dtos.cv.ExperienceDto;
import kodlamaio.hrms.entities.mapper.ExperienceMapper;

@Service
public class ExperienceManager implements ExperienceService {

	private ExperienceDao experienceDao;
	private ExperienceMapper experienceMapper;

	@Autowired
	public ExperienceManager(ExperienceDao experienceDao, ExperienceMapper experienceMapper) {
		super();
		this.experienceDao = experienceDao;
		this.experienceMapper = experienceMapper;
	}

	@Override
	public Result add(ExperienceDto experienceDto) {
		Experience experience = experienceMapper.map(experienceDto);
		this.experienceDao.save(experience);
		return new SuccessResult(Messages.successfullyAdded);
	}

	@Override
	public DataResult<List<Experience>> orderByEndDate(int cvId) {
		return new SuccessDataResult<List<Experience>>(
				this.experienceDao.findAllByJobSeekerCV_IdOrderByEndDateDesc(cvId), Messages.successfullyListed);
	}

	@Override
	public DataResult<List<Experience>> getByExperienceIdWithOrdered(int jobSeekerId) {
		return new SuccessDataResult<List<Experience>>(this.experienceDao.getByExperienceIdWithOrdered(jobSeekerId),
				Messages.successfullyListed);
	}

	@Override
	public DataResult<Experience> getById(int experienceId) {
		return new SuccessDataResult<Experience>(this.experienceDao.getById(experienceId), Messages.successfullyListed);
	}

	@Override
	public DataResult<List<Experience>> getByWorkplaceContains(String name) {
		return new SuccessDataResult<List<Experience>>(this.experienceDao.getByWorkplaceContains(name),
				Messages.successfullyListed);
	}

	@Override
	public DataResult<List<Experience>> getByJobPositionId(int id) {
		return new SuccessDataResult<List<Experience>>(this.experienceDao.getByJobPosition_Id(id),
				Messages.successfullyListed);
	}

}
