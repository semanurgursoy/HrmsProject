package kodlamaio.hrms.core.adapters.activation;

import kodlamaio.hrms.core.entities.concrete.ActivationCode;
import kodlamaio.hrms.core.entities.concrete.User;

public interface ActivationService {
	ActivationCode createActivationCode(User user);

	ActivationCode confirmActivationCode(ActivationCode code, String activationCode);
}
