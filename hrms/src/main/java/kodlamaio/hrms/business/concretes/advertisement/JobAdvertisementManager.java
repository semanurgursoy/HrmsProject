package kodlamaio.hrms.business.concretes.advertisement;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.advertisement.JobAdvertisementService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.advertisement.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.advertisement.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.advertisement.JobAdvertisementDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementDao;
	private ModelMapper modelMapper;

	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao, ModelMapper modelMapper) {
		this.jobAdvertisementDao = jobAdvertisementDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public Result add(JobAdvertisementDto jobAdvertisementDto) {
		JobAdvertisement jobAdvertisement = modelMapper.map(jobAdvertisementDto, JobAdvertisement.class);
		jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult(Messages.successfullyAdded);
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(),
				Messages.successfullyListed);
	}

	@Override
	public DataResult<List<JobAdvertisement>> findAllByIsActive(boolean isActive) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAllByIsActive(isActive),
				Messages.successfullyListed);
	}

	@Override
	public DataResult<List<JobAdvertisement>> findAllByIsActiveOrderByCreatedDateDesc(boolean isActive) {
		return new SuccessDataResult<List<JobAdvertisement>>(
				this.jobAdvertisementDao.findAllByIsActiveOrderByCreatedDateDesc(isActive),
				Messages.successfullyListed);
	}

	@Override
	public DataResult<List<JobAdvertisement>> getActiveAdvertisementsByEmployerId(int employerId) {
		return new SuccessDataResult<List<JobAdvertisement>>(
				this.jobAdvertisementDao.getActiveAdvertisementsByEmployerId(employerId), Messages.successfullyListed);
	}

	@Override
	public DataResult<JobAdvertisement> getById(int id) {
		return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.findById(id).get(),
				Messages.successfullyListed);
	}

	@Override
	public DataResult<List<JobAdvertisement>> findAllByJobPosition_Id(int id) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAllByJobPosition_Id(id),
				Messages.successfullyListed);
	}

	@Override
	public DataResult<List<JobAdvertisement>> findAllByCity_Id(int id) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAllByCity_Id(id),
				Messages.successfullyListed);
	}

}
