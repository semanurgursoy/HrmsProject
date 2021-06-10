package kodlamaio.hrms.api.controllers.cv;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.cv.SoftwareSkillService;
import kodlamaio.hrms.entities.concretes.cv.SoftwareSkill;

@RestController
@RequestMapping("/api/softwareskills")
public class SoftwareSkillsController {
	
	private SoftwareSkillService softwareSkillService;

	@Autowired
	public SoftwareSkillsController(SoftwareSkillService softwareSkillService) {
		super();
		this.softwareSkillService = softwareSkillService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody SoftwareSkill softwareSkill) {
		return ResponseEntity.ok(this.softwareSkillService.add(softwareSkill));
	}
	
}
