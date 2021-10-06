package com.example.demo.ResourceManager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue
    private Integer projectId;

    @Column(name = "date_created")
    private LocalDate dateCreated;

    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="user_id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "resource_details_detail_id")
    private ResourceDetails resourceDetails;

    public ResourceDetails getResourceDetails() {
        return resourceDetails;
    }

    public void setResourceDetails(ResourceDetails resourceDetails) {
        this.resourceDetails = resourceDetails;
    }

	@OneToMany(fetch=FetchType.LAZY,
			   mappedBy="project",
			   cascade= {CascadeType.PERSIST, CascadeType.MERGE,
						 CascadeType.DETACH, CascadeType.REFRESH})
    @JsonIgnore
	private List<ProjectColumns> ProjectColumn;

	@OneToMany(targetEntity = ProjectResources.class, cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIgnore
	private Set<ProjectResources> ProjectResource;

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