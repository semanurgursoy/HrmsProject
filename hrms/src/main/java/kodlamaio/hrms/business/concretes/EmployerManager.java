package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.utilities.services.verification.VerificationService;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {
	
	private EmployerDao employerDao;
	private VerificationService verificationService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao,VerificationService verificationService) {
		this.employerDao=employerDao;
		this.verificationService=verificationService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),Messages.successfullyListed);
	}

	@Override
	public Result add(Employer employer) {
		if(!areThereEmpty(employer).isSuccess())
			return new ErrorResult(areThereEmpty(employer).getMessage());
		if(!checkEmail(employer).isSuccess())
			return new ErrorResult(checkEmail(employer).getMessage());
		if(!verificationService.verificationEmail(employer.getEmail()).isSuccess())
			return new ErrorResult(Messages.notVerifiedEmail);
		if(!confirmByStaff(employer).isSuccess())
			return new ErrorResult(confirmByStaff(employer).getMessage());
		this.employerDao.save(employer);
		return new SuccessResult(Messages.successfullyRegister);
	}

	@Override
	public Result checkEmail(Employer employer) {
		if(this.employerDao.findByEmailEquals(employer.getEmail())!=null)
			return new ErrorResult(Messages.existEmail);
		//List<Employer> employers = this.employerDao.findAll();
		//List<String> emails = new ArrayList<String>();
		//for (Employer employer2 : employers) {
			//emails.add(employer2.getEmail());
		//}
		//if(emails.contains(employer.getEmail()))
			//return new ErrorResult(Messages.existEmail);
		return new SuccessResult(Messages.confirmEmail);
	}

	@Override
	public Result areThereEmpty(Employer employer) {
		if(employer.getCompanyName()==null||employer.getWebsite()==null||employer.getEmail()==null||employer.getTelephone()==null||employer.getPassword()==null)
			return new ErrorResult(Messages.emptyBox);
		
		if(employer.getCompanyName().length()==0||employer.getWebsite().length()==0||employer.getTelephone().length()==0||employer.getPassword().length()==0)
			return new ErrorResult(Messages.emptyBox);
		
		String emailPattern = "^(?=.{1,32}@)[A-Za-z0-9_]+(\\.[A-Za-z0-9_]+)*@"+"[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
		Pattern pattern = Pattern.compile(emailPattern);
		Matcher matcher = pattern.matcher(employer.getEmail());
		if(!matcher.matches()){
			return new ErrorResult(Messages.invalidEmail);
		}
		
		return new SuccessResult();
	}

	@Override
	public Result confirmByStaff(Employer employer) {
		if(employer.isVerified()==true)
			return new SuccessResult(Messages.verifyCompany);
		else
			return new ErrorResult(Messages.notVerifyCompany);
	}

	

}
