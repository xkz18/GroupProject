package ResourceManager.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Date;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @NotEmpty
    @Column(nullable = false, unique = true, name = "username")
    private String username;

    @NotEmpty
    @Column(name="password")
    private String password;

    @Column(name = "date_created")
    private Date dateCreated;

    @Column(name = "last_updated")
    private Date lastUpdated;

    @OneToMany(fetch=FetchType.LAZY,
            mappedBy="users",
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<Project> projects;

    public User() {

    }
    public User(String username, String password, Date dateCreated) {
        this.username = username;
        this.password = password;
        this.dateCreated = dateCreated;

    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public Date getDateCreated(){
        return dateCreated;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setPassword(String encodedPassword) {
        this.password = encodedPassword;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", userName=" + username + ", DateCreated=" + dateCreated + ", LastUpdated=" + lastUpdated
                + "]";
    }

}
