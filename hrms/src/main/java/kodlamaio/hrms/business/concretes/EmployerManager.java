package kodlamaio.hrms.business.concretes;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.business.rules.BusinessRulesService;
import kodlamaio.hrms.core.adapters.activation.ActivationService;
import kodlamaio.hrms.core.adapters.email.EmailVerificationService;
import kodlamaio.hrms.core.dataAccess.ActivationCodeDao;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.ResultChecker;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.dtos.EmployerDto;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private BusinessRulesService businessRulesService;
	private ActivationCodeDao activationCodeDao;
	private ActivationService activationService;
	private EmailVerificationService emailVerificationService;
	private ModelMapper modelMapper;

	@Autowired
	public EmployerManager(EmployerDao employerDao, BusinessRulesService businessRulesService,
			ActivationCodeDao activationCodeDao, ActivationService activationService,
			EmailVerificationService emailVerificationService, ModelMapper modelMapper) {
		super();
		this.employerDao = employerDao;
		this.businessRulesService = businessRulesService;
		this.activationCodeDao = activationCodeDao;
		this.activationService = activationService;
		this.emailVerificationService = emailVerificationService;
		this.modelMapper = modelMapper;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), Messages.successfullyListed);
	}

	@Override
	public ResponseEntity<?> get(int id) {
		if (employerDao.existsById(id))
			return ResponseEntity
					.ok(new SuccessDataResult<Employer>(this.employerDao.getById(id), Messages.successfullyListed));
		return ResponseEntity.badRequest().body(Messages.failedFindUserById);

	}

	@Override
	public Result add(EmployerDto employerDto) {
		Result result = ResultChecker.check(Arrays.asList(
				businessRulesService.checkEmailExist(employerDto.getEmail()),
				businessRulesService.checkEmailContainDomain(employerDto.getEmail(), employerDto.getWebsite()),
				businessRulesService.checkPasswordMatch(employerDto.getPassword(), employerDto.getRepassword()),
				businessRulesService.checkPasswordLength(employerDto.getPassword())));

		if (result.isSuccess()) {
			Employer employer = modelMapper.map(employerDto, Employer.class);
			this.employerDao.save(employer);
			employer.setVerified(false);
			this.activationCodeDao.save(activationService.createActivationCode(employer));
			this.emailVerificationService.sendVerificationEmail(employer.getUuid().toString());
			//this.employerDao.save(employer);
			return new SuccessResult(Messages.successfullyAdded);
		} else
			return new ErrorResult(result.getMessage());
	}

	@Override
	public Result changeEmployerVerify(int id) {
		Employer employer = employerDao.getById(id);

		if (!employerDao.existsById(id))
			return new ErrorResult(Messages.failedFindUserById);

		employer.setVerified(!employer.isVerified());
		employerDao.save(employer);
		return new SuccessResult(Messages.successfullyChangeEmployerVerify);

	}

}
