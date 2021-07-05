package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import kodlamaio.hrms.business.abstracts.SystemStaffService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SystemStaff;
import kodlamaio.hrms.entities.dtos.SystemStaffDto;

@RestController
@RequestMapping("/api/systemstaffs")
@CrossOrigin
public class SystemStaffsController {

	private SystemStaffService systemStaffService;

	@Autowired
	public SystemStaffsController(SystemStaffService systemStaffService) {
		super();
		this.systemStaffService = systemStaffService;
	}

	@GetMapping("/getall")
	public DataResult<List<SystemStaff>> getAll() {
		return this.systemStaffService.getAll();
	}

	@GetMapping("/getbyid")
	public ResponseEntity<?> getById(int id) {
		return this.systemStaffService.getById(id);
	}

	@PostMapping("/add")
	public Result add(@RequestBody @Valid SystemStaffDto systemStaffdto) {
		return this.systemStaffService.add(systemStaffdto);
	}

	@PostMapping("/changeemployerverify")
	public Result changeEmployerVerify(@RequestParam int employerId) {
		return systemStaffService.changeEmployerVerify(employerId);
	}
}
