package beltExam2.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

//import beltExam.models.Show;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	
	@NotEmpty(message="Name is required!")
	@Size(min=1, max=255, message="First name must be between 3 and 255 characters")
	private String name;
	
	
	@NotEmpty(message="Email is required!")
	@Email(message="Email must be valid")
	private String email;
	
	@NotEmpty(message="Password name is required!")
	@Size(min=8, max=128, message="Password must be between 8 and 128 characters characters")
	private String password;
	
	@Transient
	@NotEmpty(message="Confirm Password name is required!")
	@Size(min=8, max=128, message="Confrim password must be between 8 and 128 characters characters")
	private String confirm;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="likes",
			joinColumns = @JoinColumn(name="user_id"),
			inverseJoinColumns = @JoinColumn(name="baby_name_id"))
	private List<BabyName> likedNames;
	

	@OneToMany(mappedBy="user", fetch=FetchType.LAZY)
	private List<Comment> comments;
	
	
	@OneToMany(mappedBy="user", fetch=FetchType.LAZY)
	private List<BabyName> babyNames;
	
	
	public User() {}
	
	
	 @PrePersist
	    protected void onCreate(){
	        this.createdAt = new Date();
	    }
	    @PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<BabyName> getBabyNames() {
		return babyNames;
	}

	public void setShows(List<BabyName> babyNames) {
		this.babyNames = babyNames;
	}

	public List<BabyName> getLikedNames() {
		return likedNames;
	}

	public void setLikedNames(List<BabyName> likedNames) {
		this.likedNames = likedNames;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	
	
}
