package ResourceManager.controller;

import ResourceManager.entity.Resource;
import ResourceManager.Service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("findbyID")
    public Resource findRecordById(@RequestParam(value="id") Integer id){
        Resource resource=service.getResource(id);
        if(resource==null){
            System.out.println("ID is not valid");
        }
        return resource;
    }

    /**
     * get all resource from database
     */
    @GetMapping("/allResource")
    public List<Resource> list() {
        return service.getAllResource();
    }

    /**
     * add a row (resource)
     */
    @PostMapping("/create")
    public Resource createResource(@RequestBody Resource resource) {

        return service.saveResource(resource);
    }

    /**
     * delete a row (resource)
     */

    @DeleteMapping("/delete")
    public void deleteResource(@RequestParam Integer id){ service.deleteResource(id);}





}

