package kodlamaio.hrms.api.controllers.advertisement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.advertisement.JobTimeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.advertisement.JobTime;

@RestController
@RequestMapping("/api/jobtimes")
@CrossOrigin
public class JobTimesController {

	private JobTimeService jobTimeService;

	@Autowired
	public JobTimesController(JobTimeService jobTimeService) {
		super();
		this.jobTimeService = jobTimeService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobTime>> getAll(){
		return this.jobTimeService.getAll();
	}
	
}
