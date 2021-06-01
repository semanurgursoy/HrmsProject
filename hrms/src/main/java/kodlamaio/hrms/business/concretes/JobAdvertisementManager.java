package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {
	
	private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		this.jobAdvertisementDao=jobAdvertisementDao;
	}
	
	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		if(!areThereEmpty(jobAdvertisement).isSuccess())
			return new ErrorResult(areThereEmpty(jobAdvertisement).getMessage());
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult(Messages.successfullyAdded);
	}
	
	@Override
	public Result delete(JobAdvertisement jobAdvertisement) {
		if(jobAdvertisement.isActive()==true)
			return new ErrorResult(Messages.advertisementIsActive);
		this.jobAdvertisementDao.delete(jobAdvertisement);
		return new SuccessResult(Messages.successfullyDeleted);
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(),Messages.successfullyListed);
	}
	
	@Override
	public DataResult<List<JobAdvertisement>> findAllByIsActive(boolean isActive) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAllByIsActive(isActive),Messages.successfullyListed);
	}

	@Override
	public DataResult<List<JobAdvertisement>> findAllByIsActiveOrderByCreatedDateDesc(boolean isActive) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAllByIsActiveOrderByCreatedDateDesc(isActive),Messages.successfullyListed);
	}

	@Override
	public DataResult<List<JobAdvertisement>> getActiveAdvertisementsByEmployerId(int employerId) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getActiveAdvertisementsByEmployerId(employerId),Messages.successfullyListed);
	}
	
	
	
	@Override
	public Result areThereEmpty(JobAdvertisement jobAdvertisement) {
		if(jobAdvertisement.getPosition()==null||jobAdvertisement.getDescription()==null||jobAdvertisement.getCity()==null)
			return new ErrorResult(Messages.emptyBox);
		
		if(jobAdvertisement.getDescription().length()==0||jobAdvertisement.getOpenPositionCount()==0)
			return new ErrorResult(Messages.emptyBox);
		
		return new SuccessResult();
	}

}
