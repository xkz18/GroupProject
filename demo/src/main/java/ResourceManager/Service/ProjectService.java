package ResourceManager.Service;

import ResourceManager.model.Project;
import ResourceManager.model.User;

import java.util.List;

public interface ProjectService {
    public Project findById(Integer id);

    List<Project> findAll();

    public Project save(Project project);

    public Project create(Project project);
}
