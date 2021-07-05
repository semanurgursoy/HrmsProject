package kodlamaio.hrms.business.rules;

import java.rmi.RemoteException;
import java.util.UUID;

import kodlamaio.hrms.core.utilities.results.Result;

public interface BusinessRulesService {
	Result checkPasswordMatch(String password, String passwordCheck);

	Result checkPasswordLength(String password);

	Result checkEmailContainDomain(String email, String website);

	Result checkOpenPositionValid(int count);

	Result checkUuidValid(UUID uuid);

	Result checkEmailExist(String email);

	Result checkJobSeekerInformation(String nationalIdentity, String name, String surname, int year)
			throws NumberFormatException, RemoteException;
}
