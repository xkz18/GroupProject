package ResourceManager.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "resoureDetails")
public class ResourceDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer detail_id;
    private Date time_created;
    private String detail_value;

    @OneToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "resourceId")
    private Resource resource;

    @OneToMany(fetch=FetchType.LAZY,
            mappedBy="resourceDetails",
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<Project> projects;

    @ManyToOne
    @JoinColumn(name = "project_columns_column_id")
    private ProjectColumns projectColumns;

    public ProjectColumns getProjectColumns() {
        return projectColumns;
    }

    public void setProjectColumns(ProjectColumns projectColumns) {
        this.projectColumns = projectColumns;
    }

    public Integer getDetail_id() {
        return detail_id;
    }

    public void setDetail_id(Integer detail_id) {
        this.detail_id = detail_id;
    }

    public Date getTime_created() {
        return time_created;
    }

    public void setTime_created(Date time_created) {
        this.time_created = time_created;
    }

    public String getDetail_value() {
        return detail_value;
    }

    public void setDetail_value(String detail_value) {
        this.detail_value = detail_value;
    }

    public Resource getResources() {
        return resource;
    }

    public void setResources(Resource resources) {
        this.resource = resource;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "Resource_Details{" +
                "detail_id=" + detail_id +
                ", time_created=" + time_created +
                ", detail_value='" + detail_value + '\'' +
                ", resources=" + resource +
                ", projects=" + projects +
                '}';
    }
}
