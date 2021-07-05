package kodlamaio.hrms.business.concretes.advertisement;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.advertisement.PositionService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.advertisement.PositionDao;
import kodlamaio.hrms.entities.concretes.advertisement.JobPosition;
import kodlamaio.hrms.entities.dtos.advertisement.JobPositionDto;

@Service
public class PositionManager implements PositionService {

	private PositionDao positionDao;
	private ModelMapper modelMapper;

	@Autowired
	public PositionManager(PositionDao positionDao, ModelMapper modelMapper) {
		this.positionDao = positionDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(this.positionDao.findAll(), Messages.successfullyListed);
	}

	@Override
	public Result add(JobPositionDto positionDto) {
		JobPosition jobPosition = modelMapper.map(positionDto, JobPosition.class);

		if (!checkPosition(jobPosition).isSuccess())
			return new ErrorResult(checkPosition(jobPosition).getMessage());

		this.positionDao.save(jobPosition);
		return new SuccessResult(Messages.successfullyAdded);
	}

	public Result checkPosition(JobPosition position) {
		List<JobPosition> positions = this.positionDao.findAll();
		if (positions.contains(position)) {
			return new ErrorResult(Messages.failedAddPosition);
		}
		return new SuccessResult();
	}

}
