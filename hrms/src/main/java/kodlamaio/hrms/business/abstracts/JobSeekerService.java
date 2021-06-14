package kodlamaio.hrms.business.abstracts;

import java.rmi.RemoteException;
import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeeker;

public interface JobSeekerService {
	DataResult <List<JobSeeker>> getAll();
	DataResult<JobSeeker> getById(int id);
	Result add(JobSeeker jobSeeker)throws NumberFormatException, RemoteException;
	Result checkEmail(JobSeeker jobSeeker);
	Result checkNationalId(JobSeeker jobSeeker);
	Result MernisVerification(JobSeeker jobSeeker)throws NumberFormatException, RemoteException;
	Result areThereEmpty(JobSeeker jobSeeker);
}
