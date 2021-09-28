package ResourceManager.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "resoures")
public class Resources {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer resourceId;
    private Date timeCreated;

    @OneToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "resourceId")
    private Project_Resources projectResources;

    @OneToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "resourceId")
    private Resource_Details resourceDetails;


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

    public Project_Resources getProjectResources() {
        return projectResources;
    }

    public void setProjectResources(Project_Resources projectResources) {
        this.projectResources = projectResources;
    }

    public Resource_Details getResourceDetails() {
        return resourceDetails;
    }

    public void setResourceDetails(Resource_Details resourceDetails) {
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
