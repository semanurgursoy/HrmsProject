package kodlamaio.hrms.api.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployerVerifyBySystemStaffService;
import kodlamaio.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("/employerverifybysystemstaffs")
@CrossOrigin
public class EmployerVerifyBySystemStaffsController {
	
	private EmployerVerifyBySystemStaffService employerVerifyBySystemStaffService;

	@Autowired
	public EmployerVerifyBySystemStaffsController(EmployerVerifyBySystemStaffService employerVerifyBySystemStaffService) {
		super();
		this.employerVerifyBySystemStaffService = employerVerifyBySystemStaffService;
	}

	@PostMapping("/verify/{employerUuid}/{systemStaffUuid}")
	public ResponseEntity<Result> verify(@PathVariable("employerUuid") UUID employerUuid,@PathVariable("systemStaffUuid") UUID personnelUuid) {
		return employerVerifyBySystemStaffService.verifyEmployer(employerUuid, personnelUuid);
	}
}
