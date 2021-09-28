package ResourceManager.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "resoure_details")
public class Resource_Details {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer detail_id;
    private Date time_created;
    private String detail_value;

    @OneToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "resourceId")
    private Resources resources;

    @OneToMany(fetch=FetchType.LAZY,
            mappedBy="resource_details",
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<Project> projects;

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

    public Resources getResources() {
        return resources;
    }

    public void setResources(Resources resources) {
        this.resources = resources;
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
                ", resources=" + resources +
                ", projects=" + projects +
                '}';
    }
}
