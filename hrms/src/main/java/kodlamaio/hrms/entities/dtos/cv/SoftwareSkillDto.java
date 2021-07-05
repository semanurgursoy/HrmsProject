package kodlamaio.hrms.entities.dtos.cv;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SoftwareSkillDto {

	@NotNull(message = "Bilgisayar Beceri Alanı Boş Bırakılamaz")
	private String technologyName;

	private int jobSeekerCVId;
}
