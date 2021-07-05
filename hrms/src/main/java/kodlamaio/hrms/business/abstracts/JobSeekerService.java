package kodlamaio.hrms.business.abstracts;

import java.rmi.RemoteException;
import java.util.List;

import org.springframework.http.ResponseEntity;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.dtos.JobSeekerDto;

public interface JobSeekerService {
	DataResult<List<JobSeeker>> getAll();

	ResponseEntity<?> getById(int id);

	Result add(JobSeekerDto jobSeekerDto) throws NumberFormatException, RemoteException;
}
