package kodlamaio.hrms.business.concretes;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.adapters.MernisService;
import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.utilities.services.verification.VerificationService;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;


@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;
	private MernisService mernisService;
	private VerificationService verificationService;
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao,MernisService mernisService,VerificationService verificationService) {
		this.jobSeekerDao=jobSeekerDao;
		this.mernisService=mernisService;
		this.verificationService=verificationService;
	}
	
	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(),Messages.successfullyListed);
	}
	
	@Override
	public Result add(JobSeeker jobSeeker) throws NumberFormatException, RemoteException{
		if(!areThereEmpty(jobSeeker).isSuccess())
			return new ErrorResult(areThereEmpty(jobSeeker).getMessage());
		//if(!MernisVerification(jobSeeker).isSuccess())
			//return new ErrorResult(Messages.failedMernis);
		if(!checkNationalId(jobSeeker).isSuccess())
			return new ErrorResult(checkNationalId(jobSeeker).getMessage());
		if(!checkEmail(jobSeeker).isSuccess())
			return new ErrorResult(checkEmail(jobSeeker).getMessage());
		if(!this.verificationService.verificationEmail(jobSeeker.getEmail()).isSuccess())
			return new ErrorResult(Messages.notVerifiedEmail);
		this.jobSeekerDao.save(jobSeeker);
		return new SuccessResult(Messages.successfullyRegister);
	}

	
	
	
	@Override
	public Result MernisVerification(JobSeeker jobSeeker) throws NumberFormatException, RemoteException {
		if(this.mernisService.checkUser(jobSeeker.getNationalId(), jobSeeker.getFirstName(), jobSeeker.getLastName(), jobSeeker.getBirthYear())) 
			return new SuccessResult(Messages.successfulMernis);
		return new ErrorResult(Messages.failedMernis);
	}

	@Override
	public Result checkEmail(JobSeeker jobSeeker) {
		if(this.jobSeekerDao.findByEmailEquals(jobSeeker.getEmail())!=null)
			return new ErrorResult(Messages.existEmail);
		return new SuccessResult(Messages.confirmEmail);
	}

	@Override
	public Result checkNationalId(JobSeeker jobSeeker) {
		if(this.jobSeekerDao.findByNationalIdEquals(jobSeeker.getNationalId())!=null)
			return new ErrorResult(Messages.existNationalId);
		return new SuccessResult(Messages.confirmNationalId);
	}

	@Override
	public Result areThereEmpty(JobSeeker jobSeeker) {
		if(jobSeeker.getFirstName()==null||jobSeeker.getLastName()==null||jobSeeker.getNationalId()==null||jobSeeker.getBirthYear()==0||jobSeeker.getEmail()==null||jobSeeker.getPassword()==null)
			return new ErrorResult(Messages.emptyBox);
		
		if(jobSeeker.getFirstName().length()==0||jobSeeker.getLastName().length()==0||jobSeeker.getNationalId().length()==0||jobSeeker.getPassword().length()==0)
			return new ErrorResult(Messages.emptyBox);
		
		String emailPattern = "^(?=.{1,32}@)[A-Za-z0-9_]+(\\.[A-Za-z0-9_]+)*@"+"[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
		Pattern pattern = Pattern.compile(emailPattern);
		Matcher matcher = pattern.matcher(jobSeeker.getEmail());
		if(!matcher.matches()){
			return new ErrorResult(Messages.invalidEmail);
		}
		
		return new SuccessResult();
	}

}
