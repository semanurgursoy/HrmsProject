package kodlamaio.hrms.entities.dtos.cv;

import java.util.Date;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationDto {

	@NotNull(message = "Okul Adı Boş Bırakılamaz")
	private String schoolName;

	@NotNull(message = "Bölüm Adı Boş Bırakılamaz")
	private String department;

	@NotNull(message = "Başlangıç Tarihi Boş Bırakılamaz")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date beginYear;

	@NotNull(message = "Bitiş Tarihi Boş Bırakılamaz")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date graduatedYear;

	private boolean isGraduated;

	private int jobSeekerCVId;
}
