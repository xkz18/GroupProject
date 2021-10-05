package ResourceManager.controller;

import ResourceManager.Service.ProjectService;
import ResourceManager.entity.Project;
import ResourceManager.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private ProjectService service;

    @GetMapping("/project/")
    public Project findById (@RequestParam(value="id") Integer id){
        Project project = service.findById(id);
        if (project == null){
            System.out.println("ID is not valid");
        }
        return project;
    }

    @GetMapping("/project")
    public List<Project> findAll(){ return service.findAll();}

    @PostMapping("/create")
    public String create(@RequestParam(value = "project")Project project,@RequestParam(value = "user") User user){
        service.create(project,user);
        return "Created Project";
    }

    @GetMapping("/{user}")
    public List<Project> findByUser(User user){
        List<Project> project = service.findByUser(user);
        if(project==null){
            System.out.println("User is not valid");
        }
        return project;
    }
    @DeleteMapping("/delete")
    public String delete(@RequestParam Integer id){
        service.delete(id);
        return "Delete Successfully";
    }

}
