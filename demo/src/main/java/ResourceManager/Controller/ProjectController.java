package ResourceManager.Controller;

import ResourceManager.Service.ProjectService;
import ResourceManager.entity.Project;
import ResourceManager.entity.Resource;
import ResourceManager.entity.ResourceDetails;
import ResourceManager.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private ProjectService service;

    @GetMapping("/findbyid")
    public ResponseEntity<?> findById (@RequestParam(value="id") Integer id){
        Project project = service.findById(id);
        if (project == null){
            return new ResponseEntity<>("{ error : Resource is not found!}", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(project,HttpStatus.OK);
    }


    @GetMapping("/findAll")
    public List<Project> findAll(){ return service.findAll();}

    @PostMapping("/create")
    public String create(@RequestBody Project project){
        service.create(project);
        return "Created Project";
    }

    @PostMapping("findbyUser")
    @Transactional
    public ResponseEntity<?> findByUser(@RequestBody User user){
        List<Project> project = service.findByUser(user);
        if(project.isEmpty()){
            return new ResponseEntity<>("{ project owned by user can not be found !}",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(project,HttpStatus.OK);
    }



    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam Integer id){
        Project project = service.findById(id);
        if( project==null ){
            return new ResponseEntity<>("Error : Project is not found!",HttpStatus.BAD_REQUEST);
        }

        try {
            service.delete(id);
            return new ResponseEntity<>("Delete Successfully!",HttpStatus.OK);
        } catch (Exception e){
            //return ResponseEntity.badRequest().body(e.getMessage());
            return new ResponseEntity<>("Error : Cannot delete due to foreign key constraint",HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/test")
    public String getTest(){
        return "test";
    }
}
