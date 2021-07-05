package kodlamaio.hrms.entities.concretes;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employer_verify_by_system_staff")
public class EmployerVerifyBySystemStaff {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "is_verified")
	private boolean isVerified;

	@UpdateTimestamp
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "verify_date", insertable = false)
	private Date verifyDate;

	@OneToOne()
	@JoinColumn(name = "employer_id", referencedColumnName = "user_id")
	private Employer employer;

	@ManyToOne()
	@JoinColumn(name = "system_staff_id", referencedColumnName = "user_id")
	private SystemStaff systemStaff;
}
