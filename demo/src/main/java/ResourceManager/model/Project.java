package ResourceManager.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue
    private int projectId;

    @Column(name = "date_created")
    private Date dateCreated;

    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="user_id")
    private User user;

    public Project() {

    }
    public Project(Date dateCreated) {
        this.dateCreated = dateCreated;

    }
    public int getId() {
        return projectId;
    }
    public void setId(int id) {
        this.projectId = id;
    }
    public Date getDateCreated(){
        return dateCreated;
    }
    public User getUser(){
        return user;
    }
    public void setUser(User user){
        this.user = user;
    }
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "Project [id=" + projectId +", DateCreated=" + dateCreated + "]";
    }


}
