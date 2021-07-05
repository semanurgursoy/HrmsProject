package kodlamaio.hrms.entities.dtos;

import lombok.Data;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import kodlamaio.hrms.core.entities.dto.UserDto;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SystemStaffDto extends UserDto {

	@NotNull(message = "İsim Boş Bırakılamaz")
	@Length(min = 2, message = "Geçersiz İsim")
	private String name;

	@NotNull(message = "Soyisim Boş Bırakılamaz")
	@Length(min = 2, message = "Geçersiz Soy İsim")
	private String surname;
}
