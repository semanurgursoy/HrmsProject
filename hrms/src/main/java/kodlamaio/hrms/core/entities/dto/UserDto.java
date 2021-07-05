package kodlamaio.hrms.core.entities.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class UserDto {
	@NotBlank(message = "Email Boş Olamaz")
	@Email(message = "Geçersiz Email")
	private String email;

	@NotBlank(message = "Şifre Boş Olamaz")
	@Size(min = 6, max = 30, message = "Şifre En Az 6, En Fazla 30 Karakter Olmalı")
	private String password;

	@NotBlank(message = "Şifre Tekrarı Boş Olamaz")
	private String repassword;

}
