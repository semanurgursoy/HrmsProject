package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="email")
	@Email
	private String email;
	
	@Column(name="password")
	private String password;
	
	//@OneToOne(mappedBy="user",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	//private Image image;
	
	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
}
