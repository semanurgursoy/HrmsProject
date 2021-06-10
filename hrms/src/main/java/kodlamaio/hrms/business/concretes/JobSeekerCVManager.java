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
import kodlamaio.hrms.entities.dtos.CreateCvDto;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerCVDao;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;

@Service
public class JobSeekerCVManager implements JobSeekerCVService {

	private JobSeekerCVDao jobSeekerCVDao;
	private JobSeekerDao jobSeekerDao;
	
	@Autowired
	public JobSeekerCVManager(JobSeekerCVDao jobSeekerCVDao,JobSeekerDao jobSeekerDao) {
		super();
		this.jobSeekerCVDao = jobSeekerCVDao;
		this.jobSeekerDao=jobSeekerDao;
	}

	@Override
	public Result add(CreateCvDto cvAddDto) {
		JobSeekerCV jobSeekerCV = new JobSeekerCV();
		jobSeekerCV.setCoverLetter(cvAddDto.getCoverLetter());
		jobSeekerCV.setJobSeeker(this.jobSeekerDao.findById(cvAddDto.getJobSeekerId()).get());
		this.jobSeekerCVDao.save(jobSeekerCV);
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
