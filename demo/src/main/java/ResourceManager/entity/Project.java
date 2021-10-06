package ResourceManager.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "project")
public class Project {
    // edit !!
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Integer projectId;

    @Column(name = "date_created")
    private LocalDate dateCreated;

    @JsonIgnore
    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="user_id")
    private User user;

    @JsonIgnore
    @OneToMany(fetch=FetchType.LAZY,
			   mappedBy="project",
			   cascade= {CascadeType.PERSIST, CascadeType.MERGE,
						 CascadeType.DETACH, CascadeType.REFRESH})
	private List<ProjectColumns> ProjectColumn;

    //	@OneToMany(targetEntity = ProjectResources.class, cascade = CascadeType.ALL)
    //    @LazyCollection(LazyCollectionOption.FALSE)
    //	private Set<ProjectResources> ProjectResources;

    @JsonIgnore
    @OneToMany(fetch=FetchType.LAZY,
            mappedBy="project",
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<ProjectColumns> ProjectResources;

	
    public Project() {

    }
    public Project(LocalDate dateCreated) {
        this.dateCreated = dateCreated;

    }
    public int getId() {
        return projectId;
    }
    public void setId(int id) {
        this.projectId = id;
    }
    public LocalDate getDateCreated(){
        return dateCreated;
    }
    public User getUser(){
        return user;
    }
    public void setUser(User user){
        this.user = user;
    }
    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "Project [id=" + projectId +", DateCreated=" + dateCreated + "]";
    }


}
