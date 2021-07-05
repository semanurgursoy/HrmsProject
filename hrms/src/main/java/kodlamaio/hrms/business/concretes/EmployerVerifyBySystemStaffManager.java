package kodlamaio.hrms.business.concretes;

import java.util.Arrays;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerVerifyBySystemStaffService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.business.rules.BusinessRulesService;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.ResultChecker;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.EmployerVerifyBySystemStaffDao;
import kodlamaio.hrms.dataAccess.abstracts.SystemStaffDao;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.EmployerVerifyBySystemStaff;
import kodlamaio.hrms.entities.concretes.SystemStaff;

@Service
public class EmployerVerifyBySystemStaffManager implements EmployerVerifyBySystemStaffService {

	private EmployerVerifyBySystemStaffDao employerVerifyBySystemStaffDao;
	private SystemStaffDao systemStaffDao;
	private EmployerDao employerDao;
	private BusinessRulesService businessRulesService;

	@Autowired
	public EmployerVerifyBySystemStaffManager(EmployerVerifyBySystemStaffDao employerVerifyBySystemStaffDao,
			SystemStaffDao systemStaffDao, BusinessRulesService businessRulesService, EmployerDao employerDao) {
		super();
		this.employerVerifyBySystemStaffDao = employerVerifyBySystemStaffDao;
		this.systemStaffDao = systemStaffDao;
		this.employerDao = employerDao;
		this.businessRulesService = businessRulesService;
	}

	@Override
	public Result add(Employer employer) {
		EmployerVerifyBySystemStaff employerVerifyBySystemStaff = new EmployerVerifyBySystemStaff();
		employerVerifyBySystemStaff.setEmployer(employer);
		employerVerifyBySystemStaff.setVerified(false);
		employerVerifyBySystemStaffDao.save(employerVerifyBySystemStaff);
		return new SuccessResult(Messages.successfullyAdded);
	}

	@Override
	public ResponseEntity<Result> verifyEmployer(UUID employerUuid, UUID systemPersonnelUuid) {
		EmployerVerifyBySystemStaff employerVerifyBySystemStaff = employerVerifyBySystemStaffDao.findByEmployerUuid(employerUuid).orElse(null);
		if(employerVerifyBySystemStaff==null) {
			checkEmployerVerifyExist(employerVerifyBySystemStaff, employerUuid);
			employerVerifyBySystemStaff = employerVerifyBySystemStaffDao.findByEmployerUuid(employerUuid).orElse(null);
		}
		
		SystemStaff systemStaff = systemStaffDao.findByUuid(systemPersonnelUuid).orElse(null);

		Result result = ResultChecker
				.check(Arrays.asList(
						checkIfEmployerAlreadyVerified(employerUuid), 
						businessRulesService.checkUuidValid(employerUuid),
						businessRulesService.checkUuidValid(systemPersonnelUuid)
		));

		if (result.isSuccess()) {
			employerVerifyBySystemStaff.setSystemStaff(systemStaff);
			employerVerifyBySystemStaff.setVerified(true);
			employerDao.getByUuid(employerUuid).setVerified(true);
			employerVerifyBySystemStaffDao.save(employerVerifyBySystemStaff);
			return ResponseEntity.ok(new SuccessResult(Messages.successfullyVerified));
		} else
			return ResponseEntity.badRequest().body(new ErrorResult(result.getMessage()));
	}

	private Result checkIfEmployerAlreadyVerified(UUID uuid) {
		if (employerVerifyBySystemStaffDao.existsByEmployerUuidAndIsVerifiedTrue(uuid)) {
			return new ErrorDataResult<>(Messages.failedVerify);
		} else {
			return new SuccessResult();
		}
	}
	
	public Result checkEmployerVerifyExist(EmployerVerifyBySystemStaff employerVerifyBySystemStaff, UUID employerUuid) {
		if (employerVerifyBySystemStaff == null) {
			Employer employer = employerDao.getByUuid(employerUuid);
			add(employer);
		}
			return new SuccessResult();
	}

}
