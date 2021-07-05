package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kodlamaio.hrms.core.entities.concrete.User;
import kodlamaio.hrms.entities.concretes.cv.JobSeekerCV;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_seekers")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "jobSeekersCV" })
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
public class JobSeeker extends User {

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "national_id")
	private String nationalId;

	@Column(name = "birth_date", columnDefinition = "DATE")
	private LocalDate birthDate;

	@OneToMany(mappedBy = "jobSeeker", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<JobSeekerCV> jobSeekersCV;

	public JobSeeker(String email, String password, String firstName, String lastName, String nationalId,
			LocalDate birthDate) {
		super(email, password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalId = nationalId;
		this.birthDate = birthDate;
	}

}
