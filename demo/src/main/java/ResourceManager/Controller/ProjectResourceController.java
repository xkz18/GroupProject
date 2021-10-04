package ResourceManager.Controller;

import ResourceManager.entity.ProjectResources;
import ResourceManager.Service.ProjectResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.time.LocalDate;

@CrossOrigin
@RestController
@RequestMapping("/projectResource")
public class ProjectResourceController {
    @Autowired
    ProjectResourceService service;

    @PostMapping("/create")
    public ProjectResources addProjectResource(@RequestBody ProjectResources record){
        // record.setTime_created(new LocalDate(System.currentTimeMillis()));
        record.setTime_created(LocalDate.now());
        return service.addProjectResource(record);
    }

    @PostMapping("/delete")
    public void deleteProjectResource(@RequestParam Integer id){
        service.deleteProjectResource(id);
    }

    @GetMapping("/getAll")
    @Transactional
    public ResponseEntity<List<ProjectResources>> getAllResource(){
        List<ProjectResources> list = service.getAllProjectResources();
        System.out.println(list.get(0));
        return ResponseEntity.ok(list);
        //return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
