package ResourceManager.controller;

import ResourceManager.Service.ProjectColumnService;
import ResourceManager.entity.ProjectColumns;

import ResourceManager.enums.Type;
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
    public ProjectColumns addProjectResource(@RequestBody Integer project_id, String column_name, String type){
        return service.addColumnByProject(project_id,column_name, type);
    }

    @DeleteMapping("/delete")
    public String deleteProjectResource(@RequestParam Integer id){
        return service.deleteColumn(id)?"Delete Successfully":"Delete Failed";
    }

    @PutMapping("/updateColumnNameById")
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

    @PutMapping("/updateColumnTypeById")
    @Transactional
    public String updateColumnTypeById(@RequestParam(value = "id") Integer id, @RequestParam(value = "type") String type){
        ProjectColumns projectColumns=service.getColumnById(id);
        if(projectColumns==null){
            return "Updated failed: Input Id is not valid";
        }
        if(type=="Number"){
            projectColumns.setType(Type.Number);
        }
        if(type=="Text"){
            projectColumns.setType(Type.Text);
        }
        if(type=="Formula"){
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
