package kodlamaio.hrms.business.concretes.cv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.cv.SoftwareSkillService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.cv.SoftwareSkillDao;
import kodlamaio.hrms.entities.concretes.cv.SoftwareSkill;

@Service
public class SoftwareSkillManager implements SoftwareSkillService{

	private SoftwareSkillDao softwareSkillDao;
	
	@Autowired
	public SoftwareSkillManager(SoftwareSkillDao softwareSkillDao) {
		super();
		this.softwareSkillDao = softwareSkillDao;
	}
	
	@Override
	public Result add(SoftwareSkill softwareSkill) {
		this.softwareSkillDao.save(softwareSkill);
		return new SuccessResult(Messages.successfullyAdded);
	}

}
