package ResourceManager.model;

import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "resource")
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer resourceId;
    private Date timeCreated;

    @OneToMany(targetEntity = ProjectResources.class, cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.TRUE)
    private Set<ProjectResources> ProjectResource;

    @OneToMany(fetch=FetchType.LAZY,
            mappedBy="resource",
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<ResourceDetails> resourceDetails;


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

    public Set<ProjectResources> getProjectResources() {
        return ProjectResource;
    }

    public void setProjectResources(Set<ProjectResources> projectResources) {
        this.ProjectResource = projectResources;
    }

    public List<ResourceDetails> getResourceDetails() {
        return resourceDetails;
    }

    public void setResourceDetails(List<ResourceDetails> resourceDetails) {
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
