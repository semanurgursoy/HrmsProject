package kodlamaio.hrms.entities.concretes.cv;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import kodlamaio.hrms.entities.concretes.JobSeekerCV;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="educations")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Education {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="school_id")
	private int id;
	
	@Column(name="school_name")
	private String schoolName;
	
	@Column(name="school_department")
	private String department;
	
	@Column(name="begin_year")
	private Date beginYear;
	
	@Column(name="graduated_year")
	private Date graduatedYear;
	
	@Column(name="is_graduated")
	private boolean isGraduated;
	
	@ManyToOne(targetEntity = JobSeekerCV.class)
	@JoinColumn(name="job_seeker_cv_id",referencedColumnName="job_seeker_cv_id")
	@JsonProperty(access=Access.WRITE_ONLY)
	private JobSeekerCV jobSeekerCV;
	
}
