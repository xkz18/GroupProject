package ResourceManager.model;

import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue
    private int projectId;

    @Column(name = "date_created")
    private Date dateCreated;

    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="user_id")
    private User user;
	
	@OneToMany(fetch=FetchType.LAZY,
			   mappedBy="Project",
			   cascade= {CascadeType.PERSIST, CascadeType.MERGE,
						 CascadeType.DETACH, CascadeType.REFRESH})
	private List<ProjectColumns> ProjectColumn;
	
	@OneToMany(targetEntity = ProjectResources.class, cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
	private Set<ProjectResources> ProjectResource;
	
    public Project() {

    }
    public Project(Date dateCreated) {
        this.dateCreated = dateCreated;

    }
    public int getId() {
        return projectId;
    }
    public void setId(int id) {
        this.projectId = id;
    }
    public Date getDateCreated(){
        return dateCreated;
    }
    public User getUser(){
        return user;
    }
    public void setUser(User user){
        this.user = user;
    }
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "Project [id=" + projectId +", DateCreated=" + dateCreated + "]";
    }


}
