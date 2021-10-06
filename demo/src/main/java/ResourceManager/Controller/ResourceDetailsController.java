package ResourceManager.Controller;

import ResourceManager.Service.ResourceDetailsService;
import ResourceManager.entity.ProjectColumns;
import ResourceManager.entity.Resource;
import ResourceManager.entity.ResourceDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.time.LocalDate;

@RestController
@RequestMapping("/resourceDetails")
public class ResourceDetailsController {

    @Autowired
    private ResourceDetailsService service;

    /**
     * get resource by ID
     */

    @PostMapping("/findbyID")
    public ResponseEntity<?> findResourceDetailDetailById(@RequestParam(value="id") Integer id){
        ResourceDetails resourceDetails=service.getDetails(id);
        if( resourceDetails==null ){
            return new ResponseEntity<>("{ error : Resource detail is not found!}", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(resourceDetails,HttpStatus.OK);
    }


    /**
     * get all resource details from database
     */


    @GetMapping("/allResource")
    public ResponseEntity<?> list() {
        List<ResourceDetails> resourceDetails =service.getAllDetails();
        if( resourceDetails==null ){
            return new ResponseEntity<>("{ error : Resource is not found!}",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(resourceDetails,HttpStatus.OK);
    }

    /**
     * add a row (resource detail)
     */
    @PostMapping("/create")
    public ResourceDetails createResourceDetails(@RequestBody ResourceDetails resourceDetails) {
        resourceDetails.setTime_created(LocalDate.now());
        return service.saveDetails(resourceDetails);
    }

    /**
     * update detail value
     */
    @PostMapping("/updateValueById")
    @Transactional
    public ResponseEntity<?> updateValueById(@RequestParam(value = "id") Integer id, @RequestParam(value = "value") String detail_value){
        ResourceDetails resourceDetails=service.getDetails(id);
        if(resourceDetails==null){
            return new ResponseEntity<>("Update failed : Resource detail is not found!", HttpStatus.BAD_REQUEST);
        }
        resourceDetails.setDetail_value(detail_value);
        service.saveDetails(resourceDetails);
        return new ResponseEntity<>("Update done",HttpStatus.OK);
    }


    /**
     * delete a row (resource detail)
     */



    @PostMapping("/delete")
    public ResponseEntity<?> deleteResource(@RequestParam Integer id) throws Exception{
        ResourceDetails resourceDetails=service.getDetails(id);
        if( resourceDetails==null ){
            return new ResponseEntity<>("Error : Resource is not found!",HttpStatus.BAD_REQUEST);
        }

        try {
            service.deleteDetails(id);
            return new ResponseEntity<>("Delete Successfully!",HttpStatus.OK);
        } catch (Exception e){
            //return ResponseEntity.badRequest().body(e.getMessage());
            return new ResponseEntity<>("Error : Cannot delete due to foreign key constraint",HttpStatus.BAD_REQUEST);
        }

    }


    @GetMapping("/test")
    public String getTest(){
        return "resource_details_test";
    }



}

