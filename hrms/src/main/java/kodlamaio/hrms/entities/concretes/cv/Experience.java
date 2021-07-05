package kodlamaio.hrms.entities.concretes.cv;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import kodlamaio.hrms.entities.concretes.advertisement.JobPosition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "experiences")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Experience {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "experience_id")
	private int id;

	@Column(name = "workplace")
	private String workplace;

	@Column(name = "begin_date")
	private Date beginDate;

	@Column(name = "end_date")
	private Date endDate;

	@Column(name = "still_work")
	private boolean stillWork;

//	@Column(name = "position")
//	private String position;

	@ManyToOne()
	@JoinColumn(name = "position_id")
	private JobPosition jobPosition;

	@ManyToOne(targetEntity = JobSeekerCV.class)
	@JoinColumn(name = "job_seeker_cv_id", referencedColumnName = "job_seeker_cv_id")
	@JsonProperty(access = Access.WRITE_ONLY)
	private JobSeekerCV jobSeekerCV;

}
