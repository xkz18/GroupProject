package com.example.demo.Controller;

import com.example.demo.ResourceManager.model.Project;
import com.example.demo.ResourceManager.model.ProjectColumns;
import com.example.demo.ResourceManager.model.ProjectResources;
import com.example.demo.ResourceManager.model.Resource;
import com.example.demo.Service.ProjectResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ProjectResources addProjectResource(@RequestBody ProjectResources projectResources){
        return service.save(projectResources);
    }

    @PostMapping("/delete")
    @Transactional
    public String deleteProjectResource(@RequestParam Integer id){
        return service.deleteProjectResource(id)?"Delete Successfully":"Delete Failed";
    }

    @PostMapping("/findByProject")
    @Transactional
    public List<ProjectResources> findRecordByProject(@RequestBody Project project){
        return service.findByProject(project);
    }

    @PostMapping("/findByResource")
    public List<ProjectResources> findRecordByResource(@RequestBody Resource resource){
        return service.findByResource(resource);
    }

    @GetMapping("/{id}")
    public ProjectResources findRecordById(@PathVariable Integer id){
        ProjectResources projectResources=service.getProjectResourceById(id);
        if(projectResources==null){
            System.out.println("Column ID is not valid");
        }
        return projectResources;
    }

    @GetMapping("/getAll")
    @Transactional
    public ResponseEntity<List<ProjectResources>> getAllResource(){
        List<ProjectResources> list = service.getAllProjectResources();
        System.out.println(list.get(0));
        return ResponseEntity.ok(list);
        //return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/test")
    public String getTest(){
        return "project_resource_test";
    }
}
