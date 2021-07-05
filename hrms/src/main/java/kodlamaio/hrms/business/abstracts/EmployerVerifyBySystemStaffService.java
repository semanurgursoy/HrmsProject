package kodlamaio.hrms.business.abstracts;

import java.util.UUID;

import org.springframework.http.ResponseEntity;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerVerifyBySystemStaffService {
	Result add(Employer employer);
    ResponseEntity<Result> verifyEmployer(UUID employerUuid, UUID systemPersonnelUuid);
}
