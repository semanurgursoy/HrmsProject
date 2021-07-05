package kodlamaio.hrms.api.controllers.cv;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.cv.JobSeekerCVService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cv.JobSeekerCV;
import kodlamaio.hrms.entities.dtos.cv.CVDto;

@RestController
@RequestMapping("/api/jobseekercvs")
@CrossOrigin
public class JobSeekerCVsController {

	private JobSeekerCVService jobSeekerCVService;

	@Autowired
	public JobSeekerCVsController(JobSeekerCVService jobSeekerCVService) {
		super();
		this.jobSeekerCVService = jobSeekerCVService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody @Valid CVDto cvDto) {
		return this.jobSeekerCVService.add(cvDto);
	}

	@GetMapping("/getAll")
	public DataResult<List<JobSeekerCV>> getAll() {
		return this.jobSeekerCVService.getAll();
	}

	@GetMapping("/getById")
	public DataResult<JobSeekerCV> getById(int id) {
		return this.jobSeekerCVService.getById(id);
	}

	@GetMapping("/getAllSortedExperience")
	public DataResult<List<JobSeekerCV>> getAllSortedExperience() {
		return this.jobSeekerCVService.getAllSortedExperience();
	}

	@GetMapping("/getAllSortedEducation")
	public DataResult<List<JobSeekerCV>> getAllSortedEducation() {
		return this.jobSeekerCVService.getAllSortedEducation();
	}

}
