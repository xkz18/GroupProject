package ResourceManager.entity;

import ResourceManager.enums.Type;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;




@Entity
@Table(name="Project_Columns")
public class ProjectColumns {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer column_id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="project_id")
    @JsonProperty(value = "project")
    private Project project;

    @JsonIgnore
    @OneToMany(mappedBy = "projectColumns", fetch = FetchType.EAGER)
    private List<ResourceDetails> resourceDetails;

    private String column_name;
    private Type type;  //Number, Text, Formula
    private String formula_text;

    public Integer getColumn_id(){return column_id;}

    public void setColumn_id(Integer column_id){this.column_id=column_id;}

    public Project getProject(){return project;}

    public void setProject(Project project){this.project=project;}

    public void setColumn_name(String column_name){this.column_name=column_name;}

    public String getColumn_name(){return column_name;}

    public void setType(Type type){this.type=type;}

    public Type getType(){return type;}

    public void setFormula_text(String formula_text){this.formula_text=formula_text;}

    public String getFormula_text(){return formula_text;}

    @Override
    public String toString(){
        return "ProjectColumn ["+
                "column_id="+column_id+
                ", project="+project+
                ", column_name="+column_name+
                ", type="+type+
                ", formula_text="+formula_text+
                "] ";
    }

}
