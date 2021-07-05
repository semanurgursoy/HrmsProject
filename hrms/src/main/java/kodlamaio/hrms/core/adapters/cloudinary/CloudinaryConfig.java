package kodlamaio.hrms.core.adapters.cloudinary;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Configuration
public class CloudinaryConfig {
	//@Value("${cld.access-key}")	
	//String apiKey;
	
	//@Value("${cld.secret-key}")
	//String apiSecretKey;
	

 	@Bean
    public Cloudinary cloudinaryUser(){
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "ddrh2g917",
                "api_key", "542935423239386",
                "api_secret", "Y7MO_pyJ2qawqOmvto4GhLWQRpk"));
    }

    @Bean
    public CloudinaryService cloudinaryService(){
        return new CloudinaryAdapter(cloudinaryUser());
    }
}
