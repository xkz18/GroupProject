package com.example.demo.Controller;

import com.example.demo.ResourceManager.model.ProjectColumns;
import com.example.demo.ResourceManager.model.ProjectResources;
import com.example.demo.Service.ProjectColumnService;
import com.example.demo.Service.ProjectResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

@CrossOrigin
@RestController
public class ProjectColumnController {
    @Autowired
    ProjectColumnService service;

    @PostMapping("/create")
    public ProjectColumns addProjectResource(@RequestBody ProjectColumns column){
        return service.addColumn(column);
    }

    @PostMapping("/delete")
    public void deleteProjectResource(@RequestParam Integer id){
        service.deleteColumn(id);
    }

    @GetMapping("/getAll")
    @Transactional
    public ResponseEntity<List<ProjectColumns>> getAllResource(){
        List<ProjectColumns> list = service.getAllColumns();
        System.out.println(list.get(0));
        //return ResponseEntity.ok(list);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/test")
    public String getTest(){
        return "column_test";
    }
}
