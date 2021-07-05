package kodlamaio.hrms.business.concretes;

import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
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
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.dtos.JobSeekerDto;

@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;
	private ActivationCodeDao activationCodeDao;
	private ActivationService activationService;
	private EmailVerificationService emailVerificationService;
	private BusinessRulesService businessRulesService;
	private ModelMapper modelMapper;

	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, ActivationCodeDao activationCodeDao,
			ActivationService activationService, EmailVerificationService emailVerificationService,
			BusinessRulesService businessRulesService, ModelMapper modelMapper) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.activationCodeDao = activationCodeDao;
		this.activationService = activationService;
		this.emailVerificationService = emailVerificationService;
		this.businessRulesService = businessRulesService;
		this.modelMapper = modelMapper;
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(), Messages.successfullyListed);
	}

	@Override
	public ResponseEntity<?> getById(int id) {
		if(jobSeekerDao.existsById(id))
			return ResponseEntity.ok(new SuccessDataResult<JobSeeker>(this.jobSeekerDao.getById(id)));
		return ResponseEntity.badRequest().body(Messages.failedFindUserById);
	}

	@Override
	public Result add(JobSeekerDto jobSeekerDto) throws NumberFormatException, RemoteException {
		Result result = ResultChecker.check(Arrays.asList(
				businessRulesService.checkEmailExist(jobSeekerDto.getEmail()),
				//businessRulesService.checkJobSeekerInformation(jobSeekerDto.getNationalId(),jobSeekerDto.getFirstName(), jobSeekerDto.getLastName(), jobSeekerDto.getBirthDate().getYear()),
				businessRulesService.checkPasswordLength(jobSeekerDto.getPassword()),
				businessRulesService.checkPasswordMatch(jobSeekerDto.getPassword(), jobSeekerDto.getRepassword())));

		if (result.isSuccess()) {
			JobSeeker jobSeeker = modelMapper.map(jobSeekerDto, JobSeeker.class);
			this.jobSeekerDao.save(jobSeeker);
			this.activationCodeDao.save(activationService.createActivationCode(jobSeeker));
			this.emailVerificationService.sendVerificationEmail(jobSeeker.getUuid().toString());
			return new SuccessResult(Messages.successfullyAdded);
		} else
			return new ErrorResult(result.getMessage());

	}

}
