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
    //public ProjectColumns addProjectColumn(@RequestBody Project project, String column_name, String type, String text){
    public ResponseEntity<?> addProjectColumn(@RequestBody ProjectColumns projectColumns){
        ProjectColumns result= service.save(projectColumns);
        if(result==null){
            return new ResponseEntity<>("{error: Created failed!}", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<?> deleteProjectColumn(@RequestParam Integer id){
        ProjectColumns result= service.deleteColumn(id);
        if(result==null){
            return new ResponseEntity<>("{error: Delete failed, projectColumn is not found!}", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Delete Successfully: Column: "+result, HttpStatus.OK);
    }

    @PostMapping("/findByProject")
    public ResponseEntity<?> findColumnByProject(@RequestBody Project project){
        List<ProjectColumns> resultList= service.findByProject(project);
        if(resultList==null||resultList.size()==0){
            return new ResponseEntity<>("{error: No related columns found!}", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(resultList, HttpStatus.OK);
    }

    @PostMapping("/updateColumnNameById")
    public ResponseEntity<?> updateColumnNameById(@RequestParam(value = "id") Integer id, @RequestParam(value = "name") String column_name){
        if(column_name==null||column_name.equals("")){
            return new ResponseEntity<>("{error: Updated failed: Input name is not valid!}", HttpStatus.BAD_REQUEST);
        }

        ProjectColumns projectColumns=service.getColumnById(id);

        if(projectColumns==null){
            return new ResponseEntity<>("{error: Updated failed: Input Id is not valid!}", HttpStatus.BAD_REQUEST);
        }

        projectColumns.setColumn_name(column_name);
        service.save(projectColumns);
        return new ResponseEntity<>(projectColumns, HttpStatus.OK);
    }

    @PostMapping("/updateColumnTypeById")
    public ResponseEntity<?> updateColumnTypeById(@RequestParam(value = "id") Integer id, @RequestParam(value = "type") String type){
        ProjectColumns projectColumns=service.getColumnById(id);
        if(projectColumns==null){
            return new ResponseEntity<>("{error: Updated failed: Input Id is not valid!}", HttpStatus.BAD_REQUEST);
        }
        Boolean matched=false;
        if(type.equals("Number")){
            projectColumns.setType(Type.Number);
            matched=true;
        }
        if(type.equals("Text")){
            projectColumns.setType(Type.Text);
            matched=true;
        }
        if(type.equals("Formula")){
            projectColumns.setType(Type.Formula);
            matched=true;
        }
        if(!matched){
            return new ResponseEntity<>("{error: Input type is not valid!}", HttpStatus.BAD_REQUEST);
        }
        service.save(projectColumns);
        return new ResponseEntity<>(projectColumns, HttpStatus.OK);

    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ProjectColumns>> getAllResource(){
        List<ProjectColumns> list = service.getAllColumns();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/test")
    public String getTest(){
        return "column_test";
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> findColumnById(@PathVariable Integer id){
        ProjectColumns projectColumns=service.getColumnById(id);
        if(projectColumns==null){
            return new ResponseEntity<>("{error: Column not exists!}", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(projectColumns, HttpStatus.OK);
    }
}
