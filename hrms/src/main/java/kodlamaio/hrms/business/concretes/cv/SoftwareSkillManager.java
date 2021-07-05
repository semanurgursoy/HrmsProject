package kodlamaio.hrms.business.concretes.cv;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.cv.SoftwareSkillService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.cv.SoftwareSkillDao;
import kodlamaio.hrms.entities.concretes.cv.SoftwareSkill;
import kodlamaio.hrms.entities.dtos.cv.SoftwareSkillDto;

@Service
public class SoftwareSkillManager implements SoftwareSkillService {

	private SoftwareSkillDao softwareSkillDao;
	private ModelMapper modelMapper;

	@Autowired
	public SoftwareSkillManager(SoftwareSkillDao softwareSkillDao, ModelMapper modelMapper) {
		super();
		this.softwareSkillDao = softwareSkillDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public Result add(SoftwareSkillDto softwareSkillDto) {
		SoftwareSkill softwareSkill = modelMapper.map(softwareSkillDto, SoftwareSkill.class);
		this.softwareSkillDao.save(softwareSkill);
		return new SuccessResult(Messages.successfullyAdded);
	}

	@Override
	public DataResult<List<SoftwareSkill>> getByTechnologyNameContains(String name) {
		return new SuccessDataResult<List<SoftwareSkill>>(this.softwareSkillDao.getByTechnologyNameContains(name), Messages.successfullyListed);
	}

}
