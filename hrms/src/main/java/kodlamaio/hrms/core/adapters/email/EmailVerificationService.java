package kodlamaio.hrms.core.adapters.email;

import kodlamaio.hrms.core.utilities.results.Result;

public interface EmailVerificationService {
	Result sendVerificationEmail(String uuid);
}
