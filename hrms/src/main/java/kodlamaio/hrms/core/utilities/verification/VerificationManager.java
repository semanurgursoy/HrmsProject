package kodlamaio.hrms.core.utilities.verification;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

@Service
public class VerificationManager implements VerificationService {

	@Override
	public Result verificationEmail(String email) {
		return new SuccessResult(email+" Doğrulama Başarılı");
	}

}
