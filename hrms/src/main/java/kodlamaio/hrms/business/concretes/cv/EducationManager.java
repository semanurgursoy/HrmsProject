package kodlamaio.hrms.business.concretes.cv;

import java.util.List;

import org.modelmapper.ModelMapper;
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
import kodlamaio.hrms.entities.dtos.cv.EducationDto;

@Service
public class EducationManager implements EducationService {

	private EducationDao educationDao;
	private ModelMapper modelMapper;

	@Autowired
	public EducationManager(EducationDao educationDao, ModelMapper modelMapper) {
		super();
		this.educationDao = educationDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public Result add(EducationDto educationDto) {
		Education education = modelMapper.map(educationDto, Education.class);
		this.educationDao.save(education);
		return new SuccessResult(Messages.successfullyAdded);
	}

	@Override
	public DataResult<List<Education>> orderByGraduatedYear(int cvId) {
		return new SuccessDataResult<List<Education>>(
				this.educationDao.findAllByJobSeekerCV_IdOrderByGraduatedYearDesc(cvId), Messages.successfullyListed);
	}

	@Override
	public DataResult<List<Education>> getByJobSeekerIdWithOrdered(int jobSeekerId) {
		return new SuccessDataResult<List<Education>>(this.educationDao.getByJobSeekerIdWithOrdered(jobSeekerId),
				Messages.successfullyListed);
	}

	@Override
	public DataResult<Education> getById(int educationId) {
		return new SuccessDataResult<Education>(this.educationDao.getById(educationId), Messages.successfullyListed);
	}

	@Override
	public DataResult<List<Education>> getBySchoolNameContains(String schoolName) {
		return new SuccessDataResult<List<Education>>(this.educationDao.getBySchoolNameContains(schoolName),
				Messages.successfullyListed);
	}

	@Override
	public DataResult<List<Education>> getByDepartmentContains(String department) {
		return new SuccessDataResult<List<Education>>(this.educationDao.getByDepartmentContains(department),
				Messages.successfullyListed);
	}

}
