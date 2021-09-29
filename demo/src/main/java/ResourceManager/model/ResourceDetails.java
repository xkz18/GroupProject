package ResourceManager.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "resourceDetails")
public class ResourceDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer detail_id;
    private Date time_created;
    private String detail_value;

    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="resource_id")
    private Resource resource;

    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="column_id")
    private ProjectColumns projectColumns;


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

    public void setProjectColumns(ProjectColumns projectColumn){
        this.projectColumns = projectColumn;
    }
    public ProjectColumns getProjectColumns(){
        return projectColumns;
    }



    @Override
    public String toString() {
        return "Resource_Details{" +
                "detail_id=" + detail_id +
                ", time_created=" + time_created +
                ", detail_value='" + detail_value + '\'' +
                ", resources=" + resource
                + '}';
    }
}
