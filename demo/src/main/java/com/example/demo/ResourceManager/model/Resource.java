package com.example.demo.ResourceManager.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "resoure")
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer resourceId;
    private Date timeCreated;

    @OneToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "resourceId")
    private ProjectResources projectResources;

    @OneToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "resourceId")
    private ResourceDetails resourceDetails;


    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public Date getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Date timeCreated) {
        this.timeCreated = timeCreated;
    }

    public ProjectResources getProjectResources() {
        return projectResources;
    }

    public void setProjectResources(ProjectResources projectResources) {
        this.projectResources = projectResources;
    }

    public ResourceDetails getResourceDetails() {
        return resourceDetails;
    }

    public void setResourceDetails(ResourceDetails resourceDetails) {
        this.resourceDetails = resourceDetails;
    }


    @Override
    public String toString() {
        return "Resources{" +
                "resource_id=" + resourceId +
                ", time_created=" + timeCreated +
                '}';
    }
}
