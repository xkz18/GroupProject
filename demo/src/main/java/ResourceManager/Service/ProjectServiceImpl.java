package ResourceManager.Service;

import ResourceManager.model.Project;
import ResourceManager.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
