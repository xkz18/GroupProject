package ResourceManager.controller;

import ResourceManager.Service.ResourceDetailsService;
import ResourceManager.entity.ResourceDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/findbyID")
    public ResourceDetails findRecordById(@RequestParam(value="id") Integer id){
        ResourceDetails resourceDetails=service.getDetails(id);
        if(resourceDetails==null){
            System.out.println("Not valid id");
        }
        return resourceDetails;
    }

    /**
     * get all resource details from database
     */
    @GetMapping("/allResource")
    public List<ResourceDetails> list() {
        return service.getAllDetails();
    }

    /**
     * add a row (resource detail)
     */
    @PostMapping("/create")
    public ResourceDetails createResource(@RequestParam(value = "Resource_id") Integer resource_id, @RequestParam(value = "column_id") Integer column_id,
                                          @RequestParam(value = "detail_value") String detail_value) {

        return service.createDetails(resource_id,column_id,detail_value);
    }

    /**
     * delete a row (resource detail)
     */
    @PutMapping("/resourceDetails/")
    public String updateValue(@RequestParam(value = "detail_id") Integer detail_id,@RequestParam(value = "detail_value") String detail_value){
        service.updateValue(detail_id,detail_value);
        return "Updated Successfully";

    }

    @DeleteMapping("/delete")
    public void deleteResource(@RequestParam Integer id){ service.deleteDetails(id);}





}

