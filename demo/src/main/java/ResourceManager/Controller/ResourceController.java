package ResourceManager.Controller;

import ResourceManager.entity.Resource;
import ResourceManager.Service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.time.LocalDate;

@RestController

public class ResourceController {

    @Autowired
    private ResourceService service;

    /**
     * get all resource from database
     */
    @GetMapping("/resource")
    public List<Resource> list() {
        return service.getAllResource();
    }

    /**
     * add a row (resource)
     */
    @PostMapping("/create")
    public Resource createResource(@RequestParam("resource_id") Integer resourceID) {
        Resource resource = new Resource();
        resource.setResourceId(resourceID);
        resource.setTimeCreated(LocalDate.now());
        return service.createResource(resource);
    }
    @PostMapping("/delete")
    public void deleteResource(@RequestParam Integer id){ service.deleteResource(id);}


}

