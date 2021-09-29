package ResourceManager.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(nullable = false, unique = true, name = "username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name = "date_created")
    private Date dateCreated;

    @Column(name = "last_updated")
    private Date lastUpdated;
	
	@Column(name = "title")
	private String title;
	
	@Column (name = "role")
	private String role;
	
    @Column(name = "image")
    private String image;


    @OneToMany(fetch=FetchType.LAZY,
            mappedBy="users",
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<Project> projects;

    public User() {

    }
    public User(String username, String password, Date dateCreated) {
        this.username = username;
        this.password = password;
        this.dateCreated = dateCreated;

    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public Date getDateCreated(){
        return dateCreated;
    }
	public String getTitle(){
		return title;
	}
	public String getRole(){
		return role;
	}
	public String getImage(){
		return image;
	}
	public Date getLastUpdated(){
		return lastUpdated;
	}
    public void setUsername(String username) {
        this.username = username;
    }
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setPassword(String encodedPassword) {
        this.password = encodedPassword;
    }
	public void setTitle(String title){
		this.title = title;
	}
	public void setRole(String role){
		this.role = role;
	}
	public void setImage(String image){
		this.image = image;
	}
	public void setLastUpdated(Date lastUpdated){
		this.lastUpdated = lastUpdated;
	}
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", userName=" + username + ", DateCreated=" + dateCreated + ", LastUpdated=" + lastUpdated
                + "]";
    }

}
