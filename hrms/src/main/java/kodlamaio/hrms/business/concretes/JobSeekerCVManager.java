package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerCVService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.JobSeekerCV;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerCVDao;

@Service
public class JobSeekerCVManager implements JobSeekerCVService {

	private JobSeekerCVDao jobSeekerCVDao;
	
	@Autowired
	public JobSeekerCVManager(JobSeekerCVDao jobSeekerCVDao) {
		super();
		this.jobSeekerCVDao = jobSeekerCVDao;
	}

	@Override
	public Result add(JobSeekerCV cv) {
		this.jobSeekerCVDao.save(cv);
		return new SuccessResult(Messages.successfullyAdded);
	}
	
	@Override 
	public DataResult<List<JobSeekerCV>> getAll(){
		return new SuccessDataResult<List<JobSeekerCV>>(this.jobSeekerCVDao.findAll());
	}

	@Override
	public DataResult<List<JobSeekerCV>> getAllSortedEducation() {
		Sort sort = Sort.by(Sort.Direction.DESC,"education.graduatedYear");
		return new SuccessDataResult<List<JobSeekerCV>>(this.jobSeekerCVDao.findAll(sort));
	}

	@Override
	public DataResult<List<JobSeekerCV>> getAllSortedExperience() {
		Sort sort = Sort.by(Sort.Direction.DESC,"experience.endDate");
		return new SuccessDataResult<List<JobSeekerCV>>(this.jobSeekerCVDao.findAll(sort));
	}

}
