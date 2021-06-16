package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import kodlamaio.hrms.entities.concretes.cv.Education;
import kodlamaio.hrms.entities.concretes.cv.Experience;
import kodlamaio.hrms.entities.concretes.cv.Language;
import kodlamaio.hrms.entities.concretes.cv.Link;
import kodlamaio.hrms.entities.concretes.cv.SoftwareSkill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_seekers_cv")
public class JobSeekerCV {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="job_seeker_cv_id")
	private int id;
	
	@ManyToOne(targetEntity = JobSeeker.class,fetch = FetchType.EAGER)
	@JoinColumn(name="user_id")
	private JobSeeker jobSeeker;
	
	@Column(name = "cover_letter")
	private String coverLetter;
	
	
	@OneToMany(mappedBy="jobSeekerCV",cascade=CascadeType.ALL)
	private List<Education> educations;
	
	
	@OneToMany(mappedBy="jobSeekerCV",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Experience> experiences;

	
	@OneToMany(mappedBy="jobSeekerCV",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Language> languages;


	@OneToMany(mappedBy="jobSeekerCV",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private List<SoftwareSkill> softwareSkills;

	
	@OneToOne(mappedBy="jobSeekerCV",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	private Link link;
	
}
