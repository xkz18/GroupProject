package ResourceManager.Controller;

import ResourceManager.entity.Project;
import ResourceManager.entity.ProjectColumns;
import ResourceManager.entity.ProjectResources;
import ResourceManager.entity.Resource;
import ResourceManager.Service.ProjectResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import javax.transaction.Transactional;
import java.beans.Transient;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/projectResource")
public class ProjectResourceController {
    @Autowired
    ProjectResourceService service;

    @PostMapping("/create")
    //public ProjectResources addProjectResource(@RequestParam Integer project_id, Integer resource_id){
    //public ProjectResources addProjectResource(@RequestBody Project project, Resource resource){

    public ResponseEntity<?> addProjectResource(@RequestBody ProjectResources projectResources){
        ProjectResources result= service.save(projectResources);
        if(result==null){
            return new ResponseEntity<>("{error: Created failed!}", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/delete")
    @Transactional
    public ResponseEntity<?> deleteProjectResource(@RequestParam Integer id){
        ProjectResources result=service.deleteProjectResource(id);
        if(result==null){
            return new ResponseEntity<>("{error: Delete failed, record is not found!}", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Delete Successfully: Record: "+result, HttpStatus.OK);
    }

    @PostMapping("/findByProject")
    @Transactional
    public ResponseEntity<?> findRecordByProject(@RequestBody Project project){
        List<ProjectResources> resultList= service.findByProject(project);
        if(resultList==null||resultList.size()==0){
            return new ResponseEntity<>("{error: No related records found!}", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(resultList, HttpStatus.OK);
    }

    @PostMapping("/findByResource")
    public ResponseEntity<?> findRecordByResource(@RequestBody Resource resource){
        List<ProjectResources> resultList= service.findByResource(resource);
        if(resultList==null||resultList.size()==0){
            return new ResponseEntity<>("{error: No related records found!}", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(resultList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findRecordById(@PathVariable Integer id){
        ProjectResources projectResources=service.getProjectResourceById(id);
        if(projectResources==null){
            return new ResponseEntity<>("{error: Record ID is not valid!}", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(projectResources, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    @Transactional
    public ResponseEntity<List<ProjectResources>> getAllResource(){
        List<ProjectResources> list = service.getAllProjectResources();
        //System.out.println(list.get(0));
        return ResponseEntity.ok(list);
        //return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/test")
    public String getTest(){
        return "project_resource_test";
    }
}
