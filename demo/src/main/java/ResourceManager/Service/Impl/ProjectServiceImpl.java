package ResourceManager.Service.Impl;

import ResourceManager.Service.ProjectService;
import ResourceManager.entity.Project;
import ResourceManager.entity.User;
import ResourceManager.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Example;
import java.time.LocalDate;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository repository;

    @Override
    public Project findById(Integer id){
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Project> findAll(){
        return repository.findAll();

    }

    @Override
    public Project save(Project project){
        return repository.save(project);
    }

    @Override
    public Project create(Project project){
        project.setDateCreated(LocalDate.now());
        return repository.save(project);
    }
    @Override
    public Project update(Project project){
        return repository.save(project);
    }
    @Override
    public List<Project> findByUser(User user){
        Project sample = new Project();
        sample.setUser(user);
        return repository.findAll(Example.of(sample));
    }
}
