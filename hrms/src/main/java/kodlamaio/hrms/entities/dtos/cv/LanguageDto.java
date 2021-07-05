package kodlamaio.hrms.entities.dtos.cv;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LanguageDto {

	@NotNull(message = "Dil Adı Boş Bırakılamaz")
	private String languageName;

	@NotNull(message = "Level Boş Bırakılamaz")
	@Min(value = 1, message = "Min Derece 1")
	@Max(value = 5, message = "Max Derece 5")
	private int level;

	private int jobSeekerCVId;
}
