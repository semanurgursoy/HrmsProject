package kodlamaio.hrms.core.utilities.verification;

import kodlamaio.hrms.core.utilities.results.Result;

public interface VerificationService {
	Result verificationEmail(String email);
}
