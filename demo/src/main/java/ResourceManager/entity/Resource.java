package ResourceManager.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "resource")
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="resource_id")
    private Integer resourceId;
    @Column(name="date_created")
    private LocalDate timeCreated;




    @JsonIgnore
    @OneToMany(fetch=FetchType.LAZY,
            mappedBy="resource",
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<ProjectResources> ProjectResource;

    @JsonIgnore
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

    public LocalDate getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(LocalDate timeCreated) {
        this.timeCreated = timeCreated;
    }



    public List<ResourceDetails> getResourceDetails() {
        return resourceDetails;
    }


    public List<ProjectResources> getProjectResource() {
        return ProjectResource;
    }

    public void setProjectResource(List<ProjectResources> projectResource) {
        ProjectResource = projectResource;
    }

    @Override
    public String toString() {
        return "Resources{" +
                "resource_id=" + resourceId +
                ", time_created=" + timeCreated +
                '}';
    }
}
