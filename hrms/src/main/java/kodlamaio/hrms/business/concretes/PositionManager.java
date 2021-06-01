package kodlamaio.hrms.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.PositionService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.PositionDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.concretes.JobPosition;

@Service
public class PositionManager implements PositionService {

	private PositionDao positionDao;

	@Autowired	
	public PositionManager (PositionDao positionDao) {
		this.positionDao=positionDao;
	}
			

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(this.positionDao.findAll(),Messages.successfullyListed);
	}


	@Override
	public Result add(JobPosition position) {
		if(!checkPosition(position).isSuccess())
			return new ErrorResult(checkPosition(position).getMessage());
		this.positionDao.save(position);
		return new SuccessResult(Messages.successfulAddPosition);
	}


	@Override
	public Result checkPosition(JobPosition position) {
		List<JobPosition> positions = this.positionDao.findAll();
		List<String> names = new ArrayList<String>();
		for (JobPosition position2 : positions) {
			names.add(position2.getPosition());
		}
		if(names.contains(position.getPosition()))
			return new ErrorResult(Messages.failedAddPosition);
		return new SuccessResult(Messages.successfulAddPosition);
	}

}
