package ResourceManager.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.*;

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
			   mappedBy="project",
			   cascade= {CascadeType.PERSIST, CascadeType.MERGE,
						 CascadeType.DETACH, CascadeType.REFRESH})
	private List<ProjectColumns> ProjectColumn;
	
	@OneToMany(targetEntity = ProjectResources.class, cascade = CascadeType.ALL)
	private Set<ProjectResources> ProjectResource;

    @ManyToOne
    @JoinColumn(name = "resource_details_detail_id")
    private ResourceDetails resourceDetails;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private User users;

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public ResourceDetails getResourceDetails() {
        return resourceDetails;
    }

    public void setResourceDetails(ResourceDetails resourceDetails) {
        this.resourceDetails = resourceDetails;
    }

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
