package ResourceManager.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "resource_details")
public class ResourceDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="detail_id")
    private Integer detail_id;
    @Column(name="date_created")
    private LocalDate time_created;


    @Column(name="detail_value")
    private String detail_value;

    @JsonIgnore
    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="resource_id")
    @JsonProperty(value = "resource")
    private Resource resource;

    @JsonIgnore
    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="column_id")
    @JsonProperty(value = "projectColumns")
    private ProjectColumns projectColumns;


    public Integer getDetail_id() {
        return detail_id;
    }

    public void setDetail_id(Integer detail_id) {
        this.detail_id = detail_id;
    }

    public LocalDate getTime_created() {
        return time_created;
    }

    public void setTime_created(LocalDate time_created) {
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
