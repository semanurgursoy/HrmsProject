package kodlamaio.hrms.entities.dtos.advertisement;

import java.sql.Date;

import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementDto {
	private int id;

	@NotNull(message = "Açıklama Boş Bırakılamaz")
	private String description;

	private int maxSalary;

	private int minSalary;

	@NotNull(message = "Açık Pozisyon Sayısı Boş Bırakılamaz")
	private int openPositionCount;

	@NotNull(message = "İlan Kapanma Tarihi Boş Bırakılamaz")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date applicationDeadLine;

	private boolean isActive = false;

	@NotNull(message = "Şehir Alanı Boş Bırakılamaz")
	private int cityId;

	@NotNull(message = "Pozisyon Alanı Boş Bırakılamaz")
	private int jobPositionId;

	@NotNull(message = "İşveren Alanı Boş Bırakılamaz")
	private int employerId;

	@NotNull(message = "Çalışma Türü Alanı Boş Bırakılamaz")
	private int jobTypeId;

	@NotNull(message = "Çalışma Zamanı Alanı Boş Bırakılamaz")
	private int jobTimeId;
}
