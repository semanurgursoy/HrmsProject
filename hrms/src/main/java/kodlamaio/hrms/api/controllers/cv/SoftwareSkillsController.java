package kodlamaio.hrms.api.controllers.cv;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.cv.SoftwareSkillService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.cv.SoftwareSkill;
import kodlamaio.hrms.entities.dtos.cv.SoftwareSkillDto;

@RestController
@RequestMapping("/api/softwareskills")
@CrossOrigin
public class SoftwareSkillsController {

	private SoftwareSkillService softwareSkillService;

	@Autowired
	public SoftwareSkillsController(SoftwareSkillService softwareSkillService) {
		super();
		this.softwareSkillService = softwareSkillService;
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody SoftwareSkillDto softwareSkillDto) {
		return ResponseEntity.ok(this.softwareSkillService.add(softwareSkillDto));
	}

	@GetMapping("/getByTechnologyNameContains")
	DataResult<List<SoftwareSkill>> getByTechnologyNameContains(String name) {
		return softwareSkillService.getByTechnologyNameContains(name);
	}

}
