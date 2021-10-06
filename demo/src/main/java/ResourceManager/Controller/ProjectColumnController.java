package ResourceManager.Controller;

import ResourceManager.enums.Type;
import ResourceManager.entity.Project;
import ResourceManager.entity.ProjectColumns;
import ResourceManager.entity.ProjectResources;
import ResourceManager.Service.ProjectColumnService;
import ResourceManager.Service.ProjectResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/projectColumn")
public class ProjectColumnController {
    @Autowired
    ProjectColumnService service;

    @PostMapping("/create")
    //@Transactional
    //public ProjectColumns addProjectColumn(@RequestBody Project project, String column_name, String type, String text){
    public ProjectColumns addProjectColumn(@RequestBody ProjectColumns projectColumns){
        //return service.addColumnByProject(projectColumns.getProject(), "column_name", "type", "text");
        return service.save(projectColumns);
    }

    @PostMapping("/delete")
    @Transactional
    public String deleteProjectResource(@RequestParam Integer id){
        return service.deleteColumn(id)?"Delete Successfully":"Delete Failed";
    }

    @PostMapping("/findByProject")
    @Transactional
    public List<ProjectColumns> findColumnByProject(@RequestBody Project project){
        return service.findByProject(project);
    }

    @PostMapping("/updateColumnNameById")
    @Transactional
    public String updateColumnNameById(@RequestParam(value = "id") Integer id, @RequestParam(value = "name") String column_name){
        ProjectColumns projectColumns=service.getColumnById(id);
        if(projectColumns==null){
            return "Updated failed: Input Id is not valid";
        }
        projectColumns.setColumn_name(column_name);
        service.save(projectColumns);
        return "Update Successfully";
    }

    @PostMapping("/updateColumnTypeById")
    @Transactional
    public String updateColumnTypeById(@RequestParam(value = "id") Integer id, @RequestParam(value = "type") String type){
        ProjectColumns projectColumns=service.getColumnById(id);
        if(projectColumns==null){
            return "Updated failed: Input Id is not valid";
        }
        if(type.equals("Number")){
            projectColumns.setType(Type.Number);
        }
        if(type.equals("Text")){
            projectColumns.setType(Type.Text);
        }
        if(type.equals("Formula")){
            projectColumns.setType(Type.Formula);
        }

        service.save(projectColumns);
        return "Update Successfully";
    }

    @GetMapping("/getAll")
    @Transactional
    public ResponseEntity<List<ProjectColumns>> getAllResource(){
        List<ProjectColumns> list = service.getAllColumns();
        System.out.println(list.get(0));
        //return ResponseEntity.ok(list);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/test")
    public String getTest(){
        return "column_test";
    }

    /*@PostMapping("/find")
    @Transactional
    public ProjectColumns findColumnById(@RequestParam(value="id") Integer id){
        ProjectColumns projectColumns=service.getColumnById(id);
        if(projectColumns==null){
            System.out.println("Column ID is not valid");
        }
        return projectColumns;
    }*/

    @GetMapping("/{id}")
    public ProjectColumns findColumnById(@PathVariable Integer id){
        ProjectColumns projectColumns=service.getColumnById(id);
        if(projectColumns==null){
            System.out.println("Column ID is not valid");
        }
        return projectColumns;
    }
}
