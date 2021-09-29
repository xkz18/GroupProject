package ResourceManager.model;

import javax.persistence.*;
import java.security.PublicKey;
import java.util.List;


@Entity
@Table(name="Project_Columns")
public class ProjectColumns {
    public enum Type{
        Number, Text, Formula
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer column_id;

    @ManyToOne
    @JoinColumn(name="project_id")
    private Project project;

    @OneToMany(mappedBy = "projectColumns", fetch = FetchType.EAGER)
    private List<ResourceDetails> resourceDetails;

    private String column_name;
    private Type type;  //Number, Text, Formula
    //fomula_text

    public Integer getColumn_id(){return column_id;}

    public void setColumn_id(Integer column_id){this.column_id=column_id;}

    public Project getProject(){return project;}

    public void setProject(Project project){this.project=project;}

    public List<ResourceDetails> getResourceDetails(){return resourceDetails;}

    public void setResourceDetails(List<ResourceDetails> resourceDetails){
        this.resourceDetails=resourceDetails;
    }

    public void setColumn_name(String column_name){this.column_name=column_name;}

    public String getColumn_name(){return column_name;}

    public void setType(Type type){this.type=type;}

    public Type getType(){return type;}

    //set&getFormula_text()

    @Override
    public String toString(){
        return "ProjectColumn["+
                ", column_id="+column_id+
                ", project="+project+
                ", column_name="+column_name+
                ", type="+type+
                ", resourceDetails="+resourceDetails+
                "]";
    }

}
