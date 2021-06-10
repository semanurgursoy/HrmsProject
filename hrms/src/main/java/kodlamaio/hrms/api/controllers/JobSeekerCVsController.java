package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobSeekerCVService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeekerCV;
import kodlamaio.hrms.entities.dtos.CreateCvDto;

@RestController
@RequestMapping("/api/jobseekercvs")
public class JobSeekerCVsController {
	
	private JobSeekerCVService jobSeekerCVService;

	@Autowired
	public JobSeekerCVsController(JobSeekerCVService jobSeekerCVService) {
		super();
		this.jobSeekerCVService = jobSeekerCVService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CreateCvDto cvAddDto) {
		return this.jobSeekerCVService.add(cvAddDto);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobSeekerCV>> getAll(){
	    return this.jobSeekerCVService.getAll();
	}
	
	@GetMapping("/getAllSortedExperience")
	public DataResult<List<JobSeekerCV>> getAllSortedExperience(){
	    return this.jobSeekerCVService.getAllSortedExperience();
	}
	
	@GetMapping("/getAllSortedEducation")
	public DataResult<List<JobSeekerCV>> getAllSortedEducation(){
	    return this.jobSeekerCVService.getAllSortedEducation();
	}
	
}
