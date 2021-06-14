package kodlamaio.hrms.business.abstracts;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.entities.concretes.Image;
import kodlamaio.hrms.entities.concretes.User;

public interface ImageService {
	Result saveImage(MultipartFile file, int userId);
	void imageTableSetter(User user);
}
