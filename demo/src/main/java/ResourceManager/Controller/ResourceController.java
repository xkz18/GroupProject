package ResourceManager.Controller;

import ResourceManager.entity.Resource;
import ResourceManager.Service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.time.LocalDate;

@RestController
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private ResourceService service;

    /**
     * get resource by ID
     */
    @PostMapping("/findbyID")
    public ResponseEntity<?> findResourceById(@RequestParam(value="id") Integer id){
        Resource resource=service.getResource(id);
        if( resource==null ){
            return new ResponseEntity<>("{ error : Resource is not found!}",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(resource,HttpStatus.OK);
    }



    /**
     * get all resource from database
     */
    @GetMapping("/allResource")
    public ResponseEntity<?> list() {
        List<Resource> resource =service.getAllResource();
        if( resource==null ){
            return new ResponseEntity<>("{ error : Resource is not found!}",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(resource,HttpStatus.OK);
    }

    /**
     * add a row (resource)
     */
    @PostMapping("/create")
    @Transactional
    public ResponseEntity<?> createResource(@RequestBody Resource resource) throws Exception{
        try {
            resource.setTimeCreated(LocalDate.now());
            Resource saved_resource = service.saveResource(resource);

            return new ResponseEntity<>(saved_resource,HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    /**
     * delete a row (resource)
     */


    @PostMapping("/delete")
    public ResponseEntity<?> deleteResource(@RequestParam Integer id) throws Exception{
        Resource resource=service.getResource(id);
        if( resource==null ){
            return new ResponseEntity<>("Error : Resource is not found!",HttpStatus.BAD_REQUEST);
        }

        try {
            service.deleteResource(id);
            return new ResponseEntity<>("Delete Successfully!",HttpStatus.OK);
        } catch (Exception e){
            //return ResponseEntity.badRequest().body(e.getMessage());
            return new ResponseEntity<>("Error : Cannot delete due to foreign key constraint",HttpStatus.BAD_REQUEST);
        }

    }


}

