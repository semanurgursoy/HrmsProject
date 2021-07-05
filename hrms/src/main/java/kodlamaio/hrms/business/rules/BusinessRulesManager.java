package kodlamaio.hrms.business.rules;

import java.rmi.RemoteException;
import java.util.UUID;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.adapters.mernis.MernisService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;

@Component
public class BusinessRulesManager implements BusinessRulesService {

	private UserService userService;
	private MernisService mernisService;

	@Autowired
	public BusinessRulesManager(UserService userService, MernisService mernisService) {
		super();
		this.userService = userService;
		this.mernisService = mernisService;
	}

	@Override
	public Result checkPasswordMatch(String password, String passwordCheck) {
		if (!password.equals(passwordCheck))
			return new ErrorResult(Messages.failedCheckPassowrdMatch);
		else
			return new SuccessResult();
	}

	@Override
	public Result checkPasswordLength(String password) {
		if (password.length() < 6 || password.length() > 30)
			return new ErrorResult(Messages.failedCheckPassowrdLength);
		else
			return new SuccessResult();
	}

	@Override
	public Result checkEmailContainDomain(String email, String website) {
		if (!email.split("@")[1].contains(website))
			return new ErrorResult(Messages.failedCheckEmployerEmail);
		else
			return new SuccessResult();
	}

	@Override
	public Result checkOpenPositionValid(int count) {
		if (count < 1)
			return new ErrorResult(Messages.failedCheckOpenPositionValid);
		else
			return new SuccessResult();
	}

	@Override
	public Result checkUuidValid(UUID uuid) {
		String regex = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$";
		Pattern pattern = Pattern.compile(regex);
		if (!pattern.matcher(uuid.toString()).matches())
			return new ErrorResult(Messages.failedCheckUuidValid);
		else
			return new SuccessResult();

	}

	@Override
	public Result checkEmailExist(String email) {
		if (userService.existsByEmail(email))
			return new ErrorResult(Messages.failedCheckEmail);
		else
			return new SuccessResult();
	}

	@Override
	public Result checkJobSeekerInformation(String nationalIdentity, String name, String surname, int year)
			throws NumberFormatException, RemoteException {
		if (!mernisService.checkUser(nationalIdentity, name, name, year))
			return new ErrorResult();
		else
			return new SuccessResult();
	}

}
