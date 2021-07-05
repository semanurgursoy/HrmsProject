package kodlamaio.hrms.business.concretes.advertisement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.advertisement.JobTimeService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.advertisement.JobTimeDao;
import kodlamaio.hrms.entities.concretes.advertisement.JobTime;

@Service
public class JobTimeManager implements JobTimeService{

	private JobTimeDao jobTimeDao;
	
	@Autowired
	public JobTimeManager(JobTimeDao jobTimeDao) {
		super();
		this.jobTimeDao = jobTimeDao;
	}
	
	@Override
	public DataResult<List<JobTime>> getAll() {
		return new SuccessDataResult<List<JobTime>>(this.jobTimeDao.findAll(),Messages.successfullyListed);
	}

}
