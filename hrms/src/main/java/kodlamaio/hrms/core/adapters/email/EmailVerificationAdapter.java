package kodlamaio.hrms.core.adapters.email;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

@Service
public class EmailVerificationAdapter implements EmailVerificationService {

	@Override
	public Result sendVerificationEmail(String uuid) {
		return new SuccessResult();
	}

}
