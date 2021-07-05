package kodlamaio.hrms.entities.dtos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import kodlamaio.hrms.core.entities.dto.UserDto;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerDto extends UserDto {

	@NotNull(message = "Şirket İsmi Boş Bırakılamaz")
	@Length(min = 2, message = "Şirket İsmi Geçersiz")
	private String companyName;

	@NotNull(message = "Website Boş Bırakılamaz")
	@Pattern(regexp = "[a-zA-Z0-9]?[a-zA-Z0-9-]+[a-zA-Z0-9]\\.[a-zA-Z0-9]+", message = "Geçersiz Email")
	private String website;

	@NotNull(message = "Telefon Numarası Boş Bırakılamaz") 
	//@Pattern(regexp = "^(0[25])([0-9]{2})\\s?([0-9]{3})\\s?([0-9]{2})\\s?([0-9]{2})$", message = "Geçersiz Telefon Numarası")
	private String telephone;
}
