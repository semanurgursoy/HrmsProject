package kodlamaio.hrms.business.concretes.cv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.cv.EducationService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.cv.EducationDao;
import kodlamaio.hrms.entities.concretes.cv.Education;

@Service
public class EducationManager implements EducationService {

	private EducationDao educationDao;
	
	@Autowired
	public EducationManager(EducationDao educationDao) {
		super();
		this.educationDao = educationDao;
	}

	@Override
	public Result add(Education education) {
		this.educationDao.save(education);
		return new SuccessResult(Messages.successfullyAdded);
	}

	@Override 
	public DataResult<List<Education>> orderByGraduatedYear(int cvId) {
		return new SuccessDataResult<List<Education>>(this.educationDao.findAllByJobSeekerCV_IdOrderByGraduatedYearDesc(cvId));
	}

	@Override
	public DataResult<List<Education>> getByJobSeekerIdWithOrdered(int jobSeekerId) {
		return new SuccessDataResult<List<Education>>(this.educationDao.getByJobSeekerIdWithOrdered(jobSeekerId));
	}

	@Override
	public DataResult<Education> getById(int educationId) {
		return new SuccessDataResult<Education>(this.educationDao.getById(educationId));
	}

}
