package kodlamaio.hrms.business.concretes.cv;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.cv.JobSeekerCVService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.cv.JobSeekerCV;
import kodlamaio.hrms.entities.dtos.cv.CVDto;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.dataAccess.abstracts.cv.JobSeekerCVDao;

@Service
public class JobSeekerCVManager implements JobSeekerCVService {

	private JobSeekerCVDao jobSeekerCVDao;
	private JobSeekerDao jobSeekerDao;
	private ModelMapper modelMapper;

	@Autowired
	public JobSeekerCVManager(JobSeekerCVDao jobSeekerCVDao, JobSeekerDao jobSeekerDao, ModelMapper modelMapper) {
		super();
		this.jobSeekerCVDao = jobSeekerCVDao;
		this.jobSeekerDao = jobSeekerDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public Result add(CVDto cvDto) {
//		JobSeekerCV jobSeekerCV = new JobSeekerCV();
//		jobSeekerCV.setCoverLetter(cvAddDto.getCoverLetter());
//		jobSeekerCV.setJobSeeker(this.jobSeekerDao.findById(cvAddDto.getJobSeekerId()).get());
//		this.jobSeekerCVDao.save(jobSeekerCV);
//		return new SuccessResult(Messages.successfullyAdded);

		JobSeekerCV jobSeekerCV = modelMapper.map(cvDto, JobSeekerCV.class);
		this.jobSeekerCVDao.save(jobSeekerCV);
		return new SuccessResult(Messages.successfullyAdded);
	}

	@Override
	public DataResult<List<JobSeekerCV>> getAll() {
		return new SuccessDataResult<List<JobSeekerCV>>(this.jobSeekerCVDao.findAll(), Messages.successfullyListed);
	}

	@Override
	public DataResult<List<JobSeekerCV>> getAllSortedEducation() {
		Sort sort = Sort.by(Sort.Direction.DESC, "education.graduatedYear");
		return new SuccessDataResult<List<JobSeekerCV>>(this.jobSeekerCVDao.findAll(sort));
	}

	@Override
	public DataResult<List<JobSeekerCV>> getAllSortedExperience() {
		Sort sort = Sort.by(Sort.Direction.DESC, "experience.endDate");
		return new SuccessDataResult<List<JobSeekerCV>>(this.jobSeekerCVDao.findAll(sort));
	}

	@Override
	public DataResult<JobSeekerCV> getById(int id) {
		return new SuccessDataResult<JobSeekerCV>(this.jobSeekerCVDao.getById(id));
	}

}
