package kodlamaio.hrms.business.abstracts;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.entities.concrete.User;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.entities.concretes.Image;

public interface ImageService {
	Result saveImage(MultipartFile file, int userId);
	
}
