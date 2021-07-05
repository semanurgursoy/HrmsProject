package kodlamaio.hrms.core.adapters.activation;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.entities.concrete.ActivationCode;
import kodlamaio.hrms.core.entities.concrete.User;

@Service
public class ActivationAdapter implements ActivationService {

	@Override
	public ActivationCode createActivationCode(User user) {
		ActivationCode activationCode = new ActivationCode();
		activationCode.setCode(user.getUuid().toString());
		activationCode.setUser(user);
		activationCode.setConfirmed(false);
		return activationCode;
	}

	@Override
	public ActivationCode confirmActivationCode(ActivationCode code, String activationCode) {
		code.setConfirmed(true);
		return code;
	}

}
