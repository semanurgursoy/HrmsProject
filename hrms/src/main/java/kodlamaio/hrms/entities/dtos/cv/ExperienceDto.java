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
public class ExperienceDto {
	
	@NotNull(message = "Çalışma Yeri Boş Bırakılamaz")
	private String workplace;

	@NotNull(message = "Başlangıç Tarihi Boş Bırakılamaz")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date beginDate;

	@NotNull(message = "Bitiş Tarihi Boş Bırakılamaz")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date endDate;

	private boolean stillWork;
	
	private int jobPositionId;

	private int jobSeekerCVId;
}
