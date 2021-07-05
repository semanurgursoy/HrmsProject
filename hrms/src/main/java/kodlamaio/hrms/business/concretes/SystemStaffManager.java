package kodlamaio.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.SystemStaffService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.business.rules.BusinessRulesService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.ResultChecker;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SystemStaffDao;
import kodlamaio.hrms.entities.concretes.SystemStaff;
import kodlamaio.hrms.entities.dtos.SystemStaffDto;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@Service
public class SystemStaffManager implements SystemStaffService {

	private SystemStaffDao systemStaffDao;
	private EmployerService employerService;
	private BusinessRulesService businessRulesService;
	private ModelMapper modelMapper;

	@Autowired
	public SystemStaffManager(SystemStaffDao systemStaffDao, EmployerService employerService,
			BusinessRulesService businessRulesService, ModelMapper modelMapper) {
		super();
		this.systemStaffDao = systemStaffDao;
		this.employerService = employerService;
		this.businessRulesService = businessRulesService;
		this.modelMapper = modelMapper;
	}

	@Override
	public DataResult<List<SystemStaff>> getAll() {
		return new SuccessDataResult<List<SystemStaff>>(this.systemStaffDao.findAll(), Messages.successfullyListed);
	}

	@Override
	public ResponseEntity<?> getById(int id) {
		if (systemStaffDao.existsById(id))
			return ResponseEntity.ok(
					new SuccessDataResult<SystemStaff>(this.systemStaffDao.getById(id), Messages.successfullyListed));
		return ResponseEntity.badRequest().body(Messages.failedFindUserById);
	}

	@Override
	public Result add(SystemStaffDto systemStaffDto) {
		Result result = ResultChecker.check(Arrays.asList(
				businessRulesService.checkEmailExist(systemStaffDto.getEmail()),
				businessRulesService.checkPasswordMatch(systemStaffDto.getPassword(), systemStaffDto.getRepassword())));
		if (result.isSuccess()) {
			SystemStaff systemStaff = modelMapper.map(systemStaffDto, SystemStaff.class);
			this.systemStaffDao.save(systemStaff);
			return new SuccessResult(Messages.successfullyAdded);
		} else
			return new ErrorResult(result.getMessage());
	}

	@Override
	public Result changeEmployerVerify(int employerId) {
		return employerService.changeEmployerVerify(employerId);
	}

}
