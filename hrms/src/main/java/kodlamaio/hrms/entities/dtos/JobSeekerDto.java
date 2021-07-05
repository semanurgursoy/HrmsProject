package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import kodlamaio.hrms.core.entities.dto.UserDto;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerDto extends UserDto {

	@NotNull(message = "İsim Boş Bırakılamaz")
	@Length(min = 2, message = "İsim Geçersiz")
	private String firstName;

	@NotNull(message = "Soyisim Boş Bırakılamaz")
	@Length(min = 2, message = "Soyisim Geçersiz")
	private String lastName;

	@NotNull(message = "Kimlik Numarası Boş Bırakılamaz")
	private String nationalId;

	@NotNull(message = "Doğum Yılı Boş Bırakılamaz")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate birthDate;
}
