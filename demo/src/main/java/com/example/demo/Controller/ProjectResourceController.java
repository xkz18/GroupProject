package com.example.demo.Controller;

import com.example.demo.ResourceManager.model.ProjectColumns;
import com.example.demo.ResourceManager.model.ProjectResources;
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
    public ProjectResources addProjectResource(@RequestBody Integer project_id, Integer resource_id){
        return service.addProjectResource(project_id,resource_id);
    }

    @PostMapping("/delete")
    public String deleteProjectResource(@RequestParam Integer id){
        return service.deleteProjectResource(id)?"Delete Successfully":"Delete Failed";
    }

    @PostMapping("/{id}")
    public ProjectResources findRecordById(@RequestParam(value="id") Integer id){
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
