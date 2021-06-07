package kodlamaio.hrms.entities.concretes.cv;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnore;

import kodlamaio.hrms.entities.concretes.JobSeekerCV;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="educations")
public class Education {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="school_id")
	private int id;
	
	@Column(name="school_name")
	@NotBlank
	@NotNull
	private String schoolName;
	
	@Column(name="school_department")
	@NotBlank
	@NotNull
	private String department;
	
	@Column(name="begin_year")
	@NotBlank
	@NotNull
	private Date beginYear;
	
	@Column(name="graduated_year")
	private Date graduatedYear;
	
	@Column(name="is_graduated")
	@NotBlank
	@NotNull
	private boolean isGraduated;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="job_seeker_cv_id")
	@JsonIgnore
	private JobSeekerCV jobSeekerCV;
	
}
