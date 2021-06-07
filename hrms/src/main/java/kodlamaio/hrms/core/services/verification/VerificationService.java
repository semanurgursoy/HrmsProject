package kodlamaio.hrms.core.services.verification;

import kodlamaio.hrms.core.utilities.results.Result;

public interface VerificationService {
	Result verificationEmail(String email);
}
